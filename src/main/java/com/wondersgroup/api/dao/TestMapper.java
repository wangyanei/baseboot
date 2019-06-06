package com.wondersgroup.api.dao;

import com.wondersgroup.api.entity.User;
import java.util.List;
/**
 * Created by wxk on 2019/5/31.
 */
public interface TestMapper {

   User findById(String id);
   List<User> findAll();
}
