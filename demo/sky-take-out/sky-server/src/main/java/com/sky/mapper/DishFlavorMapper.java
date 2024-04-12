package com.sky.mapper;
import com.sky.entity.DishFlavor;
import org.apache.ibatis.annotations.Delete;
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

    /**
     * 根据菜品id删除对应的风味数据
     * @param dishid
     */
    @Delete("delete from dish_flavor where dish_id = #{dishid}")
    void deleteByDishId(Long dishid);
}
