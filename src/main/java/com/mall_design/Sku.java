package com.mall_design;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author cgh
 * @create 2023-07-25
 */
@Data
public class Sku {
    public Sku(String categoryId, String id, Integer memory, Integer randomOnMemory, String spuId, String color, BigDecimal price) {
        this.categoryId = categoryId;
        this.id = id;
        this.memory = memory;
        this.randomOnMemory = randomOnMemory;
        this.spuId = spuId;
        this.color = color;
        this.price = price;
    }

    private String categoryId;
    //对应spu id
    private String spuId;
    private String id;

    private Integer memory;

    private Integer randomOnMemory;


    private String color;

    private BigDecimal price;

}
