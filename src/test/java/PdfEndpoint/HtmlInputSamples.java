package PdfEndpoint;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dynamicpdf.api.*;

public class HtmlInputSamples {

	@BeforeClass
	public void setup() {
		ResourceBundle bundle =  ResourceBundle.getBundle("config");
		Pdf.setDefaultApiKey(bundle.getString("ApiKey"));
		Pdf.setDefaultBaseUrl(bundle.getString("BaseUrl"));
	}
	
	@Test
    public void HtmlString_pdfoutput(){

         Pdf pdf = new Pdf();

         HtmlResource htmlResource = new HtmlResource("<html><body>hello</body></html>");
         
         HtmlInput html = new HtmlInput(htmlResource);
         html.setPageWidth(300);
         html.setPageHeight(200);
    
         html.setTopMargin(10);
         html.setBottomMargin(10);
         html.setRightMargin(40);
         html.setLeftMargin(40);

         pdf.getInputs().add(html);

         PdfResponse response = pdf.process();

         if (response.getIsSuccessful()) {
 			File file = new File("src\\test\\outputs\\HtmlToPdfString.pdf");
 			try {
 				OutputStream os = new FileOutputStream(file);
 				os.write(response.getContent());
 				os.close();
 			} catch (Exception e) {
 				System.out.println("Exception: " + e);
 			}
 		}
 		assertEquals(response.getIsSuccessful(), true);
     }

	@Test
    public void HtmlStringParameters_pdfoutput(){

         Pdf pdf = new Pdf();
         
         HtmlResource htmlResource = new HtmlResource("<html><body>hello</body></html>");

         HtmlInput html = new HtmlInput(htmlResource, null, PageSize.LETTER, PageOrientation.PORTRAIT, 10f);

         pdf.getInputs().add(html);

         PdfResponse response = pdf.process();

         if (response.getIsSuccessful()) {
 			File file = new File("src\\test\\outputs\\HtmlStringParameters.pdf");
 			try {
 				OutputStream os = new FileOutputStream(file);
 				os.write(response.getContent());
 				os.close();
 			} catch (Exception e) {
 				System.out.println("Exception: " + e);
 			}
 		}
 		assertEquals(response.getIsSuccessful(), true);
     }
	
     @Test
     public void HtmlResource_pdfoutput(){
         Pdf pdf = new Pdf();

         String htmlString = null;
         try {
        	 htmlString = Files.lines(Paths.get("src\\test\\resources\\html.html"), StandardCharsets.UTF_8)
					   .collect(Collectors.joining(System.lineSeparator()));
         } catch (IOException ex) {
        	 System.out.println("Exception: " + ex);
		 }

         HtmlResource file = new HtmlResource(htmlString);
         
         HtmlInput html = new HtmlInput(file);
         
         html.setPageSize(PageSize.B4);
         html.setPageOrientation(PageOrientation.LANDSCAPE);

         html.setTopMargin(50);
         html.setBottomMargin(50);
         html.setRightMargin(80);
         html.setLeftMargin(80);

         pdf.getInputs().add(html);

         PdfResponse response = pdf.process();

         if (response.getIsSuccessful()) {
  			File file1 = new File("src\\test\\outputs\\HtmlToPdfFile.pdf");
  			try {
  				OutputStream os = new FileOutputStream(file1);
  				os.write(response.getContent());
  				os.close();
  			} catch (Exception e) {
  				System.out.println("Exception: " + e);
  			}
  		}
  		assertEquals(response.getIsSuccessful(), true);
     }
     
     @Test
     public void HtmlResourcePageSize_pdfoutput(){
         Pdf pdf = new Pdf();

         String htmlString = null;
         try {
        	 htmlString = Files.lines(Paths.get("src\\test\\resources\\html.html"), StandardCharsets.UTF_8)
					   .collect(Collectors.joining(System.lineSeparator()));
         } catch (IOException ex) {
        	 System.out.println("Exception: " + ex);
		 }

         HtmlResource file = new HtmlResource(htmlString);
         
         HtmlInput html = new HtmlInput(file);
         
         html.setPageSize(PageSize.POSTCARD);

         pdf.getInputs().add(html);

         PdfResponse response = pdf.process();

         if (response.getIsSuccessful()) {
  			File file1 = new File("src\\test\\outputs\\HtmlResourcePageSize.pdf");
  			try {
  				OutputStream os = new FileOutputStream(file1);
  				os.write(response.getContent());
  				os.close();
  			} catch (Exception e) {
  				System.out.println("Exception: " + e);
  			}
  		}
  		assertEquals(response.getIsSuccessful(), true);
     }
     
     @Test
     public void HtmlResourcePageHeightPageWidth_pdfoutput(){
         Pdf pdf = new Pdf();

         String htmlString = null;
         try {
        	 htmlString = Files.lines(Paths.get("src\\test\\resources\\html.html"), StandardCharsets.UTF_8)
					   .collect(Collectors.joining(System.lineSeparator()));
         } catch (IOException ex) {
        	 System.out.println("Exception: " + ex);
		 }

         HtmlResource file = new HtmlResource(htmlString);
         
         HtmlInput html = new HtmlInput(file);
         html.setPageHeight(400);
         html.setPageWidth(300);

         pdf.getInputs().add(html);

         PdfResponse response = pdf.process();

         if (response.getIsSuccessful()) {
  			File file1 = new File("src\\test\\outputs\\HtmlResourcePageHeightPageWidth.pdf");
  			try {
  				OutputStream os = new FileOutputStream(file1);
  				os.write(response.getContent());
  				os.close();
  			} catch (Exception e) {
  				System.out.println("Exception: " + e);
  			}
  		}
  		assertEquals(response.getIsSuccessful(), true);
     }
     
     @Test
     public void HtmlResourceParameters_pdfoutput(){
         Pdf pdf = new Pdf();

         String htmlString = null;
         try {
        	 htmlString = Files.lines(Paths.get("src\\test\\resources\\html.html"), StandardCharsets.UTF_8)
					   .collect(Collectors.joining(System.lineSeparator()));
         } catch (IOException ex) {
        	 System.out.println("Exception: " + ex);
		 }

         HtmlResource file = new HtmlResource(htmlString);
         
         HtmlInput html = new HtmlInput(file, null, PageSize.A3, PageOrientation.LANDSCAPE, 30f);
         
         pdf.getInputs().add(html);

         PdfResponse response = pdf.process();

         if (response.getIsSuccessful()) {
  			File file1 = new File("src\\test\\outputs\\HtmlResourceParameters.pdf");
  			try {
  				OutputStream os = new FileOutputStream(file1);
  				os.write(response.getContent());
  				os.close();
  			} catch (Exception e) {
  				System.out.println("Exception: " + e);
  			}
  		}
  		assertEquals(response.getIsSuccessful(), true);
     }
     
     
     
     
}
