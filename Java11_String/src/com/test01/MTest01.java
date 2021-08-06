package com.test01;

public class MTest01 {
	
	private static String str  = "The String class represents character strings.";
	
	public static void main(String[] args) {
		String s = "Hello";
		System.out.println(s + "World!");
		System.out.println(s);
		
		s = 1 + 2 + s;
		System.out.println(s);
		s = s + 1 + 2;
		System.out.println(s);
		// String concatenation -> String과 다른 타입이 만나면, String이 된다.
		
		
		String a = "123";
		a = 1 + a;
		System.out.println(a);
		
		// 1. str의 길이
		prn01();
		
		// 2. str 전체를 대문자로 바꿔서 출력하자.
		prn02();
		
		//3. str 전체를 소문자로 바꿔서 출력하자.
		prn03();
		
		// 4. str에서 첫 번째 c의 인덱스를 출력하자.
		prn04();
		
		// 5. "class" 를 "java"로 바꿔서 출력하자.
		prn05();
		
		// 6. "character" 를 찾아서 대문자로 바꿔서, 전체 출력
		prn06();
		
		// 7. str을 char[]로 출력하되, 'c' 만 출력하자.
		//    그리고 c의 총 갯수를 출력
		prn07();
		
		// 8. str을 char[]로 출력하되, 대문자만 출력
		//    그리고 대문자의 갯수를 출력
		prn08();
		
		// 9. str안에 있는 모든 공백을 제거 후 출력
		prn09();
		
		// 10. 전체를 거꾸로
		prn10();
		
		
	}

	private static void prn10() {
		// 1. char[]
		// 2. 마지막부터 ~ 처음까지 반복
		int index = 0;
		char[] ch = new char[str.length()];
		
		for (int i = str.length()-1; i >= 0; i--) {
			ch[i] = str.charAt(index);
			index++;
		}
		System.out.println(ch);
		
	}

	private static void prn09() {
		System.out.println(str.trim());
		System.out.println(str.replace(" ", ""));
		System.out.println(str.replaceAll(" ", ""));
		
	}

	private static void prn08() {
		char[] ch = str.toCharArray();
		int cnt = 0;
		
		for (int i = 0; i < ch.length; i++) {
			if (Character.isUpperCase(ch[i])) {
				System.out.printf("%c ", ch[i]);
				cnt++;
			}
		}
		System.out.println("\n대문자의 총 갯수 : " + cnt);
	}

	private static void prn07() {
		char[] ch = str.toCharArray();
		int cnt = 0;
		
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] == 'c') {
				System.out.printf("%c ", ch[i]);
				cnt++;
			}
		}
		
		System.out.println("\nc의 총 갯수 : " + cnt);
		
	}

	private static void prn06() {
		String target = "character";
		
		int start = str.indexOf(target);
		int end = start + target.length();
		
		// method chaining
		String upper = str.substring(start, end).toUpperCase();
		System.out.println(str.replace(target, upper));
		
	}

	private static void prn05() {
		String target = "class";
		String replacement = "java";
		
		System.out.println(str.replace(target, replacement));
	}

	private static void prn04() {
		System.out.println(str.indexOf('c'));
	
		
	}

	private static void prn03() {
		System.out.println(str.toLowerCase());
		
	}

	private static void prn02() {
		System.out.println(str.toUpperCase());
		
	}

	private static void prn01() {
		System.out.println(str.length());
		
	}

}
