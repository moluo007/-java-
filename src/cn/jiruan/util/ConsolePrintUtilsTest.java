package cn.jiruan.util;

import org.junit.Test;

import static cn.jiruan.util.ColorEnum.*;
import static cn.jiruan.util.StyleEnum.*;

/**
 * ����̨�����ʽ������
 * @author szsw
 */
@SuppressWarnings({"java:S2699", "all"})
public class ConsolePrintUtilsTest {

    @Test
    public void setColor() {
        String targetStr = "Hello World !";
        StringBuilder s = new StringBuilder();
        s.append(ConsolePrintUtils.setColor(targetStr, null, BACK));
        s.append("\n");
        s.append(ConsolePrintUtils.setColor(targetStr, BACK, null));
        s.append("\n");
        s.append(ConsolePrintUtils.setColor(targetStr, null, null));
        s.append("\n");
        s.append(ConsolePrintUtils.setColor(targetStr, BACK, BACK));
        s.append("\n");
        s.append(ConsolePrintUtils.setColor(targetStr, RED, BACK));
        s.append("\n");
        s.append(ConsolePrintUtils.setColor(targetStr, GREEN, BACK));
        s.append("\n");
        s.append(ConsolePrintUtils.setColor(targetStr, YELLOW, BACK));
        s.append("\n");
        s.append(ConsolePrintUtils.setColor(targetStr, BLUE, BACK));
        s.append("\n");
        s.append(ConsolePrintUtils.setColor(targetStr, PURPLE, BACK));
        s.append("\n");
        s.append(ConsolePrintUtils.setColor(targetStr, DARK_GREEN, BACK));
        s.append("\n");
        s.append(ConsolePrintUtils.setColor(targetStr, WHITE, BACK));
        s.append("\n");

        s.append(ConsolePrintUtils.setColor(targetStr, BACK, RED));
        s.append("\n");
        s.append(ConsolePrintUtils.setColor(targetStr, RED, RED));
        s.append("\n");
        s.append(ConsolePrintUtils.setColor(targetStr, GREEN, RED));
        s.append("\n");
        s.append(ConsolePrintUtils.setColor(targetStr, YELLOW, RED));
        s.append("\n");
        s.append(ConsolePrintUtils.setColor(targetStr, BLUE, RED));
        s.append("\n");
        s.append(ConsolePrintUtils.setColor(targetStr, PURPLE, RED));
        s.append("\n");
        s.append(ConsolePrintUtils.setColor(targetStr, DARK_GREEN, RED));
        s.append("\n");
        s.append(ConsolePrintUtils.setColor(targetStr, WHITE, RED));
        s.append("\n");

        s.append(ConsolePrintUtils.setColor(targetStr, BACK, GREEN));
        s.append("\n");
        s.append(ConsolePrintUtils.setColor(targetStr, RED, GREEN));
        s.append("\n");
        s.append(ConsolePrintUtils.setColor(targetStr, GREEN, GREEN));
        s.append("\n");
        s.append(ConsolePrintUtils.setColor(targetStr, YELLOW, GREEN));
        s.append("\n");
        s.append(ConsolePrintUtils.setColor(targetStr, BLUE, GREEN));
        s.append("\n");
        s.append(ConsolePrintUtils.setColor(targetStr, PURPLE, GREEN));
        s.append("\n");
        s.append(ConsolePrintUtils.setColor(targetStr, DARK_GREEN, GREEN));
        s.append("\n");
        s.append(ConsolePrintUtils.setColor(targetStr, WHITE, GREEN));
        s.append("\n");

        s.append(ConsolePrintUtils.setColor(targetStr, BACK, YELLOW));
        s.append("\n");
        s.append(ConsolePrintUtils.setColor(targetStr, RED, YELLOW));
        s.append("\n");
        s.append(ConsolePrintUtils.setColor(targetStr, GREEN, YELLOW));
        s.append("\n");
        s.append(ConsolePrintUtils.setColor(targetStr, YELLOW, YELLOW));
        s.append("\n");
        s.append(ConsolePrintUtils.setColor(targetStr, BLUE, YELLOW));
        s.append("\n");
        s.append(ConsolePrintUtils.setColor(targetStr, PURPLE, YELLOW));
        s.append("\n");
        s.append(ConsolePrintUtils.setColor(targetStr, DARK_GREEN, YELLOW));
        s.append("\n");
        s.append(ConsolePrintUtils.setColor(targetStr, WHITE, YELLOW));
        s.append("\n");

        s.append(ConsolePrintUtils.setColor(targetStr, BACK, BLUE));
        s.append("\n");
        s.append(ConsolePrintUtils.setColor(targetStr, RED, BLUE));
        s.append("\n");
        s.append(ConsolePrintUtils.setColor(targetStr, GREEN, BLUE));
        s.append("\n");
        s.append(ConsolePrintUtils.setColor(targetStr, YELLOW, BLUE));
        s.append("\n");
        s.append(ConsolePrintUtils.setColor(targetStr, BLUE, BLUE));
        s.append("\n");
        s.append(ConsolePrintUtils.setColor(targetStr, PURPLE, BLUE));
        s.append("\n");
        s.append(ConsolePrintUtils.setColor(targetStr, DARK_GREEN, BLUE));
        s.append("\n");
        s.append(ConsolePrintUtils.setColor(targetStr, WHITE, BLUE));
        s.append("\n");

        s.append(ConsolePrintUtils.setColor(targetStr, BACK, PURPLE));
        s.append("\n");
        s.append(ConsolePrintUtils.setColor(targetStr, RED, PURPLE));
        s.append("\n");
        s.append(ConsolePrintUtils.setColor(targetStr, GREEN, PURPLE));
        s.append("\n");
        s.append(ConsolePrintUtils.setColor(targetStr, YELLOW, PURPLE));
        s.append("\n");
        s.append(ConsolePrintUtils.setColor(targetStr, BLUE, PURPLE));
        s.append("\n");
        s.append(ConsolePrintUtils.setColor(targetStr, PURPLE, PURPLE));
        s.append("\n");
        s.append(ConsolePrintUtils.setColor(targetStr, DARK_GREEN, PURPLE));
        s.append("\n");
        s.append(ConsolePrintUtils.setColor(targetStr, WHITE, PURPLE));
        s.append("\n");

        s.append(ConsolePrintUtils.setColor(targetStr, BACK, DARK_GREEN));
        s.append("\n");
        s.append(ConsolePrintUtils.setColor(targetStr, RED, DARK_GREEN));
        s.append("\n");
        s.append(ConsolePrintUtils.setColor(targetStr, GREEN, DARK_GREEN));
        s.append("\n");
        s.append(ConsolePrintUtils.setColor(targetStr, YELLOW, DARK_GREEN));
        s.append("\n");
        s.append(ConsolePrintUtils.setColor(targetStr, BLUE, DARK_GREEN));
        s.append("\n");
        s.append(ConsolePrintUtils.setColor(targetStr, PURPLE, DARK_GREEN));
        s.append("\n");
        s.append(ConsolePrintUtils.setColor(targetStr, DARK_GREEN, DARK_GREEN));
        s.append("\n");
        s.append(ConsolePrintUtils.setColor(targetStr, WHITE, DARK_GREEN));
        s.append("\n");

        s.append(ConsolePrintUtils.setColor(targetStr, BACK, WHITE));
        s.append("\n");
        s.append(ConsolePrintUtils.setColor(targetStr, RED, WHITE));
        s.append("\n");
        s.append(ConsolePrintUtils.setColor(targetStr, GREEN, WHITE));
        s.append("\n");
        s.append(ConsolePrintUtils.setColor(targetStr, YELLOW, WHITE));
        s.append("\n");
        s.append(ConsolePrintUtils.setColor(targetStr, BLUE, WHITE));
        s.append("\n");
        s.append(ConsolePrintUtils.setColor(targetStr, PURPLE, WHITE));
        s.append("\n");
        s.append(ConsolePrintUtils.setColor(targetStr, DARK_GREEN, WHITE));
        s.append("\n");
        s.append(ConsolePrintUtils.setColor(targetStr, WHITE, WHITE));
        s.append("\n");
        System.out.println(s);
    }

    @Test
    public void setColors() throws InterruptedException {
        String targetStr = "Hello World !";
        StringBuilder s = new StringBuilder();
        s.append(ConsolePrintUtils.setColorStyle(targetStr, RED, GREEN, UNDERLINE));
        s.append("\n");
        s.append(ConsolePrintUtils.setColorStyle(targetStr, RED, GREEN, null));
        s.append("\n");
        s.append(ConsolePrintUtils.setColorStyle(targetStr, RED, null, UNDERLINE));
        s.append("\n");
        s.append(ConsolePrintUtils.setColorStyle(targetStr, RED, null, null));
        s.append("\n");
        s.append(ConsolePrintUtils.setColorStyle(targetStr, null, GREEN, UNDERLINE));
        s.append("\n");
        s.append(ConsolePrintUtils.setColorStyle(targetStr, null, GREEN, null));
        s.append("\n");
        s.append(ConsolePrintUtils.setColorStyle(targetStr, null, null, UNDERLINE));
        s.append("\n");
        s.append(ConsolePrintUtils.setColorStyle(targetStr, null, null, null));
        s.append("\n");
        s.append(ConsolePrintUtils.setColorStyle(targetStr, RED, GREEN, HIGHLIGHT));
        s.append("\n");
        s.append(ConsolePrintUtils.setColorStyle(targetStr, RED, GREEN, UNDERLINE));
        s.append("\n");
        s.append(ConsolePrintUtils.setColorStyle(targetStr, RED, GREEN, INVERSION));
        System.out.println(s);
    }

}
