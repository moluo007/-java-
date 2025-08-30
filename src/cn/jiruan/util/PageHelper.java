package cn.jiruan.util;

import java.util.ArrayList;

//分页工具类
public class PageHelper {

    private Integer dateCount;  //查询数据的总条数
    private Integer showNumber = 4; //每页显示的条数
    private Integer pageCount;  //参与分页的总页数
    private Integer pageIndex = 1;  //当前是第几页
    private ArrayList<Object> listIndex;    //当前页显示项的集合

    public Integer getDateCount() {
        return dateCount;
    }

    //传入数据总条数的同时计算好页面页数
    public void setDateCount(Integer dateCount) {
        this.dateCount = dateCount;
       getPageCount();
    }

    public Integer getShowNumber() {
        return showNumber;
    }

    public void setShowNumber(Integer showNumber) {
        this.showNumber = showNumber;
    }

/**
 * 获取总页数的方法
 * @return 返回计算后的总页数，如果没有数据则返回1
 */
    public Integer getPageCount() {
        // 修复：当没有数据时，总页数应该为1而不是0
        if (this.dateCount == null || this.dateCount <= 0) {
            return 1;    // 如果数据量为空或小于等于0，直接返回1页
        }
        // 计算总页数：如果数据总量能被每页显示数量整除，则直接相除；否则商加1
        pageCount = this.dateCount % this.showNumber == 0 ?
                this.dateCount / this.showNumber :    // 整除情况下的页数
                this.dateCount / this.showNumber + 1;  // 不能整除情况下的页数（加1）
        return pageCount;    // 返回计算得到的总页数
    }

    /*public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }*/

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public ArrayList<Object> getListIndex() {
        return listIndex;
    }

    public void setListIndex(ArrayList<Object> listIndex) {
        this.listIndex = listIndex;
    }
}
