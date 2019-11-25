package com.sxd.mapper;


import com.sxd.pojo.TbRole;
import com.sxd.pojo.TbUser;
import com.sxd.vo.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapper extends Mapper<TbUser> {
    @Select("select * from tb_user where username=#{username} and password=#{password}")
    TbUser login(@Param("username") String username,@Param("password") String password);

    @Select("select u.*,r.role_name from tb_user u left join tb_role r on u.role_id=r.role_id")
    List<TbUser> selectUsers();

    @Select("select u.*,r.role_name from tb_user u left join tb_role r on u.role_id=r.role_id where u.id=#{id}")
    TbUser selectUser(@Param("id")Integer id);

    @Select("select * from tb_role")
    List<TbRole> selectAllRole();

/*    @Select("select u.*,r.role_name from tb_user u left join tb_role r on u.role_id=r.role_id where username like '%${username}%'")
    List<TbUser> findByUsername(String username);*/
}
