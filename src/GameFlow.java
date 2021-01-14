//323082701
import biuoop.KeyboardSensor;
import biuoop.Sleeper;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.net.URL;
import java.util.List;
/**
 * GameFlow class.
 *
 * @author Tomer Shay <tomershay100@gmail.com>
 * @version 1.0
 * @since 2020-06-05
 */
public class GameFlow {

    private final KeyboardSensor keyboardSensor;
    private final AnimationRunner animationRunner;
    private Counter lives;
    private Counter score;

    /**
     * Constructor.
     * @param ar AnimationRunner
     * @param ks KeyboardSensor
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks) {
        this.keyboardSensor = ks;
        this.animationRunner = ar;
        score = new Counter();
    }

    /**
     * set the lives.
     * @param lives1 the lives.
     */
    public void setLives(Counter lives1) {
        this.lives = lives1;
    }

    /**
     * set the score.
     * @param score1 the score.
     */
    public void setScore(Counter score1) {
        this.score = score1;
    }

    /**
     * run all the levels.
     * @param levels the levels.
     */
    public void runLevels(List<LevelInformation> levels) {
        for (int i = 0; i < levels.size(); i++) {
            LevelInformation levelInfo = levels.get(i);

            GameLevel level = new GameLevel(levelInfo, this.keyboardSensor, this.animationRunner);
            level.setLives(this.lives);
            level.addToScore(this.score.getValue());
            level.initialize();

            while (level.getLives().getValue() != 0 && level.getRemainingBlocks().getValue() != 0) {
                level.playOneTurn();
            }

            if (level.getLives().getValue() == 0) {
                try {
                    //Sleeper sleeper = new Sleeper();
                    URL gameOver = getClass().getClassLoader().getResource("pacmanGameOver.wav");
                    if (gameOver != null) {
                        AudioInputStream sound = AudioSystem.getAudioInputStream(gameOver);
                        Clip clip = AudioSystem.getClip();
                        clip.open(sound);
                        clip.setFramePosition(0);
                        clip.start();
                        //sleeper.sleepFor(1800);
                    } else {
                        String filePath = "src\\extra\\pacmanGameOver.wav";
                        AudioInputStream audioInput = AudioSystem.getAudioInputStream(
                                new File(filePath).getAbsoluteFile());
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioInput);
                        clip.start();
                        //sleeper.sleepFor(1750);
                    }
                } catch (Exception ignored) {
                    //ignored.printStackTrace();
                    System.out.print("");
                }
                this.setScore(level.getScore());
                EndScreen endScreen = new EndScreen(keyboardSensor, true, score.getValue(), animationRunner.getGui());
                this.animationRunner.run(endScreen);
                break;
            }
            try {
                Sleeper sleeper = new Sleeper();
                URL gameWin = getClass().getClassLoader().getResource("winSound.wav");
                if (gameWin != null) {
                    AudioInputStream sound = AudioSystem.getAudioInputStream(gameWin);
                    Clip clip = AudioSystem.getClip();
                    clip.open(sound);
                    clip.setFramePosition(0);
                    clip.start();
                    sleeper.sleepFor(5200 - 2000);
                } else {
                    String filePath = "src\\extra\\winSound.wav";
                    AudioInputStream audioInput = AudioSystem.getAudioInputStream(
                            new File(filePath).getAbsoluteFile());
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioInput);
                    clip.start();
                    sleeper.sleepFor(5500 - 2000);
                }
            } catch (Exception ignored) {
                System.out.print("");
            }
            this.setLives(level.getLives());
            this.setScore(level.getScore());
            if (i + 2 == levels.size() && levels.get(i + 1).levelName().equals("Final Four")) {
                BeforeTheBoss beforeTheBoss = new BeforeTheBoss(keyboardSensor, score.getValue(),
                        animationRunner.getGui());
                this.animationRunner.run(beforeTheBoss);
                this.lives.increase(2);
            }
            if (i + 1 == levels.size()) {
                EndScreen endScreen = new EndScreen(keyboardSensor, false, score.getValue(),
                        animationRunner.getGui());
                this.animationRunner.run(endScreen);
            }
        }
        animationRunner.getGui().close();
    }
}