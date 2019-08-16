package com.wyn.api.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Table;

/**
 * Created by wxk on 2019/5/31.
 */
@Data
@ToString
@Table(name = "tb_dic_user")
public class User {
    private String uid;
    private String uname;
    private String upass;
}
