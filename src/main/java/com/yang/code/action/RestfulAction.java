package com.yang.code.action;

import com.alibaba.fastjson.JSONObject;
import com.yang.code.service.UserService;
import com.yang.code.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @类编号
 * @类名称：RestfulAction
 * @文件路径; com.yang.code.action.RestfulAction
 * @内容摘要：   restful 请求接口
 * @编码作者：yang
 * @创建日期：2021/5/11 10:48
 * @version：code
 * @since：code
 * @commonents：
 */
@RestController
@RequestMapping("/restful")
public class RestfulAction {
    @Autowired
    UserService userService;


    /**
     *      @PathVariable 获取请求路径上的参数
     * */
    @GetMapping("/user/{id}")
    public JSONObject getUser(@PathVariable Integer id){
        JSONObject jsonObject = new JSONObject();
        UserVO user = userService.getUserById(id);
        jsonObject.put("user",user);
        return jsonObject;
    }

}
