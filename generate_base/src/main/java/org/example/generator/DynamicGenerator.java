package org.example.generator;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.example.model.MainTemplateConfig;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;


/**
 * @author ThugsInSuits
 * Date 2024/11/17 15:57
 * Version 1.0
 * @ClassName DynamicGenerator
 * @Description TODO
 **/
public class DynamicGenerator {
    public static void main(String[] args) throws Exception{
        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);
        String inputString = projectPath  + File.separator + "src/main/resources/templates/MainTemplate.java.ftl";
        String outPutString = projectPath + File.separator + "MainTemplate.java";
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("myself");
        mainTemplateConfig.setOutputText("求和结果");
        mainTemplateConfig.setLoop(false);

        doGenerate(inputString,outPutString,mainTemplateConfig);
    }

    public static void doGenerate(String inputString,String outputPath,Object model) throws IOException, TemplateException {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);

        File templateDir = new File(inputString).getParentFile();
        configuration.setDirectoryForTemplateLoading(templateDir);
        configuration.setDefaultEncoding("utf-8");

        String templateName = new File(inputString).getName();
        Template template = configuration.getTemplate(templateName);

        Writer out = new FileWriter(outputPath);
        template.process(model,out);
        out.close();
    }
}
