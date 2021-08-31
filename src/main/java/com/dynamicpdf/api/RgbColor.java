package com.dynamicpdf.api;

/**
 * Represents an RGB color.
 */
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

	/**
	 * Initializes a new instance of the <code>RgbColor</code> class.
	 * @param red The red intensity.
	 * @param green The green intensity.
	 * @param blue The blue intensity.
	 */
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

	/**
	 * Gets the color red.
	 * @return The color red.
	 */
	public static RgbColor getRed() {
		return new RgbColor("Red");
	}

	/**
	 * Gets the color blue.
	 * @return The color blue.
	 */
	public static RgbColor getBlue() {
		return new RgbColor("Blue");
	}

	/**
	 * Gets the color green.
	 * @return The color green.
	 */
	public static RgbColor getGreen() {
		return new RgbColor("Green");
	}

	/**
	 * Gets the color black.
	 * @return The color black.
	 */
	public static RgbColor getBlack() {
		return new RgbColor("Black");
	}

	/**
	 * Gets the color silver.
	 * @return The color silver.
	 */
	public static RgbColor getSilver() {
		return new RgbColor("Silver");
	}

	/**
	 * Gets the color dark gray.
	 * @return The color dark gray.
	 */
	public static RgbColor getDarkGray() {
		return new RgbColor("DarkGray");
	}

	/**
	 * Gets the color gray.
	 * @return The color gray.
	 */
	public static RgbColor getGray() {
		return new RgbColor("Gray");
	}

	/**
	 * Gets the color dim gray.
	 * @return The color dim gray.
	 */
	public static RgbColor getDimGray() {
		return new RgbColor("DimGray");
	}

	/**
	 * Gets the color white.
	 * @return The color white.
	 */
	public static RgbColor getWhite() {
		return new RgbColor("White");
	}

	/**
	 * Gets the color lime.
	 * @return The color lime.
	 */
	public static RgbColor getLime() {
		return new RgbColor("Lime");
	}

	/**
	 * Gets the color aqua.
	 * @return The color aqua.
	 */
	public static RgbColor getAqua() {
		return new RgbColor("Aqua");
	}

	/**
	 * Gets the color purple.
	 * @return The color purple.
	 */
	public static RgbColor getPurple() {
		return new RgbColor("Purple");
	}

	/**
	 * Gets the color cyan.
	 * @return The color cyan.
	 */
	public static RgbColor getCyan() {
		return new RgbColor("Cyan");
	}

	/**
	 * Gets the color magenta.
	 * @return The color magenta.
	 */
	public static RgbColor getMagenta() {
		return new RgbColor("Magenta");
	}

	/**
	 * Gets the color yellow. 
	 * @return The color yellow.
	 */
	public static RgbColor getYellow() {
		return new RgbColor("Yellow");
	}

	/**
	 * Gets the color alice blue. 
	 * @return The color alice blue.
	 */
	public static RgbColor getAliceBlue() {
		return new RgbColor("AliceBlue");
	}

	/**
	 * Gets the color antique white.
	 * @return The color antique white.
	 */
	public static RgbColor getAntiqueWhite() {
		return new RgbColor("AntiqueWhite");
	}

	/**
	 * Gets the color aquamarine.
	 * @return The color aquamarine.
	 */
	public static RgbColor getAquamarine() {
		return new RgbColor("Aquamarine");
	}

	/**
	 * Gets the color azure.
	 * @return The color azure.
	 */
	public static RgbColor getAzure() {
		return new RgbColor("Azure");
	}

	/**
	 * Gets the color beige.
	 * @return The color beige.
	 */
	public static RgbColor getBeige() {
		return new RgbColor("Beige");
	}

	/**
	 * Gets the color bisque.
	 * @return The color bisque.
	 */
	public static RgbColor getBisque() {
		return new RgbColor("Bisque");
	}

	/**
	 * Gets the color blanched almond.
	 * @return The color blanched almond.
	 */
	public static RgbColor getBlanchedAlmond() {
		return new RgbColor("BlanchedAlmond");
	}

	/**
	 * Gets the color blue violet.
	 * @return The color blue violet.
	 */
	public static RgbColor getBlueViolet() {
		return new RgbColor("BlueViolet");
	}

	/**
	 * Gets the color brown.
	 * @return The color brown.
	 */
	public static RgbColor getBrown() {
		return new RgbColor("Brown");
	}

	/**
	 * Gets the color burly wood.
	 * @return The color  burly wood.
	 */
	public static RgbColor getBurlyWood() {
		return new RgbColor("BurlyWood");
	}

	/**
	 * Gets the color cadet blue.
	 * @return The color cadet blue.
	 */
	public static RgbColor getCadetBlue() {
		return new RgbColor("CadetBlue");
	}

	/**
	 * Gets the color chartreuse.
	 * @return The color chartreuse.
	 */
	public static RgbColor getChartreuse() {
		return new RgbColor("Chartreuse");
	}

	/**
	 * Gets the color chocolate.
	 * @return The color chocolate.
	 */
	public static RgbColor getChocolate() {
		return new RgbColor("Chocolate");
	}

	/**
	 * Gets the color coral
	 * @return The color coral.
	 */
	public static RgbColor getCoral() {
		return new RgbColor("Coral");
	}

	/**
	 * Gets the color cornflower blue.
	 * @return The color cornflower blue.
	 */
	public static RgbColor getCornflowerBlue() {
		return new RgbColor("CornflowerBlue");
	}

	/**
	 * Gets the color cornsilk.
	 * @return The color cornsilk.
	 */
	public static RgbColor getCornsilk() {
		return new RgbColor("Cornsilk");
	}

	/**
	 * Gets the color crimson.
	 * @return The color crimson.
	 */
	public static RgbColor getCrimson() {
		return new RgbColor("Crimson");
	}

	/**
	 * Gets the color dark blue.
	 * @return The color dark blue.
	 */
	public static RgbColor getDarkBlue() {
		return new RgbColor("DarkBlue");
	}

	/**
	 * Gets the color dark cyan.
	 * @return The color dark cyan.
	 */
	public static RgbColor getDarkCyan() {
		return new RgbColor("DarkCyan");
	}

	/**
	 * Gets the color dark golden rod.
	 * @return The color golden rod.
	 */
	public static RgbColor getDarkGoldenRod() {
		return new RgbColor("DarkGoldenRod");
	}

	/**
	 * Gets the color dark green.
	 * @return The color dark green.
	 */
	public static RgbColor getDarkGreen() {
		return new RgbColor("DarkGreen");
	}

	/**
	 * Gets the color dark khaki.
	 * @return The color dark khaki.
	 */
	public static RgbColor getDarkKhaki() {
		return new RgbColor("DarkKhaki");
	}

	/**
	 * Gets the color dark magenta.
	 * @return The color dark magenta.
	 */
	public static RgbColor getDarkMagenta() {
		return new RgbColor("DarkMagenta");
	}

	/**
	 * Gets the color dark olive green.
	 * @return The color dark olive green.
	 */
	public static RgbColor getDarkOliveGreen() {
		return new RgbColor("DarkOliveGreen");
	}

	/**
	 * Gets the color dark orange.
	 * @return The color dark orange.
	 */
	public static RgbColor getDarkOrange() {
		return new RgbColor("DarkOrange");
	}

	/**
	 * Gets the color dark orchid.
	 * @return The color dark orchid.
	 */
	public static RgbColor getDarkOrchid() {
		return new RgbColor("DarkOrchid");
	}

	/**
	 * Gets the color dark red.
	 * @return The color dark red.
	 */
	public static RgbColor getDarkRed() {
		return new RgbColor("DarkRed");
	}

	/**
	 * Gets the color dark salmon.
	 * @return The color dark salmon.
	 */
	public static RgbColor getDarkSalmon() {
		return new RgbColor("DarkSalmon");
	}

	/**
	 * Gets the color dark sea green.
	 * @return The color dark sea green.
	 */
	public static RgbColor getDarkSeaGreen() {
		return new RgbColor("DarkSeaGreen");
	}

	/**
	 * Gets the color dark slate blue.
	 * @return The color dark slate blue.
	 */
	public static RgbColor getDarkSlateBlue() {
		return new RgbColor("DarkSlateBlue");
	}

	/**
	 * Gets the color dark slate gray.
	 * @return The color dark slate gray.
	 */
	public static RgbColor getDarkSlateGray() {
		return new RgbColor("DarkSlateGray");
	}

	/**
	 * Gets the color dark turquoise.
	 * @return The color dark turquoise.
	 */
	public static RgbColor getDarkTurquoise() {
		return new RgbColor("DarkTurquoise");
	}

	/**
	 * Gets the color dark violet.
	 * @return The color dark violet.
	 */
	public static RgbColor getDarkViolet() {
		return new RgbColor("DarkViolet");
	}

	/**
	 * Gets the color deep pink.
	 * @return The color deep pink.
	 */
	public static RgbColor getDeepPink() {
		return new RgbColor("DeepPink");
	}

	/**
	 * Gets the color deep sky blue.
	 * @return The color  deep sky blue.
	 */
	public static RgbColor getDeepSkyBlue() {
		return new RgbColor("DeepSkyBlue");
	}

	/**
	 * Gets the color dodger blue.
	 * @return The color dodger blue.
	 */
	public static RgbColor getDodgerBlue() {
		return new RgbColor("DodgerBlue");
	}

	/**
	 * Gets the color feldspar.
	 * @return The color feldspar.
	 */
	public static RgbColor getFeldspar() {
		return new RgbColor("Feldspar");
	}

	/**
	 * Gets the color fire brick.
	 * @return The color fire brick.
	 */
	public static RgbColor getFireBrick() {
		return new RgbColor("FireBrick");
	}

	/**
	 * Gets the color floral white.
	 * @return The color floral white.
	 */
	public static RgbColor getFloralWhite() {
		return new RgbColor("FloralWhite");
	}

	/**
	 * Gets the color forest green.
	 * @return The color forest green.
	 */
	public static RgbColor getForestGreen() {
		return new RgbColor("ForestGreen");
	}

	/**
	 * Gets the color fuchsia.
	 * @return The color fuchsia.
	 */
	public static RgbColor getFuchsia() {
		return new RgbColor("Fuchsia");
	}

	/**
	 * Gets the color ghost white.
	 * @return The color ghost white.
	 */
	public static RgbColor getGhostWhite() {
		return new RgbColor("GhostWhite");
	}

	/**
	 * Gets the color gold.
	 * @return The color gold.
	 */
	public static RgbColor getGold() {
		return new RgbColor("Gold");
	}

	/**
	 * Gets the color golden rod.
	 * @return The color golden rod.
	 */
	public static RgbColor getGoldenRod() {
		return new RgbColor("GoldenRod");
	}

	/**
	 * Gets the color golden yellow.
	 * @return The color golden yellow.
	 */
	public static RgbColor getGreenYellow() {
		return new RgbColor("GreenYellow");
	}

	/**
	 * Gets the color honey dew.
	 * @return The color honey dew.
	 */
	public static RgbColor getHoneyDew() {
		return new RgbColor("HoneyDew");
	}

	/**
	 * Gets the color hot pink.
	 * @return The color hot pink.
	 */
	public static RgbColor getHotPink() {
		return new RgbColor("HotPink");
	}

	/**
	 * Gets the color indian red.
	 * @return The color indian red.
	 */
	public static RgbColor getIndianRed() {
		return new RgbColor("IndianRed");
	}

	/**
	 * Gets the color indigo.
	 * @return The color indigo.
	 */
	public static RgbColor getIndigo() {
		return new RgbColor("Indigo");
	}

	/**
	 * Gets the color ivory.
	 * @return The color ivory.
	 */
	public static RgbColor getIvory() {
		return new RgbColor("Ivory");
	}

	/**
	 * Gets the color khaki.
	 * @return The color khaki.
	 */
	public static RgbColor getKhaki() {
		return new RgbColor("Khaki");
	}

	/**
	 * Gets the color lavender.
	 * @return The color lavender.
	 */
	public static RgbColor getLavender() {
		return new RgbColor("Lavender");
	}

	/**
	 * Gets the color lavender blush.
	 * @return The color lavender blush.
	 */
	public static RgbColor getLavenderBlush() {
		return new RgbColor("LavenderBlush");
	}

	/**
	 * Gets the color lawn Green.
	 * @return The color lawn Green.
	 */
	public static RgbColor getLawnGreen() {
		return new RgbColor("LawnGreen");
	}

	/**
	 * Gets the color lemon chiffon.
	 * @return The color lemon chiffon.
	 */
	public static RgbColor getLemonChiffon() {
		return new RgbColor("LemonChiffon");
	}

	/**
	 * Gets the color light blue.
	 * @return The color light blue.
	 */
	public static RgbColor getLightBlue() {
		return new RgbColor("LightBlue");
	}

	/**
	 * Gets the color light coral.
	 * @return The color light coral.
	 */
	public static RgbColor getLightCoral() {
		return new RgbColor("LightCoral");
	}

	/**
	 * Gets the color light cyan.
	 * @return The color light cyan.
	 */
	public static RgbColor getLightCyan() {
		return new RgbColor("LightCyan");
	}

	/**
	 * Gets the color light golden rod yellow.
	 * @return The color light golden rod yellow.
	 */
	public static RgbColor getLightGoldenRodYellow() {
		return new RgbColor("LightGoldenRodYellow");
	}

	/**
	 * Gets the color light grey.
	 * @return The color light grey.
	 */
	public static RgbColor getLightGrey() {
		return new RgbColor("LightGrey");
	}

	/**
	 * Gets the color light green.
	 * @return The color light green.
	 */
	public static RgbColor getLightGreen() {
		return new RgbColor("LightGreen");
	}

	/**
	 * Gets the color light pink.
	 * @return The color light pink.
	 */
	public static RgbColor getLightPink() {
		return new RgbColor("LightPink");
	}

	/**
	 * Gets the color light salmon.
	 * @return The color light salmon.
	 */
	public static RgbColor getLightSalmon() {
		return new RgbColor("LightSalmon");
	}

	/**
	 * Gets the color light sea green.
	 * @return The color light sea green.
	 */
	public static RgbColor getLightSeaGreen() {
		return new RgbColor("LightSeaGreen");
	}

	/**
	 * Gets the color light sky blue.
	 * @return The color light sky blue.
	 */
	public static RgbColor getLightSkyBlue() {
		return new RgbColor("LightSkyBlue");
	}

	/**
	 * Gets the color light slate blue.
	 * @return The color light slate blue.
	 */
	public static RgbColor getLightSlateBlue() {
		return new RgbColor("LightSlateBlue");
	}

	/**
	 * Gets the color light slate gray.
	 * @return The color light slate gray.
	 */
	public static RgbColor getLightSlateGray() {
		return new RgbColor("LightSlateGray");
	}

	/**
	 * Gets the color light steel blue.
	 * @return The color light steel blue.
	 */
	public static RgbColor getLightSteelBlue() {
		return new RgbColor("LightSteelBlue");
	}

	/**
	 * Gets the color light yellow.
	 * @return The color light yellow.
	 */
	public static RgbColor getLightYellow() {
		return new RgbColor("LightYellow");
	}

	/**
	 * Gets the color lime green.
	 * @return The color lime green.
	 */
	public static RgbColor getLimeGreen() {
		return new RgbColor("LimeGreen");
	}

	/**
	 * Gets the color linen.
	 * @return The color linen.
	 */
	public static RgbColor getLinen() {
		return new RgbColor("Linen");
	}

	/**
	 * Gets the color maroon.
	 * @return The color maroon.
	 */
	public static RgbColor getMaroon() {
		return new RgbColor("Maroon");
	}

	/**
	 * Gets the color medium aqua marine.
	 * @return The color medium aqua marine.
	 */
	public static RgbColor getMediumAquaMarine() {
		return new RgbColor("MediumAquaMarine");
	}

	/**
	 * Gets the color medium blue.
	 * @return The color medium blue.
	 */
	public static RgbColor getMediumBlue() {
		return new RgbColor("MediumBlue");
	}

	/**
	 * Gets the color medium orchid.
	 * @return The color medium orchid.
	 */
	public static RgbColor getMediumOrchid() {
		return new RgbColor("MediumOrchid");
	}

	/**
	 * Gets the color medium purple.
	 * @return The color medium purple.
	 */
	public static RgbColor getMediumPurple() {
		return new RgbColor("MediumPurple");
	}

	/**
	 * Gets the color medium sea green.
	 * @return The color medium sea green.
	 */
	public static RgbColor getMediumSeaGreen() {
		return new RgbColor("MediumSeaGreen");
	}

	/**
	 * Gets the color medium slate blue.
	 * @return The color medium slate blue.
	 */
	public static RgbColor getMediumSlateBlue() {
		return new RgbColor("MediumSlateBlue");
	}

	/**
	 * Gets the color medium spring green.
	 * @return The color medium spring green.
	 */
	public static RgbColor getMediumSpringGreen() {
		return new RgbColor("MediumSpringGreen");
	}

	/**
	 * Gets the color medium turquoise.
	 * @return The color medium turquoise.
	 */
	public static RgbColor getMediumTurquoise() {
		return new RgbColor("MediumTurquoise");
	}

	/**
	 * Gets the color medium violet red.
	 * @return The color medium violet red.
	 */
	public static RgbColor getMediumVioletRed() {
		return new RgbColor("MediumVioletRed");
	}

	/**
	 * Gets the color midnight blue.
	 * @return The color midnight blue.
	 */
	public static RgbColor getMidnightBlue() {
		return new RgbColor("MidnightBlue");
	}

	/**
	 * Gets the color mint cream.
	 * @return The color mint cream.
	 */
	public static RgbColor getMintCream() {
		return new RgbColor("MintCream");
	}

	/**
	 * Gets the color misty rose.
	 * @return The color misty rose.
	 */
	public static RgbColor getMistyRose() {
		return new RgbColor("MistyRose");
	}

	/**
	 * Gets the color moccasin.
	 * @return The color moccasin.
	 */
	public static RgbColor getMoccasin() {
		return new RgbColor("Moccasin");
	}

	/**
	 * Gets the color navajo white.
	 * @return The color navajo white.
	 */
	public static RgbColor getNavajoWhite() {
		return new RgbColor("NavajoWhite");
	}

	/**
	 * Gets the color navy.
	 * @return The color navy.
	 */
	public static RgbColor getNavy() {
		return new RgbColor("Navy");
	}

	/**
	 * Gets the color old lace.
	 * @return The color old lace.
	 */
	public static RgbColor getOldLace() {
		return new RgbColor("OldLace");
	}

	/**
	 * Gets the color olive.
	 * @return The color olive.
	 */
	public static RgbColor getOlive() {
		return new RgbColor("Olive");
	}

	/**
	 * Gets the color olive drab.
	 * @return The color olive drab.
	 */
	public static RgbColor getOliveDrab() {
		return new RgbColor("OliveDrab");
	}

	/**
	 * Gets the color gainsboro.
	 * @return The color gainsboro.
	 */
	public static RgbColor getGainsboro() {
		return new RgbColor("Gainsboro");
	}

	/**
	 * Gets the color orange.
	 * @return The color orange.
	 */
	public static RgbColor getOrange() {
		return new RgbColor("Orange");
	}

	/**
	 * Gets the color orange red.
	 * @return The color orange red.
	 */
	public static RgbColor getOrangeRed() {
		return new RgbColor("OrangeRed");
	}

	/**
	 * Gets the color orchid.
	 * @return The color orchid.
	 */
	public static RgbColor getOrchid() {
		return new RgbColor("Orchid");
	}

	/**
	 * Gets the color pale golden rod.
	 * @return The color pale golden rod.
	 */
	public static RgbColor getPaleGoldenRod() {
		return new RgbColor("PaleGoldenRod");
	}

	/**
	 * Gets the color pale green.
	 * @return The color pale green.
	 */
	public static RgbColor getPaleGreen() {
		return new RgbColor("PaleGreen");
	}

	/**
	 * Gets the color pale turquoise.
	 * @return The color pale turquoise.
	 */
	public static RgbColor getPaleTurquoise() {
		return new RgbColor("PaleTurquoise");
	}

	/**
	 * Gets the color pale violet red.
	 * @return The color pale violet red.
	 */
	public static RgbColor getPaleVioletRed() {
		return new RgbColor("PaleVioletRed");
	}

	/**
	 * Gets the color papaya whip.
	 * @return The color papaya whip.
	 */
	public static RgbColor getPapayaWhip() {
		return new RgbColor("PapayaWhip");
	}

	/**
	 * Gets the color peach puff.
	 * @return The color peach puff.
	 */
	public static RgbColor getPeachPuff() {
		return new RgbColor("PeachPuff");
	}

	/**
	 * Gets the color peru.
	 * @return The color peru.
	 */
	public static RgbColor getPeru() {
		return new RgbColor("Peru");
	}

	/**
	 * Gets the color pink.
	 * @return The color pink.
	 */
	public static RgbColor getPink() {
		return new RgbColor("Pink");
	}

	/**
	 * Gets the color plum.
	 * @return The color plum.
	 */
	public static RgbColor getPlum() {
		return new RgbColor("Plum");
	}

	/**
	 * Gets the color powder blue.
	 * @return The color powder blue.
	 */
	public static RgbColor getPowderBlue() {
		return new RgbColor("PowderBlue");
	}

	/**
	 * Gets the color rosy brown.
	 * @return The color rosy brown.
	 */
	public static RgbColor getRosyBrown() {
		return new RgbColor("RosyBrown");
	}

	/**
	 * Gets the color royal blue.
	 * @return The color royal blue.
	 */
	public static RgbColor getRoyalBlue() {
		return new RgbColor("RoyalBlue");
	}

	/**
	 * Gets the color saddle brown.
	 * @return The color saddle brown.
	 */
	public static RgbColor getSaddleBrown() {
		return new RgbColor("SaddleBrown");
	}

	/**
	 * Gets the color salmon.
	 * @return The color salmon.
	 */
	public static RgbColor getSalmon() {
		return new RgbColor("Salmon");
	}

	/**
	 * Gets the color sandy brown.
	 * @return The color sandy brown.
	 */
	public static RgbColor getSandyBrown() {
		return new RgbColor("SandyBrown");
	}

	/**
	 * Gets the color sea green.
	 * @return The color sea green.
	 */
	public static RgbColor getSeaGreen() {
		return new RgbColor("SeaGreen");
	}

	/**
	 * Gets the color sea shell.
	 * @return The color sea shell.
	 */
	public static RgbColor getSeaShell() {
		return new RgbColor("SeaShell");
	}

	/**
	 * Gets the color sienna.
	 * @return The color sienna.
	 */
	public static RgbColor getSienna() {
		return new RgbColor("Sienna");
	}

	/**
	 * Gets the color sky blue.
	 * @return The color sky blue.
	 */
	public static RgbColor getSkyBlue() {
		return new RgbColor("SkyBlue");
	}

	/**
	 * Gets the color slate blue.
	 * @return The color slate blue.
	 */
	public static RgbColor getSlateBlue() {
		return new RgbColor("SlateBlue");
	}

	/**
	 * Gets the color slate gray.
	 * @return The color slate gray.
	 */
	public static RgbColor getSlateGray() {
		return new RgbColor("SlateGray");
	}

	/**
	 * Gets the color snow.
	 * @return The color snow.
	 */
	public static RgbColor getSnow() {
		return new RgbColor("Snow");
	}

	/**
	 * Gets the color spring green.
	 * @return The color spring green.
	 */
	public static RgbColor getSpringGreen() {
		return new RgbColor("SpringGreen");
	}

	/**
	 * Gets the color steel blue.
	 * @return The color steel blue.
	 */
	public static RgbColor getSteelBlue() {
		return new RgbColor("SteelBlue");
	}

	/**
	 * Gets the color Tan.
	 * @return The color Tan.
	 */
	public static RgbColor getTan() {
		return new RgbColor("Tan");
	}

	/**
	 * Gets the color teal.
	 * @return The color teal.
	 */
	public static RgbColor getTeal() {
		return new RgbColor("Teal");
	}

	/**
	 * Gets the color thistle.
	 * @return The color thistle.
	 */
	public static RgbColor getThistle() {
		return new RgbColor("Thistle");
	}

	/**
	 * Gets the color tomato.
	 * @return The color tomato.
	 */
	public static RgbColor getTomato() {
		return new RgbColor("Tomato");
	}

	/**
	 * Gets the color turquoise.
	 * @return The color turquoise.
	 */
	public static RgbColor getTurquoise() {
		return new RgbColor("Turquoise");
	}

	/**
	 * Gets the color violet.
	 * @return The color violet.
	 */
	public static RgbColor getViolet() {
		return new RgbColor("Violet");
	}

	/**
	 * Gets the color violet red.
	 * @return The color violet red.
	 */
	public static RgbColor getVioletRed() {
		return new RgbColor("VioletRed");
	}

	/**
	 * Gets the color wheat.
	 * @return The color wheat.
	 */
	public static RgbColor getWheat() {
		return new RgbColor("Wheat");
	}

	/**
	 * Gets the color white smoke.
	 * @return The color white smoke.
	 */
	public static RgbColor getWhiteSmoke() {
		return new RgbColor("WhiteSmoke");
	}

	/**
	 * Gets the color yellow green.
	 * @return The color yellow green.
	 */
	public static RgbColor getYellowGreen() {
		return new RgbColor("YellowGreen");
	}

}
