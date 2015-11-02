package domain;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import service.ReportServiceImpl;
//@ContextConfiguration(loader=AnnotationConfigContextLoader.class,
//	classes={DispatcherServletInitializer.class,WebMvcConfig.class,TestDataAccessConfig.class})
@ContextConfiguration(locations="classpath:test_config/test-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("testCycleCount")
@ComponentScan({"domain","repository","service","controller"})
public class TestCycleReport {
  
	@Autowired
	@Qualifier("reportService")
	ReportServiceImpl reportServiceImpl;

	@Test
	@Transactional
	public void findLocation(){
		List<String> locations = new ArrayList<String>(){{
			add("C407073A2");
			add("C540022F6");
			add("C540022F6");
		}};		
		List<CycleDetail> listCycleDetail=this.reportServiceImpl.testCycleDetail(8000417428L);
		
		assertTrue(locations.containsAll(listCycleDetail) && listCycleDetail.containsAll(locations));			
		}	
}
