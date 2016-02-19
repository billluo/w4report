package controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import domain.CycleDetail;
import service.ReportServiceImpl;

@RestController
public class RestReport {
	
	@Autowired
	@Qualifier("reportService")
	public ReportServiceImpl reportServiceImpl;
	
	@RequestMapping(value = "/v1/cycledtlreport", method=RequestMethod.GET)
	@ResponseStatus(org.springframework.http.HttpStatus.OK)
	public @ResponseBody List<CycleDetail> cycleDetailReport(){
		return reportServiceImpl.listCycleDetails();
	}
	
	@RequestMapping(value = "/v1/cycledtlreporttest/{skuId}", method=RequestMethod.GET)
	@ResponseStatus(org.springframework.http.HttpStatus.OK)
	public @ResponseBody List<CycleDetail> cycleDetailRecord(@PathVariable("skuId") String skuId){
		Long skuIdLong= Long.valueOf(skuId);
		return reportServiceImpl.testCycleDetail(skuIdLong);
	}
}
