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

    public Font(String cloudResourceName) {
        this.resourceName = cloudResourceName;
        name = UUID.randomUUID().toString();
    }

    public String getName() {
        return name;
    }

    void setName(String value) {
        name = value;
    }

    @JsonIgnore
    public FontResource getResource() {
        return resource;
    }

    public boolean getEmbed() {
        return embed;
    }

    public void setEmbed(boolean value) {
        embed = value;
    }

    public boolean getSubset() {
        return subset;
    }

    public void setSubset(boolean value) {
        subset = value;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String value) {
        resourceName = value;
    }

    public static Font getTimesRoman() {
        if (timesRoman == null) {
            timesRoman = new Font();
            timesRoman.setName("timesRoman");
        }
        return timesRoman;
    }

    public static Font getTimesBold() {
        if (timesBold == null) {
            timesBold = new Font();
            timesBold.setName("timesBold");
        }
        return timesBold;
    }

    public static Font getTimesItalic() {
        if (timesItalic == null) {
            timesItalic = new Font();
            timesItalic.setName("timesItalic");
        }
        return timesItalic;
    }

    public static Font getTimesBoldItalic() {
        if (timesBoldItalic == null) {
            timesBoldItalic = new Font();
            timesBoldItalic.setName("timesBoldItalic");
        }
        return timesBoldItalic;
    }

    public static Font getHelvetica() {
        if (helvetica == null) {
            helvetica = new Font();
            helvetica.setName("helvetica");
        }
        return helvetica;
    }

    public static Font getHelveticaBold() {
        if (helveticaBold == null) {
            helveticaBold = new Font();
            helveticaBold.setName("helveticaBold");
        }
        return helveticaBold;
    }

    public static Font getHelveticaOblique() {
        if (helveticaOblique == null) {
            helveticaOblique = new Font();
            helveticaOblique.setName("helveticaOblique");
        }
        return helveticaOblique;
    }

    public static Font getHelveticaBoldOblique() {
        if (helveticaBoldOblique == null) {
            helveticaBoldOblique = new Font();
            helveticaBoldOblique.setName("helveticaBoldOblique");
        }
        return helveticaBoldOblique;
    }

    public static Font getCourier() {
        if (courier == null) {
            courier = new Font();
            courier.setName("courier");
        }
        return courier;
    }

    public static Font getCourierBold() {
        if (courierBold == null) {
            courierBold = new Font();
            courierBold.setName("courierBold");
        }
        return courierBold;
    }

    public static Font getCourierOblique() {
        if (courierOblique == null) {
            courierOblique = new Font();
            courierOblique.setName("courierOblique");
        }
        return courierOblique;
    }

    public static Font getCourierBoldOblique() {

        if (courierBoldOblique == null) {
            courierBoldOblique = new Font();
            courierBoldOblique.setName("courierBoldOblique");
        }
        return courierBoldOblique;
    }

    public static Font getSymbol() {
        if (symbol == null) {
            symbol = new Font();
            symbol.setName("symbol");
        }
        return symbol;
    }

    public static Font getZapfDingbats() {
        if (zapfDingbats == null) {
            zapfDingbats = new Font();
            zapfDingbats.setName("zapfDingbats");
        }
        return zapfDingbats;
    }

    public static Font fromFile(String filePath, String resourceName) {
        FontResource resource = new FontResource(filePath, resourceName);
        Font font = new Font(resource, resource.getResourceName());
        return font;
    }

    public static Font fromFile(String filePath) {
        return fromFile(filePath, null);
    }

    public static Font fromStream(InputStream stream, String resourceName) {
        FontResource resource = new FontResource(stream, resourceName);
        return new Font(resource, resource.getResourceName());
    }

    public static Font fromStream(InputStream stream) {
        return fromStream(stream, null);
    }

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
