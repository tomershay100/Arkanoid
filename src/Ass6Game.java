//323082701


import biuoop.GUI;

import java.util.ArrayList;
import java.util.List;

/**
 * The final game.
 *
 * @author Tomer Shay <tomershay100@gmail.com>
 * @version 1.0
 * @since 2020-05-21
 */
public class Ass6Game {
    /**
     * The final game.
     *
     * @param args not used.
     */
    public static void main(String[] args) {
        //GameLevel gameLevel = new GameLevel(new DirectHit());
        //GameLevel gameLevel = new GameLevel(new WideEasy());
        GUI gui = new GUI("Arkanoid", 800, 600);
        AnimationRunner animationRunner = new AnimationRunner(gui, 60);
        GameFlow gameFlow = new GameFlow(animationRunner, gui.getKeyboardSensor());
        Counter lives = new Counter();
        lives.increase(1);
        gameFlow.setLives(lives);
        List<LevelInformation> lst = new ArrayList<>();
        //lst.add(new TheBoss());
        if (args == null || args.length == 0) {
            lst.add(new DirectHit());
            lst.add(new WideEasy());
            lst.add(new Green3());
            lst.add(new FinalFour());
        } else {
            for (String arg : args) {
                switch (arg) {
                    case "1":
                        lst.add(new DirectHit());
                        break;
                    case "2":
                        lst.add(new WideEasy());
                        break;
                    case "3":
                        lst.add(new Green3());
                        break;
                    case "4":
                        lst.add(new FinalFour());
                        break;
                    default:
                        break;
                }
            }
            if (lst.isEmpty()) {
                lst.add(new DirectHit());
                lst.add(new WideEasy());
                lst.add(new Green3());
                lst.add(new FinalFour());
            }
        }
        gameFlow.runLevels(lst);
    }
}
