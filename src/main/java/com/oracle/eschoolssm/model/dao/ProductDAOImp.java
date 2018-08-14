package com.oracle.eschoolssm.model.dao;

import com.oracle.eschoolssm.model.bean.Product;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller("productDAO")
public class ProductDAOImp extends BaseDAO implements ProductDAO{

    public Product getProductByID(int productid) {
        System.out.println("进了getProductDAOImp里id："+productid);
        ProductDAO dao=getSqlSession().getMapper(ProductDAO.class);
        System.out.println(dao.getProductByID(productid).getName());
        return dao.getProductByID(productid);
    }

    public List<Product> listProduct(int page, int count) {
        ProductDAO dao=getSqlSession().getMapper(ProductDAO.class);
        return dao.listProduct(1,2);
    }

    //Excel导出所有管理员的信息
    public List<Product> getProductList() {
        ProductDAO dao=getSqlSession().getMapper(ProductDAO.class);
        return dao.getProductList();
    }

    public Boolean deleteProductByID(int productid) {
        ProductDAO dao=getSqlSession().getMapper(ProductDAO.class);
        return dao.deleteProductByID(productid);
    }
}
