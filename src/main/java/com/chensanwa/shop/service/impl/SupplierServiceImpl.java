package com.chensanwa.shop.service.impl;

import com.chensanwa.shop.dao.ProductDao;
import com.chensanwa.shop.dao.SupplierDao;
import com.chensanwa.shop.dao.SupplierProductDao;
import com.chensanwa.shop.dto.SupplierProductDto;
import com.chensanwa.shop.entity.Product;
import com.chensanwa.shop.entity.Supplier;
import com.chensanwa.shop.enums.ResultEnum;
import com.chensanwa.shop.exception.BaseException;
import com.chensanwa.shop.service.SupplierService;
import com.chensanwa.shop.util.TelephoneCheckUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Created By Mr.Chen
 * Date: 2018/6/23
 * Time: 21:42
 */
@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierDao supplierDao;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private SupplierProductDao supplierProductDao;

    public List<Supplier> list() {
        List<Supplier> supplierList = supplierDao.list();
        for (int i=0;i<supplierList.size();i++){
            List<SupplierProductDto> supplierProductDtoList;
            supplierProductDtoList = supplierProductDao.list(supplierList.get(i).getId());
            List<Product> productList = new ArrayList<Product>();
            for (SupplierProductDto supplierProductDto : supplierProductDtoList){
                Product product = new Product();
                product = productDao.findById(supplierProductDto.getProductId());
                product.setStock(supplierProductDto.getAmount());
                productList.add(product);
            }
            supplierList.get(i).setProductList(productList);
        }
        return supplierList;
    }

    public void insert(Supplier supplier) {
        if (supplier == null){
            throw new BaseException(ResultEnum.PARAM_IS_NULL);
        }
        if (supplier.getName() == null || supplier.getName() == "" ||
                supplier.getName().length() > 10){
            throw new BaseException(ResultEnum.PARAM_ERROR);
        }
        if (supplier.getTelephone() == null || supplier.getTelephone() == "" ||
                !TelephoneCheckUtil.isChinaPhoneLegal(supplier.getTelephone())){
            throw new BaseException(ResultEnum.PARAM_ERROR);
        }
        supplierDao.insert(supplier);
    }

    public void delete(int id) {
        supplierDao.delete(id);
    }

    public void deleteSupplierAndProduct(int supplierId, int productId) {
        supplierProductDao.delete(supplierId,productId);
    }

    public void modifyAmount(int supplierId, int productId, int amount) {
        if (amount < 0){
            throw new BaseException(ResultEnum.PARAM_ERROR);
        }
        SupplierProductDto supplierProductDto = new SupplierProductDto();
        supplierProductDto.setSupplierId(supplierId);
        supplierProductDto.setProductId(productId);
        supplierProductDto.setAmount(amount);
        supplierProductDao.updateAmount(supplierProductDto);
    }
}
