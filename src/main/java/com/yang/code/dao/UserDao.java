package com.yang.code.dao;

import com.yang.code.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @类编号
 * @类名称：UserDao
 * @文件路径; com.yang.code.dao.UserDao
 * @内容摘要：
 * @编码作者：yang
 * @创建日期：2021/1/12 15:43
 * @version：code
 * @since：code
 * @commonents：
 */
@Mapper
@Component
public interface UserDao {
    List<UserVO> getUsers();
    void insertUser(@Param("userName") String userName, @Param("password") String password);
}
