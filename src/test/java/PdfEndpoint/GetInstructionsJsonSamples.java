package PdfEndpoint;

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
import com.dynamicpdf.api.Template;
import com.dynamicpdf.api.elements.ElementPlacement;
import com.dynamicpdf.api.elements.TextElement;

public class GetInstructionsJsonSamples {

	@BeforeClass
	public void setup() {
		ResourceBundle bundle =  ResourceBundle.getBundle("config");
		Pdf.setDefaultApiKey(bundle.getString("ApiKey"));
		Pdf.setDefaultBaseUrl(bundle.getString("BaseUrl"));
	}

	@Test
	public void FilePathGetInstructionsBeforeProcess_PdfOutput()
    {
        Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");

        Template template1 = new Template("Temp1");
        TextElement element1 = new TextElement("Merger with Template(First Dcoument)", ElementPlacement.TOPCENTER);
        template1.getElements().add(element1);

        PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\AllPageElements.pdf");
        PdfInput input = new PdfInput(resource);
        input.setTemplate(template1);

        MergeOptions mergeOptions = new MergeOptions();
        input.setMergeOptions(mergeOptions);
        pdf.getInputs().add(input);

        Template template2 = new Template("Temp2");
        TextElement element2 = new TextElement("Merger with Template(Second Dcoument)", ElementPlacement.TOPCENTER);
        template2.getElements().add(element2);

        PdfResource resource1 = new PdfResource("src\\test\\resources\\PdfEndpoint\\All Fields Sample.pdf");
        PdfInput input1 = new PdfInput(resource1);
        input1.setTemplate(template2);

        input1.setStartPage(1);
        input1.setPageCount(1);
        MergeOptions mergeOptions1 = new MergeOptions();
        mergeOptions1.setFormsXfaData(true);
        input1.setMergeOptions(mergeOptions1);
        pdf.getInputs().add(input1);

        Template template3 = new Template("Temp3");
        TextElement element3 = new TextElement("Merger with Template(Third Dcoument)", ElementPlacement.TOPCENTER);
        template3.getElements().add(element3);

        PdfResource resource2 = new PdfResource("src\\test\\resources\\PdfEndpoint\\fw9AcroForm_14.pdf");
        PdfInput input2 = new PdfInput(resource2);
        input2.setTemplate(template3);

        pdf.getInputs().add(input2);
        
        String str = pdf.getInstructionsJson();
        
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
	public void FilePathGetInstructionsAfterProcess_PdfOutput()
    {
        Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");

        Template template1 = new Template("Temp1");
        TextElement element1 = new TextElement("Merger with Template(First Dcoument)", ElementPlacement.TOPCENTER);
        template1.getElements().add(element1);

        PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\AllPageElements.pdf");
        PdfInput input = new PdfInput(resource);
        input.setTemplate(template1);

        MergeOptions mergeOptions = new MergeOptions();
        input.setMergeOptions(mergeOptions);
        pdf.getInputs().add(input);

        Template template2 = new Template("Temp2");
        TextElement element2 = new TextElement("Merger with Template(Second Dcoument)", ElementPlacement.TOPCENTER);
        template2.getElements().add(element2);

        PdfResource resource1 = new PdfResource("src\\test\\resources\\PdfEndpoint\\All Fields Sample.pdf");
        PdfInput input1 = new PdfInput(resource1);
        input1.setTemplate(template2);

        input1.setStartPage(1);
        input1.setPageCount(1);
        MergeOptions mergeOptions1 = new MergeOptions();
        mergeOptions1.setFormsXfaData(true);
        input1.setMergeOptions(mergeOptions1);
        pdf.getInputs().add(input1);

        Template template3 = new Template("Temp3");
        TextElement element3 = new TextElement("Merger with Template(Third Dcoument)", ElementPlacement.TOPCENTER);
        template3.getElements().add(element3);

        PdfResource resource2 = new PdfResource("src\\test\\resources\\PdfEndpoint\\fw9AcroForm_14.pdf");
        PdfInput input2 = new PdfInput(resource2);
        input2.setTemplate(template3);

        pdf.getInputs().add(input2); 
        
        PdfResponse response = pdf.process();
        
        String str = pdf.getInstructionsJson();
        
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
}
