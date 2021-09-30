package com.online.edu.eduservice.config;/**
 * @author ：HaiShun
 * @date ：2021/9/29
 * @description：
 **/

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author HaiShun
 * @date 2021年09月29日
 */

@EnableTransactionManagement
@Configuration
@MapperScan("com.online.edu.eduservice.mapper")
public class EduServiceConfig {

    /**
     * 逻辑删除插件
     */
    @Bean
    public ISqlInjector sqlInjector() {
        return new LogicSqlInjector();
    }

}
