package com.ecom.onlineproductcatalog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;

@Configuration
public class DataBaseConfiguration {
    @Autowired
    private DataSource dataSource;
    @Bean
    public LocalSessionFactoryBean createSessionFactory()
    {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setPackagesToScan("com.ecom.onlineproductcatalog.core.entity");
        factoryBean.setDataSource(dataSource);
        return factoryBean;
    }
    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(createSessionFactory().getObject());
        return transactionManager;
    }
}
