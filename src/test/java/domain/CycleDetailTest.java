package domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

public class CycleDetailTest {
	
	@Test
	@Transactional
	public void testCycleDetail(){
		DetailKey cycleDetailPK= new DetailKey();
		cycleDetailPK.setCountedDate("2015-09-17");
		cycleDetailPK.setLocationName("C540022F6");
		cycleDetailPK.setSkuId(8000417428L);
		cycleDetailPK.setWarehouse(98);
		
		CycleDetail cycleDetail = new CycleDetail(cycleDetailPK);
		cycleDetail.setActualQty(100);
		cycleDetail.setStyle("testStyle");
		assertEquals("C540022F6",cycleDetail.getLocationName());
		assertEquals("testStyle", cycleDetail.getStyle());
		assertTrue(cycleDetail.getActualQty()==100);
	}
	


}
