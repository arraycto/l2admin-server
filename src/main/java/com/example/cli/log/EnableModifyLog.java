package com.example.cli.log;

import com.example.cli.log.parser.DefaultContentParse;
import com.example.cli.log.service.ILogService;

import java.lang.annotation.*;

/**
 * 记录编辑详细信息的标注
 * @author lw
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface EnableModifyLog {
    /**
     * @return 操作的中文说明 可以直接调用ModifyName
     */
    String name() default "";

    /**
     * @return 获取编辑信息的解析类，目前为使用id获取，复杂的解析需要自己实现，默认不填写
     *       则使用默认解析类
     */
    Class parseclass() default DefaultContentParse.class;

    /**
     * @return 查询数据库所调用的class文件
     */
    Class serviceclass() default ILogService.class;

    /**
     * @return 前台字段名称
     */
    String[] feildName() default {"id"};
    /**
     * @return 具体业务操作名称
     */
    String handleName() default "";
}
