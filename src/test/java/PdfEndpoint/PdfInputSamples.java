package PdfEndpoint;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ResourceBundle;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dynamicpdf.api.MergeOptions;
import com.dynamicpdf.api.Pdf;
import com.dynamicpdf.api.PdfInput;
import com.dynamicpdf.api.PdfResource;
import com.dynamicpdf.api.PdfResponse;
import com.dynamicpdf.api.Template;
import com.dynamicpdf.api.elements.ElementPlacement;
import com.dynamicpdf.api.elements.TextElement;

public class PdfInputSamples {

	@BeforeClass
	public void setup()
	{
		ResourceBundle bundle =  ResourceBundle.getBundle("config");
		Pdf.setDefaultApiKey(bundle.getString("ApiKey"));
		Pdf.setDefaultBaseUrl(bundle.getString("BaseUrl"));
	}
	
	@Test	
	void simplePdfInput() {
		
        Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");

        PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\3PagesWithText.pdf");
        PdfInput input = new PdfInput(resource);
        pdf.getInputs().add(input);

        PdfResponse response = pdf.process();
        
        if (response.getIsSuccessful()){
            File file = new File("C:\\Data\\outputs\\javaOutput.pdf");
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
	void Bytes_PdfOutput() {
		
        Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");

        byte[] array = null;
		try {
			array = Files.readAllBytes(Paths.get("src\\test\\resources\\PdfEndpoint\\Emptypages.pdf"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

        PdfResource resource = new PdfResource(array);
        PdfInput input = new PdfInput(resource);
        pdf.getInputs().add(input);

        PdfResponse response = pdf.process();
        
        if (response.getIsSuccessful()){
            File file = new File("C:\\Data\\outputs\\javaOutput1.pdf");
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
	void Stream_PdfOutput() {
		
        Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");

        File initialFile = new File("src\\test\\resources\\PdfEndpoint\\Emptypages.pdf");
        InputStream targetStream = null;
		try {
			targetStream = new FileInputStream(initialFile);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

        PdfResource resource = new PdfResource(targetStream);
        PdfInput input = new PdfInput(resource);
        pdf.getInputs().add(input);

        PdfResponse response = pdf.process();
        
        if (response.getIsSuccessful()){
            File file = new File("C:\\Data\\outputs\\javaOutput2.pdf");
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
	void CloudRoot_PdfOutput() {
		
        Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");

        PdfInput input = new PdfInput("Emptypages.pdf");
        pdf.getInputs().add(input);

        PdfResponse response = pdf.process();
        
        if (response.getIsSuccessful()){
            File file = new File("C:\\Data\\outputs\\javaOutput3.pdf");
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
	void BytesPdfInputs_PdfOutput() {
		
        Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");
        
        byte[] array = null;
		try {
			array = Files.readAllBytes(Paths.get("src\\test\\resources\\PdfEndpoint\\Invoice.pdf"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        PdfResource invoiceResource = new PdfResource(array);
        PdfInput invoice = new PdfInput(invoiceResource);
        pdf.getInputs().add(invoice);

        byte[] array1 = null;
		try {
			array1 = Files.readAllBytes(Paths.get("src\\test\\resources\\PdfEndpoint\\fw9AcroForm_18.pdf"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        PdfResource fw9AcroForm_18Resource = new PdfResource(array1);
        PdfInput fw9AcroForm_18 = new PdfInput(fw9AcroForm_18Resource);
        pdf.getInputs().add(fw9AcroForm_18);

        byte[] array2 = null;
		try {
			array2 = Files.readAllBytes(Paths.get("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        PdfResource documentA100Resource = new PdfResource(array2);
        PdfInput documentA100 = new PdfInput(documentA100Resource);
        pdf.getInputs().add(documentA100);


        PdfResponse response = pdf.process();
        
        if (response.getIsSuccessful()){
            File file = new File("C:\\Data\\outputs\\javaOutput4.pdf");
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
	void FilePathPdfInputs_PdfOutput() {
		
        Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");
        
        PdfResource invoiceResource = new PdfResource("src\\test\\resources\\PdfEndpoint\\Invoice.pdf");
        PdfInput invoice = new PdfInput(invoiceResource);
        pdf.getInputs().add(invoice);

        PdfResource fw9AcroForm_18Resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\fw9AcroForm_18.pdf");
        PdfInput fw9AcroForm_18 = new PdfInput(fw9AcroForm_18Resource);
        pdf.getInputs().add(fw9AcroForm_18);

        PdfResource documentA100Resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
        PdfInput documentA100 = new PdfInput(documentA100Resource);
        pdf.getInputs().add(documentA100);


        PdfResponse response = pdf.process();
        
        if (response.getIsSuccessful()){
            File file = new File("C:\\Data\\outputs\\javaOutput5.pdf");
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
	void StreamPdfInputs_PdfOutput() {
		
        Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");
        
        File initialFile = new File("src\\test\\resources\\PdfEndpoint\\Invoice.pdf");
        InputStream targetStream = null;
		try {
			targetStream = new FileInputStream(initialFile);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        PdfResource invoiceResource = new PdfResource(targetStream);
        PdfInput invoice = new PdfInput(invoiceResource);
        pdf.getInputs().add(invoice);

        File initialFile1 = new File("src\\test\\resources\\PdfEndpoint\\fw9AcroForm_18.pdf");
        InputStream targetStream1 = null;
		try {
			targetStream1 = new FileInputStream(initialFile1);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        PdfResource fw9AcroForm_18Resource = new PdfResource(targetStream1);
        PdfInput fw9AcroForm_18 = new PdfInput(fw9AcroForm_18Resource);
        pdf.getInputs().add(fw9AcroForm_18);

        File initialFile2 = new File("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
        InputStream targetStream2 = null;
		try {
			targetStream2 = new FileInputStream(initialFile2);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        PdfResource documentA100Resource = new PdfResource(targetStream2);
        PdfInput documentA100 = new PdfInput(documentA100Resource);
        pdf.getInputs().add(documentA100);


        PdfResponse response = pdf.process();
        
        if (response.getIsSuccessful()){
            File file = new File("C:\\Data\\outputs\\javaOutput6.pdf");
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
	void CloudRootPdfInputs_PdfOutput() {
		
        Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");
        
        PdfInput invoice = new PdfInput("Invoice.pdf");
        pdf.getInputs().add(invoice);

        PdfInput fw9AcroForm_18 = new PdfInput("fw9AcroForm_18.pdf");
        pdf.getInputs().add(fw9AcroForm_18);

        PdfInput documentA100 = new PdfInput("DocumentA100.pdf");
        pdf.getInputs().add(documentA100);


        PdfResponse response = pdf.process();
        
        if (response.getIsSuccessful()){
            File file = new File("C:\\Data\\outputs\\javaOutput7.pdf");
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
	void FilePathMergeMultipleDocuments_PdfOutput() {
		
        Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");
        
        PdfResource invoiceResource = new PdfResource("src\\test\\resources\\PdfEndpoint\\AllPageElements.pdf");
        PdfInput invoice = new PdfInput(invoiceResource);
        invoice.setStartPage(1);
        invoice.setPageCount(6);
        pdf.getInputs().add(invoice);

        PdfResource fw9AcroForm_18Resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\All Fields Sample.pdf");
        PdfInput fw9AcroForm_18 = new PdfInput(fw9AcroForm_18Resource);
        pdf.getInputs().add(fw9AcroForm_18);

        PdfResource documentA100Resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\fw9AcroForm_14.pdf");
        PdfInput documentA100 = new PdfInput(documentA100Resource);
        pdf.getInputs().add(documentA100);


        PdfResponse response = pdf.process();
        
        if (response.getIsSuccessful()){
            File file = new File("C:\\Data\\outputs\\javaOutput8.pdf");
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
	void FilePathSimpleMerge_PdfOutput() {
		
        Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");

        PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\AllPageElements.pdf");
        PdfInput input = new PdfInput(resource);
        pdf.getInputs().add(input);

        PdfResponse response = pdf.process();
        
        if (response.getIsSuccessful()){
            File file = new File("C:\\Data\\outputs\\javaOutput9.pdf");
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
	void FilePathMergeStartPageAndPageCount_PdfOutput() {
		
        Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");

        PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
        PdfInput input = new PdfInput(resource);
        input.setStartPage(2);
        input.setPageCount(10);
        pdf.getInputs().add(input);

        PdfResponse response = pdf.process();
        
        if (response.getIsSuccessful()){
            File file = new File("C:\\Data\\outputs\\javaOutput10.pdf");
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
	void FilePathMergeWithSameInput_PdfOutput() {
		
        Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");
        
        PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\AllPageElements.pdf");
        PdfInput input = new PdfInput(resource);
        pdf.getInputs().add(input);

        PdfResource resource1 = new PdfResource("src\\test\\resources\\PdfEndpoint\\AllPageElements.pdf");
        PdfInput input1 = new PdfInput(resource1);
        pdf.getInputs().add(input1);

        PdfResource resource2 = new PdfResource("src\\test\\resources\\PdfEndpoint\\AllPageElements.pdf");
        PdfInput input2 = new PdfInput(resource2);
        pdf.getInputs().add(input2);


        PdfResponse response = pdf.process();
        
        if (response.getIsSuccessful()){
            File file = new File("C:\\Data\\outputs\\javaOutput11.pdf");
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
	void FilePathMergeOptions_PdfOutput() {
		
        Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");

        PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\AllPageElements.pdf");
        PdfInput input = new PdfInput(resource);
        
        MergeOptions mergeOptions = new MergeOptions();
        input.setMergeOptions(mergeOptions);
        
        pdf.getInputs().add(input);

        PdfResponse response = pdf.process();
        
        if (response.getIsSuccessful()){
            File file = new File("C:\\Data\\outputs\\javaOutput12.pdf");
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
	void FilePathMergeOptionsDocumentJavaScript_PdfOutput() {
		
        Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");

        PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\JavaScriptSample.pdf");
        PdfInput input = new PdfInput(resource);
        
        MergeOptions mergeOptions = new MergeOptions();
        mergeOptions.setDocumentJavaScript(false);
        input.setMergeOptions(mergeOptions);
        
        pdf.getInputs().add(input);

        PdfResponse response = pdf.process();
        
        if (response.getIsSuccessful()){
            File file = new File("C:\\Data\\outputs\\javaOutput13.pdf");
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
	void FilePathMergeOptionsDocumentProperties_PdfOutput() {
		
        Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");

        PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentPropertiesSample.pdf");
        PdfInput input = new PdfInput(resource);
        
        MergeOptions mergeOptions = new MergeOptions();
        mergeOptions.setDocumentProperties(true);
        input.setMergeOptions(mergeOptions);
        
        pdf.getInputs().add(input);

        PdfResponse response = pdf.process();
        
        if (response.getIsSuccessful()){
            File file = new File("C:\\Data\\outputs\\javaOutput14.pdf");
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
	void FilePathMergeOptionsEmbeddedFiles_PdfOutput() {
		
        Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");

        PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\EmbedFilesSample.pdf");
        PdfInput input = new PdfInput(resource);
        
        MergeOptions mergeOptions = new MergeOptions();
        mergeOptions.setEmbeddedFiles(false);
        input.setMergeOptions(mergeOptions);
        
        pdf.getInputs().add(input);

        PdfResponse response = pdf.process();
        
        if (response.getIsSuccessful()){
            File file = new File("C:\\Data\\outputs\\javaOutput15.pdf");
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
	void FilePathMergeOptionsFormFields_PdfOutput() {
		
        Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");

        PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\fw9AcroForm_14.pdf");
        PdfInput input = new PdfInput(resource);
        
        MergeOptions mergeOptions = new MergeOptions();
        mergeOptions.setFormFields(false);
        input.setMergeOptions(mergeOptions);
        
        pdf.getInputs().add(input);

        PdfResponse response = pdf.process();
        
        if (response.getIsSuccessful()){
            File file = new File("C:\\Data\\outputs\\javaOutput16.pdf");
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
	void FilePathMergeOptionsFormsXfaData_PdfOutput() {
		
        Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");

        PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\All Fields Sample.pdf");
        PdfInput input = new PdfInput(resource);
        
        MergeOptions mergeOptions = new MergeOptions();
        mergeOptions.setFormsXfaData(false);
        input.setMergeOptions(mergeOptions);
        
        pdf.getInputs().add(input);

        PdfResponse response = pdf.process();
        
        if (response.getIsSuccessful()){
            File file = new File("C:\\Data\\outputs\\javaOutput17.pdf");
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
	void FilePathMergeOptionsLogicalStructure_PdfOutput() {
		
        Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");

        PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\fw9AcroForm_14.pdf");
        PdfInput input = new PdfInput(resource);
        
        MergeOptions mergeOptions = new MergeOptions();
        mergeOptions.setLogicalStructure(false);
        input.setMergeOptions(mergeOptions);
        
        pdf.getInputs().add(input);

        PdfResponse response = pdf.process();
        
        if (response.getIsSuccessful()){
            File file = new File("C:\\Data\\outputs\\javaOutput18.pdf");
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
	void FilePathMergeOptionsOpenAction_PdfOutput() {
		
        Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");

        PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\OpenActionSample.pdf");
        PdfInput input = new PdfInput(resource);
        
        MergeOptions mergeOptions = new MergeOptions();
        mergeOptions.setOpenAction(true);
        input.setMergeOptions(mergeOptions);
        
        pdf.getInputs().add(input);

        PdfResponse response = pdf.process();
        
        if (response.getIsSuccessful()){
            File file = new File("C:\\Data\\outputs\\javaOutput19.pdf");
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
	void FilePathMergeOptionsOptionalContentInfo_PdfOutput() {
		
        Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");

        PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\OptionalContentInfoSample.pdf");
        PdfInput input = new PdfInput(resource);
        
        MergeOptions mergeOptions = new MergeOptions();
        mergeOptions.setOptionalContentInfo(false);
        input.setMergeOptions(mergeOptions);
        
        pdf.getInputs().add(input);

        PdfResponse response = pdf.process();
        
        if (response.getIsSuccessful()){
            File file = new File("C:\\Data\\outputs\\javaOutput20.pdf");
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
	void FilePathMergeOptionsOutlines_PdfOutput() {
		
        Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");

        PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\AllPageElements.pdf");
        PdfInput input = new PdfInput(resource);
        
        MergeOptions mergeOptions = new MergeOptions();
        mergeOptions.setOutlines(true);
        input.setMergeOptions(mergeOptions);
        
        pdf.getInputs().add(input);

        PdfResponse response = pdf.process();
        
        if (response.getIsSuccessful()){
            File file = new File("C:\\Data\\outputs\\javaOutput21.pdf");
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
	void FilePathMergeOptionsOutputIntent_PdfOutput() {
		
        Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");

        PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\OutputIntentSample.pdf");
        PdfInput input = new PdfInput(resource);
        
        MergeOptions mergeOptions = new MergeOptions();
        mergeOptions.setOutputIntent(false);
        input.setMergeOptions(mergeOptions);
        
        pdf.getInputs().add(input);

        PdfResponse response = pdf.process();
        
        if (response.getIsSuccessful()){
            File file = new File("C:\\Data\\outputs\\javaOutput22.pdf");
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
	void FilePathMergeOptionsPageAnnotations_PdfOutput() {
		
        Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");

        PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\NoteAnnotSample.pdf");
        PdfInput input = new PdfInput(resource);
        
        MergeOptions mergeOptions = new MergeOptions();
        mergeOptions.setPageAnnotations(true);
        input.setMergeOptions(mergeOptions);
        
        pdf.getInputs().add(input);

        PdfResponse response = pdf.process();
        
        if (response.getIsSuccessful()){
            File file = new File("C:\\Data\\outputs\\javaOutput23.pdf");
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
	void FilePathMergeOptionsPageLabelsAndSections_PdfOutput() {
		
        Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");

        PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\PageSectionSample.pdf");
        PdfInput input = new PdfInput(resource);
        
        MergeOptions mergeOptions = new MergeOptions();
        mergeOptions.setPageLabelsAndSections(false);
        input.setMergeOptions(mergeOptions);
        
        pdf.getInputs().add(input);

        PdfResponse response = pdf.process();
        
        if (response.getIsSuccessful()){
            File file = new File("C:\\Data\\outputs\\javaOutput24.pdf");
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
	void FilePathMergeOptionsRootFormField_PdfOutput() {
		
        Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");

        PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\fw9AcroForm_14.pdf");
        PdfInput input = new PdfInput(resource);
        
        MergeOptions mergeOptions = new MergeOptions();
        mergeOptions.setRootFormField("RootName");
        input.setMergeOptions(mergeOptions);
        
        pdf.getInputs().add(input);

        PdfResponse response = pdf.process();
        
        if (response.getIsSuccessful()){
            File file = new File("C:\\Data\\outputs\\javaOutput25.pdf");
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
	void FilePathMergeOptionsXmpMetadata_PdfOutput() {
		
        Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");

        PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\XmpAndOtherSample.pdf");
        PdfInput input = new PdfInput(resource);
        
        MergeOptions mergeOptions = new MergeOptions();
        mergeOptions.setXmpMetadata(false);
        input.setMergeOptions(mergeOptions);
        
        pdf.getInputs().add(input);

        PdfResponse response = pdf.process();
        
        if (response.getIsSuccessful()){
            File file = new File("C:\\Data\\outputs\\javaOutput26.pdf");
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
	void FilePathMergeOptionsAllTrue_PdfOutput() {
		
        Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");

        PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\AllPageElements.pdf");
        PdfInput input = new PdfInput(resource);
        
        MergeOptions mergeOptions = new MergeOptions();
        mergeOptions.setDocumentInfo(true);
        mergeOptions.setDocumentJavaScript(true);
        mergeOptions.setDocumentProperties(true);
        mergeOptions.setEmbeddedFiles(true);
        mergeOptions.setFormFields(true);
        mergeOptions.setFormsXfaData(true);
        mergeOptions.setLogicalStructure(true);
        mergeOptions.setOpenAction(true);
        mergeOptions.setOptionalContentInfo(true);
        mergeOptions.setOutlines(true);
        mergeOptions.setOutputIntent(true);
        mergeOptions.setPageAnnotations(true);
        mergeOptions.setPageLabelsAndSections(true);
        mergeOptions.setXmpMetadata(true);
        input.setMergeOptions(mergeOptions);
        
        pdf.getInputs().add(input);

        PdfResponse response = pdf.process();
        
        if (response.getIsSuccessful()){
            File file = new File("C:\\Data\\outputs\\javaOutput27.pdf");
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
	void FilePathMergeOptionsAllFalse_PdfOutput() {
		
        Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");

        PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\AllPageElements.pdf");
        PdfInput input = new PdfInput(resource);
        
        MergeOptions mergeOptions = new MergeOptions();
        mergeOptions.setDocumentInfo(false);
        mergeOptions.setDocumentJavaScript(false);
        mergeOptions.setDocumentProperties(false);
        mergeOptions.setEmbeddedFiles(false);
        mergeOptions.setFormFields(false);
        mergeOptions.setFormsXfaData(false);
        mergeOptions.setLogicalStructure(false);
        mergeOptions.setOpenAction(false);
        mergeOptions.setOptionalContentInfo(false);
        mergeOptions.setOutlines(false);
        mergeOptions.setOutputIntent(false);
        mergeOptions.setPageAnnotations(false);
        mergeOptions.setPageLabelsAndSections(false);
        mergeOptions.setXmpMetadata(false);
        input.setMergeOptions(mergeOptions);
        
        pdf.getInputs().add(input);

        PdfResponse response = pdf.process();
        
        if (response.getIsSuccessful()){
            File file = new File("C:\\Data\\outputs\\javaOutput28.pdf");
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
	void FilePathMergeOptionsWithTemplateAllPages_PdfOutput() {
		
        Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");
        
        Template template = new Template("Temp1");
        TextElement element = new TextElement("Merger with Template(All Pages)", ElementPlacement.TOPCENTER);           
        template.getElements().add(element);

        PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\AllPageElements.pdf");
        PdfInput input = new PdfInput(resource);
        
        MergeOptions mergeOptions = new MergeOptions();
        input.setMergeOptions(mergeOptions);
        input.setTemplate(template);
        pdf.getInputs().add(input);
        
        PdfResource resource1 = new PdfResource("src\\test\\resources\\PdfEndpoint\\All Fields Sample.pdf");
        PdfInput input1 = new PdfInput(resource1);
        input1.setTemplate(template);
        input1.setStartPage(1);
        input1.setPageCount(1);
        MergeOptions mergeOptions1 = new MergeOptions();
        mergeOptions1.setFormsXfaData(true);
        input1.setMergeOptions(mergeOptions1);
        pdf.getInputs().add(input1);

        PdfResource resource2 = new PdfResource("src\\test\\resources\\PdfEndpoint\\fw9AcroForm_14.pdf");
        PdfInput input2 = new PdfInput(resource2);
        input2.setTemplate(template);
        pdf.getInputs().add(input2);

        PdfResponse response = pdf.process();
        
        if (response.getIsSuccessful()){
            File file = new File("C:\\Data\\outputs\\javaOutput29.pdf");
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
	void FilePathMergeOptionsWithTemplateEvenPages_PdfOutput() {
		
        Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");
        
        Template template = new Template("Temp1");
        TextElement element = new TextElement("Merger with Template(even Pages)", ElementPlacement.TOPCENTER);           
        element.setEvenPages(true);
        template.getElements().add(element);

        PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\AllPageElements.pdf");
        PdfInput input = new PdfInput(resource);
        
        MergeOptions mergeOptions = new MergeOptions();
        input.setMergeOptions(mergeOptions);
        input.setTemplate(template);
        pdf.getInputs().add(input);
        
        PdfResource resource1 = new PdfResource("src\\test\\resources\\PdfEndpoint\\All Fields Sample.pdf");
        PdfInput input1 = new PdfInput(resource1);
        input1.setTemplate(template);
        input1.setStartPage(1);
        input1.setPageCount(1);
        MergeOptions mergeOptions1 = new MergeOptions();
        mergeOptions1.setFormsXfaData(true);
        input1.setMergeOptions(mergeOptions1);
        pdf.getInputs().add(input1);

        PdfResource resource2 = new PdfResource("src\\test\\resources\\PdfEndpoint\\fw9AcroForm_14.pdf");
        PdfInput input2 = new PdfInput(resource2);
        input2.setTemplate(template);
        pdf.getInputs().add(input2);

        PdfResponse response = pdf.process();
        
        if (response.getIsSuccessful()){
            File file = new File("C:\\Data\\outputs\\javaOutput30.pdf");
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
	void FilePathMergeOptionsWithTemplateOddPages_PdfOutput() {
		
        Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");
        
        Template template = new Template("Temp1");
        TextElement element = new TextElement("Merger with Template(odd Pages)", ElementPlacement.TOPCENTER);           
        element.setOddPages(true);
        template.getElements().add(element);

        PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\AllPageElements.pdf");
        PdfInput input = new PdfInput(resource);
        
        MergeOptions mergeOptions = new MergeOptions();
        input.setMergeOptions(mergeOptions);
        input.setTemplate(template);
        pdf.getInputs().add(input);
        
        PdfResource resource1 = new PdfResource("src\\test\\resources\\PdfEndpoint\\All Fields Sample.pdf");
        PdfInput input1 = new PdfInput(resource1);
        input1.setTemplate(template);
        input1.setStartPage(1);
        input1.setPageCount(1);
        MergeOptions mergeOptions1 = new MergeOptions();
        mergeOptions1.setFormsXfaData(true);
        input1.setMergeOptions(mergeOptions1);
        pdf.getInputs().add(input1);

        PdfResource resource2 = new PdfResource("src\\test\\resources\\PdfEndpoint\\fw9AcroForm_14.pdf");
        PdfInput input2 = new PdfInput(resource2);
        input2.setTemplate(template);
        pdf.getInputs().add(input2);

        PdfResponse response = pdf.process();
        
        if (response.getIsSuccessful()){
            File file = new File("C:\\Data\\outputs\\javaOutput31.pdf");
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
	void FilePath_AddPdf_PdfOutput() {
		
        Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");

        PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\Emptypages.pdf");
        PdfInput input = pdf.addPdf(resource);
        pdf.getInputs().add(input);

        PdfResponse response = pdf.process();
        
        if (response.getIsSuccessful()){
            File file = new File("C:\\Data\\outputs\\javaOutput32.pdf");
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
	void FilePath_AddPdfParameters_PdfOutput() {
		
        Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");

        MergeOptions mergeOptions = new MergeOptions();
        
        PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\Emptypages.pdf");
        PdfInput input = pdf.addPdf(resource, mergeOptions);
        pdf.getInputs().add(input);

        PdfResponse response = pdf.process();
        
        if (response.getIsSuccessful()){
            File file = new File("C:\\Data\\outputs\\javaOutput33.pdf");
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
	void Cloud_AddPdf_PdfOutput() {
		
        Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");

        PdfInput input = pdf.addPdf("DocumentA100.pdf");
        pdf.getInputs().add(input);

        PdfResponse response = pdf.process();
        
        if (response.getIsSuccessful()){
            File file = new File("C:\\Data\\outputs\\javaOutput34.pdf");
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
	void Cloud_AddPdfParameters_PdfOutput() {
		
        Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");

       
        PdfInput input = pdf.addPdf("DocumentA100.pdf", new MergeOptions());
        pdf.getInputs().add(input);

        PdfResponse response = pdf.process();
        
        if (response.getIsSuccessful()){
            File file = new File("C:\\Data\\outputs\\javaOutput35.pdf");
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
}
