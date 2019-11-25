package com.sxd.controller;

import com.sxd.dto.InfoDTO;
import com.sxd.pojo.TbRole;
import com.sxd.vo.Page;
import com.sxd.pojo.TbUser;
import com.sxd.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/user/list")
    public String list(@RequestParam(value="page", defaultValue = "1") Integer page, @RequestParam(value="size", defaultValue = "3") Integer size, ModelMap map){
        Page<TbUser> pages=service.page(page,size);
        map.put("page",pages);
        map.put("currentPage",page);
        map.put("size",size);
        return "list";
    }
    @DeleteMapping("/user/delete")
    public String delete(@RequestParam("id")Integer id){
        int i = service.delete(id);
        return "redirect:/user/list";
    }
    @GetMapping("/user/info")
    public String getOne(@RequestParam("id")Integer id, ModelMap map){
        InfoDTO dto = service.getOne(id);
        map.put("dto",dto);
        return "update";
    }
    @PutMapping("/user/update")
    public String update(TbUser tbUser){
       int i=service.update(tbUser);
       return "redirect:/user/list";
    }
    @GetMapping("/user/showAdd")
    public String showAdd(ModelMap map){
        List<TbRole> list = service.selectAllRole();
        map.put("list",list);
        return "add";
    }
    @PostMapping("/user/add")
    public String add(TbUser tbUser){
        service.add(tbUser);
        return "redirect:/user/list";
    }
    @GetMapping("/user/find")
    public String find(@RequestParam(value="page", defaultValue = "1") Integer page, @RequestParam(value="size", defaultValue = "3") Integer size,@RequestParam("username")String username,ModelMap map){
        Page<TbUser> pages=service.find(page,size,username);
        map.put("page",pages);
        map.put("currentPage",page);
        map.put("size",size);
        map.put("username",username);
        return "list";
    }
}
