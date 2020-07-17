package trungtamjava.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc

@ComponentScan(basePackages = { "trungtamjava.*" })
@PropertySource(value="classpath:db.properties" , ignoreResourceNotFound=true)

public class SpringConfiguration extends WebMvcConfigurerAdapter {
	@Autowired
	Environment env;

//	@Bean
//	@Autowired
//	public LocalSessionFactoryBean factoryBean(DataSource dataSource) {
//		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
//		factoryBean.setDataSource(dataSource);
//		factoryBean.setPackagesToScan("trungtamjava.entity");
//
//		Properties properties = new Properties();
//		properties.setProperty("hibernate.dialect", env.getProperty("hibernate.mysql.dialect"));
//		properties.setProperty("hibernate.show_sql", env.getProperty("hibernate.showsql"));
//		/// NEU MUON CAP NHAT BANG
//		properties.setProperty("hibernate.hbm2ddl.auto", "update");
//		factoryBean.setHibernateProperties(properties);
//
//		return factoryBean;
//
//	}
	@Bean
	@Autowired
	public LocalSessionFactoryBean factoryBean(DataSource dataSource) {
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		factoryBean.setDataSource(dataSource);
		factoryBean.setPackagesToScan("trungtamjava.entity");

		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		properties.setProperty("hibernate.show_sql","true");
		/// NEU MUON CAP NHAT BANG
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		factoryBean.setHibernateProperties(properties);

		return factoryBean;

	}
	
	@Bean(name = "transactionManager")
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();

		transactionManager.setSessionFactory(sessionFactory);

		return transactionManager;
	}


//	@Bean
//	public DataSource dataSource() {
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setUsername(env.getProperty("username"));
//		dataSource.setPassword(env.getProperty("password"));
//		dataSource.setUrl(env.getProperty("url"));
//		dataSource.setDriverClassName(env.getProperty("driver"));
//
//		return dataSource;
//	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUsername("root");
		dataSource.setPassword("123456");
		dataSource.setUrl("jdbc:mysql://localhost:3306/ban_hang");
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");

		return dataSource;
	}
//
//	@Bean
//	public JdbcTemplate jdbcTemplate() {
//		return new JdbcTemplate(dataSource());
//	}

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	// css js
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resouce/**").addResourceLocations("/resouces/");
	}

	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource bundleMessageSource = new ReloadableResourceBundleMessageSource();
		bundleMessageSource.setBasename("classpath:messages");
		bundleMessageSource.setDefaultEncoding("utf-8");
		return bundleMessageSource;
	}

	@Bean(name = "multipartResolver")
	public MultipartResolver multipartResolver() {
		CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
		commonsMultipartResolver.setMaxUploadSize(-1);// không hạn chế dung lượng
		return commonsMultipartResolver;
	}


}
