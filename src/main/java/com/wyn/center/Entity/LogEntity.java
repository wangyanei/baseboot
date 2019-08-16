package com.wyn.center.Entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by wxk on 2019/6/3.
 */
@Data
@ToString
@Table(name="tb_log")
public class LogEntity {
    @Id
    @Column(name="logId")
    private Integer logId;
    @Column(name = "loginName")
    private String loginName;
    @Column(name = "url")
    private String url;
    @Column(name="useMethod")
    private String useMethod;

}
