
package com.dynamicpdf.api;

import java.io.ByteArrayInputStream;
import java.io.IOException;


class DataStreamByteReader {
	private ByteArrayInputStream byteStream = null;
	private int length = 0;

	DataStreamByteReader(byte[] bytes) {
		this.byteStream = new ByteArrayInputStream(bytes);
		this.length = byteStream.available();
		this.byteStream.mark(0);
	}

	int read() {
		try {
			return this.byteStream.read();
		} catch(Exception e) {
			e.printStackTrace(System.err);
			return -1;
		}
	}

	int getFilePointer() {
		return this.length - this.byteStream.available();
	}

	void seek(int pos) {
		this.byteStream.reset();
		this.byteStream.skip(pos);
	}

	int skip(int pos) {
		return (int)this.byteStream.skip(pos);
	}

	int length() {
		return this.length;
	}

	int available() {
		return this.byteStream.available();
	}

	int read(byte[] tmp, int off, int len) {
		return this.byteStream.read(tmp, off, len);
	}

	void close() {
		try {
			this.byteStream.close(); // Closing a ByteArrayInputStream has no effect.
			this.byteStream = null; // So point the object to null.
		} catch(IOException e){
			e.printStackTrace(System.err);
		}
	}
}
