package com.wyn.center.service.impl;

import com.wyn.center.Entity.UrlEntity;
import com.wyn.center.dao.InitDataDao;
import com.wyn.center.service.InitDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wxk on 2019/6/3.
 */
@Service
public class InitDataServiceImpl implements InitDataService {

    @Autowired
    private InitDataDao initDataDao;



    @Override
    public List<UrlEntity> getAllUrl() {
        List<UrlEntity> urls=initDataDao.getAllUrl();
        if(urls.size()<0){
            return new ArrayList<>();
        }
        return urls;
    }
}
