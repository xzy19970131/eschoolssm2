package com.oracle.eschoolssm.model.dao;



import com.oracle.eschoolssm.model.bean.Product;

import java.util.List;

public interface ProductDAO {
    public Product getProductByID(int productid);
    public List<Product> listProduct(int page, int count);
    public List<Product> getProductList();
    public Boolean deleteProductByID(int productid);


}

