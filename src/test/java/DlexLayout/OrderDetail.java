package DlexLayout;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderDetail
{
	private int productID;
	private int quantity;
	private String productName;
	private float unitPrice;

	public OrderDetail(int productID, int quantity, String productName, float unitPrice) {
		this.productID = productID;
		this.quantity = quantity;
		this.productName = productName;
		this.unitPrice = unitPrice;
	}
	
	@JsonProperty("ProductID")
	public int getProductID() { 
		return productID;
	}

	public void setProductID(int value) {
		productID = value;
	}

	@JsonProperty("Quantity")
	public int getQuantity() { 
		return quantity;
	}

	public void setQuantity(int value) {
		quantity = value;
	}

	@JsonProperty("ProductName")
	public String getProductName() { 
		return productName;
	}

	public void setProductName(String value) {
		productName = value;
	}

	@JsonProperty("UnitPrice")
	public float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(float value) {
		unitPrice = value;
	}
}

