package Coditation.Coditation;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan("Coditation")
public class hibernateconfiguration 
{
	
	@Autowired
	Environment enviroment;
	
	public DataSource getDatasource()
	{
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName(enviroment.getProperty("db.driver"));
		dataSource.setUrl(enviroment.getProperty("db.url"));
		dataSource.setUsername(enviroment.getProperty("db.username"));
		dataSource.setPassword(enviroment.getProperty("db.password"));
		return dataSource;
	}
	
	@Bean
	public LocalSessionFactoryBean getSessionFactory()  
	{
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		factoryBean.setDataSource(getDatasource());
		factoryBean.setPackagesToScan("Coditation.Model");
		Properties hibernateProperties = new Properties();
		hibernateProperties.put("hibernate.dialect", enviroment.getProperty("hibernate.dialect"));
        hibernateProperties.put("hibernate.show_sql", enviroment.getProperty("hibernate.show_sql"));
        //hibernateProperties.put("hibernate.hbm2ddl.auto", enviroment.getProperty("hibernate.hbm2ddl.auto"));
        factoryBean.setHibernateProperties(hibernateProperties);
		return factoryBean;
	}
}
