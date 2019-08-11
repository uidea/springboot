package com.springboot;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {
	public static void main(String[] args) {
		System.out.println("123");
		System.out.println("123");
		System.out.println("123");
		//method();
		//moveZero();
		getNum();
		// HashMap<String, String> map = new HashMap<>();
		// Hashtable<String, String> map2 = new Hashtable<>();
		// map.put(null, null);
		// map2.put(null, null);
		// System.out.println("-----线程开始-----");
		// Queue<String> queue = new SynchronousQueue<String>();
		// queue.add("北京");
		// queue.add("上海");
		// queue.add("广州");
		// queue.add("深圳");
		// queue.add("西安");
		// queue.add("宝鸡");
		// Runnable runnable = new Runnable() {
		// @Override
		// public void run() {
		// try {
		// System.out.println("中斷之前");
		// Thread.sleep(5000);
		// System.out.println("正在执行线程:" + Thread.currentThread().getName());
		//
		// } catch (InterruptedException e) {
		// System.out.println("中斷");
		// }
		//
		// };
		// };
		// Thread thread = new Thread(runnable);
		// thread.start();
		// try {
		// Thread.sleep(2000);
		// thread.interrupt();
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// System.out.println("-----结束分割线-----");
	}

	public static void method() {
		char[] ch = { 'h', 'e', 'l', 'l', 'o' };
		for (int i = 0; i < ch.length >> 1; i++) {
			char temp = ch[ch.length - 1 - i];
			ch[ch.length - 1 - i] = ch[i];
			ch[i] = temp;
		}
		for (char c : ch) {
			System.out.println(c);
		}
	}
	public static void moveZero() {
		int[] array = {10,3,1,10,5};
		String temp = "";
		for(int i:array) {
			if(i != 0) {
				temp+=i;
			}
		}
		int t = array.length - temp.length();
		for(int i = 0;i<t;i++) {
			temp += 0;
		}
		for(char c:temp.toCharArray()) {
			System.out.print(c);
		}
	}
	public static void getNum() {
		String str = "ABC124G03";
		Pattern pattern = Pattern.compile("[^0-9]");
		Matcher m = pattern.matcher(str);
		System.out.println(m.replaceAll(""));
	}

}
