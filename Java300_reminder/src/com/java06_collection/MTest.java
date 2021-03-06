package com.java06_collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.java04_array.Person;

public class MTest {
	
	public static void main(String[] args) {
		Person p01 = new Person("홍길동", 100);
		Person p02 = new Person("이순신", 43);
		Person p03 = new Person("김선달", 65);
		Person p04 = new Person("유재석", 23);
		Person p05 = new Person("강호동", 66);
		Person p06 = new Person("신동엽", 22);
		
		Person[] people = {p01, p02, p03, p04, p05, p06, p01, new Person("박자바", 30), new Person("김씨샵", 50)};
		
		java.util.List<Person> list = new ArrayList<Person>();
		list.addAll(Arrays.asList(people));
		
		Set<Person> set = new HashSet<Person>();
		set.addAll(Arrays.asList(people));

		// iterator를 사용하여 list 안에 있는 값을 "[age]name" 형태로 출력하자.
		Iterator<Person> listIr = list.iterator();
		while(listIr.hasNext()) {
			Person person = listIr.next();
			System.out.println("[" + person.age + "]" + person.name);
		}
		
		System.out.println("---------------------");
		
		// forEach (향상된 for)
		for (Person p : set) {
			System.out.println("[" + p.age + "]" + p.name);
		}
		
		System.out.println("---------------------");
		
		Map<String, Person> map = new HashMap<String, Person>();
		for (int i = 1; i <= people.length; i++) {
			map.put(i+"", people[i-1]);
		}
		
		// map entry 사용해서 "key : value.name" 형태로 출력
		Set<Entry<String, Person>> entrySet = map.entrySet();
		for (Entry<String, Person> entry : entrySet) {
			System.out.println(entry.getKey() + " : " + entry.getValue().name);
		}
	}

}
// collection : 여러 개의 값을 효과적으로 관리하기 위한 객체