package pers.as.pagedb.service;

import pers.as.pagedb.entity.novel.Novel;

import java.util.List;

public interface NovelService {
    Novel getById(Integer id);

    List<Novel> getList();

    List<Novel> getListByname(String name);
    void updateComment(int id,String comments);
}
