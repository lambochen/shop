package com.chensanwa.shop.controller;

import com.chensanwa.shop.entity.Product;
import com.chensanwa.shop.service.ProductService;
import com.chensanwa.shop.util.ResultUtil;
import com.chensanwa.shop.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Created with IntelliJ IDEA
 * Created By Mr.Chen
 * Date: 2018/6/23
 * Time: 20:42
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    @ResponseBody
    public Result addProduct(Product product,
                             HttpServletRequest request, HttpServletResponse response) {
        productService.insert(product);
        return ResultUtil.success();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public Result delete(int id,
                         HttpServletRequest request, HttpServletResponse response) {
        productService.delete(id);
        return ResultUtil.success();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result findById(@PathVariable("id") int id,
                           HttpServletRequest request, HttpServletResponse response) {
        return ResultUtil.success(productService.findById(id));
    }

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    @ResponseBody
    public Result listAll(HttpServletRequest request, HttpServletResponse response) {
        return ResultUtil.success(productService.listAll());
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Result listByType(String type,HttpServletRequest request, HttpServletResponse response) {
        return ResultUtil.success(productService.listByType(type));
    }

    @RequestMapping(value = "/stock", method = RequestMethod.POST)
    @ResponseBody
    public Result modifyStock(int id, int stock,HttpServletRequest request, HttpServletResponse response) {
        productService.modifyStock(id, stock);
        return ResultUtil.success();
    }

    @RequestMapping(value = "/discount", method = RequestMethod.POST)
    @ResponseBody
    public Result modifyDiscount(int id, int discount,HttpServletRequest request, HttpServletResponse response) {
        productService.modifyDiscount(id, discount);
        return ResultUtil.success();
    }

}
