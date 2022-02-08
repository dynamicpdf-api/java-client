package DlexLayout;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InvoiceData {

	private static Order order11077 = new Order();

	public static Order getOrder11077()
	{
		order11077.setOrderID(11077);
		order11077.setOrderDate(new Date(119, 0, 6));
		order11077.setCustomerID("RATTC");
		order11077.setShippedDate(new Date(119, 0, 30));
		order11077.setShipperName("United Package");
		order11077.setShipTo("Rattlesnake Canyon Grocery\n2817 Milton Dr.\nAlbuquerque, NM 87110\nUSA");
		order11077.setBillTo("Rattlesnake Canyon Grocery\n2817 Milton Dr.\nAlbuquerque, NM 87110\nUSA");
		order11077.setFreight(8.53f);
		List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
		OrderDetail od = new OrderDetail(2, 24, "Chang", 19);
		orderDetails.add(od);
		OrderDetail od1 = new OrderDetail ( 3, 4, "Aniseed Syrup", 10f );
		orderDetails.add(od1);
		OrderDetail od2 = new OrderDetail ( 4, 1, "Chef Anton's Cajun Seasoning", 22f );
		orderDetails.add(od2);
		OrderDetail od3 = new OrderDetail ( 6, 1, "Grandma's Boysenberry Spread", 25f );
		orderDetails.add(od3);
		OrderDetail od4 = new OrderDetail ( 7, 1, "Uncle Bob's Organic Dried Pears", 30f );
		orderDetails.add(od4);
		OrderDetail od5 = new OrderDetail ( 8, 2, "Northwoods Cranberry Sauce", 40f );
		orderDetails.add(od5);
		OrderDetail od6 = new OrderDetail ( 10, 1, "Ikura", 31f );
		orderDetails.add(od6);
		OrderDetail od7 = new OrderDetail ( 12, 2, "Queso Manchego La Pastora", 38f );
		orderDetails.add(od7);
		OrderDetail od8 = new OrderDetail ( 13, 4, "Konbu", 6f );
		orderDetails.add(od8);
		OrderDetail od9 = new OrderDetail ( 14, 1, "Tofu", 23.25f );
		orderDetails.add(od9);
		OrderDetail od10 = new OrderDetail ( 16, 2, "Pavlova", 17.45f );
		orderDetails.add(od10);
		OrderDetail od11 = new OrderDetail ( 20, 1, "Sir Rodney's Marmalade", 81f );
		orderDetails.add(od11);
		OrderDetail od13 = new OrderDetail ( 23, 2, "Tunnbröd", 9f );
		orderDetails.add(od13);
		OrderDetail od14 = new OrderDetail ( 32, 1, "Mascarpone Fabioli", 32f );
		orderDetails.add(od14);
		OrderDetail od15 = new OrderDetail ( 39, 2, "Chartreuse verte", 18f );
		orderDetails.add(od15);
		OrderDetail od16 = new OrderDetail ( 41, 3, "Jack's New England Clam Chowder", 9.65f );
		orderDetails.add(od16);
		OrderDetail od17 = new OrderDetail ( 46, 3, "Spegesild", 12f );
		orderDetails.add(od17);
		OrderDetail od18 = new OrderDetail ( 52, 2, "Filo Mix", 7f );
		orderDetails.add(od18);
		OrderDetail od19 = new OrderDetail ( 55, 2, "Pâté chinois", 24f );
		orderDetails.add(od19);
		OrderDetail od20 = new OrderDetail ( 60, 2, "Camembert Pierrot", 34f );
		orderDetails.add(od20);
		OrderDetail od21 = new OrderDetail ( 64, 2, "Wimmers gute Semmelknödel", 33.25f );
		orderDetails.add(od21);
		OrderDetail od22 = new OrderDetail ( 66, 1, "Louisiana Hot Spiced Okra", 17f );
		orderDetails.add(od22);
		OrderDetail od23 = new OrderDetail ( 73, 2, "Röd Kaviar", 15f );
		orderDetails.add(od23);
		OrderDetail od24 = new OrderDetail ( 75, 4, "Rhönbräu Klosterbier", 7.75f );
		orderDetails.add(od24);
		OrderDetail od25 = new OrderDetail ( 77, 2, "Original Frankfurter grüne Soße", 13f );
		orderDetails.add(od25);
		order11077.setOrderDetails(orderDetails);
		return order11077; 
	}
}
