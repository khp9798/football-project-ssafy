package com.ssafy.mvc.Config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@MapperScan("com.ssafy.mvc.dao")
@Configuration
public class MyBatisConfig {

}
