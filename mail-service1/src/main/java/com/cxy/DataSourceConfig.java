package com.cxy;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: cxy@acmtc.com
 * \* Date: 2018/10/29
 * \* Time: 14:58
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Configuration// 配置数据源
public class DataSourceConfig {

	@Bean
	@RefreshScope// 刷新配置文件
	@ConfigurationProperties(prefix = "spring.datasource") // 数据源的自动配置的前缀
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}
}