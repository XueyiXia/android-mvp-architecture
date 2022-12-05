package com.google.mvp.bean;


/**
 * 首页
 */

public class XyHomeIndex {

    public String fconfigName;// 名称 ,
    public String fimgUrl;// 图片地址 ,
    public String flocation;//排版对应位置(排版对应的位置左一至左五对应值1-5) ,
    public String fposition;// 导航栏位置(0Banner配置 1ICON配置 2专题位配置 ,
    public int frelationId;//模块id 类型为1关联商 品分类的(分类id) 类型为2 关联商品品牌的品牌id 类型为3 关联商品标签的标签id ,
    public int ftype;//模块类型(0商品分类 1商品品牌 2商品标签 3专题活动 4文章)
    public String fredirectUrl;
    public String fcategoryLevel;

    public String getFcategroyLevel() {
        return fcategoryLevel;
    }

    public void setFcategroyLevel(String fcategroyLevel) {
        this.fcategoryLevel = fcategroyLevel;
    }

    public String getFconfigName() {
        return fconfigName;
    }

    public String getFimgUrl() {
        return fimgUrl;
    }

    public String getFlocation() {
        return flocation;
    }

    public String getFposition() {
        return fposition;
    }

    public int getFrelationId() {
        return frelationId;
    }

    public int getFtype() {
        return ftype;
    }

    public void setFconfigName(String fconfigName) {
        this.fconfigName = fconfigName;
    }

    public void setFimgUrl(String fimgUrl) {
        this.fimgUrl = fimgUrl;
    }

    public void setFlocation(String flocation) {
        this.flocation = flocation;
    }

    public void setFposition(String fposition) {
        this.fposition = fposition;
    }

    public void setFrelationId(int frelationId) {
        this.frelationId = frelationId;
    }

    public void setFtype(int ftype) {
        this.ftype = ftype;
    }

    public String getFredirectUrl() {
        return fredirectUrl;
    }

    public void setFredirectUrl(String fredirectUrl) {
        this.fredirectUrl = fredirectUrl;
    }


    @Override
    public String toString() {
        return "XyHomeIndex{" +
                "fconfigName='" + fconfigName + '\'' +
                ", fimgUrl='" + fimgUrl + '\'' +
                ", flocation='" + flocation + '\'' +
                ", fposition='" + fposition + '\'' +
                ", frelationId='" + frelationId + '\'' +
                ", ftype='" + ftype + '\'' +
                ", fredirectUrl='" + fredirectUrl + '\'' +
                ", fcategroyLevel='" + fcategoryLevel + '\'' +
                '}';
    }
}
