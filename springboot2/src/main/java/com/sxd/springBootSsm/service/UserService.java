package com.sxd.springBootSsm.service;

import com.github.pagehelper.PageHelper;
import com.sxd.springBootSsm.mapper.UserMapper;
import com.sxd.springBootSsm.pojo.TbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper mapper;

    public List<TbUser> selectAll(){
       return mapper.selectAll();
    }

    public TbUser selectById(int userId) {
        System.out.println(userId);

        TbUser tbUser = mapper.selectByPrimaryKey(1);

        return tbUser;
    }

    public List<TbUser> selectByKeyWord(String keyWord) {
        Example example=new Example(TbUser.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username","%"+keyWord+"%");
        return mapper.selectByExample(example);
    }

    public boolean delete(int id) {
        int i= mapper.deleteByPrimaryKey(id);
        if (i>0){
            return true;
        }else {
            return false;
        }
    }

    public List<TbUser> selectByPage(int page, int size) {
        PageHelper.startPage(page,size);
        List<TbUser> list=mapper.selectAll();
        return list;
    }

    public boolean update(TbUser user) {
       int i= mapper.updateByPrimaryKey(user);
        if (i>0){
            return true;
        }else {
            return false;
        }
    }

    public TbUser add(TbUser user) {
        mapper.insert(user);
        return user;
    }
}
