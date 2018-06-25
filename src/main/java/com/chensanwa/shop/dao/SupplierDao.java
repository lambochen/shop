package com.chensanwa.shop.dao;

import com.chensanwa.shop.entity.Supplier;

import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Created By Mr.Chen
 * Date: 2018/6/23
 * Time: 21:36
 */
public interface SupplierDao {

    List<Supplier> list();

    void insert(Supplier supplier);

    void delete(int id);




}
