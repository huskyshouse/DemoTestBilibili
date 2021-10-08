package com.dzy.demotestbilibili.mapper;

import com.dzy.demotestbilibili.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author dzy
 * @time 2021/10/6 15:14
 */
@Mapper
public interface QuestionMapper {
    @Insert("insert into question (title,description,gmt_create,gmt_modified,creator,tag) values (#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{tag});")
    void create(Question question);
}
