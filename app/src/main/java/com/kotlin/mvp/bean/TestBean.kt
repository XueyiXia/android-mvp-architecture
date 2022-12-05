package com.kotlin.mvp.bean

/**
 * 首页
 */
class TestBean {
    var fconfigName // 名称 ,
            : String? = null
    var fimgUrl // 图片地址 ,
            : String? = null
    var flocation //排版对应位置(排版对应的位置左一至左五对应值1-5) ,
            : String? = null
    var fposition // 导航栏位置(0Banner配置 1ICON配置 2专题位配置 ,
            : String? = null
    var frelationId //模块id 类型为1关联商 品分类的(分类id) 类型为2 关联商品品牌的品牌id 类型为3 关联商品标签的标签id ,
            = 0
    var ftype //模块类型(0商品分类 1商品品牌 2商品标签 3专题活动 4文章)
            = 0
    var fredirectUrl: String? = null
    var fcategroyLevel: String? = null
    override fun toString(): String {
        return "XyHomeIndex{" +
                "fconfigName='" + fconfigName + '\'' +
                ", fimgUrl='" + fimgUrl + '\'' +
                ", flocation='" + flocation + '\'' +
                ", fposition='" + fposition + '\'' +
                ", frelationId='" + frelationId + '\'' +
                ", ftype='" + ftype + '\'' +
                ", fredirectUrl='" + fredirectUrl + '\'' +
                ", fcategroyLevel='" + fcategroyLevel + '\'' +
                '}'
    }
}