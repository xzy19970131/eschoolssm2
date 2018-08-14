package com.oracle.eschoolssm.control;

import com.oracle.eschoolssm.model.bean.User;
import com.oracle.eschoolssm.service.UserService;
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
public class UserController {
       private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * 查看所有user
     * @param model
     * @return
     */
    @RequestMapping(value = "/userList")
    public String listUser (Model model){
        List<User> users = userService.processlistUser(1, 2);
        model.addAttribute("allUser", users);
        for (User u : users) {
            System.out.println(u);
        }
        return "auser_list";
    }
    /**
     * 根据useid查看user详情
     * @param userid
     * @param model
     * @return
     */
    @RequestMapping(value = "/userDetail")
    public String  getUserByID(@RequestParam("userid")int userid, Model model){
        User user =userService.processgetUserByID(userid);
        model.addAttribute("user",user);
        return "auser_detail";

    }
    @RequestMapping("/exportUser")
    public void export(HttpServletResponse response) throws Exception {
        System.out.println("进入到导出UserExcel");
        InputStream is = userService.getInputStream();
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("contentDisposition", "attachment;filename=AllUsers.xls");
        ServletOutputStream output = response.getOutputStream();
        IOUtils.copy(is, output);
    }
}
