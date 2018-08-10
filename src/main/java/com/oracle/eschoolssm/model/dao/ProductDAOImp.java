package com.oracle.eschoolssm.model.dao;

import com.oracle.eschoolssm.model.bean.Product;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller("productDAO")
public class ProductDAOImp extends BaseDAO implements ProductDAO{

    public Product getProductByID(int productid) {
      ProductDAO dao=getSqlSession().getMapper(ProductDAO.class);
        return dao.getProductByID(productid);
    }

    public List<Product> listProduct(int page, int count) {
        ProductDAO dao=getSqlSession().getMapper(ProductDAO.class);
        return dao.listProduct(1,2);
    }
}
