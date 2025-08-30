package cn.jiruan.util;

/**
 * 颜色枚举
 * @author szsw
 */
@SuppressWarnings("unused")
public enum ColorEnum {
    /**
     *
     */
    BACK("黑", 30, 40),
    RED("红", 31, 41),
    GREEN("绿", 32, 42),
    YELLOW("黄", 33, 43),
    BLUE("蓝", 34, 44),
    PURPLE("紫", 35, 45),
    DARK_GREEN("深绿", 36, 46),
    WHITE("白色", 37, 47),
    ;

    String name;
    int fontColor;
    int backgroundColor;

    ColorEnum(String name, int fontColor, int backgroundColor) {
        this.name = name;
        this.fontColor = fontColor;
        this.backgroundColor = backgroundColor;
    }

    public String getName() {
        return name;
    }

    public int getFontColor() {
        return fontColor;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }
}