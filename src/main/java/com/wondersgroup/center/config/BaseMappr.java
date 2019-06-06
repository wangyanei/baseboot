package com.wondersgroup.center.config;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Created by wxk on 2019/6/3.
 */
public interface BaseMappr<T> extends Mapper<T>,MySqlMapper<T> {
}
