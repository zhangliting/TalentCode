package imooc.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class FileDemo {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// File file = new File("C:\\imooc");
		// if (!file.exists()) {
		// file.mkdirs();
		// }
		// File file2 = new File("C:\\imooc\\test.txt");
		// if (!file2.exists()) {
		// file2.createNewFile();
		// }
		//
		// System.out.println(file.getName());

		// FileOutputStream fileOutputStream = new
		// FileOutputStream("demo/out.dat");
		// fileOutputStream.write('A');
		// fileOutputStream.write('B');
		// fileOutputStream.write(10);
		// fileOutputStream.write("中国".getBytes());
		// fileOutputStream.close();
		// IOUtil.printHex("demo/out.dat");

		// DataOutputStream dataOutputStream = new DataOutputStream(new
		// FileOutputStream("demo/dos.dat"));
		// dataOutputStream.writeInt(10);
		// dataOutputStream.writeInt(-10);
		// dataOutputStream.writeLong(10l);
		// dataOutputStream.writeDouble(10.5);
		// dataOutputStream.writeUTF("中国");
		// dataOutputStream.flush();
		// dataOutputStream.close();
		// IOUtil.printHex("demo/dos.dat");
		//
		// System.out.println("--------------------");
		// DataInputStream dataInputStream = new DataInputStream(new
		// FileInputStream("demo/dos.dat"));
		// System.out.println(dataInputStream.readInt());

		// FileInputStream fileInputStream = new
		// FileInputStream("demo/file.txt");
		// InputStreamReader inputStreamReader = new
		// InputStreamReader(fileInputStream, "utf-8");
		// FileOutputStream fileOutputStream = new
		// FileOutputStream("demo/file_out.txt");
		// OutputStreamWriter outputStreamWriter = new
		// OutputStreamWriter(fileOutputStream, "utf-8");
		// char[] buffer = new char[8 * 1024];
		// int c;
		// while ((c = inputStreamReader.read(buffer, 0, buffer.length)) != -1)
		// {
		// String s = new String(buffer, 0, c);
		// System.out.println(s);
		// outputStreamWriter.write(buffer, 0, c);
		// outputStreamWriter.flush();
		// }
		// inputStreamReader.close();
		// outputStreamWriter.close();

		// FileReader fileReader = new FileReader("demo/file.txt");
		// FileWriter fileWriter = new FileWriter("demo/file2.txt");
		// char[] buffer = new char[2 * 1024];
		// int c;
		// while ((c = fileReader.read(buffer, 0, buffer.length)) != -1) {
		// fileWriter.write(buffer, 0, c);
		// fileWriter.flush();
		// }
		// fileReader.close();
		// fileWriter.close();

		// BufferedReader bufferedReader = new BufferedReader(
		// new InputStreamReader(new FileInputStream("demo/file.txt"),
		// "utf-8"));
		// BufferedWriter bufferedWriter = new BufferedWriter(
		// new OutputStreamWriter(new FileOutputStream("demo/file3.txt"),
		// "utf-8"));
		// String line;
		// while ((line = bufferedReader.readLine()) != null) {
		// System.out.println(line);
		// bufferedWriter.write(line);
		// bufferedWriter.newLine();
		// bufferedWriter.flush();
		// }
		//
		// bufferedReader.close();
		// bufferedWriter.close();

		String file = "demo/obj.dat";
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
		Student student = new Student("zhangliting", 25);
		objectOutputStream.writeObject(student);
		objectOutputStream.flush();
		objectOutputStream.close();

		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
		Student student2 = (Student) objectInputStream.readObject();
		System.out.println(student2);

	}

}
