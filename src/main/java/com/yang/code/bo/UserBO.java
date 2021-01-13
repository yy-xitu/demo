package com.yang.code.bo;

import java.io.Serializable;

/**
 * @类编号
 * @类名称：UserBO
 * @文件路径; com.yang.code.bo.UserBO
 * @内容摘要：
 * @编码作者：yang
 * @创建日期：2021/1/12 16:17
 * @version：code
 * @since：code
 * @commonents：
 */
public class UserBO implements Serializable {
    private String userName;
    private String password;

    public UserBO() {
    }

    public UserBO(String userName, String password) {
        this.userName = userName;
        this.password = password;
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
