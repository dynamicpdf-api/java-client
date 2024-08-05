package ImageEndPoint;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ResourceBundle;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dynamicpdf.api.*;
import com.dynamicpdf.api.elements.*;
import com.dynamicpdf.api.imaging.BmpColorFormat;
import com.dynamicpdf.api.imaging.BmpImageFormat;
import com.dynamicpdf.api.imaging.BmpMonochromeColorFormat;
import com.dynamicpdf.api.imaging.ColorFormatType;
import com.dynamicpdf.api.imaging.DitheringAlgorithm;
import com.dynamicpdf.api.imaging.DpiImageSize;
import com.dynamicpdf.api.imaging.FixedImageSize;
import com.dynamicpdf.api.imaging.ImageSizeUnit;
import com.dynamicpdf.api.imaging.MaxImageSize;
import com.dynamicpdf.api.imaging.PdfImage;
import com.dynamicpdf.api.imaging.PdfImageResponse;
import com.dynamicpdf.api.imaging.PercentageImageSize;

import java.util.Base64;

public class BmpImagingSamples {

	@BeforeClass
	public void setup() {
		ResourceBundle bundle =  ResourceBundle.getBundle("config");
		Pdf.setDefaultApiKey(bundle.getString("ApiKey"));
		Pdf.setDefaultBaseUrl(bundle.getString("BaseUrl"));
	}
	
	@Test
	public void TestBmpImageFormat()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));

		BmpImageFormat bmpImageFormat = new BmpImageFormat();
		pdfImage.setImageFormat(bmpImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\BmpImageFormat_" + i + "." + response.getImageFormat());
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
	public void TestBmpImageFormat_PageCount()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));
		pdfImage.setPageCount(2);
		BmpImageFormat bmpImageFormat = new BmpImageFormat();
		pdfImage.setImageFormat(bmpImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\BmpImageFormat_" + i + "." + response.getImageFormat());
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
	public void TestBmpImageFormat_FixedSize_InPoint()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));
		
		FixedImageSize fixedImageSize = new FixedImageSize();
		fixedImageSize.setUnit(ImageSizeUnit.POINT);
		fixedImageSize.setWidth(500);
		fixedImageSize.setHeight(500);
		pdfImage.setImageSize(fixedImageSize);

		BmpImageFormat bmpImageFormat = new BmpImageFormat();
		pdfImage.setImageFormat(bmpImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\BmpImageFormat_Fixed_Point_Size_" + i + "." + response.getImageFormat());
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
	public void TestBmpImageFormat_FixedSize_InInch()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));
		
		FixedImageSize fixedImageSize = new FixedImageSize();
		fixedImageSize.setUnit(ImageSizeUnit.INCH);
		fixedImageSize.setWidth(5);
		fixedImageSize.setHeight(5);
		pdfImage.setImageSize(fixedImageSize);

		BmpImageFormat bmpImageFormat = new BmpImageFormat();
		pdfImage.setImageFormat(bmpImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\BmpImageFormat_Fixed_Inch_Size_" + i + "." + response.getImageFormat());
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
	public void TestBmpImageFormat_FixedSize_InMillimeter()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));

		FixedImageSize fixedImageSize = new FixedImageSize();
		fixedImageSize.setUnit(ImageSizeUnit.MILLIMETER);
		fixedImageSize.setWidth(700);
		fixedImageSize.setHeight(700);
		pdfImage.setImageSize(fixedImageSize);
		
		BmpImageFormat bmpImageFormat = new BmpImageFormat();
		pdfImage.setImageFormat(bmpImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\BmpImageFormat_Fixed_MilliMeter_Size_" + i + "." + response.getImageFormat());
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
	public void TestBmpImageFormat_MaxSize_InPoint()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));
		
		MaxImageSize maxImageSize = new MaxImageSize();
		maxImageSize.setUnit(ImageSizeUnit.POINT);
		maxImageSize.setMaxWidth(500);
		maxImageSize.setMaxHeight(500);
		pdfImage.setImageSize(maxImageSize);

		BmpImageFormat bmpImageFormat = new BmpImageFormat();
		pdfImage.setImageFormat(bmpImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\BmpImageFormat_Max_Point_Size_" + i + "." + response.getImageFormat());
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
	public void TestBmpImageFormat_MaxSize_InInch()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));
		
		MaxImageSize maxImageSize = new MaxImageSize();
		maxImageSize.setUnit(ImageSizeUnit.INCH);
		maxImageSize.setMaxWidth(7);
		maxImageSize.setMaxHeight(7);
		pdfImage.setImageSize(maxImageSize);
		
		BmpImageFormat bmpImageFormat = new BmpImageFormat();
		pdfImage.setImageFormat(bmpImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\BmpImageFormat_Max_Inch_Size_" + i + "." + response.getImageFormat());
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
	public void TestBmpImageFormat_MaxSize_InMillimeter()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));

		MaxImageSize maxImageSize = new MaxImageSize();
		maxImageSize.setUnit(ImageSizeUnit.MILLIMETER);
		maxImageSize.setMaxWidth(400);
		maxImageSize.setMaxHeight(400);
		pdfImage.setImageSize(maxImageSize);
		
		BmpImageFormat bmpImageFormat = new BmpImageFormat();
		pdfImage.setImageFormat(bmpImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\BmpImageFormat_Max_MilliMeter_Size_" + i + "." + response.getImageFormat());
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
	public void TestBmpImageFormat_Dpi_ImageSize()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));

		DpiImageSize dpiImageSize = new DpiImageSize();
		dpiImageSize.setHorizontalDpi(155);
		dpiImageSize.setVerticalDpi(155);
		pdfImage.setImageSize(dpiImageSize);
		
		BmpImageFormat bmpImageFormat = new BmpImageFormat();
		pdfImage.setImageFormat(bmpImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\BmpImageFormat_Dpi_ImageSize_" + i + "." + response.getImageFormat());
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
	public void TestBmpImageFormat_Percentage_ImageSize()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));

		PercentageImageSize percentageImageSize = new PercentageImageSize();
		percentageImageSize.setVerticalPercentage(50);
		percentageImageSize.setHorizontalPercentage(50);
		pdfImage.setImageSize(percentageImageSize);
		
		BmpImageFormat bmpImageFormat = new BmpImageFormat();
		pdfImage.setImageFormat(bmpImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\BmpImageFormat_Percentage_ImageSize_" + i + "." + response.getImageFormat());
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
	public void TestBmpImageFormat_Floyd_MonoChrome()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));

		BmpImageFormat bmpImageFormat = new BmpImageFormat();
		
		BmpMonochromeColorFormat bmpMonochromeColorFormat = new BmpMonochromeColorFormat();
		bmpMonochromeColorFormat.setDitheringAlgorithm(DitheringAlgorithm.FLOYDSTEINBERG);
		bmpMonochromeColorFormat.setDitheringPercent(50);
		bmpImageFormat.setColorFormat(bmpMonochromeColorFormat);
		pdfImage.setImageFormat(bmpImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\BmpImageFormat_Floyd_MonoChrome_" + i + "." + response.getImageFormat());
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
	public void TestBmpImageFormat_Bayer_MonoChrome()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));

		BmpImageFormat bmpImageFormat = new BmpImageFormat();
		
		BmpMonochromeColorFormat bmpMonochromeColorFormat = new BmpMonochromeColorFormat();
		bmpMonochromeColorFormat.setDitheringAlgorithm(DitheringAlgorithm.BAYER);
		bmpMonochromeColorFormat.setDitheringPercent(50);

		bmpImageFormat.setColorFormat(bmpMonochromeColorFormat);
		
		pdfImage.setImageFormat(bmpImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\BmpImageFormat_Bayer_MonoChrome_" + i + "." + response.getImageFormat());
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
	public void TestBmpImageFormat_RgbColorFormat()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));

		BmpImageFormat bmpImageFormat = new BmpImageFormat();
		bmpImageFormat.setColorFormat(new BmpColorFormat(ColorFormatType.RGB));
		pdfImage.setImageFormat(bmpImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\BmpImageFormat_Rgb_ColorFormat_" + i + "." + response.getImageFormat());
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
	public void TestBmpImageFormat_RgbaColorFormat()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));

		BmpImageFormat bmpImageFormat = new BmpImageFormat();
		bmpImageFormat.setColorFormat(new BmpColorFormat(ColorFormatType.RGBA));
		pdfImage.setImageFormat(bmpImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\BmpImageFormat_Rgba_ColorFormat_" + i + "." + response.getImageFormat());
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
	public void TestBmpImageFormat_GrayscaleColorFormat()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));

		BmpImageFormat bmpImageFormat = new BmpImageFormat();
		bmpImageFormat.setColorFormat(new BmpColorFormat(ColorFormatType.GRAYSCALE));
		pdfImage.setImageFormat(bmpImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\BmpImageFormat_GrayScale_ColorFormat_" + i + "." + response.getImageFormat());
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
	public void TestBmpImageFormat_MonochromeColorFormat()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));

		BmpImageFormat bmpImageFormat = new BmpImageFormat();
		bmpImageFormat.setColorFormat(new BmpColorFormat(ColorFormatType.MONOCHROME));
		pdfImage.setImageFormat(bmpImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\BmpImageFormat_Monochrome_ColorFormat_" + i + "." + response.getImageFormat());
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
	public void TestBmpImageFormat_IndexedColorFormat()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));

		BmpImageFormat bmpImageFormat = new BmpImageFormat();
		bmpImageFormat.setColorFormat(new BmpColorFormat(ColorFormatType.INDEXED));
		pdfImage.setImageFormat(bmpImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\BmpImageFormat_Indexed_ColorFormat_" + i + "." + response.getImageFormat());
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
	public void TestBmpImageFormat_BlackThreshold()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));

		BmpMonochromeColorFormat bmpMonochromeColorFormat = new BmpMonochromeColorFormat();
		bmpMonochromeColorFormat.setBlackThreshold(200);
		
		BmpImageFormat bmpImageFormat = new BmpImageFormat();
		bmpImageFormat.setColorFormat(bmpMonochromeColorFormat);
		pdfImage.setImageFormat(bmpImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\BmpImageFormat_BlackThreshold_" + i + "." + response.getImageFormat());
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
