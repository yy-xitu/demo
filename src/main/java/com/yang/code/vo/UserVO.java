package com.yang.code.vo;

import java.io.Serializable;

/**
 * @类编号
 * @类名称：UserVo
 * @文件路径; com.yang.code.vo.UserVo
 * @内容摘要：
 * @编码作者：yang
 * @创建日期：2021/1/12 15:36
 * @version：code
 * @since：code
 * @commonents：
 */
public class UserVO implements Serializable {
    private Integer id;
    private String userName;
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
