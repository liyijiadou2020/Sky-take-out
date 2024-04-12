package com.sky.mapper;
import com.sky.entity.DishFlavor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
/**
 * 菜品口味表
 *
 * @author Li Yijia
 * @date 2024/4/12
 */
@Mapper
public interface DishFlavorMapper {

    /**
     * 批量插入口味数据
     *
     * @param flavors
     */
    public void insertBatch(List<DishFlavor> flavors);
}
