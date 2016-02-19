package config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableJpaRepositories({"controller","domain","repository"})
@EnableTransactionManagement
public class DataAccessConfig {

  @Bean
  public EntityManagerFactory entityManagerFactory() {
    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
    vendorAdapter.setGenerateDdl(true);

    LocalContainerEntityManagerFactoryBean factory = new 
    						LocalContainerEntityManagerFactoryBean();
    factory.setJpaVendorAdapter(vendorAdapter);
    factory.setPackagesToScan("controller","domain","repository");
    factory.setDataSource(dataSource());
    factory.setJpaProperties(additionalProperties());
    factory.afterPropertiesSet();
   
    return factory.getObject();
  }

  @Bean
  public DataSource dataSource() {

	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    //dataSource.setDriverClassName(
//	    		"com.microsoft.sqlserver.jdbc.SQLServerDriver");--for SQL SERVER 2008
	    dataSource.setDriverClassName("net.sourceforge.jtds.jdbc.Driver");
	    	dataSource.setUrl("jdbc:jtds:sqlserver://XXXX-4WALL:30001/wm_test;"
	    			+ "useNTLMv2=true;domain=RH");
		dataSource.setUsername("bluo");
		dataSource.setPassword("XXXXXXX");
		
	    return dataSource;
	  
  }
  @Bean
  public PlatformTransactionManager transactionManager() {
    JpaTransactionManager txManager = new JpaTransactionManager();
    txManager.setEntityManagerFactory(entityManagerFactory());
    return txManager;
  }
  
  Properties additionalProperties() {
      Properties properties = new Properties();
      properties.setProperty("hibernate.dialect", 
    		  	"org.hibernate.dialect.SQLServerDialect");
      properties.setProperty("hibernate.show_sql","true");
      properties.setProperty("hibernate.cache.provider_class",
    		  	"org.hibernate.cache.HashtableCacheProvider");

      return properties;
   }
}
