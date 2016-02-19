package domain;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import repository.CycleDetailRepository;
import service.ReportService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:test_config/Unit-test-config.xml")
@ActiveProfiles("testCycleCount")
@ComponentScan({"domain","repository","service","controller"})
public class UnitTestReportService {
	@Mock
	private CycleDetail cycledetail1;
	
	@Mock
	private CycleDetailRepository cycleDetailRepository;
	
	@InjectMocks
	@Autowired
	private ReportService reportService;
	
	@Before
	public void SetupContext(){
		MockitoAnnotations.initMocks(this);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testListCycleDetails(){
		
		//stub the calling method for cycleDetail and cycleRepository		
		List<CycleDetail> list1 = new ArrayList<CycleDetail>();
		list1.add(cycledetail1);
		when(cycleDetailRepository.findTop10()).thenReturn(list1);
		when(cycledetail1.getActualQty()).thenReturn(Integer.valueOf(100));
		
		//test & verify service
		List<CycleDetail> testList = reportService.listCycleDetails();
		Assert.assertTrue(list1.equals(testList));
		Assert.assertEquals(Integer.valueOf(100).doubleValue(), 
				testList.get(0).getActualQty().doubleValue(),0);	
		verify(cycleDetailRepository,times(1)).findTop10();
	}
}
