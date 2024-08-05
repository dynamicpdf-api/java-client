package ImageEndPoint;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ResourceBundle;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dynamicpdf.api.*;
import com.dynamicpdf.api.imaging.TiffColorFormat;
import com.dynamicpdf.api.imaging.TiffImageFormat;
import com.dynamicpdf.api.imaging.TiffIndexedColorFormat;
import com.dynamicpdf.api.imaging.TiffMonochromeColorFormat;
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

public class TiffImagingSamples {

	@BeforeClass
	public void setup() {
		ResourceBundle bundle =  ResourceBundle.getBundle("config");
		Pdf.setDefaultApiKey(bundle.getString("ApiKey"));
		Pdf.setDefaultBaseUrl(bundle.getString("BaseUrl"));
	}
	
	@Test
	public void TestTiffImageFormat()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));

		TiffImageFormat tiffImageFormat = new TiffImageFormat();
		pdfImage.setImageFormat(tiffImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\TiffImageFormat_" + i + "." + response.getImageFormat());
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
	public void TestTiffImageFormat_PageCount()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));
		pdfImage.setPageCount(2);
		TiffImageFormat tiffImageFormat = new TiffImageFormat();
		pdfImage.setImageFormat(tiffImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\TiffImageFormat_" + i + "." + response.getImageFormat());
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
	public void TestTiffImageFormat_FixedSize_InPoint()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));
		
		FixedImageSize fixedImageSize = new FixedImageSize();
		fixedImageSize.setUnit(ImageSizeUnit.POINT);
		fixedImageSize.setWidth(500);
		fixedImageSize.setHeight(500);
		pdfImage.setImageSize(fixedImageSize);

		TiffImageFormat tiffImageFormat = new TiffImageFormat();
		pdfImage.setImageFormat(tiffImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\TiffImageFormat_Fixed_Point_Size_" + i + "." + response.getImageFormat());
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
	public void TestTiffImageFormat_FixedSize_InInch()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));
		
		FixedImageSize fixedImageSize = new FixedImageSize();
		fixedImageSize.setUnit(ImageSizeUnit.INCH);
		fixedImageSize.setWidth(5);
		fixedImageSize.setHeight(5);
		pdfImage.setImageSize(fixedImageSize);

		TiffImageFormat tiffImageFormat = new TiffImageFormat();
		pdfImage.setImageFormat(tiffImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\TiffImageFormat_Fixed_Inch_Size_" + i + "." + response.getImageFormat());
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
	public void TestTiffImageFormat_FixedSize_InMillimeter()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));

		FixedImageSize fixedImageSize = new FixedImageSize();
		fixedImageSize.setUnit(ImageSizeUnit.MILLIMETER);
		fixedImageSize.setWidth(700);
		fixedImageSize.setHeight(700);
		pdfImage.setImageSize(fixedImageSize);
		
		TiffImageFormat tiffImageFormat = new TiffImageFormat();
		pdfImage.setImageFormat(tiffImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\TiffImageFormat_Fixed_MilliMeter_Size_" + i + "." + response.getImageFormat());
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
	public void TestTiffImageFormat_MaxSize_InPoint()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));
		
		MaxImageSize maxImageSize = new MaxImageSize();
		maxImageSize.setUnit(ImageSizeUnit.POINT);
		maxImageSize.setMaxWidth(500);
		maxImageSize.setMaxHeight(500);
		pdfImage.setImageSize(maxImageSize);

		TiffImageFormat tiffImageFormat = new TiffImageFormat();
		pdfImage.setImageFormat(tiffImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\TiffImageFormat_Max_Point_Size_" + i + "." + response.getImageFormat());
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
	public void TestTiffImageFormat_MaxSize_InInch()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));
		
		MaxImageSize maxImageSize = new MaxImageSize();
		maxImageSize.setUnit(ImageSizeUnit.INCH);
		maxImageSize.setMaxWidth(7);
		maxImageSize.setMaxHeight(7);
		pdfImage.setImageSize(maxImageSize);
		
		TiffImageFormat tiffImageFormat = new TiffImageFormat();
		pdfImage.setImageFormat(tiffImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\TiffImageFormat_Max_Inch_Size_" + i + "." + response.getImageFormat());
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
	public void TestTiffImageFormat_MaxSize_InMillimeter()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));

		MaxImageSize maxImageSize = new MaxImageSize();
		maxImageSize.setUnit(ImageSizeUnit.MILLIMETER);
		maxImageSize.setMaxWidth(400);
		maxImageSize.setMaxHeight(400);
		pdfImage.setImageSize(maxImageSize);
		
		TiffImageFormat tiffImageFormat = new TiffImageFormat();
		pdfImage.setImageFormat(tiffImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\TiffImageFormat_Max_MilliMeter_Size_" + i + "." + response.getImageFormat());
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
	public void TestTiffImageFormat_Dpi_ImageSize()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));

		DpiImageSize dpiImageSize = new DpiImageSize();
		dpiImageSize.setHorizontalDpi(155);
		dpiImageSize.setVerticalDpi(155);
		pdfImage.setImageSize(dpiImageSize);
		
		TiffImageFormat tiffImageFormat = new TiffImageFormat();
		pdfImage.setImageFormat(tiffImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\TiffImageFormat_Dpi_ImageSize_" + i + "." + response.getImageFormat());
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
	public void TestTiffImageFormat_Percentage_ImageSize()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));

		PercentageImageSize percentageImageSize = new PercentageImageSize();
		percentageImageSize.setVerticalPercentage(50);
		percentageImageSize.setHorizontalPercentage(50);
		pdfImage.setImageSize(percentageImageSize);
		
		TiffImageFormat tiffImageFormat = new TiffImageFormat();
		pdfImage.setImageFormat(tiffImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\TiffImageFormat_Percentage_ImageSize_" + i + "." + response.getImageFormat());
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
	public void TestTiffImageFormat_Floyd_MonoChrome()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));

		TiffImageFormat tiffImageFormat = new TiffImageFormat();
		
		TiffMonochromeColorFormat tiffMonochromeColorFormat = new TiffMonochromeColorFormat();
		tiffMonochromeColorFormat.setDitheringAlgorithm(DitheringAlgorithm.FLOYDSTEINBERG);
		tiffMonochromeColorFormat.setDitheringPercent(50);
		tiffImageFormat.setColorFormat(tiffMonochromeColorFormat);
		pdfImage.setImageFormat(tiffImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\TiffImageFormat_Floyd_MonoChrome_" + i + "." + response.getImageFormat());
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
	public void TestTiffImageFormat_Bayer_MonoChrome()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));

		TiffImageFormat tiffImageFormat = new TiffImageFormat();
		
		TiffMonochromeColorFormat tiffMonochromeColorFormat = new TiffMonochromeColorFormat();
		tiffMonochromeColorFormat.setDitheringAlgorithm(DitheringAlgorithm.BAYER);
		tiffMonochromeColorFormat.setDitheringPercent(50);

		tiffImageFormat.setColorFormat(tiffMonochromeColorFormat);
		
		pdfImage.setImageFormat(tiffImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\TiffImageFormat_Bayer_MonoChrome_" + i + "." + response.getImageFormat());
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
	public void TestTiffImageFormat_Floyd_Indexed()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));

		TiffImageFormat tiffImageFormat = new TiffImageFormat();
		
		TiffIndexedColorFormat tiffIndexedColorFormat = new TiffIndexedColorFormat();
		tiffIndexedColorFormat.setDitheringAlgorithm(DitheringAlgorithm.FLOYDSTEINBERG);
		tiffIndexedColorFormat.setDitheringPercent(50);
		tiffImageFormat.setColorFormat(tiffIndexedColorFormat);
		pdfImage.setImageFormat(tiffImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\TiffImageFormat_Floyd_Indexed_" + i + "." + response.getImageFormat());
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
	public void TestTiffImageFormat_Bayer_Indexed()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));

		TiffImageFormat tiffImageFormat = new TiffImageFormat();
		
		TiffIndexedColorFormat tiffIndexedColorFormat = new TiffIndexedColorFormat();
		tiffIndexedColorFormat.setDitheringAlgorithm(DitheringAlgorithm.BAYER);
		tiffIndexedColorFormat.setDitheringPercent(50);
		tiffImageFormat.setColorFormat(tiffIndexedColorFormat);
		
		pdfImage.setImageFormat(tiffImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\TiffImageFormat_Bayer_Indexed_" + i + "." + response.getImageFormat());
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
	public void TestTiffImageFormat_RgbColorFormat()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));

		TiffImageFormat tiffImageFormat = new TiffImageFormat();
		tiffImageFormat.setColorFormat(new TiffColorFormat(ColorFormatType.RGB));
		pdfImage.setImageFormat(tiffImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\TiffImageFormat_Rgb_ColorFormat_" + i + "." + response.getImageFormat());
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
	public void TestTiffImageFormat_RgbaColorFormat()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));

		TiffImageFormat tiffImageFormat = new TiffImageFormat();
		tiffImageFormat.setColorFormat(new TiffColorFormat(ColorFormatType.RGBA));
		pdfImage.setImageFormat(tiffImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\TiffImageFormat_Rgba_ColorFormat_" + i + "." + response.getImageFormat());
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
	public void TestTiffImageFormat_GrayscaleColorFormat()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));

		TiffImageFormat tiffImageFormat = new TiffImageFormat();
		tiffImageFormat.setColorFormat(new TiffColorFormat(ColorFormatType.GRAYSCALE));
		pdfImage.setImageFormat(tiffImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\TiffImageFormat_GrayScale_ColorFormat_" + i + "." + response.getImageFormat());
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
	public void TestTiffImageFormat_MonochromeColorFormat()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));

		TiffImageFormat tiffImageFormat = new TiffImageFormat();
		tiffImageFormat.setColorFormat(new TiffColorFormat(ColorFormatType.MONOCHROME));
		pdfImage.setImageFormat(tiffImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\TiffImageFormat_Monochrome_ColorFormat_" + i + "." + response.getImageFormat());
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
	public void TestTiffImageFormat_IndexedColorFormat()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));

		TiffImageFormat tiffImageFormat = new TiffImageFormat();
		tiffImageFormat.setColorFormat(new TiffColorFormat(ColorFormatType.INDEXED));
		pdfImage.setImageFormat(tiffImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\TiffImageFormat_Indexed_ColorFormat_" + i + "." + response.getImageFormat());
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
	public void TestTiffImageFormat_BlackThreshold()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));

		TiffMonochromeColorFormat tiffMonochromeColorFormat = new TiffMonochromeColorFormat();
		tiffMonochromeColorFormat.setBlackThreshold(200);
		
		TiffImageFormat tiffImageFormat = new TiffImageFormat();
		tiffImageFormat.setColorFormat(tiffMonochromeColorFormat);
		pdfImage.setImageFormat(tiffImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\TiffImageFormat_BlackThreshold_" + i + "." + response.getImageFormat());
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
	public void TestTiffImageFormat_Qa_Octree()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));

		TiffImageFormat tiffImageFormat = new TiffImageFormat();
		TiffIndexedColorFormat tiffIndexedColorFormat = new TiffIndexedColorFormat();
		tiffIndexedColorFormat.setQuantizationAlgorithm(QuantizationAlgorithm.OCTREE);
		tiffImageFormat.setColorFormat(tiffIndexedColorFormat);
		pdfImage.setImageFormat(tiffImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\TiffImageFormat_Qa_Octree_" + i + "." + response.getImageFormat());
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
	public void TestTiffImageFormat_Qa_WU()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));

		TiffImageFormat tiffImageFormat = new TiffImageFormat();
		TiffIndexedColorFormat tiffIndexedColorFormat = new TiffIndexedColorFormat();
		tiffIndexedColorFormat.setQuantizationAlgorithm(QuantizationAlgorithm.WU);
		tiffImageFormat.setColorFormat(tiffIndexedColorFormat);
		pdfImage.setImageFormat(tiffImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\TiffImageFormat_Qa_WU_" + i + "." + response.getImageFormat());
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
	public void TestTiffImageFormat_Qa_WebSafe()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));

		TiffImageFormat tiffImageFormat = new TiffImageFormat();

		TiffIndexedColorFormat tiffIndexedColorFormat = new TiffIndexedColorFormat();
		tiffIndexedColorFormat.setQuantizationAlgorithm(QuantizationAlgorithm.WEBSAFE);
		tiffImageFormat.setColorFormat(tiffIndexedColorFormat);
		pdfImage.setImageFormat(tiffImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\TiffImageFormat_Qa_WebSafe_" + i + "." + response.getImageFormat());
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
	public void TestTiffImageFormat_Qa_Werner()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));

		TiffImageFormat tiffImageFormat = new TiffImageFormat();

		TiffIndexedColorFormat tiffIndexedColorFormat = new TiffIndexedColorFormat();
		tiffIndexedColorFormat.setQuantizationAlgorithm(QuantizationAlgorithm.WERNER);
		tiffImageFormat.setColorFormat(tiffIndexedColorFormat);
		pdfImage.setImageFormat(tiffImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\TiffImageFormat_Qa_Werner_" + i + "." + response.getImageFormat());
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
	public void TestTiffImageFormat_MultiPage()
	{
		PdfImage pdfImage = new PdfImage(new PdfResource("src\\test\\resources\\DocumentA.pdf"));

		TiffImageFormat tiffImageFormat = new TiffImageFormat();
		tiffImageFormat.setMultiPage(true);
		pdfImage.setImageFormat(tiffImageFormat);

		PdfImageResponse response = pdfImage.process();
		
		if (response.getIsSuccessful())
		{
		    for (int i = 0; i < response.getImages().size(); i++)
		    {
		        
		        File file = new File("src\\test\\outputs\\TiffImageFormat_MultiPage_" + i + "." + response.getImageFormat());
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
