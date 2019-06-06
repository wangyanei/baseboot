package com.wondersgroup.api.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wondersgroup.api.entity.User;
import com.wondersgroup.api.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by wxk on 2019/5/31.
 */
@Controller
@RequestMapping("/api/test/*")
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("one")
    @ResponseBody
    public User get(){
        return testService.findById("kk");
    }

    @RequestMapping("xss1")
    public String  xss(@RequestParam("key") String key, Model model, HttpServletRequest req){


        model.addAttribute("key",req.getParameter("key"));
        return "index";
    }


    @RequestMapping("two")
    public String getindex(Model model){
        User user=testService.findById("kk");
        model.addAttribute("user",user);
        return "index";
    }

    @RequestMapping("page")
    @ResponseBody
    public PageInfo<User> page(@RequestParam("index") int index,@RequestParam("size") int size){
        PageHelper.startPage(index,size);
        List<User> users=testService.findAll();
        PageInfo<User> pageInfo=new PageInfo<>(users);
        return pageInfo;
    }

}
