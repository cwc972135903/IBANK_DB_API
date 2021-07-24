package com.cmbibank.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("spring.datasource.druid")
public class DruidDataSourceWrapper extends DruidDataSource implements InitializingBean {

    @Autowired
    private DataSourceProperties basicProperties;

    @Override
    public void afterPropertiesSet() throws Exception {

        if (super.getUsername() == null) {
            super.setUsername(basicProperties.determineUsername());
        }
        if (super.getPassword() == null) {
            super.setPassword(basicProperties.determinePassword());
        }
        if (super.getUrl() == null) {
            super.setUrl(basicProperties.determineUrl());
        }
        if (super.getDriverClassName() == null) {
            super.setDriverClassName(basicProperties.getDriverClassName());
        }

        // Password 解密
        setPassword(getPassword());
    }


    /**
     * Ignore the 'maxEvictableIdleTimeMillis < minEvictableIdleTimeMillis' validate,
     * it will be validated again in {@link DruidDataSource#init()}.
     * <p>
     * for fix issue #3084, #2763
     *
     * @since 1.1.14
     */
    @Override
    public void setMaxEvictableIdleTimeMillis(long maxEvictableIdleTimeMillis) {

        try {
            super.setMaxEvictableIdleTimeMillis(maxEvictableIdleTimeMillis);
        } catch (IllegalArgumentException ignore) {
            super.maxEvictableIdleTimeMillis = maxEvictableIdleTimeMillis;
        }
    }
}
