import cn.hutool.extra.template.TemplateException;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ThugsInSuits
 * Date 2024/11/17 14:27
 * Version 1.0
 * @ClassName FreeMarkerTest
 * @Description TODO
 **/
public class FreeMarkerTest {
    @Test
    public void test() throws IOException, TemplateException, freemarker.template.TemplateException {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);
        configuration.setDirectoryForTemplateLoading(new File("src/main/resources/templates"));
        configuration.setDefaultEncoding("utf-8");
        Template template = configuration.getTemplate("web.html.ftl");

        // 创建数据模型
        Map<String,Object> dataModel = new HashMap<>();
        dataModel.put("currentYear",2023);
        List<Map<String,Object>> menuItems = new ArrayList<>();
        Map<String,Object> item1 = new HashMap<>();
        item1.put("url","https://www.baidu.com");
        item1.put("label","代码生成器");

        Map<String,Object> item2 = new HashMap<>();
        item2.put("url","https://www.baidu.com");
        item2.put("label","代码生成器");

        menuItems.add(item1);
        menuItems.add(item2);
        dataModel.put("menuItems",menuItems);

        Writer out = new FileWriter("web.html");
        template.process(dataModel,out);
        out.close();

    }
}
