package PdfEndpoint;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ResourceBundle;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dynamicpdf.api.PageInput;
import com.dynamicpdf.api.PageOrientation;
import com.dynamicpdf.api.PageSize;
import com.dynamicpdf.api.Pdf;
import com.dynamicpdf.api.PdfResponse;
import com.dynamicpdf.api.Template;
import com.dynamicpdf.api.elements.ElementPlacement;
import com.dynamicpdf.api.elements.TextElement;

public class PageInputSamples {

	@BeforeClass
	public void setup()
	{
		ResourceBundle bundle =  ResourceBundle.getBundle("config");
		Pdf.setDefaultApiKey(bundle.getString("ApiKey"));
		Pdf.setDefaultBaseUrl(bundle.getString("BaseUrl"));
	}

	@Test
	public void PageInput_TextElement_Pdfoutput()
    { 
        Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");
        pdf.setSubject("topLevel document metadata");
        pdf.setCreator("John Creator");
        pdf.setProducer("ceTe Software");
        pdf.setKeywords("dynamicpdf api example pdf dotnet instructions");
        pdf.setTag(true);

        PageInput pageInput = new PageInput();
        TextElement element = new TextElement("Hello World", ElementPlacement.TOPCENTER);
        pageInput.getElements().add(element);

        pdf.getInputs().add(pageInput);
        PdfResponse response = pdf.process();
        
        if (response.getIsSuccessful()){
            File file = new File("src\\test\\outputs\\PageInputTextElement.pdf");
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
    public void PageInput_PageDimensions_PdfOutput() {
        Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");

        PageInput pageInput = pdf.addPage(PageSize.POSTCARD, PageOrientation.LANDSCAPE, 25f);
        TextElement element = new TextElement("Hello World", ElementPlacement.TOPCENTER);
        pageInput.getElements().add(element);

        PdfResponse response = pdf.process();

        if (response.getIsSuccessful()) {
            File file = new File("src\\test\\outputs\\PageDimensions_PdfOutput.pdf");
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
	public void PageInput_TextElementAddedToPageAndTemplate_Pdfoutput()
    { 
        Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");

        PageInput pageInput = new PageInput();
        TextElement element = new TextElement("Hello World", ElementPlacement.TOPLEFT);
        pageInput.getElements().add(element);

        Template template = new Template("Temp1");
        TextElement element1 = new TextElement("Hello World", ElementPlacement.TOPCENTER);
        template.getElements().add(element1);

        pageInput.setTemplate(template);
        
        pdf.getInputs().add(pageInput);
        PdfResponse response = pdf.process();
        
        if (response.getIsSuccessful()){
            File file = new File("src\\test\\outputs\\TextElementAddedToPageAndTemplate.pdf");
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
