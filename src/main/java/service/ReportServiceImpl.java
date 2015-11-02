package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import repository.CycleDetailRepository;
import domain.CycleDetail;

@Service("reportService")
public class ReportServiceImpl implements ReportService{
	
	@Autowired
	@Qualifier("cycleRepo")
	CycleDetailRepository cycleDetailRepository;
	
	public List<CycleDetail> listCycleDetails(){
		List<CycleDetail> cycleDetails = cycleDetailRepository.findTop10();
		return cycleDetails;
	}
	
	public List<CycleDetail> testCycleDetail(Long skuId){
		List<CycleDetail> aCycleDetail = cycleDetailRepository.findBySkuId(skuId);
		return aCycleDetail;
	}
}
