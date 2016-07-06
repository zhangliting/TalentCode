package imooc.io;

import java.io.File;

public class FileUtil {

	public static void main(String[] args) throws Exception {
		File file = new File("C:/imooc");
		listDirectory(file);
	}

	public static void listDirectory(File dir) throws Exception {
		if (!dir.exists()) {
			throw new IllegalArgumentException("dir:" + dir + "not existed!");
		}
		if (!dir.isDirectory()) {
			throw new IllegalArgumentException("dir:" + dir + "not a dir!");
		}
		File[] files2 = dir.listFiles();
		if (files2 == null)
			return;
		for (File file : files2) {
			if (file.isDirectory()) {
				listDirectory(file.getAbsoluteFile());
			} else {
				System.out.println(file.getAbsolutePath());
			}
		}
	}
}
