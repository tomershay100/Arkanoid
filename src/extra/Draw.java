//323082701
package extra;

import biuoop.DrawSurface;

import java.awt.Color;

/**
 * extra.Draw Class.
 *
 * @author Tomer Shay <tomershay100@gmail.com>
 * @version 1.0
 * @since 2020-04-24
 */
public class Draw {
    /**
     * extra.Draw text without border on drawSurface.
     *
     * @param d           the drawSurface
     * @param x           the X axis
     * @param y           the Y axis
     * @param str         the text
     * @param fontSize    the font size
     * @param colorOfText the color of the text
     */
    public static void drawTextWithOutBorder(DrawSurface d, int x, int y, String str, int fontSize, Color colorOfText) {
        d.setColor(Color.darkGray.darker());
        d.drawText(x - 1, y + 2, str, fontSize);
        d.setColor(colorOfText);
        d.drawText(x, y, str, fontSize);
    }

    /**
     * extra.Draw text with border on drawSurface.
     *
     * @param d           the drawSurface
     * @param x           the X axis
     * @param y           the Y axis
     * @param str         the text
     * @param fontSize    the font size
     * @param colorOfText the color of the text
     */
    public static void drawText(DrawSurface d, int x, int y, String str, int fontSize, Color colorOfText) {
        drawBlock(d, x - 4 - fontSize / 2, (int) (y - 6 - fontSize / 1.5), (int) (str.length() * (fontSize / 2.0) + 20),
                fontSize + 10, colorOfText);
        d.setColor(Color.darkGray.darker());
        //d.drawText(x - 1, y + 2, str, fontSize);
        //d.setColor(colorOfText);
        d.drawText(x, y, str, fontSize);
    }

    /**
     * extra.Draw bloc on drawSurface.
     *
     * @param d            the drawSurface
     * @param x            the X axis
     * @param y            the Y axis
     * @param width        the width of the block
     * @param height       the height of the block
     * @param colorOfBlock the color of the block
     */
    public static void drawBlock(DrawSurface d, int x, int y, int width, int height, Color colorOfBlock) {
        //dark
        d.setColor(Color.darkGray.darker());
        d.fillRectangle(x, y + 5, width - 4, height - 5);
        //color
        d.setColor(colorOfBlock);
        d.fillRectangle(x + 1, y, width, height - 2);
        //dots
        d.setColor(Color.GRAY.darker().darker().darker());
        d.fillRectangle(x + 5, y + 4, 3, 3);
        d.fillRectangle(x + 5, y + height - 8, 3, 3);
        d.fillRectangle(x - 5 + width, y + height - 8, 3, 3);
        d.fillRectangle(x - 5 + width, y + 4, 3, 3);
        //bright
        d.setColor(Color.LIGHT_GRAY.brighter());
        d.fillRectangle(x + 4, y, width - 3, 2);
        d.fillRectangle(x + width, y, 1, height - 5);
    }
}
