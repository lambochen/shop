
# 超市库存管理系统API文档


## 管理员相关

#### 测试账户

name : Bob
password : 123456

#### 一、管理员登录

    POST /shop/admin/login.do
    
参数

    name : 管理员用户名
    password : 密码
    
返回

    {
        "code": 0,
        "msg": "请求成功",
        "data": null
    }
    

## 商品相关

#### 一、新增商品

    POST /shop/product/product.do
    
参数

    name : 商品名称
    price : 价格
    type : 商品类型
    stock : 商品库存
    discount : 商品折扣
    
返回

    {
        "code": 0,
        "msg": "请求成功",
        "data": null
    }

#### 二、 删除商品

    GET /shop/product/delete.do
    
参数

    id : 商品ID
    
返回

    {
        "code": 0,
        "msg": "请求成功",
        "data": null
    }
    
#### 三、通过ID获得商品信息

    GET /shop/product/{id}.do
    
参数

    id : 商品ID
    
返回

    {
        "code": 0,
        "msg": "请求成功",
        "data": {
            "id": 1,
            "name": "乐事薯片",
            "price": 12,
            "type": "薯片",
            "stock": 100,
            "discount": 10
        }
    }
    
#### 四、获取所有商品信息列表

    GET /shop/product/product.do
    
参数

    无

返回

    {
        "code": 0,
        "msg": "请求成功",
        "data": [
            {
                "id": 1,
                "name": "乐事薯片",
                "price": 12,
                "type": "薯片",
                "stock": 100,
                "discount": 10
            },
            {
                "id": 2,
                "name": "农夫山泉",
                "price": 2,
                "type": "矿泉水",
                "stock": 100,
                "discount": 10
            }
        ]
    }
    
#### 五、通过商品类型获得商品信息列表
    
    GET /shop/product/list.do
    
参数

    type : 商品类型
    
返回
    
    {
        "code": 0,
        "msg": "请求成功",
        "data": [
            {
                "id": 2,
                "name": "农夫山泉",
                "price": 2,
                "type": "矿泉水",
                "stock": 100,
                "discount": 10
            }
        ]
    }
    
#### 六、修改商品库存

    POST /shop/product/stock.do
    
参数

    id : 商品ID 
    stock : 商品库存
    
返回

    {
        "code": 0,
        "msg": "请求成功",
        "data": null
    }
   
   
#### 七、修改商品折扣

    POST /shop/product/discount.do
    
参数

    id : 商品ID
    discount : 商品折扣
    
返回

    {
        "code": 0,
        "msg": "请求成功",
        "data": null
    }
    
    
## 供应商相关

#### 一、获得供应商列表

    GET /shop/supplier/supplier.do
    
参数

    无
 
返回

    {
        "code": 0,
        "msg": "请求成功",
        "data": [
            {
                "id": 1,
                "name": "罗笑",
                "telephone": "13008142323",
                "productList": [
                    {
                        "id": 1,
                        "name": "乐事薯片",
                        "price": 12,
                        "type": "薯片",
                        "stock": 101,
                        "discount": 10
                    }
                ]
            },
            {
                "id": 2,
                "name": "张三",
                "telephone": "13002342343",
                "productList": [
                    {
                        "id": 2,
                        "name": "农夫山泉",
                        "price": 2,
                        "type": "矿泉水",
                        "stock": 100,
                        "discount": 10
                    }
                ]
            }
        ]
    }
    
#### 二、添加供应商

    POST /shop/supplier/supplier.do
    
参数

    name : 供应商名称
    telephone : 电话号码
    
返回

    {
        "code": 0,
        "msg": "请求成功",
        "data": null
    }
    
#### 三、删除供应商

    GET /shop/supplier/delete.do
    
参数

    id : 供应商ID
    
返回

    {
        "code": 0,
        "msg": "请求成功",
        "data": null
    }
      
#### 四、删除供应商-产品明细

    GEt /shop/supplier/product/delete.do
    
参数

    supplierId : 供应商ID
    productId : 产品ID
    
返回

    {
        "code": 0,
        "msg": "请求成功",
        "data": null
    }
    
#### 五、修改供应商-产品供货量

    POST /shop/supplier/product/amount.do
    
参数

    supplierId : 供应商ID
    productId : 产品ID
    amount : 供货量
    
返回
    
    {
        "code": 0,
        "msg": "请求成功",
        "data": null
    }
        
    