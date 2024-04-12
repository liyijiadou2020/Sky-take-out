package com.sky.service;
import com.sky.dto.DishDTO;
/**
 * 菜品
 *
 * @author Li Yijia
 * @date 2024/4/12
 */
public interface DishService {

    /**
     * 新增菜品和对应的口味
     * @param dishDTO 菜品描述和口味
     */
    public void saveWithFlavor(DishDTO dishDTO);

}
