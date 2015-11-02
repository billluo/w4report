package service;

import java.util.List;

import domain.CycleDetail;

public interface ReportService {
	
	public List<CycleDetail> listCycleDetails();
	public List<CycleDetail> testCycleDetail(Long skuId);

}
