package PdfEndpoint;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ResourceBundle;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dynamicpdf.api.MergeOptions;
import com.dynamicpdf.api.Pdf;
import com.dynamicpdf.api.PdfInput;
import com.dynamicpdf.api.PdfResource;
import com.dynamicpdf.api.PdfResponse;

public class PdfInputSamples {

	@BeforeClass
	public void setup()
	{
		ResourceBundle bundle =  ResourceBundle.getBundle("config");
		Pdf.setDefaultApiKey(bundle.getString("ApiKey"));
		Pdf.setDefaultBaseUrl(bundle.getString("BaseUrl"));
	}
	
	@Test	
	void FilePathMergeOptions_PdfOutput() {
		
        Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");

        PdfResource resource = new PdfResource("src\\test\\resources\\AllPageElements.pdf");
        PdfInput input = new PdfInput(resource);
        
        MergeOptions mergeOptions = new MergeOptions();
        mergeOptions.setRootFormField("RootName");
        mergeOptions.setOutlines(false);
        input.setMergeOptions(mergeOptions);        
        pdf.getInputs().add(input);

        PdfResource fw9AcroForm_14Resource = new PdfResource("src\\test\\resources\\fw9AcroForm_14.pdf");
        PdfInput input1 = new PdfInput(fw9AcroForm_14Resource);

        MergeOptions mergeOptions1 = new MergeOptions();
        mergeOptions1.setLogicalStructure(false);
        mergeOptions1.setFormFields(false);
        input1.setMergeOptions(mergeOptions1);
        pdf.getInputs().add(input1);
        
        PdfResponse response = pdf.process();
        
        if (response.getIsSuccessful()){
            File file = new File("src\\test\\outputs\\PdfInputMergeOptions.pdf");
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
