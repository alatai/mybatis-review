package com.saihou.mybatis.io;

import java.io.InputStream;

/**
 * 使用类加载器读取配置文件
 *
 * @author Alatai
 * @version 1.0
 * @date 2021/04/14 22:15
 */
public class Resources {

    /**
     * 根据传入的参数，获取字节输入流
     * 
     * @param filePath
     * @return
     */
    public static InputStream getResourceAsStream(String filePath) {
       return Resources.class.getClassLoader().getResourceAsStream(filePath);
    }
}
