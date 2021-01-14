//323082701

import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.List;


/**
 * Game.SpriteCollection Object - each Game.SpriteCollection has List of Sprites.
 *
 * @author Tomer Shay <tomershay100@gmail.com>
 * @version 1.0
 * @since 2020-04-24
 */

public class SpriteCollection {
    private final List<Sprite> list;

    /**
     * Init the Game.SpriteCollection.
     */
    public SpriteCollection() {
        this.list = new ArrayList<>();
    }

    /**
     * Add Interfaces.Sprite to the Game.SpriteCollection.
     *
     * @param s the Interfaces.Sprite that need to be added.
     */
    public void addSprite(Sprite s) {
        list.add(s);
    }

    /**
     * remove s from list.
     *
     * @param s the Sprite we want to remove.
     */
    public void removeSprite(Sprite s) {
        //System.out.println(list.size());
        if (list.contains(s)) {
            list.remove(s);
        } else {
            System.out.println("Error! you try to remove Sprite that doesn't exist!");
        }
    }

    /**
     * call timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        List<Sprite> listeners = new ArrayList<>(this.list);

        for (Sprite s : listeners) {
            s.timePassed();
        }
    }

    /**
     * call drawOn(d) on all sprites with the given drawSurface.
     *
     * @param d the given drawSurface.
     */
    public void drawAllOn(DrawSurface d) {
        for (Sprite s : this.list) {
            s.drawOn(d);
        }
    }
}