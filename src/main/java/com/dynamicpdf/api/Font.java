package com.dynamicpdf.api;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


/**
 * Represents font.
 */
@JsonInclude(Include.NON_DEFAULT)
@JsonAutoDetect(fieldVisibility = Visibility.NON_PRIVATE)
public class Font {

	private static Font timesRoman = null;
	private static Font timesBold = null;
	private static Font timesItalic = null;
	private static Font timesBoldItalic = null;
	private static Font helvetica = null;
	private static Font helveticaBold = null;
	private static Font helveticaOblique = null;
	private static Font helveticaBoldOblique = null;
	private static Font courier = null;
	private static Font courierBold = null;
	private static Font courierOblique = null;
	private static Font courierBoldOblique = null;
	private static Font symbol = null;
	private static Font zapfDingbats = null;
	private static boolean loadRequired = true;
	private static ReentrantLock lock = new ReentrantLock();
	private static List<FontInformation> fontDetails = new ArrayList<FontInformation>();
	private static String pathToFontsResourceDirectory = "";

	FontResource resource;

	private String name;
	private boolean embed = true;
	private boolean subset = true;
	private String resourceName;

	static {

		try {
			String windDir = System.getenv("WINDIR");
			if (windDir != null && windDir.length() > 0) {
				pathToFontsResourceDirectory = windDir + "\\Fonts";
			}
		} catch (Exception ex) {
		}
	}

	Font() {
	}

	Font(FontResource fontResource, String resourceName) {
		this.resource = fontResource;
		this.resourceName = resourceName;
		name = UUID.randomUUID().toString();
	}

	Font(FontResource fontResource) {
		this(fontResource, null);
	}

	/**
	 * Initializes a new instance of the <code>Font</code> class 
	 * using the font name that is present in the cloud resource manager.
	 * @param cloudResourceName The font name present in the cloud resource manager.
	 */

	public Font(String cloudResourceName) {
		this.resourceName = cloudResourceName;
		name = UUID.randomUUID().toString();
	}

	/**
	 * Gets the name of the font
	 * @return The name of the font
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the font
	 * @param value The name of the font
	 */
	void setName(String value) {
		name = value;
	}

	/**
	 * Gets the font resource
	 * @return The font resource
	 */
	@JsonIgnore
	public FontResource getResource() {
		return resource;
	}

	/**
	 * Gets a boolean indicating whether to embed the font.
	 * @return A boolean indicating whether to embed the font.
	 */
	public boolean getEmbed() {
		return embed;
	}

	/**
	 * Sets a boolean indicating whether to embed the font.
	 * @param value A boolean indicating whether to embed the font.
	 */
	public void setEmbed(boolean value) {
		embed = value;
	}

	/**
	 * Gets a boolean indicating whether to subset embed the font.
	 * @return A boolean indicating whether to subset embed the font.
	 */
	public boolean getSubset() {
		return subset;
	}

	/**
	 * Sets a boolean indicating whether to subset embed the font.
	 * @param value A boolean indicating whether to subset embed the font.
	 */
	public void setSubset(boolean value) {
		subset = value;
	}

	/**
	 * Gets a name for the font resource.
	 * @return A name for the font resource.
	 */
	public String getResourceName() {
		return resourceName;
	}

	/**
	 * Sets a name for the font resource.
	 * @param value A name for the font resource.
	 */
	public void setResourceName(String value) {
		resourceName = value;
	}

	/**
	 * Gets the Times Roman core font with Latin 1 encoding.
	 * @return The Times Roman core font with Latin 1 encoding.
	 */
	public static Font getTimesRoman() {
		if (timesRoman == null) {
			timesRoman = new Font();
			timesRoman.setName("timesRoman");
		}
		return timesRoman;
	}

	/**
	 * Gets the Times Bold core font with Latin 1 encoding.
	 * @return The Times Bold core font with Latin 1 encoding.
	 */
	public static Font getTimesBold() {
		if (timesBold == null) {
			timesBold = new Font();
			timesBold.setName("timesBold");
		}
		return timesBold;
	}

	/**
	 * Gets the Times Italic core font with Latin 1 encoding.
	 * @return The Times Italic core font with Latin 1 encoding.
	 */
	public static Font getTimesItalic() {
		if (timesItalic == null) {
			timesItalic = new Font();
			timesItalic.setName("timesItalic");
		}
		return timesItalic;
	}

	/**
	 * Gets the Times Bold Italic core font with Latin 1 encoding.
	 * @return The Times Bold Italic core font with Latin 1 encoding.
	 */
	public static Font getTimesBoldItalic() {
		if (timesBoldItalic == null) {
			timesBoldItalic = new Font();
			timesBoldItalic.setName("timesBoldItalic");
		}
		return timesBoldItalic;
	}

	/**
	 * Gets the Helvetica core font with Latin 1 encoding.
	 * @return The Helvetica core font with Latin 1 encoding.
	 */
	public static Font getHelvetica() {
		if (helvetica == null) {
			helvetica = new Font();
			helvetica.setName("helvetica");
		}
		return helvetica;
	}

	/**
	 * Gets the Helvetica Bold core font with Latin 1 encoding.
	 * @return The Helvetica Bold core font with Latin 1 encoding.
	 */
	public static Font getHelveticaBold() {
		if (helveticaBold == null) {
			helveticaBold = new Font();
			helveticaBold.setName("helveticaBold");
		}
		return helveticaBold;
	}

	/**
	 * Gets the Helvetica Oblique core font with Latin 1 encoding.
	 * @return The Helvetica Oblique core font with Latin 1 encoding.
	 */
	public static Font getHelveticaOblique() {
		if (helveticaOblique == null) {
			helveticaOblique = new Font();
			helveticaOblique.setName("helveticaOblique");
		}
		return helveticaOblique;
	}

	/**
	 * Gets the Helvetica Bold Oblique core font with Latin 1 encoding.
	 * @return The Helvetica Bold Oblique core font with Latin 1 encoding.
	 */
	public static Font getHelveticaBoldOblique() {
		if (helveticaBoldOblique == null) {
			helveticaBoldOblique = new Font();
			helveticaBoldOblique.setName("helveticaBoldOblique");
		}
		return helveticaBoldOblique;
	}

	/**
	 * Gets the Courier core font with Latin 1 encoding.
	 * @return The Courier core font with Latin 1 encoding.
	 */
	public static Font getCourier() {
		if (courier == null) {
			courier = new Font();
			courier.setName("courier");
		}
		return courier;
	}

	/**
	 * Gets the Courier Bold core font with Latin 1 encoding.
	 * @return The Courier Bold core font with Latin 1 encoding.
	 */
	public static Font getCourierBold() {
		if (courierBold == null) {
			courierBold = new Font();
			courierBold.setName("courierBold");
		}
		return courierBold;
	}

	/**
	 * Gets the Courier Oblique core font with Latin 1 encoding.
	 * @return The Courier Oblique core font with Latin 1 encoding.
	 */
	public static Font getCourierOblique() {
		if (courierOblique == null) {
			courierOblique = new Font();
			courierOblique.setName("courierOblique");
		}
		return courierOblique;
	}

	/**
	 * Gets the Courier Bold Oblique core font with Latin 1 encoding.
	 * @return The Courier Bold Oblique core font with Latin 1 encoding.
	 */
	public static Font getCourierBoldOblique() {

		if (courierBoldOblique == null) {
			courierBoldOblique = new Font();
			courierBoldOblique.setName("courierBoldOblique");
		}
		return courierBoldOblique;
	}

	/**
	 * Gets the Symbol core font.
	 * @return The Symbol core font.
	 */
	public static Font getSymbol() {
		if (symbol == null) {
			symbol = new Font();
			symbol.setName("symbol");
		}
		return symbol;
	}

	/**
	 * Gets the Zapf Dingbats core font.
	 * @return The Zapf Dingbats core font.
	 */
	public static Font getZapfDingbats() {
		if (zapfDingbats == null) {
			zapfDingbats = new Font();
			zapfDingbats.setName("zapfDingbats");
		}
		return zapfDingbats;
	}

	/**
	 * Initializes a new instance of the <code>Font</code> class 
	 * using the file path of the font and resource name.
	 * @param filePath The file path of the font file.
	 * @param resourceName The resource name for the font.
	 * @return The font
	 */
	public static Font fromFile(String filePath, String resourceName) {
		FontResource resource = new FontResource(filePath, resourceName);
		Font font = new Font(resource, resource.getResourceName());
		return font;
	}

	/**
	 * Initializes a new instance of the <code>Font</code> class 
	 * using the file path of the font and resource name.
	 * @param filePath The file path of the font file.
	 * @return The file path of the font file.
	 */
	public static Font fromFile(String filePath) {
		return fromFile(filePath, null);
	}

	/**
	 * Initializes a new instance of the <code>Font</code> class 
	 * using the stream of the font file and resource name.
	 * @param stream The stream of the font file.
	 * @param resourceName The resource name for the font.
	 * @return The font
	 */
	public static Font fromStream(InputStream stream, String resourceName) {
		FontResource resource = new FontResource(stream, resourceName);
		return new Font(resource, resource.getResourceName());
	}

	/**
	 * Initializes a new instance of the <code>Font</code> class 
	 * using the file path of the font and resource name.
	 * @param stream The stream of the font file.
	 * @return The font from stream
	 */
	public static Font fromStream(InputStream stream) {
		return fromStream(stream, null);
	}
	
	static String getGoogleFontText(String name, int weight, boolean italic) {
		return name + "," + Integer.toString(weight) + "," + Boolean.toString(italic);
	}

	/**
	 * Initializes a new instance of the <code>Font</code> class
	 * using the google font name.
	 * @param fontName The name of the google font.
	 * @return The font from the google.
	 */
	public static Font google(String fontName) {
		Font font = new Font();
		font.setName(Font.getGoogleFontText(fontName, 400, false));
		return font;
	}

    /**
     * Initializes a new instance of the <code>Font</code> class
     * using the google font name and bold.
     * @param fontName The name of the google font.
     * @param bold If true font weight will be taken as 700 otherwise 400.
     * @return The font from the google.
     */
	public static Font google(String fontName, boolean bold) {
		Font font = new Font();
		if (bold) {
			font.setName(Font.getGoogleFontText(fontName, 700, false));
		} else {
			font.setName(Font.getGoogleFontText(fontName, 400, false));
		}
		return font;
	}
    
    /**
     * Initializes a new instance of the <code>Font</code> class
     * using the google font name and weight. 
     * @param fontName The name of the google font.
     * @param weight The weight of the font.
     * @return The font from the google.
     */
	public static Font google(String fontName, int weight) {
		Font font = new Font();
		font.setName(Font.getGoogleFontText(fontName, weight, false));
		return font;
	}
    
    /**
     * Initializes a new instance of the <code>Font</code> class
     * using the google font name, bold and italic. 
     * @param fontName The name of the google font.
     * @param bold If true font weight will be taken as 700 otherwise 400.
     * @param italic The italic property of the font.
     * @return The font from the google.
     */
	public static Font google(String fontName, boolean bold, boolean italic) {
		Font font = new Font();
		if (bold) {
			font.setName(Font.getGoogleFontText(fontName, 700, italic));
		} else {
			font.setName(Font.getGoogleFontText(fontName, 400, italic));
		}
		return font;
	}
    
    /**
     * Initializes a new instance of the <code>Font</code> class
     * using the google font name, weight and italic.  
     * @param fontName The name of the google font.
     * @param weight The weight of the font.
     * @param italic The italic property of the font.
     * @return The font from the google.
     */
	public static Font google(String fontName, int weight, boolean italic) {
		Font font = new Font();
		font.setName(Font.getGoogleFontText(fontName, weight, italic));
		return font;
	}

	/**
	 * Initializes a new instance of the <code>Font</code> class 
	 * using the system font name and resource name.
	 * @param fontName The name of the font in the system.
	 * @param resourceName The resource name for the font.
	 * @return The font from system.
	 */
	public static Font fromSystem(String fontName, String resourceName) {
		FontResource fontResource;

		if (fontName == null) {
			return null;
		}
		if (fontName.isEmpty() || fontName.length() < 1) {
			return null;
		}

		fontName = fontName.replace("-", "");
		fontName = fontName.replace(" ", "");

		if (loadRequired) {
			loadFonts();
		}

		for (FontInformation fontDetail : fontDetails) {
			if (fontDetail.getFontName().toUpperCase().equals(fontName.toUpperCase())) {
				fontResource = new FontResource(fontDetail.getFilePath(), resourceName);
				return new Font(fontResource, fontResource.getResourceName());
			}
		}

		return null;
	}

	/**
	 * Initializes a new instance of the <code>Font</code> class 
	 * using the system font name and resource name.
	 * @param fontName The name of the font in the system.
	 * @return The font from system.
	 */
	public static Font fromSystem(String fontName) {
		return fromSystem(fontName, null);
	}

	private static void loadFonts() {
		lock.lock();
		{
			if (loadRequired) {
				if (pathToFontsResourceDirectory != null && pathToFontsResourceDirectory != "") {                    
					ArrayList<File> files = new ArrayList<File>();
					processDirectoryForFonts(pathToFontsResourceDirectory, files);

					DataStreamByteReader reader;
					FullNameTable nameTable;

					for (File file : files) {

						try {
							byte[] data = Files.readAllBytes(Paths.get(file.getPath()));

							reader = new DataStreamByteReader(data);
							nameTable = readFontNameTable(reader);
							if (nameTable != null) {
								fontDetails.add(new FontInformation(nameTable.getFontName(), file.getPath()));
							}
						} catch (IOException ex) {

						}
					}
				}
			}
		}
		lock.unlock();
	}

	private static void processDirectoryForFonts(String targetDirectory, ArrayList files) {
		File di = new File(targetDirectory);
		File[] allFiles = di.listFiles();

		if (allFiles != null) {
			for (File file : allFiles) {
				String extension = "";

				int i = file.getName().lastIndexOf('.');
				if (i > 0) {
					extension = file.getName().substring(i + 1);
				}
				if (extension.compareToIgnoreCase("ttf") == 0) {
					files.add(file);
				}
				if (extension.compareToIgnoreCase("otf") == 0) {
					files.add(file);
				}
			}
		}

		String[] subDirectory = di.list(new FilenameFilter() {
			public boolean accept(File current, String name) {
				return new File(current, name).isDirectory();
			}
		});

		if (subDirectory != null) {
			for (String subdirectory : subDirectory) {
				processDirectoryForFonts(subdirectory, files);
			}
		}
	}

	private static FullNameTable readFontNameTable(DataStreamByteReader reader) {
		FullNameTable nameTable = null;
		try {

			reader.seek(4);
			int intTableCount = (reader.read() << 8) | reader.read();
			if (intTableCount > 0) {
				byte[] bytTableDirectory = new byte[intTableCount * 16];

				reader.seek(12);
				reader.read(bytTableDirectory, 0, intTableCount * 16);
				for (int i = 0; i < bytTableDirectory.length; i += 16) {
					switch (toInt32(bytTableDirectory, i)) {
					case 1701667182: // "name" 
						nameTable = new FullNameTable(reader, bytTableDirectory, i);
						break;
					}
				}
			}
		} catch (Exception ex) {
		}
		return nameTable;
	}

	private static int toInt32(byte[] value, int startIndex) {
		int resultInt = 0;
		for (int i = 0, x = 0; i < 4; i++, x += 8) {
			resultInt = resultInt | ((value[startIndex++] & 0xff) << x);
		}
		return resultInt;

	}

}
