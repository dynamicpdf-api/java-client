package PdfEndpoint;

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

import com.dynamicpdf.api.DlexInput;
import com.dynamicpdf.api.ImageInput;
import com.dynamicpdf.api.ImageResource;
import com.dynamicpdf.api.MergeOptions;
import com.dynamicpdf.api.PageInput;
import com.dynamicpdf.api.Pdf;
import com.dynamicpdf.api.PdfInput;
import com.dynamicpdf.api.PdfResponse;
import com.dynamicpdf.api.elements.ElementPlacement;
import com.dynamicpdf.api.elements.ImageElement;
import com.dynamicpdf.api.elements.TextElement;

public class MultipleInputs {

	@BeforeClass
	public void setup() {
		ResourceBundle bundle = ResourceBundle.getBundle("config");
		Pdf.setDefaultApiKey(bundle.getString("ApiKey"));
		Pdf.setDefaultBaseUrl(bundle.getString("BaseUrl"));
	}

   	@Test
	public void Inputs_DifferentInputs_PdfOutput() {
        Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");

        PdfInput pdfInput = new PdfInput("TFWResources/DocumentA100.pdf");
        MergeOptions mergeOptions = new MergeOptions();
        pdfInput.setMergeOptions(mergeOptions);
        pdf.getInputs().add(pdfInput);

        PageInput pageInput = new PageInput();
        TextElement textElement = new TextElement("Hello World", ElementPlacement.TOPLEFT);
        textElement.setFontSize(40);
        pageInput.getElements().add(textElement);
        pdf.getInputs().add(pageInput);

        PageInput pageInput1 = new PageInput();
        ImageResource img = new ImageResource("src\\test\\resources\\DocumentA.jpeg", "DocumentA.jpeg");
        ImageElement element = new ImageElement(img, ElementPlacement.TOPCENTER);
        element.setXOffset(50);
        element.setYOffset(50);
        pageInput1.getElements().add(element);
        pdf.getInputs().add(pageInput1);

        String jsonString = null;

        try {
            jsonString = Files.readString(Paths.get("src\\test\\resources\\SimpleReportData.json"));
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        DlexInput dlexInput = new DlexInput("TFWResources/SimpleReportWithCoverPage.dlex", jsonString);
        pdf.getInputs().add(dlexInput);

        ImageInput imageInput = new ImageInput("TFWResources/Northwind Logo.gif");
        imageInput.setTopMargin(10);
        imageInput.setLeftMargin(10);
        imageInput.setRightMargin(10);
        imageInput.setBottomMargin(10);
        pdf.getInputs().add(imageInput);

        PdfResponse response = pdf.process();

        if (response.getIsSuccessful()) {
            File file = new File("src\\test\\outputs\\MultipleInputs_PdfOutput.pdf");
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
}
