package pers.as.pagedb.dao;

import org.apache.ibatis.annotations.Mapper;
import pers.as.pagedb.entity.Novel;

import java.util.List;

public interface NovelDao {
    Novel getById(Integer id);

    List<Novel> getList();

    List<Novel> getListByname(String name);
}
