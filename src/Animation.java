//323082701

import biuoop.DrawSurface;

/**
 * Animation interface.
 *
 * @author Tomer Shay <tomershay100@gmail.com>
 * @version 1.0
 * @since 2020-06-05
 */
public interface Animation {
    /**
     * Make one frame one the given drawSurface.
     * @param d the drawSurface.
     */
    void doOneFrame(DrawSurface d);

    /**
     * Return if the animation should stop.
     * @return if the animation should stop.
     */
    boolean shouldStop();
}