package imooc.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author lz10297
 *
 */
public class IOUtil {

	public static void main(String[] args) throws IOException {
		// printHexByByteArray("demo/raf.dat");
		copyFileByBuffer(new File("demo/raf.dat"), new File("demo/raf_copy.dat"));
	}

	/**
	 * @param fileName
	 * @throws FileNotFoundException
	 */
	public static void printHex(String fileName) throws IOException {
		FileInputStream fileInputStream = new FileInputStream(fileName);
		int b;
		int i = 1;
		while ((b = fileInputStream.read()) != -1) {
			if (b <= 0xf) {
				System.out.print("0" + b + " ");
			} else {
				System.out.print(Integer.toHexString(b) + " ");
			}
			if (i++ % 10 == 0) {
				System.out.println();
			}
		}
		fileInputStream.close();
	}

	/**
	 * @param fileName
	 * @throws IOException
	 */
	public static void printHexByByteArray(String fileName) throws IOException {
		FileInputStream fileInputStream = new FileInputStream(fileName);
		byte[] buf = new byte[20 * 1024];
		int bytes = -1;
		while ((bytes = fileInputStream.read(buf, 0, buf.length)) != -1) {
			for (int i = 0; i < bytes; i++) {
				System.out.print(Integer.toHexString(buf[i] & 0xff) + " ");
				if ((i + 1) % 10 == 0) {
					System.out.println();
				}
			}
		}
		fileInputStream.close();
	}

	public static void copyFile(File srcFile, File destFile) throws IOException {
		if (!srcFile.exists()) {
			throw new IllegalArgumentException("File not exists!");
		}
		if (!srcFile.isFile()) {
			throw new IllegalArgumentException("Not a File!");
		}
		FileInputStream fileInputStream = new FileInputStream(srcFile);
		FileOutputStream fileOutputStream = new FileOutputStream(destFile);

		byte[] buf = new byte[20 * 1024];
		int bytes = -1;
		while ((bytes = fileInputStream.read(buf, 0, buf.length)) != -1) {
			fileOutputStream.write(buf, 0, bytes);
			fileOutputStream.flush();
		}
		fileInputStream.close();
		fileOutputStream.close();

	}

	public static void copyFileByBuffer(File srcFile, File destFile) throws IOException {
		if (!srcFile.exists()) {
			throw new IllegalArgumentException("File not exists!");
		}
		if (!srcFile.isFile()) {
			throw new IllegalArgumentException("Not a File!");
		}
		BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(srcFile));
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(destFile));

		int c;
		while ((c = bufferedInputStream.read()) != -1) {
			bufferedOutputStream.write(c);
			bufferedOutputStream.flush();
		}
		bufferedInputStream.close();
		bufferedOutputStream.close();

	}

}
