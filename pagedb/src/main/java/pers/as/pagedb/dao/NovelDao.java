package pers.as.pagedb.dao;

import org.apache.ibatis.annotations.Mapper;
import pers.as.pagedb.entity.Novel;

public interface NovelDao {
    Novel getById(Integer id);
}
