package com.wyn.api.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.wyn.api.entity.User;
import com.wyn.api.service.TestService;
import org.elasticsearch.action.ActionFuture;
import org.elasticsearch.action.admin.indices.stats.IndexStats;
import org.elasticsearch.action.admin.indices.stats.IndicesStatsRequest;
import org.elasticsearch.action.admin.indices.stats.IndicesStatsResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.IndicesAdminClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by wxk on 2019/5/31.
 */
@Controller
@RequestMapping("/api/test/*")
public class TestController {

    @Autowired
    private TestService testService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private  ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    private MongoTemplate mongoTemplate;

    @RequestMapping("mongo1")
    @ResponseBody
    public  String mongo1(){
        DBCollection coll=mongoTemplate.getMongoDbFactory().getLegacyDb().getCollection("jbs");
        BasicDBObject obj=new BasicDBObject("title","糖尿病");
        DBCursor onecur=coll.find(obj);
        while (onecur.hasNext()){
            System.out.print(""+onecur.next().get("title"));
        }
        return "";
    }


    @RequestMapping("es1")
    @ResponseBody
    public  String es1(){
        Client client=elasticsearchTemplate.getClient();
        IndicesAdminClient indicesAdminClient=client.admin().indices();

        ActionFuture<IndicesStatsResponse> isr = client.admin().indices().stats(new IndicesStatsRequest().all());
        Map<String, IndexStats> indexStatsMap = isr.actionGet().getIndices();
        Set<String> set = isr.actionGet().getIndices().keySet();
       for(String s:set){
           System.out.println(s);
       }
        return "";
    }


    @RequestMapping("redis1")
    @ResponseBody
    public  String redist1(){
        stringRedisTemplate.opsForValue().set("cc","120");

      return  stringRedisTemplate.opsForValue().get("wk");
    }


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
    public String getindex(Model model,HttpServletRequest request){
        User user=testService.findById("kk");
        model.addAttribute("user",user);
        HttpSession session=request.getSession();
        session.setAttribute("longin","/api/test/two1");
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


    @RequestMapping("upload")
    @ResponseBody
    public String upload(MultipartFile file) throws Exception{
        InputStream inputStream=file.getInputStream();
        BufferedInputStream buf=new BufferedInputStream(inputStream);
        OutputStream out=new FileOutputStream("D:/ek.xls");
        byte[] bytes=new byte[1024];
        int len=0;
        while ((len=buf.read(bytes,0,len))!=-1){
            out.write(bytes,0,len);
        }
        out.flush();
        out.close();
        buf.close();
        inputStream.close();
        return "success";
    }

}
