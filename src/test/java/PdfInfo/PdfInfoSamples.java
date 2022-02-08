package PdfInfo;

import java.io.File;
import java.util.ResourceBundle;
import java.io.FileWriter;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dynamicpdf.api.PdfInfo;
import com.dynamicpdf.api.PdfInfoResponse;
import com.dynamicpdf.api.PdfResource;

public class PdfInfoSamples  {

	@BeforeClass
    public void setup()
    {
		ResourceBundle bundle =  ResourceBundle.getBundle("config");
		PdfInfo.setDefaultApiKey(bundle.getString("ApiKey"));
		PdfInfo.setDefaultBaseUrl(bundle.getString("BaseUrl"));
    }
	
	@Test
	public static void PdfInfoSample(){

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfInfo\\3PagesWithText.pdf");

		PdfInfo pdfInfo = new PdfInfo(resource);
		PdfInfoResponse response = pdfInfo.process();

		if (response.getIsSuccessful()){
			File file = new File("C:\\Data\\outputs\\Output1.json");
			try {
				FileWriter fw=new FileWriter(file);    
				fw.write(response.getJsonContent());    
				fw.close();  
			}
			catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}

	@Test
	public static void AllFormFields_JsonOutput(){

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfInfo\\AllFormFields.pdf");

		PdfInfo pdfInfo = new PdfInfo(resource);
		PdfInfoResponse response = pdfInfo.process();

		if (response.getIsSuccessful()){
			File file = new File("C:\\Data\\outputs\\Output2.json");
			try {
				FileWriter fw=new FileWriter(file);    
				fw.write(response.getJsonContent());    
				fw.close();  
			}
			catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}
	
	@Test
	public static void Button_JsonOutput(){

		
		PdfResource resource = new PdfResource("src\\test\\resources\\PdfInfo\\Button.pdf");

		PdfInfo pdfInfo = new PdfInfo(resource);
		PdfInfoResponse response = pdfInfo.process();

		if (response.getIsSuccessful()){
			File file = new File("C:\\Data\\outputs\\Output3.json");
			try {
				FileWriter fw=new FileWriter(file);    
				fw.write(response.getJsonContent());    
				fw.close();  
			}
			catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}
	
	@Test
	public static void Checkbox_JsonOutput(){

		
		PdfResource resource = new PdfResource("src\\test\\resources\\PdfInfo\\Checkbox.pdf");

		PdfInfo pdfInfo = new PdfInfo(resource);
		PdfInfoResponse response = pdfInfo.process();

		if (response.getIsSuccessful()){
			File file = new File("C:\\Data\\outputs\\Output4.json");
			try {
				FileWriter fw=new FileWriter(file);    
				fw.write(response.getJsonContent());    
				fw.close();  
			}
			catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}
	
	@Test
	public static void Combo_JsonOutput(){

		
		PdfResource resource = new PdfResource("src\\test\\resources\\PdfInfo\\Checkbox.pdf");

		PdfInfo pdfInfo = new PdfInfo(resource);
		PdfInfoResponse response = pdfInfo.process();

		if (response.getIsSuccessful()){
			File file = new File("C:\\Data\\outputs\\Output5.json");
			try {
				FileWriter fw=new FileWriter(file);    
				fw.write(response.getJsonContent());    
				fw.close();  
			}
			catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}
	@Test
	public static void ComboExport_JsonOutput(){

		
		PdfResource resource = new PdfResource("src\\test\\resources\\PdfInfo\\ComboExport.pdf");

		PdfInfo pdfInfo = new PdfInfo(resource);
		PdfInfoResponse response = pdfInfo.process();

		if (response.getIsSuccessful()){
			File file = new File("C:\\Data\\outputs\\Output6.json");
			try {
				FileWriter fw=new FileWriter(file);    
				fw.write(response.getJsonContent());    
				fw.close();  
			}
			catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}
	@Test
	public static void ComboExport1_JsonOutput(){

		
		PdfResource resource = new PdfResource("src\\test\\resources\\PdfInfo\\ComboExport1.pdf");

		PdfInfo pdfInfo = new PdfInfo(resource);
		PdfInfoResponse response = pdfInfo.process();

		if (response.getIsSuccessful()){
			File file = new File("C:\\Data\\outputs\\Output7.json");
			try {
				FileWriter fw=new FileWriter(file);    
				fw.write(response.getJsonContent());    
				fw.close();  
			}
			catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}
	
	@Test
	public static void ComboExport2_JsonOutput(){

		
		PdfResource resource = new PdfResource("src\\test\\resources\\PdfInfo\\ComboExport2.pdf");

		PdfInfo pdfInfo = new PdfInfo(resource);
		PdfInfoResponse response = pdfInfo.process();

		if (response.getIsSuccessful()){
			File file = new File("C:\\Data\\outputs\\Output8.json");
			try {
				FileWriter fw=new FileWriter(file);    
				fw.write(response.getJsonContent());    
				fw.close();  
			}
			catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}
	
	@Test
	public static void ListBoxMultiSelect_JsonOutput(){

		
		PdfResource resource = new PdfResource("src\\test\\resources\\PdfInfo\\ListBoxMultiSelect.pdf");

		PdfInfo pdfInfo = new PdfInfo(resource);
		PdfInfoResponse response = pdfInfo.process();

		if (response.getIsSuccessful()){
			File file = new File("C:\\Data\\outputs\\Output9.json");
			try {
				FileWriter fw=new FileWriter(file);    
				fw.write(response.getJsonContent());    
				fw.close();  
			}
			catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}
	
	@Test
	public static void ListBoxSingleSelect_JsonOutput(){

		
		PdfResource resource = new PdfResource("src\\test\\resources\\PdfInfo\\ListBoxSingleSelect.pdf");

		PdfInfo pdfInfo = new PdfInfo(resource);
		PdfInfoResponse response = pdfInfo.process();

		if (response.getIsSuccessful()){
			File file = new File("C:\\Data\\outputs\\Output10.json");
			try {
				FileWriter fw=new FileWriter(file);    
				fw.write(response.getJsonContent());    
				fw.close();  
			}
			catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}
	
	@Test
	public static void ListMultiSelectExport2_JsonOutput(){

		
		PdfResource resource = new PdfResource("src\\test\\resources\\PdfInfo\\ListMultiSelectExport2.pdf");

		PdfInfo pdfInfo = new PdfInfo(resource);
		PdfInfoResponse response = pdfInfo.process();

		if (response.getIsSuccessful()){
			File file = new File("C:\\Data\\outputs\\Output11.json");
			try {
				FileWriter fw=new FileWriter(file);    
				fw.write(response.getJsonContent());    
				fw.close();  
			}
			catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}
	
	@Test
	public static void PushButton_JsonOutput(){

		
		PdfResource resource = new PdfResource("src\\test\\resources\\PdfInfo\\PushButton.pdf");

		PdfInfo pdfInfo = new PdfInfo(resource);
		PdfInfoResponse response = pdfInfo.process();

		if (response.getIsSuccessful()){
			File file = new File("C:\\Data\\outputs\\Output12.json");
			try {
				FileWriter fw=new FileWriter(file);    
				fw.write(response.getJsonContent());    
				fw.close();  
			}
			catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}
	
	@Test
	public static void Radio_JsonOutput(){

		
		PdfResource resource = new PdfResource("src\\test\\resources\\PdfInfo\\Radio.pdf");

		PdfInfo pdfInfo = new PdfInfo(resource);
		PdfInfoResponse response = pdfInfo.process();

		if (response.getIsSuccessful()){
			File file = new File("C:\\Data\\outputs\\Output13.json");
			try {
				FileWriter fw=new FileWriter(file);    
				fw.write(response.getJsonContent());    
				fw.close();  
			}
			catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}
	
	@Test
	public static void Signature_JsonOutput(){

		
		PdfResource resource = new PdfResource("src\\test\\resources\\PdfInfo\\Signature.pdf");

		PdfInfo pdfInfo = new PdfInfo(resource);
		PdfInfoResponse response = pdfInfo.process();

		if (response.getIsSuccessful()){
			File file = new File("C:\\Data\\outputs\\Output14.json");
			try {
				FileWriter fw=new FileWriter(file);    
				fw.write(response.getJsonContent());    
				fw.close();  
			}
			catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}
	
	
	@Test
	public static void SignatureNoSign_JsonOutput(){

		
		PdfResource resource = new PdfResource("src\\test\\resources\\PdfInfo\\SignatureNoSign.pdf");

		PdfInfo pdfInfo = new PdfInfo(resource);
		PdfInfoResponse response = pdfInfo.process();

		if (response.getIsSuccessful()){
			File file = new File("C:\\Data\\outputs\\Output15.json");
			try {
				FileWriter fw=new FileWriter(file);    
				fw.write(response.getJsonContent());    
				fw.close();  
			}
			catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}
	
	@Test
	public static void TextField_JsonOutput(){

		
		PdfResource resource = new PdfResource("src\\test\\resources\\PdfInfo\\TextField.pdf");

		PdfInfo pdfInfo = new PdfInfo(resource);
		PdfInfoResponse response = pdfInfo.process();

		if (response.getIsSuccessful()){
			File file = new File("C:\\Data\\outputs\\Output16.json");
			try {
				FileWriter fw=new FileWriter(file);    
				fw.write(response.getJsonContent());    
				fw.close();  
			}
			catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}
	
	@Test
	public static void TextField2_JsonOutput(){

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfInfo\\TextField2.pdf");

		PdfInfo pdfInfo = new PdfInfo(resource);
		PdfInfoResponse response = pdfInfo.process();

		if (response.getIsSuccessful()){
			File file = new File("C:\\Data\\outputs\\Output17.json");
			try {
				FileWriter fw=new FileWriter(file);    
				fw.write(response.getJsonContent());    
				fw.close();  
			}
			catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}
}
