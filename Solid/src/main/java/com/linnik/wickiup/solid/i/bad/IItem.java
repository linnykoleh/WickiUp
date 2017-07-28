package com.linnik.wickiup.solid.i.bad;

import java.math.BigDecimal;

/**
 * @author LinnykOleh
 */
public interface IItem {

    void applyDiscount(Integer discount);

    void applyPromocode(String promocode);

    void setColor(String color);

    void setSize(Integer size);

    void setMaterial(String material);

    void setCondition(Boolean condition);

    void setPrice(BigDecimal price);
}
