package cn.jiruan.util;

import cn.jiruan.util.ColorEnum;
import cn.jiruan.util.StyleEnum;

import static cn.jiruan.util.StyleEnum.CLOSE;

/**
 * 控制台输出工具。通过设置颜色和样式返回有样式的字符串
 * @author szsw
 * @date 2022/11/2 14:36:49
 */
@SuppressWarnings({"unused"})
public class ConsolePrintUtils {

    private static final String QUOTE_START_STR = "\033[";
    private static final String QUOTE_END_STR = "m";

    private ConsolePrintUtils() {
    }

    /**
     * 设置样式
     *
     * @param targetStr 目标字符串
     * @param style     样式
     * @param hasClose  是否闭合，如果闭合在样式不会延续整行
     * @return 有控制台输出样式的字符串
     */
    public static String setStyle(String targetStr, StyleEnum style, boolean hasClose) {
        return setColorStyle(targetStr, null, null, style, hasClose);
    }

    /**
     * 设置样式，默认闭合
     *
     * @param targetStr 目标字符串
     * @param style     样式
     * @return 有控制台输出样式的字符串
     */
    public static String setStyle(String targetStr, StyleEnum style) {
        return setStyle(targetStr, style, true);
    }

    /**
     * 设置字体颜色和背景色
     *
     * @param targetStr       目标字符串
     * @param fontColor       字体颜色
     * @param backgroundColor 背景色
     * @param hasClose        是否闭合，如果闭合在样式不会延续整行
     * @return 有控制台输出样式的字符串
     */
    public static String setColor(String targetStr, ColorEnum fontColor, ColorEnum backgroundColor, boolean hasClose) {
        return setColorStyle(targetStr, fontColor, backgroundColor, null, hasClose);
    }

    /**
     * 设置字体颜色和背景色，默认闭合
     *
     * @param targetStr       目标字符串
     * @param fontColor       字体颜色
     * @param backgroundColor 背景色
     * @return 有控制台输出样式的字符串
     */
    public static String setColor(String targetStr, ColorEnum fontColor, ColorEnum backgroundColor) {
        return setColor(targetStr, fontColor, backgroundColor, true);
    }

    /**
     * 设置字体颜色、背景色和样式，默认闭合
     *
     * @param targetStr       目标字符串
     * @param fontColor       字体颜色
     * @param backgroundColor 背景色
     * @param style           样式
     * @return 有控制台输出样式的字符串
     */
    public static String setColorStyle(String targetStr, ColorEnum fontColor, ColorEnum backgroundColor, StyleEnum style) {
        return setColorStyle(targetStr, fontColor, backgroundColor, style, true);
    }

    /**
     * 设置字体颜色、背景色和样式
     *
     * @param targetStr       目标字符串
     * @param fontColor       字体颜色
     * @param backgroundColor 背景色
     * @param style           样式
     * @param hasClose        是否闭合，如果闭合在样式不会延续整行
     * @return 有控制台输出样式的字符串
     */
    public static String setColorStyle(String targetStr, ColorEnum fontColor, ColorEnum backgroundColor, StyleEnum style, boolean hasClose) {
        String result = "";
        boolean isStart = false;
        if (fontColor != null) {
            result += QUOTE_START_STR + fontColor.getFontColor();
            isStart = true;
        }
        if (backgroundColor != null) {
            result += (isStart ? ":" : QUOTE_START_STR) + backgroundColor.getBackgroundColor();
            isStart = true;
        }
        if (style != null) {
            result += (isStart ? ":" : QUOTE_START_STR) + style.getCode();
            isStart = true;
        }
        return result + (isStart ? QUOTE_END_STR : "") + targetStr + (hasClose ? CLOSE.getCloseCode() : "");
    }


}
