package com.oracle.eschoolssm.service;

import com.oracle.eschoolssm.model.bean.Product;
import com.oracle.eschoolssm.model.dao.ProductDAO;
import com.oracle.eschoolssm.util.WriteExcel;
import org.springframework.stereotype.Controller;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
@Controller("productService")
public class ProductServiceImp implements ProductService{
    private ProductDAO productDAO;

    public ProductDAO getProductDAO() {
        return productDAO;
    }

    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public List<Product> processlistProduct(int count, int page) {
        System.out.println("进了productServiceImp");
        List<Product> u=productDAO.listProduct(1,2);
        return u;
    }

    public Product getProductByID(int productid) {
        Product product = productDAO.getProductByID(productid);
        return product;
    }

    public InputStream getInputStream() throws Exception {
        String[] title=new String[]{"产品编号","名称","原价","现价","可还价","成色","描述","下架时间","发布时间","是否推广","物品数量","销售？下架","分类ID","用户ID"};
        List<Product> plist=productDAO.getProductList();
        List<Object[]> dataList = new ArrayList<Object[]>();
        for(int i=0;i<plist.size();i++){
            Object[] obj=new Object[14];
            obj[0]=plist.get(i).getProductid();
            obj[1]=plist.get(i).getName();
            obj[2]=plist.get(i).getCostprice();
            obj[3]=plist.get(i).getNowprice();
            obj[4]=plist.get(i).getDiscount();
            obj[5]=plist.get(i).getQuality();
            obj[6]=plist.get(i).getDescrible();
            obj[7]=plist.get(i).getEndtime();
            obj[8]=plist.get(i).getStarttime();
            obj[9]=plist.get(i).getPromotion();
            obj[10]=plist.get(i).getCount();
            obj[11]=plist.get(i).getShelves();
            obj[12]=plist.get(i).getId();
            obj[13]=plist.get(i).getUserid();


            dataList.add(obj);
        }
        WriteExcel ex = new WriteExcel(title, dataList);
        InputStream in;
        in = ex.export();
        return in;
    }

    public boolean deleteProductByID(int productid) {
        Boolean result = productDAO.deleteProductByID(productid);
        return result;
    }
}
