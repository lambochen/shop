package com.chensanwa.shop.dao;

import com.chensanwa.shop.entity.Product;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Created By Mr.Chen
 * Date: 2018/6/23
 * Time: 18:07
 */
public interface ProductDao {

    void insert(Product product);

    void delete(int id);

    Product findById(int id);

    List<Product> list();

    List<Product> listByType(String type);

    void updateStock(@Param("id") int id, @Param("stock") int stock);

    void updateDiscount(@Param("id") int id, @Param("discount") int discount);
}
