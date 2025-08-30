package cn.jiruan.util;

import java.io.*;

/**
 * 文件加密工具类
 * @author szsw
 */
@SuppressWarnings({"unused", "java:S106", "java:S1075"})
public class FileEncAndDec {

    /**
     * 加密解密秘钥
     */
    private static final int NUM_OF_ENC_AND_DEC = 0x255;
    /**
     * 文件字节内容
     */
    private static int dataOfFile = 0;

    /**
     * 文件加密
     *
     * @param srcFile 目标文件
     * @param encFile 加密生成文件
     */
    private static void encFile(File srcFile, File encFile) {
        if (!srcFile.exists()) {
            System.out.println("源文件不存在！");
            return;
        }
        try (InputStream fis = new FileInputStream(srcFile);
             OutputStream fos = new FileOutputStream(encFile)) {
            while ((dataOfFile = fis.read()) > -1) {
                fos.write(dataOfFile ^ NUM_OF_ENC_AND_DEC);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 文件解密
     *
     * @param encFile 已加密文件
     * @param decFile 解密生成文件
     */
    private static void decFile(File encFile, File decFile) {
        if (!encFile.exists()) {
            System.out.println("加密文件不存在");
            return;
        }
        try (InputStream fis = new FileInputStream(encFile);
             OutputStream fos = new FileOutputStream(decFile)) {
            while ((dataOfFile = fis.read()) > -1) {
                fos.write(dataOfFile ^ NUM_OF_ENC_AND_DEC);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        File f1 = new File("E:\\123\\txt\\1.txt");
        File f2 = new File("E:\\123\\txt\\2.txt");
        File f3 = new File("E:\\123\\txt\\3.txt");
        encFile(f1, f2);
        decFile(f2, f3);
    }
}
