package com.ecom.onlineproductcatalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication(exclude = {JpaRepositoriesAutoConfiguration.class , HibernateJpaAutoConfiguration.class})
@EnableTransactionManagement
public class OnlineproductcatalogApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineproductcatalogApplication.class, args);
	}

}
