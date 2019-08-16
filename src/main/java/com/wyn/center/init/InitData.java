package com.wyn.center.init;

import com.wyn.center.service.InitDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 在项目启动时加载的类
 * Created by wxk on 2019/6/3.
 */
@Component
@Order(1)
public class InitData  implements CommandLineRunner {

    public static Map<String,String> urlData=new HashMap<>();

    @Autowired
    private InitDataService initDataService;

    @Override
    public void run(String... args) throws Exception {
       /* List<UrlEntity> urls=initDataService.getAllUrl();
        if(urls.size()<0){
            System.out.println("初始化数据失败");
        }
        for(UrlEntity url:urls){
            urlData.put(url.getUrlName(),url.getUrlDesc());
        } */
        System.out.print("wk--------------"+urlData.size());
        System.out.print("wk--------------"+urlData.get("/api/test/one"));
    }
}
