package com.wondersgroup.api.service.impl;

import com.wondersgroup.api.dao.TestMapper;
import com.wondersgroup.api.entity.User;
import com.wondersgroup.api.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wxk on 2019/5/31.
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    public User findById(String id) {

        return testMapper.findById(id);
    }

    @Override
    public List<User> findAll() {
        return testMapper.findAll();
    }
}
