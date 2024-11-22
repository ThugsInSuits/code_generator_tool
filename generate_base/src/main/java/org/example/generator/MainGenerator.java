package org.example.generator;

import freemarker.template.TemplateException;
import org.example.model.MainTemplateConfig;

import java.io.File;
import java.io.IOException;

/**
 * @author ThugsInSuits
 * Date 2024/11/17 23:15
 * Version 1.0
 * @ClassName MainGenerator
 * @Description TODO
 **/
public class MainGenerator {
    public static void doGenerate(MainTemplateConfig mainTemplateConfig) throws TemplateException, IOException {
        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);
        File parentFile = new File(projectPath).getParentFile();
        String inputPath = new File(parentFile,"acm-template").getAbsolutePath();

        StaticGenerator.copyFileByHutool(inputPath,projectPath,true);

        String inputDynamicFile = projectPath + File.separator + "src/main/resources/templates/MainTemplate.java.ftl";
        String outputDynamicFile = projectPath + File.separator + "acm-template/src/main/java/org/example/MainTemplate.java";
        DynamicGenerator.doGenerate(inputDynamicFile,outputDynamicFile,mainTemplateConfig);
    }

    public static void main(String[] args) throws TemplateException, IOException {
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("mySelf");
        mainTemplateConfig.setLoop(false);
        mainTemplateConfig.setOutputText("求和结果");
        doGenerate(mainTemplateConfig);
    }
}
