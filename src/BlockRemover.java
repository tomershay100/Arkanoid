//323082701

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.net.URL;

// a BlocksPackage.BlockRemover is in charge of removing blocks from the game, as well as keeping count
// of the number of blocks that remain.

/**
 * a BlocksPackage. BlockRemover is in charge of removing blocks from the game, as well as keeping count of the number
 * of blocks that remain.
 *
 * @author Tomer Shay <tomershay100@gmail.com>
 * @version 1.0
 * @since 2020-05-21
 */
public class BlockRemover implements HitListener {
    private final GameLevel game;
    private final Counter remainingBlocks;

    /**
     * Constructor.
     *
     * @param game          the game.
     * @param removedBlocks the Counter.
     */
    public BlockRemover(GameLevel game, Counter removedBlocks) {
        this.game = game;
        this.remainingBlocks = removedBlocks;
    }

    // Blocks that are hit and reach 0 hit-points should be removed
    // from the game. Remember to remove this listener from the block
    // that is being removed from the game.
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        if (!beingHit.isDeathBlock() && !beingHit.isDupBalls() && !beingHit.isBorderBlock()) {
            //System.out.println("$");
            beingHit.decreaseHitCount();
            if (beingHit.getHitCountLeft() == 0) {
                this.remainingBlocks.decrease(1);
                beingHit.removeFromGame(this.game);
                beingHit.removeHitListener(this);
            } else {
                beingHit.brightColor();
            }
            try {
                URL blockHit = getClass().getClassLoader().getResource("soundIdan.wav");
                if (blockHit != null) {
                    AudioInputStream sound = AudioSystem.getAudioInputStream(blockHit);
                    Clip clip = AudioSystem.getClip();
                    clip.open(sound);
                    clip.setFramePosition(0);
                    clip.start();
                } else {
                    String filePath = "src\\extra\\soundIdan.wav";
                    AudioInputStream audioInput = AudioSystem.getAudioInputStream(
                            new File(filePath).getAbsoluteFile());
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioInput);
                    clip.start();
                }
                /*
                String filePath = "src\\sound\\soundIdan.wav";
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
        } /*else if (beingHit.isBorderBlock()) {
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
        }*/
    }
}