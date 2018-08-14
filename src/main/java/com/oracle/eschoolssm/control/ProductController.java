package com.oracle.eschoolssm.control;

import com.oracle.eschoolssm.model.bean.Product;
import com.oracle.eschoolssm.service.ProductService;
import org.apache.poi.util.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.List;

@Controller
public class ProductController {
    private ProductService productService;

    public ProductService getProductService() {
        return productService;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
    /*列出所有User*/
    @RequestMapping("/productList")
    public String  listLUser(Model model){
        System.out.println("进了productList");
        List<Product> products=productService.processlistProduct(1,2);
        model.addAttribute("allProduct",products);
        for (Product u:products){
            System.out.println(u);
        } return "product_business_list";
    }

    /*根据userid取得User*/
    @RequestMapping(value = "/productDetail"/*,params = "userid"*/)
    public String  getProductByID(@RequestParam("productid")int productid, Model model){
        System.out.println("进了getproductByID");
        System.out.println("product的ID:"+productid);
        Product product =productService.getProductByID(productid);
        System.out.println("product的ID:"+product.getName());
        model.addAttribute("product",product);
        return "product_detail";

    }




    @RequestMapping("/exportProduct")
    public void export(HttpServletResponse response) throws Exception {
        System.out.println("进了exportProduct");
        InputStream is = productService.getInputStream();
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("contentDisposition", "attachment;filename=AllAdmins.xls");
        ServletOutputStream output = response.getOutputStream();
        IOUtils.copy(is, output);
    }

    /*根据id删除商品*/
    @RequestMapping(value = "/productDelete"/*,params = "userid"*/)
    public String deleteProductByID(@RequestParam("productid")int productid, Model model){
        System.out.println("进了deleteproductByID");
        System.out.println("product的ID:"+productid);
        Boolean result =productService.deleteProductByID(productid);
        List<Product> products=productService.processlistProduct(1,2);
        model.addAttribute("allProduct",products);
        return "product_business_list";
    }




}
