//Jonathan Bohbot
//260377050
//McGill University
//Friday September 24 2012
//Assignment 2
//ECSE-321-001


import org.junit.* ;
import static org.junit.Assert.* ;

public class TemperatureTest {
// Add multiple tests to check all functions of
// {@Code Temperature} class.

	private static final double DELTA=1e-12;


//Testing the getUnits method for all different types of temperatures

@Test
public void testgetunits (){
Temperature t=new Temperature(30, Temperature.Units.CELCIUS);
assertEquals(Temperature.Units.CELCIUS,t.getUnits());
t=new Temperature(30,Temperature.Units.FAHRENHEIT);
assertEquals(Temperature.Units.FAHRENHEIT,t.getUnits());
t=new Temperature(40,Temperature.Units.KELVIN);
assertEquals(Temperature.Units.KELVIN,t.getUnits());
}

 //Testing the getValue method for all different types of temperatures and for positive and negative numbers

 @Test
 public void testgetvalue(){
 Temperature t=new Temperature(45.8,Temperature.Units.KELVIN);
 assertEquals("Result",45.8,t.getValue(),DELTA);
 t=new Temperature(50.555,Temperature.Units.FAHRENHEIT);
 assertEquals("Result",50.555,t.getValue(),DELTA);
 t=new Temperature(777.765,Temperature.Units.CELCIUS);
 assertEquals("Result",777.765,t.getValue(),DELTA);
 t=new Temperature(-45.8,Temperature.Units.KELVIN);
 assertEquals("Result",-45.8,t.getValue(),DELTA);
 t=new Temperature(-50.555,Temperature.Units.FAHRENHEIT);
 assertEquals("Result",-50.555,t.getValue(),DELTA);
 t=new Temperature(-777.765,Temperature.Units.CELCIUS);
 assertEquals("Result",-777.765,t.getValue(),DELTA);
 }

 //Testing the changeUnits method for all possible combinations: Celcius to Fahrenheit, Fahrenheit to Celcius, Celcius to Kelvin, Kelvin to Celcius,
 //Fahrenheit to Kelvin, and Kelvin to Fahrenheit

 @Test
 public void testchangeUnits(){
 Temperature t=new Temperature(45.8, Temperature.Units.CELCIUS);
 t.changeUnits(Temperature.Units.FAHRENHEIT);
 assertEquals(Temperature.Units.FAHRENHEIT,t.getUnits());
 assertEquals("Result",114.44,t.getValue(),DELTA);
 t=new Temperature(89.6,Temperature.Units.FAHRENHEIT);
 t.changeUnits(Temperature.Units.CELCIUS);
 assertEquals(Temperature.Units.CELCIUS,t.getUnits());
 assertEquals("Result",32,t.getValue(),DELTA);
 t=new Temperature(50.55,Temperature.Units.CELCIUS);
 t.changeUnits(Temperature.Units.KELVIN);
 assertEquals(Temperature.Units.KELVIN,t.getUnits());
 assertEquals("Result",323.7,t.getValue(),DELTA);
 t=new Temperature(300,Temperature.Units.KELVIN);
 t.changeUnits(Temperature.Units.CELCIUS);
 assertEquals(Temperature.Units.CELCIUS,t.getUnits());
 assertEquals("Result",26.85,t.getValue(),DELTA);
 t=new Temperature(330.85,Temperature.Units.KELVIN);
 t.changeUnits(Temperature.Units.FAHRENHEIT);
 assertEquals(Temperature.Units.FAHRENHEIT,t.getUnits());
 assertEquals("Result",135.86,t.getValue(),DELTA);
 t=new Temperature(234.5,Temperature.Units.FAHRENHEIT);
 t.changeUnits(Temperature.Units.KELVIN);
 assertEquals(Temperature.Units.KELVIN,t.getUnits());
 assertEquals("Result",385.65,t.getValue(),DELTA);
 }

 //Testing the equals method. Testing was performed for all possible combinations: Celcius and Celcius, Fahrenheit and Fahrenheit, Kelvin and Kelvin, Celcius and Kelvin,
 //Fahrenheit and Celcius, and Fahrenheit and Kelvin.  We check if the two temperatures are equal and not equal for many different values.  It is important to perform many
 //tests because this method makes use of previous methods to compare if two other methods are equal.

 @Test
 public void testequals(){
 Temperature t1=new Temperature(350.56,Temperature.Units.KELVIN);
 Temperature t2=new Temperature(110.33,Temperature.Units.FAHRENHEIT);
 assertEquals(false,t1.equals(t2));
 assertEquals(Temperature.Units.KELVIN,t1.getUnits());
 assertEquals(Temperature.Units.FAHRENHEIT,t2.getUnits());
 t1=new Temperature(350.56,Temperature.Units.CELCIUS);
 t2=new Temperature(171.33,Temperature.Units.KELVIN);
 assertEquals(false,t1.equals(t2));
 assertEquals(Temperature.Units.CELCIUS,t1.getUnits());
 assertEquals(Temperature.Units.KELVIN,t2.getUnits());
 t1=new Temperature(51.84,Temperature.Units.CELCIUS);
 t2=new Temperature(325.00,Temperature.Units.FAHRENHEIT);
 assertEquals(false,t1.equals(t2));
 assertEquals(Temperature.Units.CELCIUS,t1.getUnits());
 assertEquals(Temperature.Units.FAHRENHEIT,t2.getUnits());
 t1=new Temperature(43.86,Temperature.Units.CELCIUS);
 t2=new Temperature(110.947,Temperature.Units.CELCIUS);
 assertEquals(false,t1.equals(t2));
 assertEquals(Temperature.Units.CELCIUS,t1.getUnits());
 assertEquals(Temperature.Units.CELCIUS,t2.getUnits());
 t1=new Temperature(350.566,Temperature.Units.CELCIUS);
 t2=new Temperature(350.566,Temperature.Units.CELCIUS);
 assertEquals(true,t1.equals(t2));
 assertEquals(Temperature.Units.CELCIUS,t1.getUnits());
 assertEquals(Temperature.Units.CELCIUS,t2.getUnits());
 t1=new Temperature(114.564,Temperature.Units.FAHRENHEIT);
 t2=new Temperature(114.564,Temperature.Units.FAHRENHEIT);
 assertEquals(true,t1.equals(t2));
 assertEquals(Temperature.Units.FAHRENHEIT,t1.getUnits());
 assertEquals(Temperature.Units.FAHRENHEIT,t2.getUnits());
 t1=new Temperature(350.56,Temperature.Units.FAHRENHEIT);
 t2=new Temperature(350.57,Temperature.Units.FAHRENHEIT);
 assertEquals(false,t1.equals(t2));
 assertEquals(Temperature.Units.FAHRENHEIT,t1.getUnits());
 assertEquals(Temperature.Units.FAHRENHEIT,t2.getUnits());
 t1=new Temperature(350.56,Temperature.Units.KELVIN);
 t2=new Temperature(350.56,Temperature.Units.KELVIN);
 assertEquals(true,t1.equals(t2));
 assertEquals(Temperature.Units.KELVIN,t1.getUnits());
 assertEquals(Temperature.Units.KELVIN,t2.getUnits());
 t1=new Temperature(350.56,Temperature.Units.KELVIN);
 t2=new Temperature(110.33,Temperature.Units.KELVIN);
 assertEquals(false,t1.equals(t2));
 assertEquals(Temperature.Units.KELVIN,t1.getUnits());
 assertEquals(Temperature.Units.KELVIN,t2.getUnits());
 t1=new Temperature(350.56,Temperature.Units.KELVIN);
 t2=new Temperature(171.338,Temperature.Units.FAHRENHEIT);
 assertEquals(true,t1.equals(t2));
 assertEquals(Temperature.Units.KELVIN,t1.getUnits());
 assertEquals(Temperature.Units.FAHRENHEIT,t2.getUnits());
 t1=new Temperature(51.84,Temperature.Units.CELCIUS);
 t2=new Temperature(324.99,Temperature.Units.KELVIN);
 assertEquals(true,t1.equals(t2));
 assertEquals(Temperature.Units.CELCIUS,t1.getUnits());
 assertEquals(Temperature.Units.KELVIN,t2.getUnits());
 t1=new Temperature(43.86,Temperature.Units.CELCIUS);
 t2=new Temperature(110.948,Temperature.Units.FAHRENHEIT);
 assertEquals(true,t1.equals(t2));
 assertEquals(Temperature.Units.CELCIUS,t1.getUnits());
 assertEquals(Temperature.Units.FAHRENHEIT,t2.getUnits());
 }
}

//Note that the code was tested on the Eclipse Version of McGill Computers and reported errors.  However, I tested these values on my computer's Eclipse
//version and it worked fine.  Furthermore, I checked that the temperatures were equal or not using the temperature converter on google.





