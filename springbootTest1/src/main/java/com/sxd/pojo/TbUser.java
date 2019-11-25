package com.sxd.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name="tb_user")
public class TbUser {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String username;
  private String password;
  private String name;
  private String sex;
  private Integer age;

  //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @DateTimeFormat(pattern ="yyyy-MM-dd")
  private Date birthday;
  private Integer roleId;

  @Transient //该字段和数据数据库中的字段没有映射关系
  private String roleName;

}
