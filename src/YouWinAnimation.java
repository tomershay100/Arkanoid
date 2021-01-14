//323082701
import biuoop.DrawSurface;
import extra.Draw;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
/**
 * YouWinAnimation class.
 *
 * @author Tomer Shay <tomershay100@gmail.com>
 * @version 1.0
 * @since 2020-06-05
 */
public class YouWinAnimation implements Animation {
    private final int score;
    private final boolean stop;
    private final int[] y;

    /**
     * Constructor.
     * @param score the score.
     */
    public YouWinAnimation(int score) {
        this.score = score;
        stop = false;
        this.y = new int[]{600, 640, 680, 720, 760, 800, 820, 840, 860};
    }

    /**
     * draw big pixel on the drawSurface.
     * @param d the DrawSurface.
     * @param color the color of the pixel.
     * @param x the the x of the upper left point.
     * @param y1 the the y of the upper left point.
     */
    public void drawBigPixel(DrawSurface d, Color color, int x, int y1) {
        d.setColor(color);
        d.fillRectangle(x, y1, 10, 10);
    }
    /**
     * Returns list of color in line according to the line number.
     * @param i the number of line.
     * @return list of color in line according to the line number.
     */
    public java.util.List<Color> getLinesColorList(int i) {
        Color background = Color.BLACK;
        Color color1 = new Color(150, 132, 0);
        Color color2 = new Color(202, 181, 24);
        Color color3 = new Color(157, 31, 5);
        Color color4 = new Color(236, 74, 40);
        Color color5 = new Color(86, 17, 3);
        Color color6 = new Color(193, 42, 10);

        List<Color> line = new ArrayList<>();
        if (i == 1) {
            line.add(color1);
            for (int j = 0; j < 5; j++) {
                line.add(background);
            }
            for (int j = 0; j < 2; j++) {
                line.add(color2);
            }
            for (int j = 0; j < 5; j++) {
                line.add(background);
            }
            line.add(color2);
            return line;
        }
        if (i == 2) {
            line.add(color1);
            line.add(color2);
            for (int j = 0; j < 3; j++) {
                line.add(background);
            }
            for (int j = 0; j < 4; j++) {
                line.add(color2);
            }
            for (int j = 0; j < 3; j++) {
                line.add(background);
            }
            for (int j = 0; j < 2; j++) {
                line.add(color2);
            }
            return line;
        }
        if (i == 3) {
            line.add(color3);
            line.add(color1);
            line.add(color2);
            line.add(background);
            for (int j = 0; j < 6; j++) {
                line.add(color2);
            }
            line.add(background);
            for (int j = 0; j < 2; j++) {
                line.add(color2);
            }
            line.add(color4);
            return line;
        }
        if (i == 4) {
            line.add(color5);
            line.add(color3);
            line.add(color1);
            line.add(color2);
            for (int j = 0; j < 2; j++) {
                line.add(color2);
            }
            for (int j = 0; j < 2; j++) {
                line.add(color6);
            }
            for (int j = 0; j < 4; j++) {
                line.add(color2);
            }
            for (int j = 0; j < 2; j++) {
                line.add(color6);
            }
            return line;
        }
        if (i == 5) {
            line.add(color5);
            line.add(color3);
            line.add(color1);
            line.add(color2);
            for (int j = 0; j < 1; j++) {
                line.add(color2);
            }
            line.add(color6);
            for (int j = 0; j < 2; j++) {
                line.add(color3);
            }
            line.add(color6);
            for (int j = 0; j < 3; j++) {
                line.add(color2);
            }
            for (int j = 0; j < 2; j++) {
                line.add(color6);
            }
            return line;
        }
        if (i == 6) {
            line.add(color3);
            for (int j = 0; j < 3; j++) {
                line.add(color1);
            }
            line.add(color2);
            line.add(color6);
            for (int j = 0; j < 2; j++) {
                line.add(color3);
            }
            line.add(color6);
            for (int j = 0; j < 4; j++) {
                line.add(color2);
            }
            line.add(color4);
            return line;
        }
        if (i == 7) {
            for (int j = 0; j < 5; j++) {
                line.add(color1);
            }
            line.add(color2);
            for (int j = 0; j < 2; j++) {
                line.add(color6);
            }
            for (int j = 0; j < 6; j++) {
                line.add(color2);
            }
            return line;
        }
        line.add(background);
        for (int j = 0; j < 4; j++) {
            line.add(color1);
        }
        for (int j = 0; j < 8; j++) {
            line.add(color2);
        }
        line.add(background);
        return line;
    }
    /**
     * draw one Crown on the drawSurface.
     * @param d the drawSurface
     * @param x the the x of the upper left point.
     * @param y1 the the y of the upper left point.
     */
    public void drawOneCrown(DrawSurface d, int x, int y1) {
        for (int i = 0; i < 8; i++) {
            List<Color> line = getLinesColorList(i + 1);
            for (int j = 0; j < line.size(); j++) {
                Color color = line.get(j);
                drawBigPixel(d, color, x + j * 10, y1 + 10 * i);
            }
            line.clear();
        }
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.BLACK);
        d.fillRectangle(0, 0, d.getWidth(), d.getHeight());
        d.setColor(Color.WHITE);
        d.drawText(50, 200, "OMG! You win", 32);
        Draw.drawText(d, 50, 250, "Score: " + this.score, 15, Color.GRAY.brighter());
        Draw.drawText(d, 50, 450, "Press Space to Exit", 25, Color.GRAY.brighter());
        drawOneCrown(d, 65, 80);
        GameOverAnimation.drawCredits(d, y, Color.WHITE);
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
