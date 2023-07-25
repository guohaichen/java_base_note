package com.mall_design;

import lombok.Data;

/**
 * @author cgh
 * @create 2023-07-25
 */
@Data
public class GoodsCategory {
    private String id;
    private String name;

    public GoodsCategory(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
