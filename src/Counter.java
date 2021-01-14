//323082701

/**
 * Counter class.
 *
 * @author Tomer Shay <tomershay100@gmail.com>
 * @version 1.0
 * @since 2020-05-21
 */
public class Counter {
    private int count;

    /**
     * Constructor.
     */
    public Counter() {
        this.count = 0;
    }

    /**
     * add number to current count.
     *
     * @param number the number.
     */
    public void increase(int number) {
        this.count += number;
    }

    /**
     * subtract number from current count.
     *
     * @param number the number.
     */
    public void decrease(int number) {
        this.count -= number;
    }

    /**
     * get current count.
     *
     * @return current count.
     */
    public int getValue() {
        return count;
    }
}