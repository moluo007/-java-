package cn.jiruan.util;

import java.util.Objects;

public class PrintTools {


    /*根据设定参数决定打出的'\t'数量
    如果 给定数据(newNum)的长度 小于 指定长度(limit)
    则根据spacial的值来决定打印'\t'的数量
    否则根据normal的值来决定打印'\t'的数量*/
    public static void judgeWei(Integer newNum, int limit, int normal, int spacial) {
        int count = 0;
        while(newNum / 10 != 0){
            newNum = newNum / 10;
            count++;
        }
        if(count + 1 <= limit){
            for(int i = 0; i < spacial; i++){
                System.out.print("\t");
            }
        }else{
            for(int i = 0; i < normal; i++){
                System.out.print("\t");
            }
        }
    }


    //根据选项判断翻页
    public static void judgePage(String choice2, PageHelper ph, String upSign, String downSign) {
        try{
            if(upSign.equals(choice2)){
                if(Objects.equals(ph.getPageIndex(), ph.getPageCount())){
//                    Thread.sleep(1000);
                    System.out.println("-----------------------------------------------");
                    System.out.println("-----------------不能向下翻了--------------------");
                    System.out.println("-----------------------------------------------");
//                    Thread.sleep(1000);
                }else{
                    //向上翻页
                    ph.setPageIndex(ph.getPageIndex() + 1);
                }
            }else if(downSign.equals(choice2)){
                if(ph.getPageIndex() == 1){
//                    Thread.sleep(1000);
                    System.out.println("-----------------------------------------------");
                    System.out.println("-----------------不能向上翻了--------------------");
                    System.out.println("-----------------------------------------------");
//                    Thread.sleep(1000);
                }else{
                    //向下翻页
                    ph.setPageIndex(ph.getPageIndex() - 1);
                }
           }
//            else{
////                Thread.sleep(1000);
//            }
        }catch(Exception ignored){}
    }
}
