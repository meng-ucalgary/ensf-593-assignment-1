/**
 * Solving exercise 11.4 from the book "Think Java, 2nd edition"
 */
public class Rational {
    public int numerator;
    public int denominator;

    /**
     * Constructor with default values
     */
    Rational() {
        this.numerator = 0;
        this.denominator = 1;
    }

    /**
     * Constructor with specified values
     *
     * @param num numerator
     * @param den denominator
     */
    Rational(int num, int den) {
        this.numerator = num;
        this.denominator = den;
    }

    /**
     * Print the Rational number in nice format
     */
    public void printRational() {
        if (this.denominator < 0) {
            System.out.printf("%d/%d", Math.negateExact(this.numerator), Math.negateExact(this.denominator));
        }

        else {
            System.out.printf("%d/%d", this.numerator, this.denominator);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        if (this.denominator < 0) {
            return String.format("%d/%d", Math.negateExact(this.numerator), Math.negateExact(this.denominator));
        }

        else {
            return String.format("%d/%d", this.numerator, this.denominator);
        }
    }

    /**
     * Reverses the sign of Rational number
     */
    public void negate() {
        // this.numerator = Math.negateExact(this.numerator);
        this.denominator = Math.negateExact(this.denominator);
    }

    /**
     * Swaps numerator and denominator. Equivalent to exponent of (-1)
     */
    public void invert() {
        int temp = this.numerator;
        this.numerator = this.denominator;
        this.denominator = temp;
    }

    /**
     * Returns the Rational number in decimal format
     *
     * @return
     */
    public double toDouble() {
        return ((double) this.numerator / (double) this.denominator);
    }

    /**
     * Reduce the Rational number in lowest form, and returns
     */
    public Rational reduce() {
        // assigning because original shouldn't be changed
        int a = this.numerator;
        int b = this.denominator;

        // finding GCD by Euclidean algorithm
        int x = Math.abs(a);
        int y = Math.abs(b);

        while (x != y) {
            if (x > y)
                x = x - y;

            else
                y = y - x;
        }

        a = a / x;
        b = b / x;

        if (b < 0) {
            return (new Rational(Math.negateExact(a), Math.negateExact(b)));
        }

        else {
            return (new Rational(a, b));
        }
    }

    /**
     * Add two Rational numbers
     *
     * @param rObject
     */
    public Rational add(Rational rObject) {
        int num1 = this.numerator;
        int den1 = this.denominator;

        int num2 = rObject.numerator;
        int den2 = rObject.denominator;

        // cross multiply the numerators
        num1 = num1 * den2;
        num2 = num2 * den1;

        // make the denominators same
        den1 = den1 * den2;
        den2 = den1;

        // add the numerators
        num1 = num1 + num2;

        // create new Rational and reduce it
        Rational rNew = new Rational(num1, den1);
        rNew = rNew.reduce();

        return rNew;
    }

    public static void main(String[] args) {
        System.out.printf("%n");

        // Exercise Point 4
        // --------------------------------------------------------------------------------
        Rational r1 = new Rational();
        r1.numerator = -126;
        r1.denominator = 90;
        System.out.printf("Rational number r1 with default values -126 and 90 = ");
        r1.printRational();
        // --------------------------------------------------------------------------------

        System.out.printf("%n%n");

        // Exercise Point 6
        // --------------------------------------------------------------------------------
        System.out.println("Rational number r1 with toString() implementation = " + r1);
        // --------------------------------------------------------------------------------

        System.out.printf("%n");

        // Exercise Point 8
        // --------------------------------------------------------------------------------
        r1.negate();
        System.out.printf("Rational number r1 after negate() = %s", r1);
        // --------------------------------------------------------------------------------

        System.out.printf("%n%n");

        // Exercise Point 9
        // --------------------------------------------------------------------------------
        r1.invert();
        System.out.printf("Rational number r1 after invert() = %s", r1);
        // --------------------------------------------------------------------------------

        System.out.printf("%n%n");

        // Exercise Point 10
        // --------------------------------------------------------------------------------
        System.out.printf("Rational number r1 in double form = %.2f", r1.toDouble());
        // --------------------------------------------------------------------------------

        System.out.printf("%n%n");

        // Exercise Point 11
        // --------------------------------------------------------------------------------
        System.out.printf("Rational number r1 in reduced form = %s", r1.reduce());
        // --------------------------------------------------------------------------------

        System.out.printf("%n%n");

        // Exercise Point 12
        // --------------------------------------------------------------------------------
        Rational r2 = new Rational(5, -6);
        System.out.printf("Rational number addition demonstration : %s + %s = %s", r1, r2, r1.add(r2));
        // --------------------------------------------------------------------------------

        System.out.printf("%n");
    }
}
