package com.sky.service;
import com.sky.dto.ShoppingCartDTO;
/**
 * C端购物车相关的服务
 *
 * @author Li Yijia
 * @date 2024/4/15
 */
public interface ShoppingCartService {
    /**
     * 添加一项套餐或菜品到购物车
     * @param shoppingCartDTO
     */
    void addShoppingCart(ShoppingCartDTO shoppingCartDTO);
}
