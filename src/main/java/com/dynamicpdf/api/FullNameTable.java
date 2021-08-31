package com.dynamicpdf.api;

import java.io.UnsupportedEncodingException;

class FullNameTable {

	private String fullFontName = "";

	private byte[] data;
	private byte[] tableDirectory;

	FullNameTable(DataStreamByteReader reader, byte[] tableDirectory, int position) {
		if (tableDirectory != null) {
			this.tableDirectory = tableDirectory;

			int intOffset = readULong(tableDirectory, position + 8);
			int intLength = readULong(tableDirectory, position + 12);

			this.data = new byte[intLength];

			reader.seek(intOffset);
			reader.read(this.data, 0, intLength);
		}

		int dataStart = readUShort(4);
		int headerStart = 6;
		int headerEnd = (readUShort(2) * 12);

		for (int i = headerStart; i < headerEnd; i += 12) {
			if (readUShort(i + 6) == 4) //4 is the Name ID for Full font name 
			{
				if (readUShort(i) == 3 && readUShort(i + 2) == 1 && readUShort(i + 4) == 0x0409) //3 for PlatForm ID, 1 for Encoding ID and 0x0409 Language ID for English(United States)
				{
					try {
						fullFontName = new String(this.data, dataStart + readUShort(i + 10), readUShort(i + 8), "UTF-16BE").trim().replace(" ", "");
					} catch (UnsupportedEncodingException ex) {

					}
					fullFontName = fullFontName.replace("-", "");
					break;
				}
			}
		}

		if (fullFontName.length() == 0) {
			for (int i = headerStart; i < headerEnd; i += 12) {
				if (readUShort(i + 6) == 4) //4 is the Name ID for Full font name 
				{
					if (readUShort(i) == 3 && readUShort(i + 2) == 0 && readUShort(i + 4) == 0x0409) //3 for PlatForm ID, 0 for Encoding ID and 0x0409 Language ID for English(United States)
					{
						try {
							fullFontName = new String(this.data, dataStart + readUShort(i + 10), readUShort(i + 8), "UTF-16BE").trim().replace(" ", "");
						} catch (UnsupportedEncodingException ex) {

						}
						fullFontName = fullFontName.replace("-", "");
						break;
					}
				}
			}
		}

		this.data = null;
	}

	String getFontName() {
		return fullFontName;
	}

	private int readULong(byte[] data, int index) {
		int intReturn = data[index++] & 0xFF;
		intReturn *= 0x100;
		intReturn += data[index++] & 0xFF;
		intReturn *= 0x100;
		intReturn += data[index++] & 0xFF;
		intReturn *= 0x100;
		intReturn += data[index] & 0xFF;
		return intReturn;
	}

	private int readULong(int index) {
		return readULong(this.data, index);
	}

	private int readUShort(int index) {
		return (int) ((this.data[index++] & 0xFF) << 8 | (this.data[index] & 0xFF));
	}

	private int readUShort1(int index) {
		return (int) (this.data[index++] | this.data[index] << 8);
	}

	private int readShort(int index) {
		return (int) (this.data[index++] << 8 | this.data[index]);
	}

	private int readByte(int index) {
		return this.data[index++];
	}

	private float readFixed(int index) {
		int intInteger = this.data[index++];
		if (intInteger > 127) {
			intInteger -= 256;
		}
		intInteger *= 0x100;
		intInteger += this.data[index++];
		intInteger *= 0x100;
		intInteger += this.data[index++];
		intInteger *= 0x100;
		intInteger += this.data[index];
		return intInteger / 0x10000;
	}

	private short readFWord(int index) {
		short intReturn = this.data[index++];
		if (intReturn > 127) {
			intReturn -= 256;
		}
		intReturn *= 0x100;
		intReturn += this.data[index];
		return intReturn;
	}

}
