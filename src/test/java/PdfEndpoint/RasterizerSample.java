package PdfEndpoint;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ResourceBundle;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dynamicpdf.api.Pdf;
import com.dynamicpdf.api.PdfResource;
import com.dynamicpdf.api.imaging.PdfImage;
import com.dynamicpdf.api.imaging.PdfImageResponse;
import com.dynamicpdf.api.imaging.PdfImageResponse.Image;
import com.dynamicpdf.api.imaging.TiffImageFormat;

import java.util.Base64;
import java.util.List;

public class RasterizerSample {

    @BeforeClass
    public void setup() {
        ResourceBundle bundle = ResourceBundle.getBundle("config");
        Pdf.setDefaultApiKey(bundle.getString("ApiKey"));
        Pdf.setDefaultBaseUrl(bundle.getString("BaseUrl"));
    }

    @Test
    void Rasterizer_Test() {

        Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");

        PdfResource resource = new PdfResource("src\\test\\resources\\DocumentA.pdf");
        PdfImage pdfImage = new PdfImage(resource);

        TiffImageFormat tiffImageFormat = new TiffImageFormat();
        tiffImageFormat.setMultiPage(false);

        pdfImage.setImageFormat(tiffImageFormat);
     
        PdfImageResponse response = pdfImage.process();

        if (response.getIsSuccessful()) {
            List<Image> images = response.getImages();
            for (int i = 0; i < images.size(); i++) {

                Image image = images.get(i);
                byte[] imageData = Base64.getDecoder().decode(image.getData());

                File file = new File("src\\test\\outputs\\Imaging" + i + "." + response.getImageFormat());
                try {
                    OutputStream os = new FileOutputStream(file);
                    os.write(imageData);
                    os.close();
                } catch (Exception e) {
                    System.out.println("Exception: " + e);
                }
            }
            assertEquals(response.getIsSuccessful(), true);
        }
    }
}
