package com.dzy.demotestbilibili.mapper;

import com.dzy.demotestbilibili.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author dzy
 * @time 2021/9/16 19:11
 */
@Mapper
public interface UserMapper {

    /**
     * 添加用户信息
     * @param user
     * @return
     * @author dzy
     * @time 2021/9/17 11:28
     */
    @Insert("insert into user values (#{id},#{accountId},#{name},#{token},#{gmtCreate},#{gmtModified},#{bio},#{avatarUrl})")
    void insert(User user);

    /**
     * 根据token去数据库查信息
     * @param token
     * @return
     * @author dzy
     * @time 2021/9/17 11:28
     */
    @Select("select * from user where token = #{token}")
    User findByToken(@Param("token") String token);
}
