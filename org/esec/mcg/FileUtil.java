//package org.esec.mcg.utils;

import java.io.FileInputStream;
import java.io.File;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public final class FileUtil {
	public static byte[] FileToByteArray(File file) {
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(file);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

		int i;
		try {
			while((i = fileInputStream.read()) != -1) {
				byteArrayOutputStream.write(i);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}

		byte result[] = byteArrayOutputStream.toByteArray();
		try {
			fileInputStream.close();
			byteArrayOutputStream.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}