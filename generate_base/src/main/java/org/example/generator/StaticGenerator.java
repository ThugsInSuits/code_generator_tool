package org.example.generator;

import cn.hutool.core.io.FileUtil;

import java.io.File;

/**
 * @author ThugsInSuits
 * Date 2024/11/14 20:40
 * Version 1.0
 * @ClassName StaticGenerator
 * @Description 静态文件生成器
 **/
public class StaticGenerator {
    public static void main(String[] args) {
        String rootPath = System.getProperty("user.dir");
        String srcPath = rootPath + File.separator + "acm-template";
        String targetPath = rootPath + File.separator + "copyDir";
        copyFileByHutool(srcPath,targetPath,true);
    }

    public static void copyFileByHutool(String srcPath,String targetPath,boolean isOver) {
        FileUtil.copy(srcPath,targetPath,isOver);
    }
}
