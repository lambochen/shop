package com.chensanwa.shop.service;

import com.chensanwa.shop.entity.Supplier;

import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Created By Mr.Chen
 * Date: 2018/6/23
 * Time: 21:41
 */
public interface SupplierService {

    List<Supplier> list();

    void insert(Supplier supplier);

    void delete(int id);

    void deleteSupplierAndProduct(int supplierId,int productId);

    void modifyAmount(int supplierId,int productId,int amount);

}
