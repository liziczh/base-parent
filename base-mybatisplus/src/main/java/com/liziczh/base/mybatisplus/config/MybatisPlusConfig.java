package com.liziczh.base.mybatisplus.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * MyBatisPlusConfig
 *
 * @author chenzhehao
 * @version 1.0
 * @description
 * @date 2022/1/16 12:11 上午
 */
@EnableTransactionManagement
@Configuration
public class MybatisPlusConfig {
    /**
     * 分页插件
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        return new MybatisPlusInterceptor();
    }
}
