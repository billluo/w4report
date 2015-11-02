package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@IdClass(DetailKey.class)
@Entity
@Table(name="w4CycleDtlRpt")
public class CycleDetail {
	private String countedDate;
	private Integer warehouse;
	private String locationName;
	private Long skuId;
	private String style;
	private Integer expectedQty;
	private Integer actualQty;
	private Integer varianceQty;

	private CycleDetail() {}
	
	public CycleDetail(DetailKey detailKey) {
		countedDate = detailKey.getCountedDate();
		warehouse = detailKey.getWarehouse();
		locationName = detailKey.getLocationName();
		skuId = detailKey.getSkuId();
	}
	
	@Id
	@Column(name="counted_date",insertable=false, updatable=false)
	public String getCountedDate() {
		return countedDate;
	}
	public void setCountedDate(String countedDate) {
		this.countedDate = countedDate;
	}
	@Id
	@Column(name="warehouse",insertable=false, updatable=false)
	public Integer getWarehouse() {
		return warehouse;
	}
	public void setWarehouse(Integer warehouse) {
		this.warehouse = warehouse;
	}
	@Id
	@Column(name="location_name",insertable=false, updatable=false)
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	@Id
	@Column(name="sku_id",insertable=false, updatable=false)
	public Long getSkuId() {
		return skuId;
	}
	public void setSkuId(Long skuId) {
		this.skuId = skuId;
	}
	@Column(name="style")
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	@Column(name="expected_qty")
	public Integer getExpectedQty() {
		return expectedQty;
	}
	public void setExpectedQty(Integer expectedQty) {
		this.expectedQty = expectedQty;
	}
	@Column(name="actual_qty")
	public Integer getActualQty() {
		return actualQty;
	}
	public void setActualQty(Integer actualQty) {
		this.actualQty = actualQty;
	}
	@Column(name="variance_qty")
	public Integer getVarianceQty() {
		return varianceQty;
	}
	public void setVarianceQty(Integer varianceQty) {
		this.varianceQty = varianceQty;
	}


}
