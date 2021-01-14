//323082701

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.net.URL;

/**
 * Removes Balls from the game and change the counter.
 *
 * @author Tomer Shay <tomershay100@gmail.com>
 * @version 1.0
 * @since 2020-05-21
 */

public class BallRemover implements HitListener {
    private final GameLevel game;
    private final Counter availabeBalls;

    /**
     * Constructor.
     *
     * @param game          the game.
     * @param availabeBalls the counter of balls.
     */
    public BallRemover(GameLevel game, Counter availabeBalls) {
        this.game = game;
        this.availabeBalls = availabeBalls;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        //System.out.println("D");
        if (beingHit.isDeathBlock()) {
            //System.out.println("D");
            this.availabeBalls.decrease(1);
            //System.out.println(this.availabeBalls.getValue());
            hitter.removeFromGame(this.game);
            if (availabeBalls.getValue() == 0) {
                //beingHit.removeHitListener(this);
                //this.remainingBlocks.decrease(1);
                beingHit.removeFromGame(this.game);
                //beingHit.removeHitListener(this);
            }
            //hitter.removeHitListener(this);
        }

        if (beingHit.isDupBalls()) {
            //this.game.addBall();
            //Random rand = new Random();
            //System.out.println("D");
            //this.availabeBalls.increase(1);
            //System.out.println(this.availabeBalls.getValue());
            //Ball b = new Ball(400, 400, hitter.getSize(), hitter.getColor());
            //b.setVelocity(hitter.getVelocity());
            game.createBallOnTopOfPaddle(hitter.getVelocity());
            //b.addToGame(this.game);
            //b.addHitListener(this);
            try {
                URL dupBlock = getClass().getClassLoader().getResource("healingSound.wav");
                if (dupBlock != null) {
                    AudioInputStream sound = AudioSystem.getAudioInputStream(dupBlock);
                    Clip clip = AudioSystem.getClip();
                    clip.open(sound);
                    clip.setFramePosition(0);
                    clip.start();
                } else {
                    String filePath = "src\\extra\\healingSound.wav";
                    AudioInputStream audioInput = AudioSystem.getAudioInputStream(
                            new File(filePath).getAbsoluteFile());
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioInput);
                    clip.start();
                }
                /*
                String filePath = "src\\sound\\healingSound.wav";
                //SimpleAudioPlayer audioPlayer = new SimpleAudioPlayer(filePath);

                //audioPlayer.play();
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                */
            } catch (Exception ignored) {
                System.out.print("");
            }
        }
    }
}
