package cn.jiruan.my;

import cn.jiruan.pojo.WareHouse;
import cn.jiruan.util.PageHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;

public class tools {
    public static Integer format(String str) {
        while (true) {
            try {
                System.out.println(str);
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                String s = br.readLine();
                return Integer.parseInt(s);
            } catch (IOException e) {
                System.out.println("输入流错误");
            } catch (NumberFormatException e) {
                System.out.println("输入格式错误");
            } catch (Exception e) {
                System.out.println("奇怪的错误");
            }
        }
    }


    //检查id输入是否正确
    public static Integer safeIdInput(ArrayList<WareHouse> list){

        while (true){
            Integer id=format("");
            for (WareHouse wareHouse : list){
               Integer wareHouseId=wareHouse.getWareHouseId();
               if (wareHouseId.equals(id)){
                   return id;
               }
            }
        }
    }




    //页 ph的改变
    public static PageHelper pageChange(String choice, PageHelper ph, String up, String down){
        try {
            if (choice.equals(up)){
                if (ph.getPageIndex()==1){
                    System.out.println("已经是最上一页，无法向上翻页===================================");
                }else{
                    ph.setPageIndex(ph.getPageIndex()-1);
                }
            }else if (choice.equals(down)){
                if(Objects.equals(ph.getPageIndex(), ph.getPageCount())){
                    System.out.println("已经是最下一页，无法向下翻页===================================");
                }else{
                    ph.setPageIndex(ph.getPageIndex()+1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }return ph;

    }




}
