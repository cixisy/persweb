package pers.as.pagedb.service;

import pers.as.pagedb.entity.Novel;

import java.util.List;

public interface NovelService {
    Novel getById(Integer id);

    List<Novel> getList();
}
