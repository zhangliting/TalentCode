package imooc.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

/**
 * @author lz10297
 *
 */
public class RafDemo {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		File demo = new File("demo");
		if (!demo.exists()) {
			demo.mkdirs();
		}
		File file = new File(demo, "raf.dat");
		if (file.exists()) {
			file.delete();
		}
		file.createNewFile();

		RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
		randomAccessFile.write('A');
		randomAccessFile.write('B');
		System.out.println(randomAccessFile.getFilePointer());
		int i = 0x7fffffff;
		// randomAccessFile.write(i >>> 24);
		// randomAccessFile.write(i >>> 16);
		// randomAccessFile.write(i >>> 8);
		// randomAccessFile.write(i);
		// System.out.println(randomAccessFile.getFilePointer());

		randomAccessFile.writeInt(i);

		String string = "中";
		randomAccessFile.write(string.getBytes("utf-8"));

		randomAccessFile.seek(0);
		byte[] buf = new byte[(int) randomAccessFile.length()];
		randomAccessFile.read(buf);

		System.out.println(Arrays.toString(buf));
		
		String s1 = new String(buf, "utf-8");
		System.out.println(s1);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
