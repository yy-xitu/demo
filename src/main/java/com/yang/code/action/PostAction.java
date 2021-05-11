package com.yang.code.action;

import com.alibaba.fastjson.JSONObject;
import com.yang.code.bo.UserBO;
import com.yang.code.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @类编号
 * @类名称：PostAction
 * @文件路径; com.yang.code.action.PostAction
 * @内容摘要：
 * @编码作者：yang
 * @创建日期：2021/5/11 11:06
 * @version：code
 * @since：code
 * @commonents：
 */
@RestController
@RequestMapping("/post")
public class PostAction  {
    @Resource
    private UserService userService;


    /**
     *
     *  @RequestBody   请求参数，获取post请求参数
     *      required false  代表当前参数可以不传
     */
    @RequestMapping("/testInsert")
    public JSONObject testInsert(@RequestBody(required = false) UserBO bo){
        JSONObject jsonObject = new JSONObject();
        try {
            userService.insert(bo);
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("success","0");
            return jsonObject;
        }
        jsonObject.put("success","1");
        return jsonObject;
    }
}
