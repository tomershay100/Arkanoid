//323082701

import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Creeper class.
 *
 * @author Tomer Shay <tomershay100@gmail.com>
 * @version 1.0
 * @since 2020-06-05
 */
public class FlappyBird implements Sprite {
    private final int sizeOfPixel = 3;
    private int x;

    /**
     * Constructor.
     */
    public FlappyBird() {
        this.x = 0;
    }

    /**
     * draw big pixel on the drawSurface.
     *
     * @param d     the DrawSurface.
     * @param color the color of the pixel.
     * @param x1     the the x1 of the upper left point.
     * @param y     the the y of the upper left point.
     */
    public void drawBigPixel(DrawSurface d, Color color, int x1, int y) {
        d.setColor(color);
        d.fillRectangle(x1, y, sizeOfPixel, sizeOfPixel);
    }

    /**
     * return color according to number.
     *
     * @param i the number.
     * @return color according to number.
     */
    public Color getColor(int i) {
        switch (i) {
            case 1:
                return new Color(0, 0, 0);
            case 2:
                return new Color(254, 193, 7);
            case 3:
                return new Color(255, 255, 255);
            case 4:
                return new Color(255, 85, 33);
            default:
                return null;
        }
    }

    /**
     * Returns list of color in line according to the line number.
     *
     * @param i the number of line.
     * @return list of color in line according to the line number.
     */
    public List<Color> getLinesColorList1Down(int i) {
        List<Color> line1 = new ArrayList<>();
        switch (i) {
            case 1:
                for (int j = 0; j < 6; j++) {
                    line1.add(getColor(0));
                }
                for (int j = 0; j < 6; j++) {
                    line1.add(getColor(1));
                }
                for (int j = 0; j < 5; j++) {
                    line1.add(getColor(0));
                }
                return line1;
            case 2:
                for (int j = 0; j < 4; j++) {
                    line1.add(getColor(0));
                }
                for (int j = 0; j < 2; j++) {
                    line1.add(getColor(1));
                }
                for (int j = 0; j < 4; j++) {
                    line1.add(getColor(2));
                }
                line1.add(getColor(1));
                line1.add(getColor(3));
                line1.add(getColor(1));
                for (int j = 0; j < 4; j++) {
                    line1.add(getColor(0));
                }
                return line1;
            case 3:
                for (int j = 0; j < 3; j++) {
                    line1.add(getColor(0));
                }
                line1.add(getColor(1));
                for (int j = 0; j < 5; j++) {
                    line1.add(getColor(2));
                }
                line1.add(getColor(1));
                line1.add(getColor(3));
                line1.add(getColor(3));
                line1.add(getColor(3));
                line1.add(getColor(1));
                for (int j = 0; j < 3; j++) {
                    line1.add(getColor(0));
                }
                return line1;
            case 4:
                line1.add(getColor(0));
                for (int j = 0; j < 4; j++) {
                    line1.add(getColor(1));
                }
                for (int j = 0; j < 4; j++) {
                    line1.add(getColor(2));
                }
                line1.add(getColor(1));
                line1.add(getColor(3));
                line1.add(getColor(3));
                line1.add(getColor(1));
                line1.add(getColor(3));
                line1.add(getColor(1));
                for (int j = 0; j < 3; j++) {
                    line1.add(getColor(0));
                }
                return line1;
            case 5:
                line1.add(getColor(1));
                for (int j = 0; j < 4; j++) {
                    line1.add(getColor(3));
                }
                line1.add(getColor(1));
                for (int j = 0; j < 3; j++) {
                    line1.add(getColor(2));
                }
                line1.add(getColor(1));
                line1.add(getColor(3));
                line1.add(getColor(3));
                line1.add(getColor(1));
                line1.add(getColor(3));
                line1.add(getColor(1));
                for (int j = 0; j < 3; j++) {
                    line1.add(getColor(0));
                }
                return line1;
            case 6:
                line1.add(getColor(1));
                for (int j = 0; j < 5; j++) {
                    line1.add(getColor(3));
                }
                line1.add(getColor(1));
                for (int j = 0; j < 3; j++) {
                    line1.add(getColor(2));
                }
                line1.add(getColor(1));
                line1.add(getColor(3));
                line1.add(getColor(3));
                line1.add(getColor(3));
                line1.add(getColor(1));
                for (int j = 0; j < 2; j++) {
                    line1.add(getColor(0));
                }
                return line1;
            default:
                return null;
        }
    }

    /**
     * Returns list of color in line according to the line number.
     *
     * @param i the number of line.
     * @return list of color in line according to the line number.
     */
    public List<Color> getLinesColorList2Down(int i) {
        List<Color> line1 = new ArrayList<>();
        switch (i) {
            case 7:
                line1.add(getColor(1));
                line1.add(getColor(2));
                for (int j = 0; j < 3; j++) {
                    line1.add(getColor(3));
                }
                line1.add(getColor(2));
                line1.add(getColor(1));
                for (int j = 0; j < 4; j++) {
                    line1.add(getColor(2));
                }
                for (int j = 0; j < 5; j++) {
                    line1.add(getColor(1));
                }
                line1.add(getColor(0));
                return line1;
            case 8:
                line1.add(getColor(0));
                line1.add(getColor(1));
                for (int j = 0; j < 3; j++) {
                    line1.add(getColor(2));
                }
                line1.add(getColor(1));
                for (int j = 0; j < 4; j++) {
                    line1.add(getColor(2));
                }
                line1.add(getColor(1));
                for (int j = 0; j < 5; j++) {
                    line1.add(getColor(4));
                }
                line1.add(getColor(1));
                return line1;
            case 9:
                line1.add(getColor(0));
                line1.add(getColor(0));
                for (int j = 0; j < 3; j++) {
                    line1.add(getColor(1));
                }
                for (int j = 0; j < 4; j++) {
                    line1.add(getColor(2));
                }
                line1.add(getColor(1));
                line1.add(getColor(4));
                for (int j = 0; j < 5; j++) {
                    line1.add(getColor(1));
                }
                line1.add(getColor(0));
                return line1;
            case 10:
                for (int j = 0; j < 4; j++) {
                    line1.add(getColor(0));
                }
                line1.add(getColor(1));
                for (int j = 0; j < 5; j++) {
                    line1.add(getColor(2));
                }
                line1.add(getColor(1));
                for (int j = 0; j < 4; j++) {
                    line1.add(getColor(4));
                }
                line1.add(getColor(1));
                line1.add(getColor(0));
                return line1;
            case 11:
                for (int j = 0; j < 5; j++) {
                    line1.add(getColor(0));
                }
                line1.add(getColor(1));
                line1.add(getColor(1));
                for (int j = 0; j < 4; j++) {
                    line1.add(getColor(2));
                }
                for (int j = 0; j < 5; j++) {
                    line1.add(getColor(1));
                }
                line1.add(getColor(0));
                return line1;
            case 12:
                for (int j = 0; j < 7; j++) {
                    line1.add(getColor(0));
                }
                for (int j = 0; j < 4; j++) {
                    line1.add(getColor(1));
                }
                for (int j = 0; j < 6; j++) {
                    line1.add(getColor(0));
                }
                return line1;
            default:
                return null;
        }
    }

    /**
     * Returns list of color in line according to the line number.
     *
     * @param i the number of line.
     * @return list of color in line according to the line number.
     */
    public List<Color> getLinesColorListDown(int i) {
        if (i < 7) {
            return getLinesColorList1Down(i);
        }
        return getLinesColorList2Down(i);
    }

    /**
     * Returns list of color in line according to the line number.
     *
     * @param i the number of line.
     * @return list of color in line according to the line number.
     */
    public List<Color> getLinesColorList1Up(int i) {
        List<Color> line1 = new ArrayList<>();
        switch (i) {
            case 1:
                for (int j = 0; j < 6; j++) {
                    line1.add(getColor(0));
                }
                for (int j = 0; j < 6; j++) {
                    line1.add(getColor(1));
                }
                for (int j = 0; j < 5; j++) {
                    line1.add(getColor(0));
                }
                return line1;
            case 2:
                for (int j = 0; j < 4; j++) {
                    line1.add(getColor(0));
                }
                for (int j = 0; j < 2; j++) {
                    line1.add(getColor(1));
                }
                for (int j = 0; j < 4; j++) {
                    line1.add(getColor(2));
                }
                line1.add(getColor(1));
                line1.add(getColor(3));
                line1.add(getColor(1));
                for (int j = 0; j < 4; j++) {
                    line1.add(getColor(0));
                }
                return line1;
            case 3:
                for (int j = 0; j < 3; j++) {
                    line1.add(getColor(0));
                }
                line1.add(getColor(1));
                for (int j = 0; j < 5; j++) {
                    line1.add(getColor(2));
                }
                line1.add(getColor(1));
                line1.add(getColor(3));
                line1.add(getColor(3));
                line1.add(getColor(3));
                line1.add(getColor(1));
                for (int j = 0; j < 3; j++) {
                    line1.add(getColor(0));
                }
                return line1;
            case 4:
                line1.add(getColor(0));
                line1.add(getColor(0));
                line1.add(getColor(0));
                line1.add(getColor(1));
                for (int j = 0; j < 5; j++) {
                    line1.add(getColor(2));
                }
                line1.add(getColor(1));
                line1.add(getColor(3));
                line1.add(getColor(3));
                line1.add(getColor(1));
                line1.add(getColor(3));
                line1.add(getColor(1));
                for (int j = 0; j < 3; j++) {
                    line1.add(getColor(0));
                }
                return line1;
            case 5:
                line1.add(getColor(0));
                line1.add(getColor(0));
                line1.add(getColor(1));
                for (int j = 0; j < 6; j++) {
                    line1.add(getColor(2));
                }
                line1.add(getColor(1));
                line1.add(getColor(3));
                line1.add(getColor(3));
                line1.add(getColor(1));
                line1.add(getColor(3));
                line1.add(getColor(1));
                for (int j = 0; j < 3; j++) {
                    line1.add(getColor(0));
                }
                return line1;
            case 6:
                line1.add(getColor(0));
                for (int j = 0; j < 5; j++) {
                    line1.add(getColor(1));
                }
                for (int j = 0; j < 4; j++) {
                    line1.add(getColor(2));
                }
                line1.add(getColor(1));
                line1.add(getColor(3));
                line1.add(getColor(3));
                line1.add(getColor(3));
                line1.add(getColor(1));
                for (int j = 0; j < 2; j++) {
                    line1.add(getColor(0));
                }
                return line1;
            default:
                return null;
        }
    }

    /**
     * Returns list of color in line according to the line number.
     *
     * @param i the number of line.
     * @return list of color in line according to the line number.
     */
    public List<Color> getLinesColorList2Up(int i) {
        List<Color> line1 = new ArrayList<>();
        switch (i) {
            case 7:
                line1.add(getColor(0));
                line1.add(getColor(1));
                for (int j = 0; j < 5; j++) {
                    line1.add(getColor(3));
                }
                line1.add(getColor(1));
                for (int j = 0; j < 3; j++) {
                    line1.add(getColor(2));
                }
                for (int j = 0; j < 5; j++) {
                    line1.add(getColor(1));
                }
                line1.add(getColor(0));
                return line1;
            case 8:
                line1.add(getColor(0));
                line1.add(getColor(1));
                line1.add(getColor(2));
                for (int j = 0; j < 3; j++) {
                    line1.add(getColor(2));
                }
                line1.add(getColor(2));
                line1.add(getColor(1));
                for (int j = 0; j < 2; j++) {
                    line1.add(getColor(2));
                }
                line1.add(getColor(1));
                for (int j = 0; j < 5; j++) {
                    line1.add(getColor(4));
                }
                line1.add(getColor(1));
                return line1;
            case 9:
                line1.add(getColor(0));
                line1.add(getColor(0));
                for (int j = 0; j < 5; j++) {
                    line1.add(getColor(1));
                }
                for (int j = 0; j < 2; j++) {
                    line1.add(getColor(2));
                }
                line1.add(getColor(1));
                line1.add(getColor(4));
                for (int j = 0; j < 5; j++) {
                    line1.add(getColor(1));
                }
                line1.add(getColor(0));
                return line1;
            case 10:
                for (int j = 0; j < 4; j++) {
                    line1.add(getColor(0));
                }
                line1.add(getColor(1));
                for (int j = 0; j < 5; j++) {
                    line1.add(getColor(2));
                }
                line1.add(getColor(1));
                for (int j = 0; j < 4; j++) {
                    line1.add(getColor(4));
                }
                line1.add(getColor(1));
                line1.add(getColor(0));
                return line1;
            case 11:
                for (int j = 0; j < 5; j++) {
                    line1.add(getColor(0));
                }
                line1.add(getColor(1));
                line1.add(getColor(1));
                for (int j = 0; j < 4; j++) {
                    line1.add(getColor(2));
                }
                for (int j = 0; j < 5; j++) {
                    line1.add(getColor(1));
                }
                line1.add(getColor(0));
                return line1;
            case 12:
                for (int j = 0; j < 7; j++) {
                    line1.add(getColor(0));
                }
                for (int j = 0; j < 4; j++) {
                    line1.add(getColor(1));
                }
                for (int j = 0; j < 6; j++) {
                    line1.add(getColor(0));
                }
                return line1;
            default:
                return null;
        }
    }

    /**
     * Returns list of color in line according to the line number.
     *
     * @param i the number of line.
     * @return list of color in line according to the line number.
     */
    public List<Color> getLinesColorListUp(int i) {
        if (i < 7) {
            return getLinesColorList1Up(i);
        }
        return getLinesColorList2Up(i);
    }
    /**
     * Returns list of color in line according to the line number.
     *
     * @param i the number of line.
     * @return list of color in line according to the line number.
     */
    public List<Color> getLinesColorList1Mid(int i) {
        List<Color> line1 = new ArrayList<>();
        switch (i) {
            case 1:
                for (int j = 0; j < 6; j++) {
                    line1.add(getColor(0));
                }
                for (int j = 0; j < 6; j++) {
                    line1.add(getColor(1));
                }
                for (int j = 0; j < 5; j++) {
                    line1.add(getColor(0));
                }
                return line1;
            case 2:
                for (int j = 0; j < 4; j++) {
                    line1.add(getColor(0));
                }
                for (int j = 0; j < 2; j++) {
                    line1.add(getColor(1));
                }
                for (int j = 0; j < 4; j++) {
                    line1.add(getColor(2));
                }
                line1.add(getColor(1));
                line1.add(getColor(3));
                line1.add(getColor(1));
                for (int j = 0; j < 4; j++) {
                    line1.add(getColor(0));
                }
                return line1;
            case 3:
                for (int j = 0; j < 3; j++) {
                    line1.add(getColor(0));
                }
                line1.add(getColor(1));
                for (int j = 0; j < 5; j++) {
                    line1.add(getColor(2));
                }
                line1.add(getColor(1));
                line1.add(getColor(3));
                line1.add(getColor(3));
                line1.add(getColor(3));
                line1.add(getColor(1));
                for (int j = 0; j < 3; j++) {
                    line1.add(getColor(0));
                }
                return line1;
            case 4:
                line1.add(getColor(0));
                line1.add(getColor(0));
                line1.add(getColor(0));
                line1.add(getColor(1));
                for (int j = 0; j < 5; j++) {
                    line1.add(getColor(2));
                }
                line1.add(getColor(1));
                line1.add(getColor(3));
                line1.add(getColor(3));
                line1.add(getColor(1));
                line1.add(getColor(3));
                line1.add(getColor(1));
                for (int j = 0; j < 2; j++) {
                    line1.add(getColor(0));
                }
                return line1;
            case 5:
                line1.add(getColor(0));
                line1.add(getColor(0));
                line1.add(getColor(1));
                for (int j = 0; j < 6; j++) {
                    line1.add(getColor(2));
                }
                line1.add(getColor(1));
                for (int j = 0; j < 2; j++) {
                    line1.add(getColor(3));
                }
                line1.add(getColor(1));
                line1.add(getColor(3));
                line1.add(getColor(1));
                for (int j = 0; j < 2; j++) {
                    line1.add(getColor(0));
                }
                return line1;
            case 6:
                line1.add(getColor(0));
                line1.add(getColor(0));
                line1.add(getColor(1));
                for (int j = 0; j < 7; j++) {
                    line1.add(getColor(2));
                }
                line1.add(getColor(1));
                for (int j = 0; j < 3; j++) {
                    line1.add(getColor(3));
                }
                line1.add(getColor(1));
                for (int j = 0; j < 2; j++) {
                    line1.add(getColor(0));
                }
                return line1;
            default:
                return null;
        }
    }

    /**
     * Returns list of color in line according to the line number.
     *
     * @param i the number of line.
     * @return list of color in line according to the line number.
     */
    public List<Color> getLinesColorList2Mid(int i) {
        List<Color> line1 = new ArrayList<>();
        switch (i) {
            case 7:
                line1.add(getColor(0));
                for (int j = 0; j < 5; j++) {
                    line1.add(getColor(1));
                }
                for (int j = 0; j < 5; j++) {
                    line1.add(getColor(2));
                }
                for (int j = 0; j < 5; j++) {
                    line1.add(getColor(1));
                }
                line1.add(getColor(0));
                return line1;
            case 8:
                line1.add(getColor(0));
                line1.add(getColor(1));
                line1.add(getColor(2));
                for (int j = 0; j < 3; j++) {
                    line1.add(getColor(3));
                }
                line1.add(getColor(2));
                line1.add(getColor(1));
                for (int j = 0; j < 2; j++) {
                    line1.add(getColor(2));
                }
                line1.add(getColor(1));
                for (int j = 0; j < 5; j++) {
                    line1.add(getColor(4));
                }
                line1.add(getColor(1));
                return line1;
            case 9:
                line1.add(getColor(0));
                line1.add(getColor(1));
                for (int j = 0; j < 4; j++) {
                    line1.add(getColor(3));
                }
                line1.add(getColor(1));
                for (int j = 0; j < 2; j++) {
                    line1.add(getColor(2));
                }
                line1.add(getColor(1));
                line1.add(getColor(4));
                for (int j = 0; j < 5; j++) {
                    line1.add(getColor(1));
                }
                line1.add(getColor(0));
                return line1;
            case 10:
                line1.add(getColor(0));
                line1.add(getColor(1));
                for (int j = 0; j < 2; j++) {
                    line1.add(getColor(3));
                }
                line1.add(getColor(2));
                line1.add(getColor(1));
                for (int j = 0; j < 4; j++) {
                    line1.add(getColor(2));
                }
                line1.add(getColor(1));
                for (int j = 0; j < 4; j++) {
                    line1.add(getColor(4));
                }
                line1.add(getColor(1));
                line1.add(getColor(0));
                return line1;
            case 11:
                line1.add(getColor(0));
                line1.add(getColor(0));
                for (int j = 0; j < 4; j++) {
                    line1.add(getColor(1));
                }
                for (int j = 0; j < 5; j++) {
                    line1.add(getColor(2));
                }
                for (int j = 0; j < 5; j++) {
                    line1.add(getColor(1));
                }
                line1.add(getColor(0));
                return line1;
            case 12:
                for (int j = 0; j < 7; j++) {
                    line1.add(getColor(0));
                }
                for (int j = 0; j < 4; j++) {
                    line1.add(getColor(1));
                }
                for (int j = 0; j < 6; j++) {
                    line1.add(getColor(0));
                }
                return line1;
            default:
                return null;
        }
    }

    /**
     * Returns list of color in line according to the line number.
     *
     * @param i the number of line.
     * @return list of color in line according to the line number.
     */
    public List<Color> getLinesColorListMid(int i) {
        if (i < 7) {
            return getLinesColorList1Mid(i);
        }
        return getLinesColorList2Mid(i);
    }

    /**
     * draw one Bird on the drawSurface.
     *
     * @param d the drawSurface
     * @param x1 the the x of the upper left point.
     * @param y the the y of the upper left point.
     */
    public void drawOneBirdMid(DrawSurface d, int x1, int y) {
        for (int i = 0; i < 12; i++) {
            List<Color> line1 = getLinesColorListMid(i + 1);
            drawOneBird(d, x1, y, i, line1);
        }
    }

    /**
     * draw one Bird on the drawSurface.
     * @param d the drawSurface
     * @param x1 the the x of the upper left point.
     * @param y the the y of the upper left point.
     * @param i the line.
     * @param line1 the colors in line.
     */
    private void drawOneBird(DrawSurface d, int x1, int y, int i, List<Color> line1) {
        for (int j = 0; j < line1.size(); j++) {
            if (line1.get(j) != null) {
                Color color = line1.get(j);
                drawBigPixel(d, color, x1 + j * sizeOfPixel, y + sizeOfPixel * i);
            }
        }
        line1.clear();
    }

    /**
     * draw one Bird on the drawSurface.
     *
     * @param d the drawSurface
     * @param x1 the the x of the upper left point.
     * @param y the the y of the upper left point.
     */
    public void drawOneBirdDown(DrawSurface d, int x1, int y) {
        for (int i = 0; i < 12; i++) {
            List<Color> line1 = getLinesColorListDown(i + 1);
            drawOneBird(d, x1, y, i, line1);
        }
    }
    /**
     * draw one Bird on the drawSurface.
     *
     * @param d the drawSurface
     * @param x1 the the x of the upper left point.
     * @param y the the y of the upper left point.
     */
    public void drawOneBirdUp(DrawSurface d, int x1, int y) {
        for (int i = 0; i < 12; i++) {
            List<Color> line1 = getLinesColorListUp(i + 1);
            drawOneBird(d, x1, y, i, line1);
        }
    }
    @Override
    public void drawOn(DrawSurface d) {
        if (x % 40 <= 9) {
            drawOneBirdDown(d, x, 410);
        } else if (x % 40 <= 19) {
            drawOneBirdUp(d, x, 400);
        } else if (x % 40 <= 29) {
            drawOneBirdMid(d, x, 390);
        } else {
            drawOneBirdUp(d, x, 400);
        }
    }

    @Override
    public void timePassed() {
        x++;
        if (x == 800) {
            x = -15;
        }
    }
}
