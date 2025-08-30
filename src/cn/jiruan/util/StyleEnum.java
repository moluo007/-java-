package cn.jiruan.util;

/**
 * 样式枚举
 * @author szsw
 */
@SuppressWarnings("unused")
public enum StyleEnum {
    /**
     *
     */
    CLOSE("关闭所有属性", "0"),
    HIGHLIGHT("加粗", "1"),
    UNDERLINE("下划线", "4"),
    INVERSION("反显", "7"),
    ;

    String name;
    String code;

    StyleEnum(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getCloseCode() {
        return "\033[" + CLOSE.getCode() + "m";
    }
}
