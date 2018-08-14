package com.oracle.eschoolssm.service;



import com.oracle.eschoolssm.model.bean.Product;

import java.io.InputStream;
import java.util.List;

public interface ProductService {
    public List<Product> processlistProduct(int count, int page);
    public Product getProductByID(int productid);
    InputStream getInputStream() throws Exception;
    public boolean deleteProductByID(int productid);
}
