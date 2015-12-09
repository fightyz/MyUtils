package org.esec.mcg.utils;

import java.io.FileInputStream;
import java.io.File;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 以File为操作对象的工具类
 */
public final class FileUtil {
	/**
	 * 将一个File实例转换成一个字节数组
	 * 主要可用于：将证书转换成字节数组
	 */
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