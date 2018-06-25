package com.chensanwa.shop.dao;

import com.chensanwa.shop.dto.SupplierProductDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Created By Mr.Chen
 * Date: 2018/6/25
 * Time: 10:44
 */
public interface SupplierProductDao {

    void insert(SupplierProductDto supplierProductDto);

    void delete(@Param("supplierId") int supplierId, @Param("productId") int productId);

    void updateAmount(SupplierProductDto supplierProductDto);

    List<SupplierProductDto> list(@Param("supplierId") int supplierId);

}
