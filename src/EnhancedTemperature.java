import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Provides data fields and methods to create a data-type representing an
 * Enhanced Temperature application
 *
 * @author Bhavyai Gupta
 * @version 1.0
 * @since May 17, 2021
 */
public class EnhancedTemperature extends Temperature {
	protected String RED = "\033[0;91m";
	protected String YELLOW = "\033[0;93m";
	protected String RESET = "\033[0m";

	/**
	 * Constructs an object of class EnhancedTemperature with fahrenheit temperature
	 * supplied as a parameter
	 *
	 * @param t The temperature in fahrenheit
	 */
	public EnhancedTemperature(double t) {
		super(t);
	}

	/**
	 * Sets the temperature in Fahrenheit
	 *
	 * @param t temperature on Fahrenheit scale
	 */
	void setFahrenheit(double t) {
		this.degrees = t;
	}

	/**
	 * Sets the temperature in Celsius
	 *
	 * @param t temperature on Celsius scale
	 */
	void setCelsius(double t) {
		double ans = ((9 * t) / 5) + 32;
		this.degrees = ans;
	}

	public static void main(String[] args) {
		// initializing the object with absolute zero temperature
		EnhancedTemperature et = new EnhancedTemperature(-459.67);
		char ch = 'y';
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		// loop until user enters q or Q
		while (!(ch == 'q' || ch == 'Q')) {
			System.out.printf("%n%nPlease enter the temperature scale (F)ahrenheit/(C)elsius: ");
			String response = sc.nextLine();

			// if users enters an empty string
			if (response.length() == 0) {
				System.out.printf("%n%sNo response detected%s", et.RED, et.RESET);
				continue;
			}

			// if user choose the Fahrenheit scale
			else if (response.equalsIgnoreCase("fahrenheit") || response.equalsIgnoreCase("f")) {
				System.out.printf("%n%nPlease enter the temperature in Fahrenreit: ");

				while (true) {
					try {
						et.setFahrenheit(Double.parseDouble(sc.nextLine()));
						break;
					}

					catch (InputMismatchException | NullPointerException | NumberFormatException e) {
						System.err.printf(
								"%n%n%sCannot parse the temperature%s%n%nPlease enter the temperature in Fahrenreit again: ",
								et.RED, et.RESET);
					}
				}

				System.out.printf("%nTemperature in Celsius is %s%.2f%s", et.YELLOW, et.getCelsius(), et.RESET);
			}

			// if user chooses the Celsius scale
			else if (response.equalsIgnoreCase("celsius") || response.equalsIgnoreCase("c")) {
				System.out.printf("%n%nPlease enter the temperature in Celsius: ");

				while (true) {
					try {
						et.setCelsius(Double.parseDouble(sc.nextLine()));
						break;
					}

					catch (InputMismatchException | NullPointerException | NumberFormatException e) {
						System.err.printf(
								"%n%n%sCannot parse the temperature%s%n%nPlease enter the temperature in Celsius again: ",
								et.RED, et.RESET);
					}
				}

				System.out.printf("%nTemperature in Fahrenheit is %s%.2f%s", et.YELLOW, et.getFahrenheit(), et.RESET);
			}

			// if user enters gibberish
			else {
				System.err.printf("%n%sPlease enter the correct response!%s", et.RED, et.RESET);
				continue;
			}

			System.out.printf("%n%nPlaying conversion again. Press q now to quit: ");
			String temp = sc.nextLine();

			if (temp.length() == 0) {
				continue;
			}

			else {
				ch = temp.charAt(0);
			}
		}

		System.out.printf("Bye!");
		sc.close();
	}
}
