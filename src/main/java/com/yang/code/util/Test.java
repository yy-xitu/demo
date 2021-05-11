package com.yang.code.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @类编号
 * @类名称：Test
 * @文件路径; com.yang.code.util.Test
 * @内容摘要：
 * @编码作者：yang
 * @创建日期：2021/5/11 11:33
 * @version：code
 * @since：code
 * @commonents：
 */
public class Test {
    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:ss:mm");
        System.out.println(simpleDateFormat.format(new Date()));
    }
}
