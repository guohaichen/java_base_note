package com.design_mode.adapter.objectAdapter;

import com.design_mode.adapter.SDCard;
import com.design_mode.adapter.TFCard;

/**
 * @author cgh
 * @create 2022-08-26 13:34
 * 对象适配器模式
 * 将现有TFCard注入到适配器类，适配器类同时实现当前系统的业务接口
 *      这里其实和静态代理模式原理一样了。从概念上讲，代理更偏向对实现方的接口一致，适配主要是用来适配用户方的需求。
 */
public class SDAndTFCardAdapter implements SDCard {

    TFCard tfCard;

    public SDAndTFCardAdapter(TFCard tfCard) {
        this.tfCard = tfCard;
    }

    @Override
    public void readFromSD(String msg) {
        System.out.println("TFCard 处理");
        tfCard.readFromTF(msg);
    }
}
