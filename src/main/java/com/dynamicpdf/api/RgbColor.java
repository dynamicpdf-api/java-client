package com.dynamicpdf.api;

public class RgbColor extends Color {

    private String colorString;
    private float red;
    private float green;
    private float blue;

    RgbColor() {
    }

    RgbColor(String colorString) {
        this.colorString = colorString;
    }

    public RgbColor(float red, float green, float blue) {
        if (red < 0.0f || red > 1.0f || green < 0.0f || green > 1.0f || blue < 0.0f || blue > 1.0f) {
            throw new EndpointException("RGB values must be from 0.0 to 1.0.");
        }
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public String getColorString() {
        if (colorString != null) {
            return colorString;
        } else {
            return "rgb(" + Float.toString(red) + "," + Float.toString(green) + "," + Float.toString(blue) + ")";
        }
    }

    void setColorString(String value) {
        colorString = value;
    }

    public static RgbColor getRed() {
        return new RgbColor("Red");
    }

    public static RgbColor getBlue() {
        return new RgbColor("Blue");
    }

    public static RgbColor getGreen() {
        return new RgbColor("Green");
    }

    public static RgbColor getBlack() {
        return new RgbColor("Black");
    }

    public static RgbColor getSilver() {
        return new RgbColor("Silver");
    }

    public static RgbColor getDarkGray() {
        return new RgbColor("DarkGray");
    }

    public static RgbColor getGray() {
        return new RgbColor("Gray");
    }

    public static RgbColor getDimGray() {
        return new RgbColor("DimGray");
    }

    public static RgbColor getWhite() {
        return new RgbColor("White");
    }

    public static RgbColor getLime() {
        return new RgbColor("Lime");
    }

    public static RgbColor getAqua() {
        return new RgbColor("Aqua");
    }

    public static RgbColor getPurple() {
        return new RgbColor("Purple");
    }

    public static RgbColor getCyan() {
        return new RgbColor("Cyan");
    }

    public static RgbColor getMagenta() {
        return new RgbColor("Magenta");
    }

    public static RgbColor getYellow() {
        return new RgbColor("Yellow");
    }

    public static RgbColor getAliceBlue() {
        return new RgbColor("AliceBlue");
    }

    public static RgbColor getAntiqueWhite() {
        return new RgbColor("AntiqueWhite");
    }

    public static RgbColor getAquamarine() {
        return new RgbColor("Aquamarine");
    }

    public static RgbColor getAzure() {
        return new RgbColor("Azure");
    }

    public static RgbColor getBeige() {
        return new RgbColor("Beige");
    }

    public static RgbColor getBisque() {
        return new RgbColor("Bisque");
    }

    public static RgbColor getBlanchedAlmond() {
        return new RgbColor("BlanchedAlmond");
    }

    public static RgbColor getBlueViolet() {
        return new RgbColor("BlueViolet");
    }

    public static RgbColor getBrown() {
        return new RgbColor("Brown");
    }

    public static RgbColor getBurlyWood() {
        return new RgbColor("BurlyWood");
    }

    public static RgbColor getCadetBlue() {
        return new RgbColor("CadetBlue");
    }

    public static RgbColor getChartreuse() {
        return new RgbColor("Chartreuse");
    }

    public static RgbColor getChocolate() {
        return new RgbColor("Chocolate");
    }

    public static RgbColor getCoral() {
        return new RgbColor("Coral");
    }

    public static RgbColor getCornflowerBlue() {
        return new RgbColor("CornflowerBlue");
    }

    public static RgbColor getCornsilk() {
        return new RgbColor("Cornsilk");
    }

    public static RgbColor getCrimson() {
        return new RgbColor("Crimson");
    }

    public static RgbColor getDarkBlue() {
        return new RgbColor("DarkBlue");
    }

    public static RgbColor getDarkCyan() {
        return new RgbColor("DarkCyan");
    }

    public static RgbColor getDarkGoldenRod() {
        return new RgbColor("DarkGoldenRod");
    }

    public static RgbColor getDarkGreen() {
        return new RgbColor("DarkGreen");
    }

    public static RgbColor getDarkKhaki() {
        return new RgbColor("DarkKhaki");
    }

    public static RgbColor getDarkMagenta() {
        return new RgbColor("DarkMagenta");
    }

    public static RgbColor getDarkOliveGreen() {
        return new RgbColor("DarkOliveGreen");
    }

    public static RgbColor getDarkOrange() {
        return new RgbColor("DarkOrange");
    }

    public static RgbColor getDarkOrchid() {
        return new RgbColor("DarkOrchid");
    }

    public static RgbColor getDarkRed() {
        return new RgbColor("DarkRed");
    }

    public static RgbColor getDarkSalmon() {
        return new RgbColor("DarkSalmon");
    }

    public static RgbColor getDarkSeaGreen() {
        return new RgbColor("DarkSeaGreen");
    }

    public static RgbColor getDarkSlateBlue() {
        return new RgbColor("DarkSlateBlue");
    }

    public static RgbColor getDarkSlateGray() {
        return new RgbColor("DarkSlateGray");
    }

    public static RgbColor getDarkTurquoise() {
        return new RgbColor("DarkTurquoise");
    }

    public static RgbColor getDarkViolet() {
        return new RgbColor("DarkViolet");
    }

    public static RgbColor getDeepPink() {
        return new RgbColor("DeepPink");
    }

    public static RgbColor getDeepSkyBlue() {
        return new RgbColor("DeepSkyBlue");
    }

    public static RgbColor getDodgerBlue() {
        return new RgbColor("DodgerBlue");
    }

    public static RgbColor getFeldspar() {
        return new RgbColor("Feldspar");
    }

    public static RgbColor getFireBrick() {
        return new RgbColor("FireBrick");
    }

    public static RgbColor getFloralWhite() {
        return new RgbColor("FloralWhite");
    }

    public static RgbColor getForestGreen() {
        return new RgbColor("ForestGreen");
    }

    public static RgbColor getFuchsia() {
        return new RgbColor("Fuchsia");
    }

    public static RgbColor getGhostWhite() {
        return new RgbColor("GhostWhite");
    }

    public static RgbColor getGold() {
        return new RgbColor("Gold");
    }

    public static RgbColor getGoldenRod() {
        return new RgbColor("GoldenRod");
    }

    public static RgbColor getGreenYellow() {
        return new RgbColor("GreenYellow");
    }

    public static RgbColor getHoneyDew() {
        return new RgbColor("HoneyDew");
    }

    public static RgbColor getHotPink() {
        return new RgbColor("HotPink");
    }

    public static RgbColor getIndianRed() {
        return new RgbColor("IndianRed");
    }

    public static RgbColor getIndigo() {
        return new RgbColor("Indigo");
    }

    public static RgbColor getIvory() {
        return new RgbColor("Ivory");
    }

    public static RgbColor getKhaki() {
        return new RgbColor("Khaki");
    }

    public static RgbColor getLavender() {
        return new RgbColor("Lavender");
    }

    public static RgbColor getLavenderBlush() {
        return new RgbColor("LavenderBlush");
    }

    public static RgbColor getLawnGreen() {
        return new RgbColor("LawnGreen");
    }

    public static RgbColor getLemonChiffon() {
        return new RgbColor("LemonChiffon");
    }

    public static RgbColor getLightBlue() {
        return new RgbColor("LightBlue");
    }

    public static RgbColor getLightCoral() {
        return new RgbColor("LightCoral");
    }

    public static RgbColor getLightCyan() {
        return new RgbColor("LightCyan");
    }

    public static RgbColor getLightGoldenRodYellow() {
        return new RgbColor("LightGoldenRodYellow");
    }

    public static RgbColor getLightGrey() {
        return new RgbColor("LightGrey");
    }

    public static RgbColor getLightGreen() {
        return new RgbColor("LightGreen");
    }

    public static RgbColor getLightPink() {
        return new RgbColor("LightPink");
    }

    public static RgbColor getLightSalmon() {
        return new RgbColor("LightSalmon");
    }

    public static RgbColor getLightSeaGreen() {
        return new RgbColor("LightSeaGreen");
    }

    public static RgbColor getLightSkyBlue() {
        return new RgbColor("LightSkyBlue");
    }

    public static RgbColor getLightSlateBlue() {
        return new RgbColor("LightSlateBlue");
    }

    public static RgbColor getLightSlateGray() {
        return new RgbColor("LightSlateGray");
    }

    public static RgbColor getLightSteelBlue() {
        return new RgbColor("LightSteelBlue");
    }

    public static RgbColor getLightYellow() {
        return new RgbColor("LightYellow");
    }

    public static RgbColor getLimeGreen() {
        return new RgbColor("LimeGreen");
    }

    public static RgbColor getLinen() {
        return new RgbColor("Linen");
    }

    public static RgbColor getMaroon() {
        return new RgbColor("Maroon");
    }

    public static RgbColor getMediumAquaMarine() {
        return new RgbColor("MediumAquaMarine");
    }

    public static RgbColor getMediumBlue() {
        return new RgbColor("MediumBlue");
    }

    public static RgbColor getMediumOrchid() {
        return new RgbColor("MediumOrchid");
    }

    public static RgbColor getMediumPurple() {
        return new RgbColor("MediumPurple");
    }

    public static RgbColor getMediumSeaGreen() {
        return new RgbColor("MediumSeaGreen");
    }

    public static RgbColor getMediumSlateBlue() {
        return new RgbColor("MediumSlateBlue");
    }

    public static RgbColor getMediumSpringGreen() {
        return new RgbColor("MediumSpringGreen");
    }

    public static RgbColor getMediumTurquoise() {
        return new RgbColor("MediumTurquoise");
    }

    public static RgbColor getMediumVioletRed() {
        return new RgbColor("MediumVioletRed");
    }

    public static RgbColor getMidnightBlue() {
        return new RgbColor("MidnightBlue");
    }

    public static RgbColor getMintCream() {
        return new RgbColor("MintCream");
    }

    public static RgbColor getMistyRose() {
        return new RgbColor("MistyRose");
    }

    public static RgbColor getMoccasin() {
        return new RgbColor("Moccasin");
    }

    public static RgbColor getNavajoWhite() {
        return new RgbColor("NavajoWhite");
    }

    public static RgbColor getNavy() {
        return new RgbColor("Navy");
    }

    public static RgbColor getOldLace() {
        return new RgbColor("OldLace");
    }

    public static RgbColor getOlive() {
        return new RgbColor("Olive");
    }

    public static RgbColor getOliveDrab() {
        return new RgbColor("OliveDrab");
    }

    public static RgbColor getGainsboro() {
        return new RgbColor("Gainsboro");
    }

    public static RgbColor getOrange() {
        return new RgbColor("Orange");
    }

    public static RgbColor getOrangeRed() {
        return new RgbColor("OrangeRed");
    }

    public static RgbColor getOrchid() {
        return new RgbColor("Orchid");
    }

    public static RgbColor getPaleGoldenRod() {
        return new RgbColor("PaleGoldenRod");
    }

    public static RgbColor getPaleGreen() {
        return new RgbColor("PaleGreen");
    }

    public static RgbColor getPaleTurquoise() {
        return new RgbColor("PaleTurquoise");
    }

    public static RgbColor getPaleVioletRed() {
        return new RgbColor("PaleVioletRed");
    }

    public static RgbColor getPapayaWhip() {
        return new RgbColor("PapayaWhip");
    }

    public static RgbColor getPeachPuff() {
        return new RgbColor("PeachPuff");
    }

    public static RgbColor getPeru() {
        return new RgbColor("Peru");
    }

    public static RgbColor getPink() {
        return new RgbColor("Pink");
    }

    public static RgbColor getPlum() {
        return new RgbColor("Plum");
    }

    public static RgbColor getPowderBlue() {
        return new RgbColor("PowderBlue");
    }

    public static RgbColor getRosyBrown() {
        return new RgbColor("RosyBrown");
    }

    public static RgbColor getRoyalBlue() {
        return new RgbColor("RoyalBlue");
    }

    public static RgbColor getSaddleBrown() {
        return new RgbColor("SaddleBrown");
    }

    public static RgbColor getSalmon() {
        return new RgbColor("Salmon");
    }

    public static RgbColor getSandyBrown() {
        return new RgbColor("SandyBrown");
    }

    public static RgbColor getSeaGreen() {
        return new RgbColor("SeaGreen");
    }

    public static RgbColor getSeaShell() {
        return new RgbColor("SeaShell");
    }

    public static RgbColor getSienna() {
        return new RgbColor("Sienna");
    }

    public static RgbColor getSkyBlue() {
        return new RgbColor("SkyBlue");
    }

    public static RgbColor getSlateBlue() {
        return new RgbColor("SlateBlue");
    }

    public static RgbColor getSlateGray() {
        return new RgbColor("SlateGray");
    }

    public static RgbColor getSnow() {
        return new RgbColor("Snow");
    }

    public static RgbColor getSpringGreen() {
        return new RgbColor("SpringGreen");
    }

    public static RgbColor getSteelBlue() {
        return new RgbColor("SteelBlue");
    }

    public static RgbColor getTan() {
        return new RgbColor("Tan");
    }

    public static RgbColor getTeal() {
        return new RgbColor("Teal");
    }

    public static RgbColor getThistle() {
        return new RgbColor("Thistle");
    }

    public static RgbColor getTomato() {
        return new RgbColor("Tomato");
    }

    public static RgbColor getTurquoise() {
        return new RgbColor("Turquoise");
    }

    public static RgbColor getViolet() {
        return new RgbColor("Violet");
    }

    public static RgbColor getVioletRed() {
        return new RgbColor("VioletRed");
    }

    public static RgbColor getWheat() {
        return new RgbColor("Wheat");
    }

    public static RgbColor getWhiteSmoke() {
        return new RgbColor("WhiteSmoke");
    }

    public static RgbColor getYellowGreen() {
        return new RgbColor("YellowGreen");
    }

}
