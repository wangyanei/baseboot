package com.wondersgroup.api.service;

import com.wondersgroup.api.entity.User;

import java.util.List;

/**
 * Created by wxk on 2019/5/31.
 */
public interface TestService {
    User findById(String id);
    List<User> findAll();
}
