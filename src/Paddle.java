//323082701

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.Color;
import java.net.URL;

/**
 * BlocksPackage.Paddle Object - each BlocksPackage.Paddle has a KeyboardSensor, a Geometries.Rectangle and a Color.
 *
 * @author Tomer Shay <tomershay100@gmail.com>
 * @version 1.0
 * @since 2020-04-24
 */
public class Paddle implements Sprite, Collidable {
    private final biuoop.KeyboardSensor keyboard;
    private Rectangle rectangle;
    private final Color color;
    private final int gameWidth;
    private final int borderThickness;
    private final int borderSpace;
    private int speed;

    /**
     * Constructor.
     *
     * @param rectangle       the BlocksPackage.Paddle rectangle.
     * @param keyboard        the BlocksPackage.Paddle KeyboardSensor.
     * @param color           the BlocksPackage.Paddle color.
     * @param gameWidth       the Game.Game Width.
     * @param borderThickness the borders thickness.
     * @param borderSpace     the space between the borders.
     */
    public Paddle(Rectangle rectangle, KeyboardSensor keyboard, Color color, int gameWidth, int borderThickness,
                  int borderSpace) {
        this.rectangle = rectangle;
        this.keyboard = keyboard;
        this.color = color;
        this.gameWidth = gameWidth;
        this.borderThickness = borderThickness;
        this.borderSpace = borderSpace;
        this.speed = 5;
    }

    /**
     * Set the paddle speed.
     *
     * @param speed1 the speed.
     */
    public void setSpeed(int speed1) {
        this.speed = speed1;
    }

    /**
     * move the paddle 5 points left.
     */
    public void moveLeft() {
        this.rectangle.setPoint(new Point(this.rectangle.getUpperLeft().getX() - this.speed,
                this.rectangle.getUpperLeft().getY()));
    }

    /**
     * move the paddle 5 points right.
     */
    public void moveRight() {
        this.rectangle.setPoint(new Point(this.rectangle.getUpperLeft().getX() + this.speed,
                this.rectangle.getUpperLeft().getY()));
    }

    @Override
    public void timePassed() {
        if (this.keyboard.isPressed(KeyboardSensor.LEFT_KEY)
                && this.rectangle.getUpperLeft().getX() - this.speed > borderThickness) {
            moveLeft();
        }
        if (this.keyboard.isPressed(KeyboardSensor.RIGHT_KEY)
                && this.rectangle.getUpperLeft().getX() + this.rectangle.getWidth() + this.speed
                < gameWidth - borderThickness) {
            moveRight();
        }
    }

    @Override
    public void drawOn(DrawSurface surface) {
        //dark
        surface.setColor(Color.darkGray.darker());
        surface.fillRectangle((int) this.rectangle.getUpperLeft().getX(),
                (int) this.rectangle.getUpperLeft().getY() + 5, (int) this.rectangle.getWidth() - 4,
                (int) this.rectangle.getHeight() - 5);
        //color
        surface.setColor(this.color);
        surface.fillRectangle((int) this.rectangle.getUpperLeft().getX() + 1,
                (int) this.rectangle.getUpperLeft().getY(), (int) this.rectangle.getWidth(),
                (int) this.rectangle.getHeight() - 2);
        //dots
        surface.setColor(Color.GRAY.darker().darker().darker());
        surface.fillRectangle((int) this.rectangle.getUpperLeft().getX() + 5,
                (int) this.rectangle.getUpperLeft().getY() + 4, 3, 3);
        surface.fillRectangle((int) this.rectangle.getUpperLeft().getX() + 5,
                (int) (this.rectangle.getUpperLeft().getY() + this.rectangle.getHeight() - 8), 3, 3);
        surface.fillRectangle((int) (this.rectangle.getUpperLeft().getX() - 5 + this.rectangle.getWidth()),
                (int) (this.rectangle.getUpperLeft().getY() + this.rectangle.getHeight() - 8), 3, 3);
        surface.fillRectangle((int) (this.rectangle.getUpperLeft().getX() - 5 + this.rectangle.getWidth()),
                (int) this.rectangle.getUpperLeft().getY() + 4, 3, 3);
        //bright
        surface.setColor(Color.LIGHT_GRAY.brighter());
        surface.fillRectangle((int) this.rectangle.getUpperLeft().getX() + 4,
                (int) this.rectangle.getUpperLeft().getY(), (int) this.rectangle.getWidth() - 3, 2);
        surface.fillRectangle((int) this.rectangle.getUpperLeft().getX() + (int) this.rectangle.getWidth(),
                (int) this.rectangle.getUpperLeft().getY(), 1, (int) this.rectangle.getHeight() - 5);
    }

    @Override
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }

    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        final double epsilon = Math.pow(10, -8);
        //int count = 0;
        /*if (Math.abs(collisionPoint.getX() - this.rectangle.getUpperLeft().getX()) < epsilon
                || Math.abs(collisionPoint.getX() - this.rectangle.getUpperLeft().getX() - this.rectangle.getWidth())
                < epsilon) {
            currentVelocity = new Velocity(-currentVelocity.getDx(), currentVelocity.getDy());
            count++;
        }*/
        if ((Math.abs(collisionPoint.getY() - this.rectangle.getUpperLeft().getY()) < epsilon)) {
            Point upperLeft = this.rectangle.getUpperLeft();
            double v;
            if (collisionPoint.getX() < upperLeft.getX() + this.rectangle.getWidth() / 5) {
                v = Math.sqrt(Math.pow(currentVelocity.getDx(), 2) + Math.pow(currentVelocity.getDy(), 2));
                currentVelocity = Velocity.fromAngleAndSpeed(300.0, v);
            } else if (collisionPoint.getX() < upperLeft.getX() + 2 * this.rectangle.getWidth() / 5) {
                v = Math.sqrt(Math.pow(currentVelocity.getDx(), 2) + Math.pow(currentVelocity.getDy(), 2));
                currentVelocity = Velocity.fromAngleAndSpeed(330.0, v);
            } else if (collisionPoint.getX() > upperLeft.getX() + 4 * this.rectangle.getWidth() / 5) {
                v = Math.sqrt(Math.pow(currentVelocity.getDx(), 2) + Math.pow(currentVelocity.getDy(), 2));
                currentVelocity = Velocity.fromAngleAndSpeed(60.0, v);
            } else if (collisionPoint.getX() > upperLeft.getX() + 3 * this.rectangle.getWidth() / 5) {
                v = Math.sqrt(Math.pow(currentVelocity.getDx(), 2) + Math.pow(currentVelocity.getDy(), 2));
                currentVelocity = Velocity.fromAngleAndSpeed(30.0, v);
            } else {
                currentVelocity = new Velocity(currentVelocity.getDx(), -currentVelocity.getDy());
            }
            try {
                URL borderHit = getClass().getClassLoader().getResource("borderHit.wav");
                if (borderHit != null) {
                    AudioInputStream sound = AudioSystem.getAudioInputStream(borderHit);
                    Clip clip = AudioSystem.getClip();
                    clip.open(sound);
                    clip.setFramePosition(30000);
                    clip.start();
                }
            } catch (Exception ignored) {
                System.out.print("");
            }
        }
        return currentVelocity;
    }

    /**
     * Add this paddle to the game.
     *
     * @param g The game.
     */
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }

    /**
     * set the paddle Rectangle.
     * @param rectangle1 the Rectangle.
     */
    public void setPoint(Rectangle rectangle1) {
        this.rectangle = rectangle1;
    }
}