package com.sxd.dto;

import com.sxd.pojo.TbRole;
import com.sxd.pojo.TbUser;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Transient;
import java.util.Date;
import java.util.List;
@Data
public class InfoDTO {
/*    private Integer id;
    private String username;
    private String password;
    private String name;
    private String sex;
    private Integer age;
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date birthday;
    private Integer roleId;
    private String roleName;*/
    private  TbUser user;
    private List<TbRole> roles;
}
