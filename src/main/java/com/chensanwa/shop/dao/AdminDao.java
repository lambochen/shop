package com.chensanwa.shop.dao;

import com.chensanwa.shop.entity.Admin;
import org.apache.ibatis.annotations.Param;

/**
 * Created with IntelliJ IDEA
 * Created By Mr.Chen
 * Date: 2018/6/23
 * Time: 17:52
 */
public interface AdminDao {

    int matchByNameAndPassword(@Param("name")String name, @Param("password") String password);

}
