package com.chensanwa.shop.service.impl;

import com.chensanwa.shop.dao.AdminDao;
import com.chensanwa.shop.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA
 * Created By Mr.Chen
 * Date: 2018/6/23
 * Time: 19:49
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    public boolean login(String name, String password) {

        int count = adminDao.matchByNameAndPassword(name,password);

        if (count > 0){
            return true;
        }
        return false;
    }
}
