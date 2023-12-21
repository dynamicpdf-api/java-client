package DlexLayout;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ResourceBundle;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dynamicpdf.api.AdditionalResourceType;
import com.dynamicpdf.api.DlexLayout;
import com.dynamicpdf.api.DlexResource;
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
	public void DlexLayoutSample()
	{
		LayoutDataResource layoutData = new LayoutDataResource("src\\test\\resources\\SimpleReportData.json");

		DlexLayout dlexEndpoint = new DlexLayout("TFWResources/SimpleReportWithCoverPage.dlex", layoutData);

		PdfResponse response = dlexEndpoint.process();

		if (response.getIsSuccessful()){
			File file = new File("src\\test\\outputs\\DlexSimple.pdf");
			try {
				OutputStream os = new FileOutputStream(file);
				os.write(response.getContent());
				os.close();
			}
			catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}		
		assertEquals(response.getIsSuccessful(), true);
	}
	
	@Test
	public void DlexLayoutWithResource()
	{
		LayoutDataResource layoutData = new LayoutDataResource("src\\test\\resources\\SimpleReportData.json");
		DlexResource dlexResource = new DlexResource("src\\test\\resources\\SimpleReportWithCoverPage.dlex", "SimpleReportWithCoverPage.dlex" );
		DlexLayout dlexEndpoint = new DlexLayout(dlexResource, layoutData);
		dlexEndpoint.addAdditionalResource("src\\test\\resources\\Northwind Logo.gif","Northwind Logo.gif");
		PdfResponse response = dlexEndpoint.process();

		if (response.getIsSuccessful()){
			File file = new File("src\\test\\outputs\\DlexLayoutWithResource.pdf");
			try {
				OutputStream os = new FileOutputStream(file);
				os.write(response.getContent());
				os.close();
			}
			catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}		
		assertEquals(response.getIsSuccessful(), true);
	}
	
	@Test
	public void DlexLayoutWithResourceData()
	{
		LayoutDataResource layoutData = new LayoutDataResource("src\\test\\resources\\SimpleReportData.json");
		DlexResource dlexResource = new DlexResource("src\\test\\resources\\SimpleReportWithCoverPage.dlex", "SimpleReportWithCoverPage.dlex" );
		DlexLayout dlexEndpoint = new DlexLayout(dlexResource, layoutData);

		byte[] resourceData = null;
		try {
			resourceData = Files.readAllBytes(Paths.get("src\\test\\resources\\Northwind Logo.gif"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		dlexEndpoint.addAdditionalResource(resourceData, AdditionalResourceType.IMAGE, "Northwind Logo.gif");
		PdfResponse response = dlexEndpoint.process();

		if (response.getIsSuccessful()){
			File file = new File("src\\test\\outputs\\DlexLayoutWithResourceData.pdf");
			try {
				OutputStream os = new FileOutputStream(file);
				os.write(response.getContent());
				os.close();
			}
			catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}		
		assertEquals(response.getIsSuccessful(), true);
	}
	
	@Test
	public void InvoiceData_Pdfoutput(){

		Order invoiceLinqData = InvoiceData.getOrder11077();
		LayoutDataResource layoutDataResource = new LayoutDataResource(invoiceLinqData);
		DlexLayout dlexEndpoint = new DlexLayout("TFWResources/InvoiceOrderId.dlex", layoutDataResource);

		PdfResponse response = dlexEndpoint.process();

		if (response.getIsSuccessful()){
			File file = new File("src\\test\\outputs\\DlexInvoiceData.pdf");
			try {
				OutputStream os = new FileOutputStream(file);
				os.write(response.getContent());
				os.close();
			}
			catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}		
		assertEquals(response.getIsSuccessful(), true);
	}	
}
