package com.chensanwa.shop.service;

import com.chensanwa.shop.entity.Product;

import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Created By Mr.Chen
 * Date: 2018/6/23
 * Time: 20:29
 */
public interface ProductService {

    void insert(Product product);

    void delete(int id);

    Product findById(int id);

    List<Product> listAll();

    List<Product> listByType(String type);

    void modifyStock(int id, int stock);

    void modifyDiscount(int id, int discount);

}
