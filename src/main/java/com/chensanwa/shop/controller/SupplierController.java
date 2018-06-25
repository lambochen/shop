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
    public Result list(){
        return ResultUtil.success(supplierService.list());
    }

    @RequestMapping(value = "/supplier",method = RequestMethod.POST)
    @ResponseBody
    public Result insert(Supplier supplier){
        supplierService.insert(supplier);
        return ResultUtil.success();
    }

    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    @ResponseBody
    public Result delete(int id){
        supplierService.delete(id);
        return ResultUtil.success();
    }

    @RequestMapping(value = "/product/delete",method = RequestMethod.GET)
    @ResponseBody
    public Result deleteSupplierProduct(@RequestParam("supplierId") int supplierId,
                                        @RequestParam("productId") int productId){
        supplierService.deleteSupplierAndProduct(supplierId,productId);
        return ResultUtil.success();
    }

    @RequestMapping(value = "/product/amount",method = RequestMethod.POST)
    @ResponseBody
    public Result updateAmount(@RequestParam("supplierId") int supplierId,
                               @RequestParam("productId") int productId,
                               @RequestParam("amount") int amount){
        supplierService.modifyAmount(supplierId,productId,amount);
        return ResultUtil.success();
    }

}
