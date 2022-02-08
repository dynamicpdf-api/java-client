package DlexLayout;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ResourceBundle;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dynamicpdf.api.DlexLayout;
import com.dynamicpdf.api.LayoutDataResource;
import com.dynamicpdf.api.PdfResponse;

public class DlexLayoutSamples {

	@BeforeClass
	public void setup()
	{
		ResourceBundle bundle =  ResourceBundle.getBundle("config");
		DlexLayout.setDefaultApiKey(bundle.getString("ApiKey"));
		DlexLayout.setDefaultBaseUrl(bundle.getString("BaseUrl"));
	}

	@Test
	public static void DlexLayoutSample(){

		LayoutDataResource layoutData = new LayoutDataResource("src\\test\\resources\\DlexLayout\\SimpleReportData.json");

		DlexLayout dlexEndpoint = new DlexLayout("SimpleReportWithCoverPage.dlex", layoutData);

		PdfResponse response = dlexEndpoint.process();

		if (response.getIsSuccessful()){
			File file = new File("C:\\Data\\outputs\\Output.pdf");
			try {
				OutputStream os = new FileOutputStream(file);
				os.write(response.getContent());
				os.close();
			}
			catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}
	
	@Test
	public static void ContactListDlex_Pdfoutput(){

		LayoutDataResource layoutData = new LayoutDataResource("src\\test\\resources\\DlexLayout\\ContactList.json");

		DlexLayout dlexEndpoint = new DlexLayout("ContactList.dlex", layoutData);

		PdfResponse response = dlexEndpoint.process();

		if (response.getIsSuccessful()){
			File file = new File("C:\\Data\\outputs\\Output1.pdf");
			try {
				OutputStream os = new FileOutputStream(file);
				os.write(response.getContent());
				os.close();
			}
			catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}
	
	@Test
	public static void ContentGroupSubReport_Pdfoutput(){

		LayoutDataResource layoutData = new LayoutDataResource("src\\test\\resources\\DlexLayout\\ContentGroupSubReportData.json");

		DlexLayout dlexEndpoint = new DlexLayout("Resources/ReportWriter/ContentGroup/ContentGroupSubReport.dlex", layoutData);

		PdfResponse response = dlexEndpoint.process();

		if (response.getIsSuccessful()){
			File file = new File("C:\\Data\\outputs\\Output2.pdf");
			try {
				OutputStream os = new FileOutputStream(file);
				os.write(response.getContent());
				os.close();
			}
			catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}
	
	@Test
	public static void AllReportElements_Pdfoutput(){

		LayoutDataResource layoutData = new LayoutDataResource("src\\test\\resources\\DlexLayout\\AllReportElementsData.json");

		DlexLayout dlexEndpoint = new DlexLayout("Resources/ReportWriter/AllReportElements.dlex", layoutData);

		PdfResponse response = dlexEndpoint.process();

		if (response.getIsSuccessful()){
			File file = new File("C:\\Data\\outputs\\Output3.pdf");
			try {
				OutputStream os = new FileOutputStream(file);
				os.write(response.getContent());
				os.close();
			}
			catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}
	
	@Test
	public static void ContentGroup_Pdfoutput(){

		LayoutDataResource layoutData = new LayoutDataResource("src\\test\\resources\\DlexLayout\\ContentGroupData.json");

		DlexLayout dlexEndpoint = new DlexLayout("Resources/ReportWriter/ContentGroup.dlex", layoutData);

		PdfResponse response = dlexEndpoint.process();

		if (response.getIsSuccessful()){
			File file = new File("C:\\Data\\outputs\\Output4.pdf");
			try {
				OutputStream os = new FileOutputStream(file);
				os.write(response.getContent());
				os.close();
			}
			catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}
	
	@Test
	public static void Invoice_Pdfoutput(){

		LayoutDataResource layoutData = new LayoutDataResource("src\\test\\resources\\DlexLayout\\InvoiceReportData.json");

		DlexLayout dlexEndpoint = new DlexLayout("Resources/ReportWriter/Invoice.dlex", layoutData);

		PdfResponse response = dlexEndpoint.process();

		if (response.getIsSuccessful()){
			File file = new File("C:\\Data\\outputs\\Output5.pdf");
			try {
				OutputStream os = new FileOutputStream(file);
				os.write(response.getContent());
				os.close();
			}
			catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}
	
	@Test
	public static void InvoiceData_Pdfoutput(){

		Order invoiceLinqData = InvoiceData.getOrder11077();
		LayoutDataResource layoutDataResource = new LayoutDataResource(invoiceLinqData);
		DlexLayout dlexEndpoint = new DlexLayout("InvoiceOrderId.dlex", layoutDataResource);

		PdfResponse response = dlexEndpoint.process();

		if (response.getIsSuccessful()){
			File file = new File("C:\\Data\\outputs\\Output6.pdf");
			try {
				OutputStream os = new FileOutputStream(file);
				os.write(response.getContent());
				os.close();
			}
			catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}
	
	@Test
	public static void SimpleDlex_JsonString_Pdfoutput() {

		String jsonString = null;
		
		try {
			jsonString = new String(Files.readAllBytes(Paths.get("src\\test\\resources\\DlexLayout\\SimpleReportData.json")));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		LayoutDataResource layoutData = new LayoutDataResource(jsonString);
		DlexLayout dlexEndpoint = new DlexLayout("SimpleReportWithCoverPage.dlex", layoutData);
		PdfResponse response = dlexEndpoint.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Output7.pdf");
			try {
				OutputStream os = new FileOutputStream(file);
				os.write(response.getContent());
				os.close();
			} catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}
	
}
