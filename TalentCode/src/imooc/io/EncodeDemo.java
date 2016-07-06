package imooc.io;

import java.io.UnsupportedEncodingException;

public class EncodeDemo {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String s = "慕课ABC";
		byte[] byte1 = s.getBytes("utf-8");// 中3英1
		for (byte b : byte1) {
			System.out.print(Integer.toHexString(b & 0xff) + " ");
		}
		System.out.println();
		byte[] byte2 = s.getBytes("gbk");// 中2英1
		for (byte b : byte2) {
			System.out.print(Integer.toHexString(b & 0xff) + " ");
		}
		System.out.println();
		byte[] byte3 = s.getBytes("utf-16be");// 中2英2
		for (byte b : byte3) {
			System.out.print(Integer.toHexString(b & 0xff) + " ");
		}
		System.out.println();
		String str = new String(byte2, "gbk");
		System.out.println(str);
	}

}
