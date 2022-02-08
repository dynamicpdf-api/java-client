package ImageInfo;

import java.io.File;
import java.io.FileWriter;
import java.util.ResourceBundle;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import com.dynamicpdf.api.ImageInfo;
import com.dynamicpdf.api.ImageResource;
import com.dynamicpdf.api.ImageResponse;


public class ImageInfoSamples {


	@BeforeClass
	public void setup()
	{
		ResourceBundle bundle =  ResourceBundle.getBundle("config");
		ImageInfo.setDefaultApiKey(bundle.getString("ApiKey"));
		ImageInfo.setDefaultBaseUrl(bundle.getString("BaseUrl"));
	}

	@Test
	public void ImageInfoSample(){



		ImageResource resource = new ImageResource("src\\test\\resources\\ImageInfo\\Northwind Logo.gif");

		ImageInfo image =  new ImageInfo(resource);
		ImageResponse response = image.process();

		if (response.getIsSuccessful()){
			File file = new File("C:\\Data\\outputs\\image.json");
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
	public void Tiff_JsonOutput()
	{


		ImageResource resource = new ImageResource("src\\test\\resources\\ImageInfo\\Output.tiff");

		ImageInfo pdfEndPoint = new ImageInfo(resource);
		ImageResponse response = pdfEndPoint.process();
		if (response.getIsSuccessful()){
			File file = new File("C:\\Data\\outputs\\image1.json");
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
	public void Group4Fax_JsonOutput()
	{


		ImageResource resource = new ImageResource("src\\test\\resources\\ImageInfo\\CCITT_1.tif");

		ImageInfo pdfEndPoint = new ImageInfo(resource);
		ImageResponse response = pdfEndPoint.process();
		if (response.getIsSuccessful()){
			File file = new File("C:\\Data\\outputs\\image2.json");
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
	public void Png_JsonOutput()
	{


		ImageResource resource = new ImageResource("src\\test\\resources\\ImageInfo\\170x220_T.png");

		ImageInfo pdfEndPoint = new ImageInfo(resource);
		ImageResponse response = pdfEndPoint.process();
		if (response.getIsSuccessful()){
			File file = new File("C:\\Data\\outputs\\image3.json");
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
	public void Bmp_JsonOutput()
	{


		ImageResource resource = new ImageResource("src\\test\\resources\\ImageInfo\\Earth2.bmp");

		ImageInfo pdfEndPoint = new ImageInfo(resource);
		ImageResponse response = pdfEndPoint.process();
		if (response.getIsSuccessful()){
			File file = new File("C:\\Data\\outputs\\image4.json");
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
	public void Jpg_JsonOutput()
	{


		ImageResource resource = new ImageResource("src\\test\\resources\\ImageInfo\\Image1.jpg");

		ImageInfo pdfEndPoint = new ImageInfo(resource);
		ImageResponse response = pdfEndPoint.process();
		if (response.getIsSuccessful()){
			File file = new File("C:\\Data\\outputs\\image5.json");
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
	public void MultipleFormats_JsonOutput()
	{



		String[] images = { "Output.tiff","Northwind Logo.gif", "CCITT_1.tif", "170x220_T.png", "Image1.jpg", "Earth2.bmp" };

		for (int i = 0; i < images.length; i++) {
			ImageResource resource = new ImageResource("src\\test\\resources\\ImageInfo\\" +images[i]);

			ImageInfo pdfEndPoint = new ImageInfo(resource);
			ImageResponse response = pdfEndPoint.process();
			if (response.getIsSuccessful()){
				File file = new File("C:\\Data\\outputs\\"+i+".json");
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

	@Test
	public void Group3Fax_JsonOutput()
	{


		ImageResource resource = new ImageResource("src\\test\\resources\\ImageInfo\\FaxTest.tif");

		ImageInfo pdfEndPoint = new ImageInfo(resource);
		ImageResponse response = pdfEndPoint.process();
		if (response.getIsSuccessful()){
			File file = new File("C:\\Data\\outputs\\image6.json");
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
	public void JpegTiff_JsonOutput()
	{


		ImageResource resource = new ImageResource("src\\test\\resources\\ImageInfo\\2 page Color.tif");

		ImageInfo pdfEndPoint = new ImageInfo(resource);
		ImageResponse response = pdfEndPoint.process();
		if (response.getIsSuccessful()){
			File file = new File("C:\\Data\\outputs\\image7.json");
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
	public void LzwTiff_JsonOutput()
	{


		ImageResource resource = new ImageResource("src\\test\\resources\\ImageInfo\\2.tif");

		ImageInfo pdfEndPoint = new ImageInfo(resource);
		ImageResponse response = pdfEndPoint.process();
		if (response.getIsSuccessful()){
			File file = new File("C:\\Data\\outputs\\image8.json");
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
	public void UnCompressedTiff_JsonOutput()
	{


		ImageResource resource = new ImageResource("src\\test\\resources\\ImageInfo\\16UnCompressedCMYKMM.tif");

		ImageInfo pdfEndPoint = new ImageInfo(resource);
		ImageResponse response = pdfEndPoint.process();
		if (response.getIsSuccessful()){
			File file = new File("C:\\Data\\outputs\\image9.json");
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
	public void Indexed_Bmp_JsonOutput()
	{


		ImageResource resource = new ImageResource("src\\test\\resources\\ImageInfo\\3_rescale_indexed.bmp");

		ImageInfo pdfEndPoint = new ImageInfo(resource);
		ImageResponse response = pdfEndPoint.process();
		if (response.getIsSuccessful()){
			File file = new File("C:\\Data\\outputs\\image10.json");
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
	public void _2Bpp_Png_JsonOutput()
	{


		ImageResource resource = new ImageResource("src\\test\\resources\\ImageInfo\\121_2bpp.png");

		ImageInfo pdfEndPoint = new ImageInfo(resource);
		ImageResponse response = pdfEndPoint.process();
		if (response.getIsSuccessful()){
			File file = new File("C:\\Data\\outputs\\image11.json");
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
	public void _4Bpp_Png_JsonOutput()
	{


		ImageResource resource = new ImageResource("src\\test\\resources\\ImageInfo\\4bpp.png");

		ImageInfo pdfEndPoint = new ImageInfo(resource);
		ImageResponse response = pdfEndPoint.process();
		if (response.getIsSuccessful()){
			File file = new File("C:\\Data\\outputs\\image12.json");
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
	public void Rgba_Png_JsonOutput()
	{


		ImageResource resource = new ImageResource("src\\test\\resources\\ImageInfo\\Animated_PNG_example_bouncing_beach_ball.png");

		ImageInfo pdfEndPoint = new ImageInfo(resource);
		ImageResponse response = pdfEndPoint.process();
		if (response.getIsSuccessful()){
			File file = new File("C:\\Data\\outputs\\image13.json");
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
	public void Interlaced_Png_JsonOutput()
	{


		ImageResource resource = new ImageResource("src\\test\\resources\\ImageInfo\\cat.png");

		ImageInfo pdfEndPoint = new ImageInfo(resource);
		ImageResponse response = pdfEndPoint.process();
		if (response.getIsSuccessful()){
			File file = new File("C:\\Data\\outputs\\image14.json");
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
	public void GrayScale_Png_JsonOutput()
	{


		ImageResource resource = new ImageResource("src\\test\\resources\\ImageInfo\\error.png");

		ImageInfo pdfEndPoint = new ImageInfo(resource);
		ImageResponse response = pdfEndPoint.process();
		if (response.getIsSuccessful()){
			File file = new File("C:\\Data\\outputs\\image15.json");
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
	public void GrayScaleAlpha_Png_JsonOutput()
	{


		ImageResource resource = new ImageResource("src\\test\\resources\\ImageInfo\\gray8a.png");

		ImageInfo pdfEndPoint = new ImageInfo(resource);
		ImageResponse response = pdfEndPoint.process();
		if (response.getIsSuccessful()){
			File file = new File("C:\\Data\\outputs\\image16.json");
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
	public void GrayScaleAlpha16Bit_Png_JsonOutput()
	{


		ImageResource resource = new ImageResource("src\\test\\resources\\ImageInfo\\gray16a.png");

		ImageInfo pdfEndPoint = new ImageInfo(resource);
		ImageResponse response = pdfEndPoint.process();
		if (response.getIsSuccessful()){
			File file = new File("C:\\Data\\outputs\\image17.json");
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
	public void Rgba16Bit_Png_JsonOutput()
	{


		ImageResource resource = new ImageResource("src\\test\\resources\\ImageInfo\\rgba16.png");

		ImageInfo pdfEndPoint = new ImageInfo(resource);
		ImageResponse response = pdfEndPoint.process();
		if (response.getIsSuccessful()){
			File file = new File("C:\\Data\\outputs\\image18.json");
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
	public void Indexed_Png_JsonOutput()
	{


		ImageResource resource = new ImageResource("src\\test\\resources\\ImageInfo\\png2.png");

		ImageInfo pdfEndPoint = new ImageInfo(resource);
		ImageResponse response = pdfEndPoint.process();
		if (response.getIsSuccessful()){
			File file = new File("C:\\Data\\outputs\\image19.json");
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
