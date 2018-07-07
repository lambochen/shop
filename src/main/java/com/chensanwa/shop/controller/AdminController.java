package com.chensanwa.shop.controller;

import com.chensanwa.shop.enums.ResultEnum;
import com.chensanwa.shop.service.AdminService;
import com.chensanwa.shop.service.SupplierService;
import com.chensanwa.shop.util.ResultUtil;
import com.chensanwa.shop.vo.Result;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA
 * Created By Mr.Chen
 * Date: 2018/6/23
 * Time: 19:55
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public Result login(String name, String password,
                        HttpServletRequest request, HttpServletResponse response){

//        //允许session跨域访问
//        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
//        response.setHeader("Access-Control-Allow-Credentials", "true");
        boolean count = adminService.login(name,password);

        if (count){
            return ResultUtil.success();
        }
        return ResultUtil.error(ResultEnum.PARAM_ERROR);
    }




}
