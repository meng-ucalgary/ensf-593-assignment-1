/**
 * Class to provide data fields and methods for representing a scrabble Tile
 *
 * @author Bhavyai Gupta
 * @version 1.0
 * @since May 17, 2021
 */
public class Tile {
    /**
     * An alphabet representing the Tile in the form of a <code>char</code>
     */
    private char letter;

    /**
     * The value of the Tile, in the form of an <code>int</code>
     */
    private int value;

    /**
     * Constructs an object of class Tile with default values
     */
    public Tile() {
        this.letter = 'A';
        this.value = 1;
    }

    /**
     * Constructs an object of class Tile with specified values of letter and value,
     * supplied by given parameters
     *
     * @param letter an alphabet representing the Tile
     * @param value  an integer value representing the value of the Tile
     */
    public Tile(char letter, int value) {
        this.letter = letter;
        this.value = value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return String.format("%c[%d]", this.letter, this.value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if ((this.letter == ((Tile) obj).letter) && (this.value == ((Tile) obj).value))
            return true;

        return false;
    }

    /**
     * Checking toString and equals methods of Tile class
     *
     * @param args not used
     */
    public static void main(String[] args) {
        Tile t0 = new Tile();
        Tile t1 = new Tile();
        Tile t2 = new Tile('Z', 10);

        System.out.println("Tile 0: " + t0.toString());
        System.out.println("Tile 1: " + t1.toString());
        System.out.println("Tile 2: " + t2.toString());

        System.out.println("Tile 0 is equal to Tile 1 is " + t0.equals(t1));
        System.out.println("Tile 0 is equal to Tile 2 is " + t0.equals(t2));
    }

}
