package com.sxd.springBootSsm.controller;

import com.sxd.springBootSsm.pojo.TbUser;
import com.sxd.springBootSsm.service.UserService;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService service;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public List<TbUser> get(){
        List<TbUser>list=service.selectAll();
        return list;
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public TbUser getUser(@PathVariable("id") int id){
        System.out.println(id);
        TbUser tbUser = service.selectById(id);
        System.out.println(tbUser);
        return tbUser;
    }

    //根据用户名查
    @GetMapping("/search")
    @ResponseBody
    public List<TbUser> search(String keyWord){
        return service.selectByKeyWord(keyWord);
    }
    //分页查询
    @GetMapping("/page")
    @ResponseBody
    public List<TbUser> page(@RequestParam(value = "page",defaultValue = "1") int page,@RequestParam(value = "size",defaultValue = "2")int size){
        return service.selectByPage(page,size);
    }

    //根据id删除
    @DeleteMapping("/delete")
    @ResponseBody
    public boolean delete(int id){
        return service.delete(id);
    }
    //修改
    @PutMapping("/update")
    @ResponseBody
    public boolean update(TbUser user){
        return service.update(user);
    }
    //增加
    @PostMapping("/insert")
    @ResponseBody
    public TbUser save(TbUser user){
        return service.add(user);
    }
}
