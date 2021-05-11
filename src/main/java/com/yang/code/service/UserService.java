package com.yang.code.service;

import com.yang.code.bo.UserBO;
import com.yang.code.dao.UserDao;
import com.yang.code.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @类编号
 * @类名称：UserService
 * @文件路径; com.yang.code.service.UserService
 * @内容摘要：
 * @编码作者：yang
 * @创建日期：2021/1/12 15:50
 * @version：code
 * @since：code
 * @commonents：
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public List<UserVO> list(){
        return userDao.getUsers();
    }
    public UserVO getUserById(int id){
        return userDao.getUserById(id);
    }

    public void insert(UserBO bo){
        userDao.insertUser(bo.getUserName(),bo.getPassword());
    }

}
