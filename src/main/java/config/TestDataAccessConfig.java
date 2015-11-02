//package config;
//
//import java.util.Properties;
//
//import javax.persistence.EntityManagerFactory;
//import javax.sql.DataSource;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
//import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
//import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//
//@Configuration
//@Profile("test")
//@EnableJpaRepositories({"controller","domain","repository","service"})
//@EnableTransactionManagement
//public class TestDataAccessConfig {
//	
//	@Bean
//	public EntityManagerFactory testManagerFactory(){
//		HibernateJpaVendorAdapter testAdapter = new
//			  HibernateJpaVendorAdapter();
//		testAdapter.setGenerateDdl(true);
//		LocalContainerEntityManagerFactoryBean testFactory = new
//			  LocalContainerEntityManagerFactoryBean();
//		testFactory.setJpaVendorAdapter(testAdapter);
//		testFactory.setPackagesToScan("controller","domain","repository","service");
//		testFactory.setDataSource(dataSource());
//		testFactory.setJpaProperties(additionalTestProperties());
//	  
//		return testFactory.getObject();
//	}
//	
//	@Bean
//	public DataSource dataSource() {
//		
//		// no need shutdown, EmbeddedDatabaseFactoryBean will take care of this
//		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
//		EmbeddedDatabase db = builder
//			.setType(EmbeddedDatabaseType.HSQL) //.H2 or .DERBY
//			.addScript("initDB.sql")
//			.addScript("import_data.sql")
//			.build();
//		return db;
//	}
////	@Bean
////	public DataSource testSource() {
//////		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
//////		return builder.setType(EmbeddedDatabaseType.HSQL)
////////    				  .setName("testW4Report")
//////    				  .addScript("classpath:initDB.sql")
//////    				  .addScript("classpath:import_data.sql")
//////    				  .build(); 
////		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
////		EmbeddedDatabase db = builder
////			.setType(EmbeddedDatabaseType.HSQL) //.H2 or .DERBY
////			.addScript("initDB.sql")
////			.addScript("classpath:import_data.sql")
////			.build();
////		return db;
////	}
//  
//	Properties additionalTestProperties() {
//		Properties properties = new Properties();
//		properties.setProperty("hibernate.dialect",
//    		  		"org.hibernate.dialect.HSQLDialect");
//		properties.setProperty("hibernate.show_sql","true");
//		properties.setProperty("hibernate.cache.provider_class",
//    		  		"org.hibernate.cache.HashtableCacheProvider");
//
//		return properties;
//	}
//	  @Bean
//	  public PlatformTransactionManager testTransactionManager() {
//	    JpaTransactionManager txManager = new JpaTransactionManager();
//	    txManager.setEntityManagerFactory(testManagerFactory());
//	    return txManager;
//	  }
//	  
//}
