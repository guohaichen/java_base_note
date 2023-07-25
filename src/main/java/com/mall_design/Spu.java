package com.mall_design;

import lombok.Data;

/**
 * @author cgh
 * @create 2023-07-25
 *
 */
@Data
public class Spu {
    private String id;

    public Spu(String id, String title, String description, String brand) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.brand = brand;
    }

    //商品标题
    private String title;
    //描述
    private String description;
    //品牌
    private String brand;

}
