
# 超市库存管理系统

## 数据库表结构设计

#### 管理员表(admin)

    id(int) : 管理员ID
    name(string) : 姓名
    password(string) : 密码

#### 货品表(product)

    id(int) : 商品ID【PK，自增】
    name(string) : 商品名称
    price(decimal) : 价格【decimal(8,2)】
    type(string) : 商品类别
    stock(int) : 商品库存
    discount(int) : 折扣【1-10】
    
#### 供应商表(supplier)

    id(int) : 供应商ID
    name(string) : 姓名
    telephone(string) : 电话号码
    
#### 供应商品表(supplier_product)

    supplier_id(int) : 供应商ID【FK】
    product_id(int) : 商品ID【FK】
    amount(int) : 数量
    

    






