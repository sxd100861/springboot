package com.sxd.service;


import com.sxd.dto.InfoDTO;
import com.sxd.pojo.TbRole;
import com.sxd.vo.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sxd.mapper.UserMapper;
import com.sxd.pojo.TbUser;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.management.relation.Role;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper mapper;

    public TbUser login(String username, String password) {
        TbUser user=new TbUser();
        user.setUsername(username);
        user.setPassword(password);
        return mapper.selectOne(user);
       // return mapper.login(username, password);
    }

    public Page<TbUser> page(Integer page, Integer size) {
        PageHelper.startPage(page,size);//基于拦截器  给查询sql添加limit (page-1)*size,size
        List<TbUser> users= mapper.selectUsers();
        PageInfo<TbUser> pageInfo=new PageInfo<>(users);
        Page<TbUser> mypage=new Page<TbUser>();
        //数据
        mypage.setDatas(users);
        //总页数
        mypage.setTotalPage(pageInfo.getPages());
        //总记录数
        mypage.setTotalNum(pageInfo.getTotal());
        return mypage;
    }

    public int delete(Integer id) {
        int i = mapper.deleteByPrimaryKey(id);
        return i;
    }

    public InfoDTO getOne(Integer id) {
        TbUser user = mapper.selectUser(id);
        List<TbRole> tbRoles = mapper.selectAllRole();
        InfoDTO dto=new InfoDTO();
        dto.setUser(user);
        dto.setRoles(tbRoles);
        return dto;
    }

    public int update(TbUser tbUser) {
        return mapper.updateByPrimaryKey(tbUser);
    }

    public List<TbRole> selectAllRole() {
        return mapper.selectAllRole();
    }

    public int add(TbUser tbUser) {
        return mapper.insert(tbUser);
    }

    public Page<TbUser> find(Integer page, Integer size, String username) {
        PageHelper.startPage(page,size);//基于拦截器  给查询sql添加limit (page-1)*size,size

        Example example=new Example(TbUser.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andLike("username","%"+username+"%");
        List<TbUser> users= mapper.selectByExample(example);
        System.out.println("----"+users);

        PageInfo<TbUser> pageInfo=new PageInfo<>(users);
        Page<TbUser> mypage=new Page<TbUser>();
        //数据
        mypage.setDatas(users);
        //总页数
        mypage.setTotalPage(pageInfo.getPages());
        //总记录数
        mypage.setTotalNum(pageInfo.getTotal());
        return mypage;
    }
}
