package ImageEndPoint;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ResourceBundle;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dynamicpdf.api.*;
import com.dynamicpdf.api.imaging.PngColorFormat;
import com.dynamicpdf.api.imaging.PngImageFormat;
import com.dynamicpdf.api.imaging.PngIndexedColorFormat;
import com.dynamicpdf.api.imaging.PngMonochromeColorFormat;
import com.dynamicpdf.api.imaging.QuantizationAlgorithm;
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

public class PngImagingSamples {

	@BeforeClass
	public void setup() {
		ResourceBundle bundle =  ResourceBundle.getBundle("config");
		Pdf.setDefaultApiKey(bundle.getString("ApiKey"));
		Pdf.setDefaultBaseUrl(bundle.getString("BaseUrl"));
	}
	
	@Test
	public void TestPngImageFormat()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));

		PngImageFormat pngImageFormat = new PngImageFormat();
		pdfImage.setImageFormat(pngImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\PngImageFormat_" + i + "." + response.getImageFormat());
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
	public void TestPngImageFormat_PageCount()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));
		pdfImage.setPageCount(2);
		PngImageFormat pngImageFormat = new PngImageFormat();
		pdfImage.setImageFormat(pngImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\PngImageFormat_" + i + "." + response.getImageFormat());
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
	public void TestPngImageFormat_FixedSize_InPoint()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));
		
		FixedImageSize fixedImageSize = new FixedImageSize();
		fixedImageSize.setUnit(ImageSizeUnit.POINT);
		fixedImageSize.setWidth(500);
		fixedImageSize.setHeight(500);
		pdfImage.setImageSize(fixedImageSize);

		PngImageFormat pngImageFormat = new PngImageFormat();
		pdfImage.setImageFormat(pngImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\PngImageFormat_Fixed_Point_Size_" + i + "." + response.getImageFormat());
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
	public void TestPngImageFormat_FixedSize_InInch()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));
		
		FixedImageSize fixedImageSize = new FixedImageSize();
		fixedImageSize.setUnit(ImageSizeUnit.INCH);
		fixedImageSize.setWidth(5);
		fixedImageSize.setHeight(5);
		pdfImage.setImageSize(fixedImageSize);

		PngImageFormat pngImageFormat = new PngImageFormat();
		pdfImage.setImageFormat(pngImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\PngImageFormat_Fixed_Inch_Size_" + i + "." + response.getImageFormat());
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
	public void TestPngImageFormat_FixedSize_InMillimeter()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));

		FixedImageSize fixedImageSize = new FixedImageSize();
		fixedImageSize.setUnit(ImageSizeUnit.MILLIMETER);
		fixedImageSize.setWidth(700);
		fixedImageSize.setHeight(700);
		pdfImage.setImageSize(fixedImageSize);
		
		PngImageFormat pngImageFormat = new PngImageFormat();
		pdfImage.setImageFormat(pngImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\PngImageFormat_Fixed_MilliMeter_Size_" + i + "." + response.getImageFormat());
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
	public void TestPngImageFormat_MaxSize_InPoint()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));
		
		MaxImageSize maxImageSize = new MaxImageSize();
		maxImageSize.setUnit(ImageSizeUnit.POINT);
		maxImageSize.setMaxWidth(500);
		maxImageSize.setMaxHeight(500);
		pdfImage.setImageSize(maxImageSize);

		PngImageFormat pngImageFormat = new PngImageFormat();
		pdfImage.setImageFormat(pngImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\PngImageFormat_Max_Point_Size_" + i + "." + response.getImageFormat());
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
	public void TestPngImageFormat_MaxSize_InInch()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));
		
		MaxImageSize maxImageSize = new MaxImageSize();
		maxImageSize.setUnit(ImageSizeUnit.INCH);
		maxImageSize.setMaxWidth(7);
		maxImageSize.setMaxHeight(7);
		pdfImage.setImageSize(maxImageSize);
		
		PngImageFormat pngImageFormat = new PngImageFormat();
		pdfImage.setImageFormat(pngImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\PngImageFormat_Max_Inch_Size_" + i + "." + response.getImageFormat());
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
	public void TestPngImageFormat_MaxSize_InMillimeter()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));

		MaxImageSize maxImageSize = new MaxImageSize();
		maxImageSize.setUnit(ImageSizeUnit.MILLIMETER);
		maxImageSize.setMaxWidth(400);
		maxImageSize.setMaxHeight(400);
		pdfImage.setImageSize(maxImageSize);
		
		PngImageFormat pngImageFormat = new PngImageFormat();
		pdfImage.setImageFormat(pngImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\PngImageFormat_Max_MilliMeter_Size_" + i + "." + response.getImageFormat());
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
	public void TestPngImageFormat_Dpi_ImageSize()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));

		DpiImageSize dpiImageSize = new DpiImageSize();
		dpiImageSize.setHorizontalDpi(155);
		dpiImageSize.setVerticalDpi(155);
		pdfImage.setImageSize(dpiImageSize);
		
		PngImageFormat pngImageFormat = new PngImageFormat();
		pdfImage.setImageFormat(pngImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\PngImageFormat_Dpi_ImageSize_" + i + "." + response.getImageFormat());
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
	public void TestPngImageFormat_Percentage_ImageSize()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));

		PercentageImageSize percentageImageSize = new PercentageImageSize();
		percentageImageSize.setVerticalPercentage(50);
		percentageImageSize.setHorizontalPercentage(50);
		pdfImage.setImageSize(percentageImageSize);
		
		PngImageFormat pngImageFormat = new PngImageFormat();
		pdfImage.setImageFormat(pngImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\PngImageFormat_Percentage_ImageSize_" + i + "." + response.getImageFormat());
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
	public void TestPngImageFormat_Floyd_MonoChrome()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));

		PngImageFormat pngImageFormat = new PngImageFormat();
		
		PngMonochromeColorFormat pngMonochromeColorFormat = new PngMonochromeColorFormat();
		pngMonochromeColorFormat.setDitheringAlgorithm(DitheringAlgorithm.FLOYDSTEINBERG);
		pngMonochromeColorFormat.setDitheringPercent(50);
		pngImageFormat.setColorFormat(pngMonochromeColorFormat);
		pdfImage.setImageFormat(pngImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\PngImageFormat_Floyd_MonoChrome_" + i + "." + response.getImageFormat());
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
	public void TestPngImageFormat_Bayer_MonoChrome()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));

		PngImageFormat pngImageFormat = new PngImageFormat();
		
		PngMonochromeColorFormat pngMonochromeColorFormat = new PngMonochromeColorFormat();
		pngMonochromeColorFormat.setDitheringAlgorithm(DitheringAlgorithm.BAYER);
		pngMonochromeColorFormat.setDitheringPercent(50);

		pngImageFormat.setColorFormat(pngMonochromeColorFormat);
		
		pdfImage.setImageFormat(pngImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\PngImageFormat_Bayer_MonoChrome_" + i + "." + response.getImageFormat());
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
	public void TestPngImageFormat_Floyd_Indexed()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));

		PngImageFormat pngImageFormat = new PngImageFormat();
		
		PngIndexedColorFormat pngIndexedColorFormat = new PngIndexedColorFormat();
		pngIndexedColorFormat.setDitheringAlgorithm(DitheringAlgorithm.FLOYDSTEINBERG);
		pngIndexedColorFormat.setDitheringPercent(50);
		pngImageFormat.setColorFormat(pngIndexedColorFormat);
		pdfImage.setImageFormat(pngImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\PngImageFormat_Floyd_Indexed_" + i + "." + response.getImageFormat());
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
	public void TestPngImageFormat_Bayer_Indexed()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));

		PngImageFormat pngImageFormat = new PngImageFormat();
		
		PngIndexedColorFormat pngIndexedColorFormat = new PngIndexedColorFormat();
		pngIndexedColorFormat.setDitheringAlgorithm(DitheringAlgorithm.BAYER);
		pngIndexedColorFormat.setDitheringPercent(50);
		pngImageFormat.setColorFormat(pngIndexedColorFormat);
		
		pdfImage.setImageFormat(pngImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\PngImageFormat_Bayer_Indexed_" + i + "." + response.getImageFormat());
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
	public void TestPngImageFormat_RgbColorFormat()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));

		PngImageFormat pngImageFormat = new PngImageFormat();
		pngImageFormat.setColorFormat(new PngColorFormat(ColorFormatType.RGB));
		pdfImage.setImageFormat(pngImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\PngImageFormat_Rgb_ColorFormat_" + i + "." + response.getImageFormat());
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
	public void TestPngImageFormat_RgbaColorFormat()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));

		PngImageFormat pngImageFormat = new PngImageFormat();
		pngImageFormat.setColorFormat(new PngColorFormat(ColorFormatType.RGBA));
		pdfImage.setImageFormat(pngImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\PngImageFormat_Rgba_ColorFormat_" + i + "." + response.getImageFormat());
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
	public void TestPngImageFormat_GrayscaleColorFormat()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));

		PngImageFormat pngImageFormat = new PngImageFormat();
		pngImageFormat.setColorFormat(new PngColorFormat(ColorFormatType.GRAYSCALE));
		pdfImage.setImageFormat(pngImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\PngImageFormat_GrayScale_ColorFormat_" + i + "." + response.getImageFormat());
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
	public void TestPngImageFormat_MonochromeColorFormat()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));

		PngImageFormat pngImageFormat = new PngImageFormat();
		pngImageFormat.setColorFormat(new PngColorFormat(ColorFormatType.MONOCHROME));
		pdfImage.setImageFormat(pngImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\PngImageFormat_Monochrome_ColorFormat_" + i + "." + response.getImageFormat());
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
	public void TestPngImageFormat_IndexedColorFormat()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));

		PngImageFormat pngImageFormat = new PngImageFormat();
		pngImageFormat.setColorFormat(new PngColorFormat(ColorFormatType.INDEXED));
		pdfImage.setImageFormat(pngImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\PngImageFormat_Indexed_ColorFormat_" + i + "." + response.getImageFormat());
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
	public void TestPngImageFormat_BlackThreshold()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));

		PngMonochromeColorFormat pngMonochromeColorFormat = new PngMonochromeColorFormat();
		pngMonochromeColorFormat.setBlackThreshold(200);
		
		PngImageFormat pngImageFormat = new PngImageFormat();
		pngImageFormat.setColorFormat(pngMonochromeColorFormat);
		pdfImage.setImageFormat(pngImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\PngImageFormat_BlackThreshold_" + i + "." + response.getImageFormat());
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
	public void TestPngImageFormat_Qa_Octree()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));

		PngImageFormat pngImageFormat = new PngImageFormat();
		PngIndexedColorFormat pngIndexedColorFormat = new PngIndexedColorFormat();
		pngIndexedColorFormat.setQuantizationAlgorithm(QuantizationAlgorithm.OCTREE);
		pngImageFormat.setColorFormat(pngIndexedColorFormat);
		pdfImage.setImageFormat(pngImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\PngImageFormat_Qa_Octree_" + i + "." + response.getImageFormat());
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
	public void TestPngImageFormat_Qa_WU()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));

		PngImageFormat pngImageFormat = new PngImageFormat();
		PngIndexedColorFormat pngIndexedColorFormat = new PngIndexedColorFormat();
		pngIndexedColorFormat.setQuantizationAlgorithm(QuantizationAlgorithm.WU);
		pngImageFormat.setColorFormat(pngIndexedColorFormat);
		pdfImage.setImageFormat(pngImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\PngImageFormat_Qa_WU_" + i + "." + response.getImageFormat());
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
	public void TestPngImageFormat_Qa_WebSafe()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));

		PngImageFormat pngImageFormat = new PngImageFormat();

		PngIndexedColorFormat pngIndexedColorFormat = new PngIndexedColorFormat();
		pngIndexedColorFormat.setQuantizationAlgorithm(QuantizationAlgorithm.WEBSAFE);
		pngImageFormat.setColorFormat(pngIndexedColorFormat);
		pdfImage.setImageFormat(pngImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\PngImageFormat_Qa_WebSafe_" + i + "." + response.getImageFormat());
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
	public void TestPngImageFormat_Qa_Werner()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));

		PngImageFormat pngImageFormat = new PngImageFormat();

		PngIndexedColorFormat pngIndexedColorFormat = new PngIndexedColorFormat();
		pngIndexedColorFormat.setQuantizationAlgorithm(QuantizationAlgorithm.WERNER);
		pngImageFormat.setColorFormat(pngIndexedColorFormat);
		pdfImage.setImageFormat(pngImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\PngImageFormat_Qa_Werner_" + i + "." + response.getImageFormat());
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
