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

import com.dynamicpdf.api.Align;
import com.dynamicpdf.api.ImageInput;
import com.dynamicpdf.api.ImageResource;
import com.dynamicpdf.api.Pdf;
import com.dynamicpdf.api.PdfResponse;
import com.dynamicpdf.api.VAlign;

public class ImageInputSamples {

	@BeforeClass
	public void setup()
	{
		ResourceBundle bundle =  ResourceBundle.getBundle("config");
		Pdf.setDefaultApiKey(bundle.getString("ApiKey"));
		Pdf.setDefaultBaseUrl(bundle.getString("BaseUrl"));
	}
	
	@Test
	public void FilePathTiffImage_Pdfoutput()
    {
		Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");


        ImageResource resource = new ImageResource("src\\test\\resources\\PdfEndpoint\\CCITT_1.tif");
        ImageInput input = new ImageInput(resource);
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
	public void StreamTiffImage_Pdfoutput()
    {
		Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");

        File initialFile = new File("src\\test\\resources\\PdfEndpoint\\CCITT_1.tif");
        InputStream targetStream = null;
		try {
			targetStream = new FileInputStream(initialFile);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        ImageResource resource = new ImageResource(targetStream);
        ImageInput input = new ImageInput(resource);
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
	public void BytesTiffImage_Pdfoutput()
    {
		Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");

        byte[] array = null;
		try {
			array = Files.readAllBytes(Paths.get("src\\test\\resources\\PdfEndpoint\\CCITT_1.tif"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

        ImageResource resource = new ImageResource(array);
        ImageInput input = new ImageInput(resource);
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
	public void ImageInputUsingCloudRoot_TiffImageAddedToInput_Pdfoutput()
    {
		Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");
        
        ImageInput input = new ImageInput("170x220_T.png");
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
	public void FilePathTiffImageWithProperties_Pdfoutput()
    {
		Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");


        ImageResource resource = new ImageResource("src\\test\\resources\\PdfEndpoint\\CCITT_1.tif");
        ImageInput input = new ImageInput(resource);
        
        input.setRightMargin(50);
        input.setBottomMargin(50);
        input.setTopMargin(50);
        input.setLeftMargin(50);
        
        pdf.getInputs().add(input);
       
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
	public void FilePathMulitiTiffImage_Pdfoutput()
    {
		Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");


        ImageResource resource = new ImageResource("src\\test\\resources\\PdfEndpoint\\PalaisDuLouvre.tif");
        ImageInput input = new ImageInput(resource);
        
        pdf.getInputs().add(input);
       
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
	public void StreamMulitiTiffImage_Pdfoutput()
    {
		Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");

        File initialFile = new File("src\\test\\resources\\PdfEndpoint\\PalaisDuLouvre.tif");
        InputStream targetStream = null;
		try {
			targetStream = new FileInputStream(initialFile);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        ImageResource resource = new ImageResource(targetStream);
        ImageInput input = new ImageInput(resource);
        pdf.getInputs().add(input);
       
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
	public void BytesMulitiTiffImage_Pdfoutput()
    {
		Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");

        byte[] array = null;
		try {
			array = Files.readAllBytes(Paths.get("src\\test\\resources\\PdfEndpoint\\PalaisDuLouvre.tif"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

        ImageResource resource = new ImageResource(array);
        ImageInput input = new ImageInput(resource);
        pdf.getInputs().add(input);
       
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
	public void FilePathMulitiTiffImageWithProperties_Pdfoutput()
    {
		Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");


        ImageResource resource = new ImageResource("src\\test\\resources\\PdfEndpoint\\PalaisDuLouvre.tif");
        ImageInput input = new ImageInput(resource);
        
        input.setRightMargin(50);
        input.setBottomMargin(50);
        input.setTopMargin(50);
        input.setLeftMargin(50);
        
        pdf.getInputs().add(input);
       
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
	public void FilePathPngImage_Pdfoutput()
    {
		Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");


        ImageResource resource = new ImageResource("src\\test\\resources\\PdfEndpoint\\170x220_T.png");
        ImageInput input = new ImageInput(resource);
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
	public void StreamPngImage_Pdfoutput()
    {
		Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");

        File initialFile = new File("src\\test\\resources\\PdfEndpoint\\170x220_T.png");
        InputStream targetStream = null;
		try {
			targetStream = new FileInputStream(initialFile);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        ImageResource resource = new ImageResource(targetStream);
        ImageInput input = new ImageInput(resource);
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
	public void BytesPngImage_Pdfoutput()
    {
		Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");

        byte[] array = null;
		try {
			array = Files.readAllBytes(Paths.get("src\\test\\resources\\PdfEndpoint\\170x220_T.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

        ImageResource resource = new ImageResource(array);
        ImageInput input = new ImageInput(resource);
        pdf.getInputs().add(input);
       
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
	public void CloudRootPngImage_Pdfoutput()
    {
		Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");
        
        ImageInput input = new ImageInput("170x220_T.png");
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
	public void FilePathPngImageWithProperties_Pdfoutput()
    {
		Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");
        
        ImageResource resource = new ImageResource("src\\test\\resources\\PdfEndpoint\\170x220_T.png");
        ImageInput input = new ImageInput(resource);
        input.setScaleX(4);
        input.setScaleY(4);
        input.setPageWidth(400);
        input.setPageHeight(400);
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
	public void FilePathGifImage_Pdfouput()
    {
		Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");


        ImageResource resource = new ImageResource("src\\test\\resources\\PdfEndpoint\\Northwind Logo.gif");
        ImageInput input = new ImageInput(resource);
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
	public void StreamGifImage_Pdfouput()
    {
		Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");

        File initialFile = new File("src\\test\\resources\\PdfEndpoint\\Northwind Logo.gif");
        InputStream targetStream = null;
		try {
			targetStream = new FileInputStream(initialFile);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        ImageResource resource = new ImageResource(targetStream);
        ImageInput input = new ImageInput(resource);
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
	public void BytesGifImage_Pdfouput()
    {
		Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");

        byte[] array = null;
		try {
			array = Files.readAllBytes(Paths.get("src\\test\\resources\\PdfEndpoint\\Northwind Logo.gif"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

        ImageResource resource = new ImageResource(array);
        ImageInput input = new ImageInput(resource);
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
	public void CloudRootGifImage_Pdfouput()
    {
		Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");
        
        ImageInput input = new ImageInput("Northwind Logo.gif");
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
	public void FilePathGifImageWithProperties_Pdfouput()
    {
		Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");


        ImageResource resource = new ImageResource("src\\test\\resources\\PdfEndpoint\\Northwind Logo.gif");
        ImageInput input = new ImageInput(resource);
        
        input.setAlign(Align.LEFT);
        input.setVAlign(VAlign.CENTER);
        input.setPageWidth(400);
        input.setPageHeight(400);
        
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
	public void FilePathJpegImage_Pdfoutput()
    {
		Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");


        ImageResource resource = new ImageResource("src\\test\\resources\\PdfEndpoint\\Small.jpg");
        ImageInput input = new ImageInput(resource);
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
	public void StreamJpegImage_Pdfoutput()
    {
		Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");

        File initialFile = new File("src\\test\\resources\\PdfEndpoint\\Small.jpg");
        InputStream targetStream = null;
		try {
			targetStream = new FileInputStream(initialFile);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        ImageResource resource = new ImageResource(targetStream);
        ImageInput input = new ImageInput(resource);
        input.setShrinkToFit(false);
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
	public void BytesJpegImage_Pdfoutput()
    {
		Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");

        byte[] array = null;
		try {
			array = Files.readAllBytes(Paths.get("src\\test\\resources\\PdfEndpoint\\Small.jpg"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

        ImageResource resource = new ImageResource(array);
        ImageInput input = new ImageInput(resource);
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
	public void CloudRootJpegImage_Pdfoutput()
    {
		Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");
        
        ImageInput input = new ImageInput("Small.jpg");
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
	public void FilePathJpegImageWithProperties_Pdfoutput()
    {
		Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");


        ImageResource resource = new ImageResource("src\\test\\resources\\PdfEndpoint\\Small.jpg");
        ImageInput input = new ImageInput(resource);
        
        input.setAlign(Align.LEFT);
        input.setVAlign(VAlign.CENTER);
        input.setPageWidth(400);
        input.setPageHeight(400);
        
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
	public void FilePathTiffImage_AddImage_Pdfoutput()
    {
		Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");


        ImageResource resource = new ImageResource("src\\test\\resources\\PdfEndpoint\\CCITT_1.tif");
        ImageInput input = pdf.addImage(resource);
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
	public void FilePathPngImage_AddImageCloudResource_Pdfoutput()
    {
		Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");


        ImageInput input = pdf.addImage("170x220_T.png");

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
}
