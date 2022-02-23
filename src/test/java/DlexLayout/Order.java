package DlexLayout;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Order
{
	private int orderID;
	private Date orderDate;
	private String customerID;
	private Date shippedDate;
	private String shipperName;
	private String shipTo;
	private String billTo;
	private float freight;
	private List<OrderDetail> orderDetails;

	@JsonProperty("OrderID")
	public int getOrderID(){
		return orderID;
	}

	public void setOrderID(int value) {
		orderID = value;
	}

	@JsonProperty("OrderDate")
	public String getOrderDate() { 
		SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");  
	    String strDate = formatter.format(orderDate); 
		return strDate;
	}

	public void setOrderDate(Date value) {
		orderDate = value;
	}

	@JsonProperty("CustomerID")
	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String value) {
		customerID = value;
	}

	@JsonProperty("ShippedDate")
	public String getShippedDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");  
	    String strDate = formatter.format(shippedDate); 
		return strDate;
	}

	public void setShippedDate(Date value) {
		shippedDate = value;
	}

	@JsonProperty("ShipperName")
	public String getShipperName() { 
		return shipperName;
	}

	public void setShipperName(String value) {
		shipperName= value;
	}

	@JsonProperty("ShipTo")
	public String getShipTo() { 
		return shipTo;
	}

	public void setShipTo(String value) {
		shipTo= value;
	}

	@JsonProperty("BillTo")
	public String getBillTo() { 
		return billTo;
	}

	public void setBillTo(String value) {
		billTo = value;
	}

	@JsonProperty("Freight")
	public float getFreight() {
		return freight;
	}

	public void setFreight(float value) {
		freight = value;
	}

	@JsonProperty("OrderDetails")
	public List<OrderDetail> getOrderDetails() { 
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> value) { 
		orderDetails = value;
	}
}
