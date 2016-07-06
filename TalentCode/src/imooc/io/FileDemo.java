package imooc.io;

import java.io.File;
import java.io.IOException;

public class FileDemo {

	public static void main(String[] args) throws IOException {
		File file = new File("C:\\imooc");
		if (!file.exists()) {
			file.mkdirs();
		}
		File file2 = new File("C:\\imooc\\test.txt");
		if (!file2.exists()) {
			file2.createNewFile();
		}
		
		System.out.println(file.getName());
	}

}
