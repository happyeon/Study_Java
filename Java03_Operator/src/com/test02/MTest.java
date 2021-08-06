package com.test02;

public class MTest {
	
	public static void main(String[] args) {
		FruitBasket bananaBasket = new FruitBasket();
		bananaBasket.basketSetting("바나나", 10);
		bananaBasket.fruitCount = 50;
		System.out.println(bananaBasket.fruitCount);
		
		FruitBasket.basketSize = 100;
		
		System.out.println(bananaBasket.basketSize);
		
		// FruitBasket.FruitCount = 30;  -> static에서 non-static 안됨
		
		FruitBasket appleBasket = new FruitBasket();
		appleBasket.basketSetting("사과", 30);
		System.out.println(appleBasket.fruitCount);
		System.out.println(appleBasket.basketSize);
	}

}
