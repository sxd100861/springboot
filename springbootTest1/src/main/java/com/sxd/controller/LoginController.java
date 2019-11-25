package com.sxd.controller;

import com.sxd.pojo.TbUser;
import com.sxd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private UserService service;
    //跳转登录页面
    @RequestMapping(value = "/")
    public String show(){
        return "index";
    }

    @RequestMapping(value = "/dashboard")
    public String show1(){
        return "dashboard";
    }

    @PostMapping(value = "/login")
    public String login(String username, String password, ModelMap map,HttpSession session){
        TbUser user= service.login(username, password);
        System.out.println(user);
        if (user==null){
           map.put("errorMsg","用户名密码错误");
            return "index";
        }else{
            session.setAttribute("username",user.getUsername());
            return "redirect:/dashboard";
        }

    }

}
