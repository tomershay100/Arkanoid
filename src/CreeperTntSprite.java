//323082701
import biuoop.DrawSurface;
/**
 * CreeperTntSprite class.
 *
 * @author Tomer Shay <tomershay100@gmail.com>
 * @version 1.0
 * @since 2020-06-05
 */
public class CreeperTntSprite implements Sprite {
    @Override
    public void drawOn(DrawSurface d) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 6; j++) {
                if (i % 2 == 0 ^ j % 2 == 0) {
                    new Creeper().drawOneCrepper(d, i * 25 * 8, j * 25 * 8);
                } else {
                    new Zombie().drawOneZombie(d, i * 25 * 8, j * 25 * 8);
                }
            }
        }

    }

    @Override
    public void timePassed() {

    }
}
