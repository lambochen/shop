package com.chensanwa.shop.controller;

import com.chensanwa.shop.entity.Supplier;
import com.chensanwa.shop.service.SupplierService;
import com.chensanwa.shop.util.ResultUtil;
import com.chensanwa.shop.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA
 * Created By Mr.Chen
 * Date: 2018/6/23
 * Time: 21:48
 */
@Controller
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;


    @RequestMapping(value = "/supplier",method = RequestMethod.GET)
    @ResponseBody
    public Result list(HttpServletRequest request, HttpServletResponse response){
        //允许session跨域访问
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        return ResultUtil.success(supplierService.list());
    }

    @RequestMapping(value = "/supplier",method = RequestMethod.POST)
    @ResponseBody
    public Result insert(Supplier supplier,
                         HttpServletRequest request, HttpServletResponse response){
        //允许session跨域访问
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        supplierService.insert(supplier);
        return ResultUtil.success();
    }

    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    @ResponseBody
    public Result delete(int id,
                         HttpServletRequest request, HttpServletResponse response){
        //允许session跨域访问
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        supplierService.delete(id);
        return ResultUtil.success(); 
    }

    @RequestMapping(value = "/product/delete",method = RequestMethod.GET)
    @ResponseBody
    public Result deleteSupplierProduct(@RequestParam("supplierId") int supplierId,
                                        @RequestParam("productId") int productId,
                                        HttpServletRequest request, HttpServletResponse response){
        //允许session跨域访问
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        supplierService.deleteSupplierAndProduct(supplierId,productId);
        return ResultUtil.success();
    }

    @RequestMapping(value = "/product/amount",method = RequestMethod.POST)
    @ResponseBody
    public Result updateAmount(@RequestParam("supplierId") int supplierId,
                               @RequestParam("productId") int productId,
                               @RequestParam("amount") int amount,
                               HttpServletRequest request, HttpServletResponse response){
        //允许session跨域访问
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        supplierService.modifyAmount(supplierId,productId,amount);
        return ResultUtil.success();
    }

}
