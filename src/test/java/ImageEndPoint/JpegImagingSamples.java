package ImageEndPoint;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ResourceBundle;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dynamicpdf.api.*;
import com.dynamicpdf.api.imaging.JpegImageFormat;
import com.dynamicpdf.api.imaging.DpiImageSize;
import com.dynamicpdf.api.imaging.FixedImageSize;
import com.dynamicpdf.api.imaging.ImageSizeUnit;
import com.dynamicpdf.api.imaging.MaxImageSize;
import com.dynamicpdf.api.imaging.PdfImage;
import com.dynamicpdf.api.imaging.PdfImageResponse;
import com.dynamicpdf.api.imaging.PercentageImageSize;

import java.util.Base64;

public class JpegImagingSamples {

	@BeforeClass
	public void setup() {
		ResourceBundle bundle =  ResourceBundle.getBundle("config");
		Pdf.setDefaultApiKey(bundle.getString("ApiKey"));
		Pdf.setDefaultBaseUrl(bundle.getString("BaseUrl"));
	}
	
	@Test
	public void TestJpegImageFormat()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));

		JpegImageFormat jpegImageFormat = new JpegImageFormat();
		pdfImage.setImageFormat(jpegImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\JpegImageFormat_" + i + "." + response.getImageFormat());
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
	public void TestJpegImageFormat_PageCount()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));
		pdfImage.setPageCount(2);
		JpegImageFormat jpegImageFormat = new JpegImageFormat();
		pdfImage.setImageFormat(jpegImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\JpegImageFormat_" + i + "." + response.getImageFormat());
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
	public void TestJpegImageFormat_FixedSize_InPoint()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));
		
		FixedImageSize fixedImageSize = new FixedImageSize();
		fixedImageSize.setUnit(ImageSizeUnit.POINT);
		fixedImageSize.setWidth(500);
		fixedImageSize.setHeight(500);
		pdfImage.setImageSize(fixedImageSize);

		JpegImageFormat jpegImageFormat = new JpegImageFormat();
		pdfImage.setImageFormat(jpegImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\JpegImageFormat_Fixed_Point_Size_" + i + "." + response.getImageFormat());
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
	public void TestJpegImageFormat_FixedSize_InInch()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));
		
		FixedImageSize fixedImageSize = new FixedImageSize();
		fixedImageSize.setUnit(ImageSizeUnit.INCH);
		fixedImageSize.setWidth(5);
		fixedImageSize.setHeight(5);
		pdfImage.setImageSize(fixedImageSize);

		JpegImageFormat jpegImageFormat = new JpegImageFormat();
		pdfImage.setImageFormat(jpegImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\JpegImageFormat_Fixed_Inch_Size_" + i + "." + response.getImageFormat());
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
	public void TestJpegImageFormat_FixedSize_InMillimeter()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));

		FixedImageSize fixedImageSize = new FixedImageSize();
		fixedImageSize.setUnit(ImageSizeUnit.MILLIMETER);
		fixedImageSize.setWidth(700);
		fixedImageSize.setHeight(700);
		pdfImage.setImageSize(fixedImageSize);
		
		JpegImageFormat jpegImageFormat = new JpegImageFormat();
		pdfImage.setImageFormat(jpegImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\JpegImageFormat_Fixed_MilliMeter_Size_" + i + "." + response.getImageFormat());
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
	public void TestJpegImageFormat_MaxSize_InPoint()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));
		
		MaxImageSize maxImageSize = new MaxImageSize();
		maxImageSize.setUnit(ImageSizeUnit.POINT);
		maxImageSize.setMaxWidth(500);
		maxImageSize.setMaxHeight(500);
		pdfImage.setImageSize(maxImageSize);

		JpegImageFormat jpegImageFormat = new JpegImageFormat();
		pdfImage.setImageFormat(jpegImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\JpegImageFormat_Max_Point_Size_" + i + "." + response.getImageFormat());
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
	public void TestJpegImageFormat_MaxSize_InInch()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));
		
		MaxImageSize maxImageSize = new MaxImageSize();
		maxImageSize.setUnit(ImageSizeUnit.INCH);
		maxImageSize.setMaxWidth(7);
		maxImageSize.setMaxHeight(7);
		pdfImage.setImageSize(maxImageSize);
		
		JpegImageFormat jpegImageFormat = new JpegImageFormat();
		pdfImage.setImageFormat(jpegImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\JpegImageFormat_Max_Inch_Size_" + i + "." + response.getImageFormat());
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
	public void TestJpegImageFormat_MaxSize_InMillimeter()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));

		MaxImageSize maxImageSize = new MaxImageSize();
		maxImageSize.setUnit(ImageSizeUnit.MILLIMETER);
		maxImageSize.setMaxWidth(400);
		maxImageSize.setMaxHeight(400);
		pdfImage.setImageSize(maxImageSize);
		
		JpegImageFormat jpegImageFormat = new JpegImageFormat();
		pdfImage.setImageFormat(jpegImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\JpegImageFormat_Max_MilliMeter_Size_" + i + "." + response.getImageFormat());
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
	public void TestJpegImageFormat_Dpi_ImageSize()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));

		DpiImageSize dpiImageSize = new DpiImageSize();
		dpiImageSize.setHorizontalDpi(155);
		dpiImageSize.setVerticalDpi(155);
		pdfImage.setImageSize(dpiImageSize);
		
		JpegImageFormat jpegImageFormat = new JpegImageFormat();
		pdfImage.setImageFormat(jpegImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\JpegImageFormat_Dpi_ImageSize_" + i + "." + response.getImageFormat());
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
	public void TestJpegImageFormat_Percentage_ImageSize()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));

		PercentageImageSize percentageImageSize = new PercentageImageSize();
		percentageImageSize.setVerticalPercentage(50);
		percentageImageSize.setHorizontalPercentage(50);
		pdfImage.setImageSize(percentageImageSize);
		
		JpegImageFormat jpegImageFormat = new JpegImageFormat();
		pdfImage.setImageFormat(jpegImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\JpegImageFormat_Percentage_ImageSize_" + i + "." + response.getImageFormat());
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
	public void TestJpegImageFormat_Quality()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));

		JpegImageFormat jpegImageFormat = new JpegImageFormat();
		jpegImageFormat.setQuality(10);
		pdfImage.setImageFormat(jpegImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\JpegImageFormat_Quality_" + i + "." + response.getImageFormat());
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
