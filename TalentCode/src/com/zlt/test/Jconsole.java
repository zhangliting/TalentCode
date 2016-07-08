package com.zlt.test;

public class Jconsole {

	public static void main(String[] args) {
		while (true) {
//			String a = new String("abc");
			 String a = "abc";
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			a = null;
		}
	}

}
