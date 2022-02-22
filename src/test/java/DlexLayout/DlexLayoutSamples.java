package DlexLayout;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
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
	public static void InvoiceData_Pdfoutput(){

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
