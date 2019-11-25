package com.sxd.springBootSsm.pojo;


import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Table(name="tb_user")
public class TbUser {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer userId;
  private String username;
  private String password;
  private int roleId;
  private Date createTime;

}
