package com.mall_design;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author cgh
 * @create 2023-07-25
 */
public class DriverTest {
    public static void main(String[] args) {
        //分类
        List<GoodsCategory> categoryList = new ArrayList<>();
        categoryList.add(new GoodsCategory(UUID.randomUUID().toString(), "手机"));
        categoryList.add(new GoodsCategory(UUID.randomUUID().toString(), "笔记本"));
        categoryList.add(new GoodsCategory(UUID.randomUUID().toString(), "平板电脑"));
        System.out.println(categoryList);

        //spu standard product unit
        Spu huaweiMate = new Spu(UUID.randomUUID().toString(), "华为mate40", "麒麟990，徕卡", "华为");
        Spu xiaomi12 = new Spu(UUID.randomUUID().toString(), "小米12", "骁龙8gen，徕卡", "小米");
        Spu iphone13 = new Spu(UUID.randomUUID().toString(), "苹果13", "A13处理器", "苹果");
        ArrayList<Spu> spuList = new ArrayList<>();
        spuList.add(huaweiMate);
        spuList.add(xiaomi12);
        spuList.add(iphone13);

        //stock keeping unit
        ArrayList<Sku> skuArrayList = new ArrayList<>();
        Sku mateSku1 = new Sku(categoryList.get(0).getId(), UUID.randomUUID().toString(), 8, 256, spuList.get(0).getId(), "翡冷翠", new BigDecimal(5200));
        Sku mateSku2 = new Sku(categoryList.get(0).getId(), UUID.randomUUID().toString(), 8, 256, spuList.get(0).getId(), "皓月银", new BigDecimal(5200));
        Sku mateSku3 = new Sku(categoryList.get(0).getId(), UUID.randomUUID().toString(), 12, 512, spuList.get(0).getId(), "保时捷", new BigDecimal(6800));
        skuArrayList.add(mateSku1);
        skuArrayList.add(mateSku2);
        skuArrayList.add(mateSku3);

        Sku xiaomi1 = new Sku(categoryList.get(0).getId(), UUID.randomUUID().toString(), 8, 256, spuList.get(1).getId(), "蓝色", new BigDecimal(4500));
        Sku xiaomi2 = new Sku(categoryList.get(0).getId(), UUID.randomUUID().toString(), 8, 512, spuList.get(1).getId(), "白色", new BigDecimal(5000));
        Sku xiaomi3 = new Sku(categoryList.get(0).getId(), UUID.randomUUID().toString(), 8, 512, spuList.get(1).getId(), "波光澜澜", new BigDecimal(5000));
        skuArrayList.add(xiaomi1);
        skuArrayList.add(xiaomi2);
        skuArrayList.add(xiaomi3);

        Sku iPhone1 = new Sku(categoryList.get(0).getId(), UUID.randomUUID().toString(), 6, 128, spuList.get(2).getId(), "香槟金", new BigDecimal(5500));
        Sku iPhone2 = new Sku(categoryList.get(0).getId(), UUID.randomUUID().toString(), 8, 256, spuList.get(2).getId(), "蔷薇红", new BigDecimal(6500));
        skuArrayList.add(iPhone1);
        skuArrayList.add(iPhone2);
        //spu中将 id name 做成映射表，方便查看sku数据；
        HashMap<String, String> idToNameMap = new HashMap<>();
        for (Spu spu : spuList) {
            if (spu.getId() != null && spu.getTitle() != null)
                idToNameMap.put(spu.getId(), spu.getTitle());
        }

        for (Sku sku : skuArrayList) {
            sku.setSpuId(idToNameMap.get(sku.getSpuId()));
            System.out.println(sku);
        }
    }
}
