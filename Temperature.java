//Jonathan Bohbot
//260377050
//McGill University
//Friday September 24 2012
//Assignment 1
//ECSE-321-001

/**
 * We want to use the Java collections library to sort
 * a collection of temperatures. Therefore, the {@code Temperature}
 * class implements the {@code Comparable} interface by overriding
 * {@code compareTo} method.
 */

public class Temperature implements Comparable<Temperature> {

  /** Enumerator for different temperature units */
  public static enum Units { FAHRENHEIT, CELCIUS, KELVIN }

  //Variables Declaration
  public double v=1.0;
  public Units u;
  public Units storage;
  private static final double DELTA=1e-12;

  /**
   * Create a new {@code Temperature} with given attributes
   * @param value numerical value of {@code Temperature}
   * @param units {@code Units} of {@code Temperature}
   */
  public Temperature (double value, Temperature.Units units) {
  	v=value;
  	u=units;
  }

  /**
    * Get the value of the {@code Temperature}
    * @return numerical value of the {@code Temperature} in the current {@code Units}
    */
  public double getValue() {
    return v;
  }

  /**
   * Get the current {@code Units} of the {@code Temperature}
   * @return current {@code Units} of {@code Temperature}
   */
  public Units getUnits() {
    return u;
  }

  /**
   * Change the current {@code Units} of the {@code Temperature}.
   * Changing the {@code Units} also changes the numerical value
   * in a consistent manner.
   * @param units the new {@code Units}
   */
  public void changeUnits(Units units) {
    if(u==Units.CELCIUS&&units==Units.FAHRENHEIT){
    u=Units.FAHRENHEIT;
    v=((v*9.0)/5.0)+32.0;
    }

    else if(u==Units.CELCIUS&&units==Units.KELVIN){
    u=Units.KELVIN;
    v=v+273.15;
    }

    else if(u==Units.FAHRENHEIT&&units==Units.CELCIUS){
    u=Units.CELCIUS;
    v=((v-32.0)*5.0)/9.0;
    }

    else if(u==Units.FAHRENHEIT&&units==Units.KELVIN){
    u=Units.KELVIN;
    v=(((v-32.0)*5.0)/9.0)+273.15;
    }

    else if(u==Units.KELVIN&&units==Units.CELCIUS){
    u=Units.CELCIUS;
    v=v-273.15;
    }

    else if(u==Units.KELVIN&&units==Units.FAHRENHEIT){
    u=Units.FAHRENHEIT;
    v=(((v-273.15)*9.0)/5.0)+32.0;
    }

    else{
    }
}

  /**
   * Convert the {@code Temperature} to {@code String}. The output is
   * as follows
   * <pre><code>
   *    Temperature temperature = new Temperature(0, Units.CELCIUS);
   *    System.out.println(temperature.toString()); // prints "0 °C"
   *    temperature.changeUnits(Units.FAHRENHEIT);
   *    System.out.println(temperature.toString()); // prints "32 °F"
   *    temperature.changeUnits(Units.KELVIN);
   *    System.out.println(temperature.toString()); // prints "273.15 K"
   * </code></pre>
   */
  public String toString() {
    if(u==Units.CELCIUS){
    return "" + v + " °C";
    }

    else if(u==Units.FAHRENHEIT){
    return "" + v + " °F";
    }

    else{
    return "" + v + " K";
    }
 }

  /**
   * In order to implement {@code Comparable}, we need to override
   * the {@code compareTo} method.
   * @param temperature The {@code Temperature} to compare against
   * @return -1 if current object is less than {@code temperature}
   *          0 if both are equal
   *          1 if current object is greater than {@code temperature}
   */
  @Override
  public int compareTo (Temperature temperature) {

  	storage=temperature.getUnits();

  	if(this.u!=temperature.getUnits()){
  	temperature.changeUnits(this.getUnits());
    }

  	if(this.v<=temperature.getValue()+DELTA&&this.v>=temperature.getValue()-DELTA){
  	temperature.changeUnits(storage);
  	return 0;
  	}

  	else if(this.v<temperature.getValue()){
  	temperature.changeUnits(storage);
  	return -1;
  	}

  	else{
  	temperature.changeUnits(storage);
  	return 1;
  	}
}

  /**
   * Indicates whether some object is "equal" to this one.
   * To maintain consistency, whenever a class overrdes
   * {@code compareTo}, it must override {@code equals} so
   * that
   * <pre>
   *   <code>o1.compareTo(o2) == 0</code> implies <code>o1.equals(o2) == true</code>
   * </pre>
   * See the API documentation of {@code Object} class for more details.
   */
  @Override
  public boolean equals (Object o){
  	Temperature t=(Temperature)o;
  	if(this.compareTo(t)==0)
  	return true;
  	else
  	return false;
  }

  /**
   * Return a hash code of the object. To maintain consistency,
   * whenever a class overrides {@code equals} it mush also override
   * {@code hashCode} in such a manner that
   * <pre>
   *   <code>o1.equals(o2) == true</code> implies <code>o1.hashCode() == o2.hashCode()</code>
   * </pre>
   * See the API documentation of {@code Object} class for more details.
   */
  @Override
  public int hashCode() {
    Temperature temp1=new Temperature(this.v,this.u);
    temp1.changeUnits(Units.KELVIN);
    long bits=Double.doubleToLongBits(temp1.v);
    int hash=7;
    hash=31*hash+(int)(bits^(bits>>>32));
    hash=31*hash+(null==u.KELVIN ? 0: u.KELVIN.hashCode());
    return hash;
  }
}

