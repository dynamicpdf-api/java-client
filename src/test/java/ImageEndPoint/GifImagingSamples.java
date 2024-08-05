package ImageEndPoint;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ResourceBundle;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dynamicpdf.api.*;
import com.dynamicpdf.api.imaging.GifImageFormat;
import com.dynamicpdf.api.imaging.DitheringAlgorithm;
import com.dynamicpdf.api.imaging.DpiImageSize;
import com.dynamicpdf.api.imaging.FixedImageSize;
import com.dynamicpdf.api.imaging.ImageSizeUnit;
import com.dynamicpdf.api.imaging.MaxImageSize;
import com.dynamicpdf.api.imaging.PdfImage;
import com.dynamicpdf.api.imaging.PdfImageResponse;
import com.dynamicpdf.api.imaging.PercentageImageSize;

import java.util.Base64;

public class GifImagingSamples {

	@BeforeClass
	public void setup() {
		ResourceBundle bundle =  ResourceBundle.getBundle("config");
		Pdf.setDefaultApiKey(bundle.getString("ApiKey"));
		Pdf.setDefaultBaseUrl(bundle.getString("BaseUrl"));
	}
	
	@Test
	public void TestGifImageFormat()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));

		GifImageFormat gifImageFormat = new GifImageFormat();
		pdfImage.setImageFormat(gifImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\GifImageFormat_" + i + "." + response.getImageFormat());
                try {
                    OutputStream os = new FileOutputStream(file);
                    os.write(Base64.getDecoder().decode(response.getImages().get(i).getData()));
                    os.close();
                } catch (Exception e) {
                    System.out.println("Exception: " + e);
                }
		    }
		}
		assertEquals(response.getIsSuccessful(), true);
	}
	@Test
	public void TestGifImageFormat_PageCount()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));
		pdfImage.setPageCount(2);
		GifImageFormat gifImageFormat = new GifImageFormat();
		pdfImage.setImageFormat(gifImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\GifImageFormat_" + i + "." + response.getImageFormat());
                try {
                    OutputStream os = new FileOutputStream(file);
                    os.write(Base64.getDecoder().decode(response.getImages().get(i).getData()));
                    os.close();
                } catch (Exception e) {
                    System.out.println("Exception: " + e);
                }
		    }
		}
		assertEquals(response.getIsSuccessful(), true);
	}
	@Test
	public void TestGifImageFormat_FixedSize_InPoint()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));
		
		FixedImageSize fixedImageSize = new FixedImageSize();
		fixedImageSize.setUnit(ImageSizeUnit.POINT);
		fixedImageSize.setWidth(500);
		fixedImageSize.setHeight(500);
		pdfImage.setImageSize(fixedImageSize);

		GifImageFormat gifImageFormat = new GifImageFormat();
		pdfImage.setImageFormat(gifImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\GifImageFormat_Fixed_Point_Size_" + i + "." + response.getImageFormat());
                try {
                    OutputStream os = new FileOutputStream(file);
                    os.write(Base64.getDecoder().decode(response.getImages().get(i).getData()));
                    os.close();
                } catch (Exception e) {
                    System.out.println("Exception: " + e);
                }
		    }
		}
		assertEquals(response.getIsSuccessful(), true);
	}
	@Test
	public void TestGifImageFormat_FixedSize_InInch()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));
		
		FixedImageSize fixedImageSize = new FixedImageSize();
		fixedImageSize.setUnit(ImageSizeUnit.INCH);
		fixedImageSize.setWidth(5);
		fixedImageSize.setHeight(5);
		pdfImage.setImageSize(fixedImageSize);

		GifImageFormat gifImageFormat = new GifImageFormat();
		pdfImage.setImageFormat(gifImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\GifImageFormat_Fixed_Inch_Size_" + i + "." + response.getImageFormat());
                try {
                    OutputStream os = new FileOutputStream(file);
                    os.write(Base64.getDecoder().decode(response.getImages().get(i).getData()));
                    os.close();
                } catch (Exception e) {
                    System.out.println("Exception: " + e);
                }
		    }
		}
		assertEquals(response.getIsSuccessful(), true);
	}
	@Test
	public void TestGifImageFormat_FixedSize_InMillimeter()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));

		FixedImageSize fixedImageSize = new FixedImageSize();
		fixedImageSize.setUnit(ImageSizeUnit.MILLIMETER);
		fixedImageSize.setWidth(700);
		fixedImageSize.setHeight(700);
		pdfImage.setImageSize(fixedImageSize);
		
		GifImageFormat gifImageFormat = new GifImageFormat();
		pdfImage.setImageFormat(gifImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\GifImageFormat_Fixed_MilliMeter_Size_" + i + "." + response.getImageFormat());
                try {
                    OutputStream os = new FileOutputStream(file);
                    os.write(Base64.getDecoder().decode(response.getImages().get(i).getData()));
                    os.close();
                } catch (Exception e) {
                    System.out.println("Exception: " + e);
                }
		    }
		}
		assertEquals(response.getIsSuccessful(), true);
	}
	@Test
	public void TestGifImageFormat_MaxSize_InPoint()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));
		
		MaxImageSize maxImageSize = new MaxImageSize();
		maxImageSize.setUnit(ImageSizeUnit.POINT);
		maxImageSize.setMaxWidth(500);
		maxImageSize.setMaxHeight(500);
		pdfImage.setImageSize(maxImageSize);

		GifImageFormat gifImageFormat = new GifImageFormat();
		pdfImage.setImageFormat(gifImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\GifImageFormat_Max_Point_Size_" + i + "." + response.getImageFormat());
                try {
                    OutputStream os = new FileOutputStream(file);
                    os.write(Base64.getDecoder().decode(response.getImages().get(i).getData()));
                    os.close();
                } catch (Exception e) {
                    System.out.println("Exception: " + e);
                }
		    }
		}
		assertEquals(response.getIsSuccessful(), true);
	}
	@Test
	public void TestGifImageFormat_MaxSize_InInch()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));
		
		MaxImageSize maxImageSize = new MaxImageSize();
		maxImageSize.setUnit(ImageSizeUnit.INCH);
		maxImageSize.setMaxWidth(7);
		maxImageSize.setMaxHeight(7);
		pdfImage.setImageSize(maxImageSize);
		
		GifImageFormat gifImageFormat = new GifImageFormat();
		pdfImage.setImageFormat(gifImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\GifImageFormat_Max_Inch_Size_" + i + "." + response.getImageFormat());
                try {
                    OutputStream os = new FileOutputStream(file);
                    os.write(Base64.getDecoder().decode(response.getImages().get(i).getData()));
                    os.close();
                } catch (Exception e) {
                    System.out.println("Exception: " + e);
                }
		    }
		}
		assertEquals(response.getIsSuccessful(), true);
	}
	@Test
	public void TestGifImageFormat_MaxSize_InMillimeter()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));

		MaxImageSize maxImageSize = new MaxImageSize();
		maxImageSize.setUnit(ImageSizeUnit.MILLIMETER);
		maxImageSize.setMaxWidth(400);
		maxImageSize.setMaxHeight(400);
		pdfImage.setImageSize(maxImageSize);
		
		GifImageFormat gifImageFormat = new GifImageFormat();
		pdfImage.setImageFormat(gifImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\GifImageFormat_Max_MilliMeter_Size_" + i + "." + response.getImageFormat());
                try {
                    OutputStream os = new FileOutputStream(file);
                    os.write(Base64.getDecoder().decode(response.getImages().get(i).getData()));
                    os.close();
                } catch (Exception e) {
                    System.out.println("Exception: " + e);
                }
		    }
		}
		assertEquals(response.getIsSuccessful(), true);
	}
	@Test
	public void TestGifImageFormat_Dpi_ImageSize()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));

		DpiImageSize dpiImageSize = new DpiImageSize();
		dpiImageSize.setHorizontalDpi(155);
		dpiImageSize.setVerticalDpi(155);
		pdfImage.setImageSize(dpiImageSize);
		
		GifImageFormat gifImageFormat = new GifImageFormat();
		pdfImage.setImageFormat(gifImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\GifImageFormat_Dpi_ImageSize_" + i + "." + response.getImageFormat());
                try {
                    OutputStream os = new FileOutputStream(file);
                    os.write(Base64.getDecoder().decode(response.getImages().get(i).getData()));
                    os.close();
                } catch (Exception e) {
                    System.out.println("Exception: " + e);
                }
		    }
		}
		assertEquals(response.getIsSuccessful(), true);
	}
	@Test
	public void TestGifImageFormat_Percentage_ImageSize()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));

		PercentageImageSize percentageImageSize = new PercentageImageSize();
		percentageImageSize.setVerticalPercentage(50);
		percentageImageSize.setHorizontalPercentage(50);
		pdfImage.setImageSize(percentageImageSize);
		
		GifImageFormat gifImageFormat = new GifImageFormat();
		pdfImage.setImageFormat(gifImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\GifImageFormat_Percentage_ImageSize_" + i + "." + response.getImageFormat());
                try {
                    OutputStream os = new FileOutputStream(file);
                    os.write(Base64.getDecoder().decode(response.getImages().get(i).getData()));
                    os.close();
                } catch (Exception e) {
                    System.out.println("Exception: " + e);
                }
		    }
		}
		assertEquals(response.getIsSuccessful(), true);
	}
	@Test
	public void TestGifImageFormat_FLOYDSTEINBERG()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));

		GifImageFormat gifImageFormat = new GifImageFormat();
		gifImageFormat.setDitheringAlgorithm(DitheringAlgorithm.FLOYDSTEINBERG);
		pdfImage.setImageFormat(gifImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\GifImageFormat_FLOYDSTEINBERG_" + i + "." + response.getImageFormat());
                try {
                    OutputStream os = new FileOutputStream(file);
                    os.write(Base64.getDecoder().decode(response.getImages().get(i).getData()));
                    os.close();
                } catch (Exception e) {
                    System.out.println("Exception: " + e);
                }
		    }
		}
		assertEquals(response.getIsSuccessful(), true);
	}
	@Test
	public void TestGifImageFormat_BAYER()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));

		GifImageFormat gifImageFormat = new GifImageFormat();
		gifImageFormat.setDitheringAlgorithm(DitheringAlgorithm.BAYER);
		pdfImage.setImageFormat(gifImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\GifImageFormat_BAYER_" + i + "." + response.getImageFormat());
                try {
                    OutputStream os = new FileOutputStream(file);
                    os.write(Base64.getDecoder().decode(response.getImages().get(i).getData()));
                    os.close();
                } catch (Exception e) {
                    System.out.println("Exception: " + e);
                }
		    }
		}
		assertEquals(response.getIsSuccessful(), true);
	}
}
