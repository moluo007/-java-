package cn.jiruan.service;

import cn.jiruan.pojo.Inventory;
import cn.jiruan.pojo.User;
import cn.jiruan.pojo.WareHouse;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

public interface IWarningService {

    //不写了，没用的功能，纯恶心人来的，去他****的
    /*//容量预警
    *//*
    * 在库存操作中要监控库存容量，如果超出限制，给出提示，没有超出限制则不做任何操作。
    * *//*
    boolean capacityWarning(Inventory inventory);*/

    //质量预警
    /*
    * 查询仓库或库存时，根据产品保质期提示10天内要过期的产品，并显示所在仓库和库存。
    *
    * 1. 首先查询获取所有产品对象以及对应的剩余天数Map集合
    * 2. 遍历集合 -> 将所有剩余天数 < 0 的数据对应的产品对象存到一个ArrayList集合中
    * 3. 返回这个ArrayList集合
    * */
    Map<WareHouse,Inventory> qualityWarning();


}
