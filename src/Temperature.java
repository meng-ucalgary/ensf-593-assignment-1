/**
 * Provides data fields and methods to create a data-type representing a
 * Temperature in a Java application.
 *
 * @author Bhavyai Gupta
 * @version 1.0
 * @since May 17, 2021
 */
public class Temperature {
	/**
	 * The temperature to be stored in fahrenheit
	 */
	protected double degrees;

	/**
	 * Constructs an object of class Temperature with fahrenheit temperature
	 * supplied as a parameter
	 *
	 * @param t The temperature in fahrenheit
	 */
	public Temperature(double t) {
		this.degrees = t;
	}

	/**
	 * Returns the temperature stored in the <code>Temperature</code> object in
	 * fahrenheit degrees
	 *
	 * @return the value of temperature in fahrenheit
	 */
	public double getFahrenheit() {
		return this.degrees;
	}

	/**
	 * Returns the temperature stored in the <code>Temperature</code> object in
	 * celcius degrees
	 *
	 * @return the value of temperature in celcius
	 */
	public double getCelsius() {
		double ans = (5 * (this.degrees - 32) / 9);
		ans = Math.round(ans * 100) / 100.0;
		return ans;
	}

	public static void main(String[] args) {
		Temperature thermometer1 = new Temperature(-20.0);

		System.out.print("The Fahrenheit temperature of thermometer1 is ");
		System.out.print(thermometer1.getFahrenheit());
		System.out.println(" degrees.");

		System.out.print("The Celsius temperature of thermometer1 is ");
		System.out.print(thermometer1.getCelsius());
		System.out.println(" degrees.");

		Temperature thermometer2 = new Temperature(98.6);

		System.out.print("The Fahrenheit temperature of thermometer2 is ");
		System.out.print(thermometer2.getFahrenheit());
		System.out.println(" degrees.");

		System.out.print("The Celsius temperature of thermometer2 is ");
		System.out.print(thermometer2.getCelsius());
		System.out.println(" degrees.");
	}
}
