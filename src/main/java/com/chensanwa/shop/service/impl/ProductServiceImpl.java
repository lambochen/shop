package com.chensanwa.shop.service.impl;

import com.chensanwa.shop.dao.ProductDao;
import com.chensanwa.shop.entity.Product;
import com.chensanwa.shop.enums.ResultEnum;
import com.chensanwa.shop.exception.BaseException;
import com.chensanwa.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Created By Mr.Chen
 * Date: 2018/6/23
 * Time: 20:33
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    public void insert(Product product) {
        try {
            if (product.getName() == null || product.getName() == "" ||
                    product.getName().length() > 30) {
                throw new BaseException(ResultEnum.PARAM_ERROR);
            }
            if (product.getType() == null || product.getType() == "" ||
                    product.getType().length() > 30) {
                throw new BaseException(ResultEnum.PARAM_ERROR);
            }
            productDao.insert(product);
        } catch (Exception e) {
            throw new BaseException(ResultEnum.UNKNOWN_ERROR);
        }
    }

    public void delete(int id) {
        productDao.delete(id);
    }

    public Product findById(int id) {
        return productDao.findById(id);
    }

    public List<Product> listAll() {
        return productDao.list();
    }

    public List<Product> listByType(String type) {
        return productDao.listByType(type);
    }

    public void modifyStock(int id, int stock) {
        productDao.updateStock(id, stock);
    }

    public void modifyDiscount(int id, int discount) {
        productDao.updateDiscount(id, discount);
    }
}
