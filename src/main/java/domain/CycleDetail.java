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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((actualQty == null) ? 0 : actualQty.hashCode());
		result = prime * result
				+ ((countedDate == null) ? 0 : countedDate.hashCode());
		result = prime * result
				+ ((expectedQty == null) ? 0 : expectedQty.hashCode());
		result = prime * result
				+ ((locationName == null) ? 0 : locationName.hashCode());
		result = prime * result + ((skuId == null) ? 0 : skuId.hashCode());
		result = prime * result + ((style == null) ? 0 : style.hashCode());
		result = prime * result
				+ ((varianceQty == null) ? 0 : varianceQty.hashCode());
		result = prime * result
				+ ((warehouse == null) ? 0 : warehouse.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CycleDetail other = (CycleDetail) obj;
		if (actualQty == null) {
			if (other.actualQty != null)
				return false;
		} else if (!actualQty.equals(other.actualQty))
			return false;
		if (countedDate == null) {
			if (other.countedDate != null)
				return false;
		} else if (!countedDate.equals(other.countedDate))
			return false;
		if (expectedQty == null) {
			if (other.expectedQty != null)
				return false;
		} else if (!expectedQty.equals(other.expectedQty))
			return false;
		if (locationName == null) {
			if (other.locationName != null)
				return false;
		} else if (!locationName.equals(other.locationName))
			return false;
		if (skuId == null) {
			if (other.skuId != null)
				return false;
		} else if (!skuId.equals(other.skuId))
			return false;
		if (style == null) {
			if (other.style != null)
				return false;
		} else if (!style.equals(other.style))
			return false;
		if (varianceQty == null) {
			if (other.varianceQty != null)
				return false;
		} else if (!varianceQty.equals(other.varianceQty))
			return false;
		if (warehouse == null) {
			if (other.warehouse != null)
				return false;
		} else if (!warehouse.equals(other.warehouse))
			return false;
		return true;
	}


}
