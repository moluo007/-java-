package cn.jiruan.util;

import java.io.File;
import java.io.IOException;

/**
 * DOS命令工具类型
 * @author szsw
 */
@SuppressWarnings({"java:S1075", "java:S112"})
public class DosUtils {

    private static final String SPACE = " ";
    private static final String MESSAGE = "没有找到运行的文件！";

    public static void main(String[] args) throws Exception {
        open(new File("E:\\123\\0.png"));
        run(new File("D:\\Program Files (x86)\\Pure Codec\\x64\\PotPlayerMini64.exe"));
        File execFile = new File("D:\\Program Files (x86)\\Pure Codec\\x64\\PotPlayerMini64.exe");
        File file = new File("D:\\视频\\庆余年 测试\\01 1.mp4");
        open(execFile, file);
    }

    /**
     * 运行程序
     *
     * @param file 程序文件
     * @throws Exception 可能抛出没有找到文件或IO异常
     */
    public static void run(File file) throws Exception {
        if (file.exists()) {
            exec(file.getPath());
        } else {

            throw new Exception(MESSAGE);
        }
    }

    /**
     * 用系统默认程序打开文件
     *
     * @param file 目标文件
     * @throws Exception 可能抛出没有找到文件或IO异常
     */
    public static void open(File file) throws Exception {
        if (file.exists()) {
            String command = "cmd /C start ";
            String path = file.getPath();
            if (path.contains(SPACE)) {
                command += "\" \" \"" + path + "\"";
            } else {
                command += path;
            }
            exec(command);
        } else {
            throw new Exception(MESSAGE);
        }
    }

    /**
     * 用指定程序打开指定文件
     *
     * @param execFile 程序文件
     * @param file     目标文件
     * @throws Exception 可能抛出没有找到文件或IO异常
     */
    public static void open(File execFile, File file) throws Exception {
        if (execFile.exists() && file.exists()) {
            String command = execFile.getPath() + " " + file.getPath();
            exec(command);
        } else {
            throw new Exception(MESSAGE);
        }
    }

    /**
     * 执行dos命令
     *
     * @param command dos命令
     * @throws IOException IO异常
     */
    public static void exec(String command) throws IOException {
        Runtime.getRuntime().exec(command);
    }

}
