package com.chensanwa.shop.dao;

import com.chensanwa.shop.entity.Admin;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA
 * Created By Mr.Chen
 * Date: 2018/6/23
 * Time: 17:56
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-mybatis.xml"})
public class AdminDaoTest {

    @Autowired
    private AdminDao adminDao;

    @Test
    public void matchByNameAndPassword() {

        String name = "Bob";
        String password = "123456";

        int admin = adminDao.matchByNameAndPassword(name,password);

        Assert.assertNotEquals(0,admin);

    }
}