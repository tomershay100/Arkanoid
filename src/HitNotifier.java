//323082701


/**
 * HitNotifier interface.
 *
 * @author Tomer Shay <tomershay100@gmail.com>
 * @version 1.0
 * @since 2020-05-21
 */
public interface HitNotifier {

    /**
     * Add hl as a listener to hit events.
     *
     * @param hl the HitListener we want to add.
     */
    void addHitListener(HitListener hl);

    /**
     * Remove hl from the list of listeners to hit events.
     *
     * @param hl the HitListener we want to Remove.
     */
    void removeHitListener(HitListener hl);
}