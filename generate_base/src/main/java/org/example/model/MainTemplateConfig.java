package org.example.model;

import lombok.Data;

/**
 * @author ThugsInSuits
 * Date 2024/11/17 15:53
 * Version 1.0
 * @ClassName MainTemplateConfig
 * @Description TODO
 **/
@Data
public class MainTemplateConfig {
    // 是否生成循环
    private boolean loop;
    // 作者注释
    private String author;
    // 输出信息
    private String outputText;
}
