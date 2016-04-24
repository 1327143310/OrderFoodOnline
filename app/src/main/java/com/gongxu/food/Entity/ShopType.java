package com.gongxu.food.Entity;

/**
 * Created by Administrator on 2016/4/24.
 */
public class ShopType {

    private String shopTypeId;    //店铺类型id
    private String shopTypeName;  //店铺类型名，即菜系
    private String backUp1;     //备用字段1
    private String backUp2;     //备用字段2
    private String backUp3;     //备用字段3

    public String getShopTypeId() {
        return shopTypeId;
    }

    public void setShopTypeId(String shopTypeId) {
        this.shopTypeId = shopTypeId;
    }

    public String getShopTypeName() {
        return shopTypeName;
    }

    public void setShopTypeName(String shopTypeName) {
        this.shopTypeName = shopTypeName;
    }

    public String getBackUp1() {
        return backUp1;
    }

    public void setBackUp1(String backUp1) {
        this.backUp1 = backUp1;
    }

    public String getBackUp2() {
        return backUp2;
    }

    public void setBackUp2(String backUp2) {
        this.backUp2 = backUp2;
    }

    public String getBackUp3() {
        return backUp3;
    }

    public void setBackUp3(String backUp3) {
        this.backUp3 = backUp3;
    }
}
