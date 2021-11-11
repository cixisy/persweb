package pers.as.pagedb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.as.pagedb.dao.NovelDao;
import pers.as.pagedb.entity.Novel;
import pers.as.pagedb.service.NovelService;

import java.util.List;

@Service
public class NovelServiceImpl implements NovelService {
    @Autowired
    private  NovelDao novelDao;
    @Override
    public Novel getById(Integer id) {
        System.out.println("dsdda");
        System.out.println(this.novelDao.getById(id));
        System.out.println("service后");
        return this.novelDao.getById(id);
    }

    @Override
    public List<Novel> getList() {
        return this.novelDao.getList();
    }

    @Override
    public List<Novel> getListByname(String name) {
        return this.novelDao.getListByname(name);
    }
}
