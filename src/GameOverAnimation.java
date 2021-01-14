//323082701
import biuoop.DrawSurface;
import extra.Draw;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
/**
 * GameOverAnimation class.
 *
 * @author Tomer Shay <tomershay100@gmail.com>
 * @version 1.0
 * @since 2020-06-05
 */
public class GameOverAnimation implements Animation {
    private final int score;
    private final boolean stop;
    private final int[] y;

    /**
     * Constructor.
     * @param score the score.
     */
    public GameOverAnimation(int score) {
        this.score = score;
        stop = false;
        this.y = new int[]{600, 640, 680, 720, 760, 800, 820, 840, 860};
    }

    /**
     * returns colors list.
     * @param background the background color
     * @param yellow yellow color
     * @param black black color
     * @param blue blue color
     * @param line the list.
     */
    static void getColors1(Color background, Color yellow, Color black, Color blue, List<Color> line) {
        for (int j = 0; j < 2; j++) {
            line.add(background);
        }
        line.add(yellow);
        getColors1(yellow, black, blue, line);
        line.add(yellow);
    }

    /**
     * returns colors list.
     * @param yellow yellow color
     * @param black black color
     * @param blue blue color
     * @param line the list.
     */
    private static void getColors1(Color yellow, Color black, Color blue, List<Color> line) {
        for (int j = 0; j < 2; j++) {
            line.add(blue);
        }
        line.add(yellow);
        for (int j = 0; j < 3; j++) {
            line.add(black);
        }
        line.add(yellow);
        for (int j = 0; j < 2; j++) {
            line.add(blue);
        }
    }

    /**
     * draw the credits.
     * @param d the DrawSurface
     * @param y1 the array.
     * @param color the color of the text.
     */
    static void drawCredits(DrawSurface d, int[] y1, Color color) {
        d.setColor(color);
        d.drawText(450, y1[0], "Audio:", 17);
        d.drawText(450 + 115, y1[0], "Idan Tzur", 17);
        d.drawText(450, y1[1], "Development:", 17);
        d.drawText(450 + 115, y1[1], "Tomer Shay", 17);
        d.drawText(450, y1[2], "Designer:", 17);
        d.drawText(450 + 115, y1[2], "Tomer Shay", 17);
        d.drawText(450, y1[3], "Easter Eggs:", 17);
        d.drawText(450 + 115, y1[3], "Tomer Shay", 17);
        d.drawText(450, y1[4], "Creator:", 17);
        d.drawText(450 + 115, y1[4], "Tomer Shay", 17);
        d.drawText(450, y1[5], "Copyrights:", 17);
        d.drawText(450 + 115, y1[5], "Super Mario,", 17);
        d.drawText(450 + 115, y1[6], "Pacman,", 17);
        d.drawText(450 + 115, y1[7], "Fluppy Bird", 17);
        d.drawText(450 + 115, y1[8], "and Minecraft", 17);
        for (int i = 0; i < y1.length; i++) {
            if (y1[i] == 5) {
                y1[i] = 610;
            } else {
                y1[i]--;
            }
        }
    }

    /**
     * draw big pixel.
     * @param d the DrawSurface.
     * @param color the color.
     * @param x the x axis.
     * @param y1 the y axis.
     */
    public void drawBigPixel(DrawSurface d, Color color, int x, int y1) {
        d.setColor(color);
        d.fillRectangle(x, y1, 10, 10);
    }

    /**
     * returns list of colors according to line number.
     * @param i line number.
     * @return list of color of line.
     */
    public java.util.List<Color> getLinesColorList(int i) {
        Color background = Color.BLACK;
        Color yellow = new Color(238, 243, 12);
        Color black = Color.BLACK;
        Color white = Color.WHITE;
        Color blue = new Color(135, 192, 243);

        java.util.List<Color> line = new ArrayList<>();
        if (i == 1 || i == 15) {
            for (int j = 0; j < 5; j++) {
                line.add(background);
            }
            for (int j = 0; j < 5; j++) {
                line.add(yellow);
            }
            for (int j = 0; j < 5; j++) {
                line.add(background);
            }
            return line;
        }
        if (i == 2) {
            for (int j = 0; j < 3; j++) {
                line.add(background);
            }
            for (int j = 0; j < 9; j++) {
                line.add(yellow);
            }
            for (int j = 0; j < 3; j++) {
                line.add(background);
            }
            return line;
        }
        if (i == 3) {
            for (int j = 0; j < 2; j++) {
                line.add(background);
            }
            for (int j = 0; j < 11; j++) {
                line.add(yellow);
            }
            for (int j = 0; j < 2; j++) {
                line.add(background);
            }
            return line;
        }
        if (i == 4) {
            line.add(background);
            for (int j = 0; j < 2; j++) {
                line.add(yellow);
            }
            line.add(black);
            for (int j = 0; j < 7; j++) {
                line.add(yellow);
            }
            line.add(black);
            for (int j = 0; j < 2; j++) {
                line.add(yellow);
            }
            line.add(background);
            return line;
        }
        if (i == 5) {
            line.add(background);
            line.add(yellow);
            line.add(black);
            for (int j = 0; j < 9; j++) {
                line.add(yellow);
            }
            line.add(black);
            line.add(yellow);
            line.add(background);

            return line;
        }
        if (i == 6) {
            for (int j = 0; j < 4; j++) {
                line.add(yellow);
            }
            for (int j = 0; j < 2; j++) {
                line.add(black);
            }
            for (int j = 0; j < 3; j++) {
                line.add(yellow);
            }
            for (int j = 0; j < 2; j++) {
                line.add(black);
            }
            for (int j = 0; j < 4; j++) {
                line.add(yellow);
            }
            return line;
        }
        if (i == 7) {
            for (int j = 0; j < 3; j++) {
                line.add(yellow);
            }
            line.add(black);
            line.add(blue);
            line.add(yellow);
            line.add(black);
            line.add(yellow);
            line.add(black);
            line.add(yellow);
            line.add(blue);
            line.add(black);
            for (int j = 0; j < 3; j++) {
                line.add(yellow);
            }
            return line;
        }
        if (i == 8 || i == 9) {
            return getColors(yellow, yellow, blue, line);
        }
        if (i == 10) {
            for (int j = 0; j < 3; j++) {
                line.add(yellow);
            }
            getColors1(yellow, white, blue, line);
            for (int j = 0; j < 3; j++) {
                line.add(yellow);
            }
            return line;
        }
        if (i == 11) {
            return getColors(background, yellow, white, blue, line);
        }
        if (i == 12) {
            return getColors(background, yellow, black, blue, line);
        }
        if (i == 13) {
            getColors1(background, yellow, black, blue, line);
            for (int j = 0; j < 2; j++) {
                line.add(background);
            }
            return line;
        }
        return getColors(background, yellow, blue, line);
    }

    /**
     * returns colors list.
     * @param background color.
     * @param yellow color.
     * @param white color.
     * @param blue color.
     * @param line the list.
     * @return colors list.
     */
    private List<Color> getColors(Color background, Color yellow, Color white, Color blue, List<Color> line) {
        line.add(background);
        for (int j = 0; j < 2; j++) {
            line.add(yellow);
        }
        getColors1(yellow, white, blue, line);
        for (int j = 0; j < 2; j++) {
            line.add(yellow);
        }
        line.add(background);
        return line;
    }
    /**
     * returns colors list.
     * @param background color.
     * @param yellow color.
     * @param blue color.
     * @param line the list.
     * @return colors list.
     */
    private List<Color> getColors(Color background, Color yellow, Color blue, List<Color> line) {
        for (int j = 0; j < 3; j++) {
            line.add(background);
        }
        for (int j = 0; j < 2; j++) {
            line.add(blue);
        }
        for (int j = 0; j < 5; j++) {
            line.add(yellow);
        }
        for (int j = 0; j < 2; j++) {
            line.add(blue);
        }
        for (int j = 0; j < 3; j++) {
            line.add(background);
        }
        return line;
    }

    /**
     * draw sad emoji on DrawSurface.
     * @param d the DrawSurface.
     * @param x the x axis.
     * @param y1 the y axis.
     */
    public void drawOneSadEmoji(DrawSurface d, int x, int y1) {
        for (int i = 0; i < 15; i++) {
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
        //new Tnt().drawOn(d);
        d.setColor(Color.BLACK);
        d.fillRectangle(0, 0, d.getWidth(), d.getHeight());
        d.setColor(Color.WHITE);
        d.drawText(50, 200, "Loser! You lost", 32);
        Draw.drawText(d, 50, 250, "Score: " + this.score, 15, Color.GRAY.brighter());
        Draw.drawText(d, 50, 450, "Press Space to Exit", 25, Color.GRAY.brighter());
        new Tnt(9).drawOneTNT(d, 400, 12);
        new Tnt(9).drawOneTNT(d, 400, 156);
        new Tnt(9).drawOneTNT(d, 400, 300);
        new Tnt(9).drawOneTNT(d, 400, 444);
        new Tnt(9).drawOneTNT(d, 544, 12);
        new Tnt(9).drawOneTNT(d, 544, 156);
        new Tnt(9).drawOneTNT(d, 544, 300);
        new Tnt(9).drawOneTNT(d, 544, 444);
        drawOneSadEmoji(d, 250, 250);
        int[] yCopy = new int[y.length];
        for (int i = 0; i < y.length; i++) {
            yCopy[i] = y[i] + 2;
        }
        drawCredits(d, yCopy, Color.black);
        drawCredits(d, y, Color.WHITE);
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
