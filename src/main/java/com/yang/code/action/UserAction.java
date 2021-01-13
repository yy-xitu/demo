package com.yang.code.action;

import com.yang.code.bo.UserBO;
import com.yang.code.service.UserService;
import com.yang.code.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @类编号
 * @类名称：UserAction
 * @文件路径; com.yang.code.action.UserAction
 * @内容摘要：
 * @编码作者：yang
 * @创建日期：2021/1/12 15:26
 * @version：code
 * @since：code
 * @commonents：
 */
@Controller
public class UserAction {
    @Autowired
    UserService userService;

    @RequestMapping(value = "test")
    public String test(Model model){
        model.addAttribute("s","test");
        return "index";
    }
    @RequestMapping(value = "/test2")
    public String cc(){

        return "index2";
    }
    @ResponseBody
    @RequestMapping(value = "testJson")
    public List<UserVO> testJson(){
        UserVO vo = new UserVO();
        vo.setId(1);
        vo.setUserName("yangyang");
        vo.setPassword("11111");

        return userService.list();
    }

    @ResponseBody
    @RequestMapping(value = "/testInsert")
    public String testInsert(String userName,String password){

        UserBO bo = new UserBO(userName,password);
        userService.insert(bo);
        return "添加成功";

    }
}
