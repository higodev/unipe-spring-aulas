package br.com.unipe.aula.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class SpringJpaConfig {

	private static final String PACKAGE_MODELS = "br.com.unipe.aula.model";
	private static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
	private static final String MYSQL_DATABASE = "unipe";
	private static final String MYSQL_URL = "jdbc:mysql://localhost:3306/{database}?createDatabaseIfNotExist=true";
	private static final String MYSQL_USERNAME = "root";
	private static final String MYSQL_PASSWORD = "root";

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(MYSQL_DRIVER);
		dataSource.setUsername(MYSQL_USERNAME);
		dataSource.setPassword(MYSQL_PASSWORD);
		String strUrl = MYSQL_URL.replace("{database}", MYSQL_DATABASE);
		dataSource.setUrl(strUrl);
		return dataSource;
	}

	@Bean
	public EntityManagerFactory entityManagerFactory(DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setDataSource(dataSource);
		factory.setPackagesToScan(PACKAGE_MODELS);
		factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		factory.setJpaProperties(jpaProperties());
		factory.afterPropertiesSet();
		return factory.getObject();
	}

	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory factory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(factory);
		transactionManager.setJpaDialect(new HibernateJpaDialect());
		return transactionManager;
	}

	private Properties jpaProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.format_sql", "true");
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		return properties;
	}
}
