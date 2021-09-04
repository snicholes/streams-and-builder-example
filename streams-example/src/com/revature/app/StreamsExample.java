package com.revature.app;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamsExample {

	public static void main(String[] args) {
		List<Food> foodList = getLotsOfFood();
		
		List<Food> upchargedFruits = foodList.stream()
				.filter(food -> food.getType().toString().equals("FRUIT"))
				.map(food -> {
					food.setPrice(food.getPrice()+1.0);
					return food;
				})
				.collect(Collectors.toList());
		
		System.out.println(upchargedFruits);
		
		List<Type> foodTypes = foodList.stream()
				.map(Food::getType)
				.distinct()
				.collect(Collectors.toList());
		
		System.out.println(foodTypes);
		
		long vegetables = foodList.stream()
				.filter(food -> food.getType().equals(Type.VEGETABLE))
				.count();
		
		System.out.println("Vegetables: " + vegetables);
		
		Map<Type, List<Food>> typeGroups = foodList.stream()
				.collect(Collectors.groupingBy(food -> food.getType()));
		
		for (Type type : typeGroups.keySet()) {
			System.out.println(type + ": " + typeGroups.get(type));
		}
		
		Map<Type, Long> typeCounts = foodList.stream()
				.collect(Collectors.groupingBy(food -> food.getType(), Collectors.counting()));
		
		System.out.println(typeCounts);
		
		foodList.stream()
				.filter(food -> food.getType().equals(Type.SNACK))
				.forEach(food -> {food.setPrice(food.getPrice()+1000.0);});
		
		System.out.println(foodList);
	}
	
	private static List<Food> getLotsOfFood() {
		List<Food> foodList = new LinkedList<>();
		
		foodList.add(new Food("potato", Type.VEGETABLE, 0.3, 100));
		foodList.add(new Food("tomato", Type.VEGETABLE, 0.8, 40));
		foodList.add(new Food("mango", Type.FRUIT, 2.1, 30));
		foodList.add(new Food("pineapple", Type.FRUIT, 1.89, 12));
		foodList.add(new Food("goldenberry", Type.FRUIT, 4.99, 2));
		foodList.add(new Food("chips", Type.SNACK, 1.0, 20));
		foodList.add(new Food("cookies", Type.SNACK, 1.3, 2));
		foodList.add(new Food("popcorn", Type.SNACK, 1.15, 8));
		foodList.add(new Food("macaroni", Type.GRAIN, 2.5, 24));
		foodList.add(new Food.Builder("carrot", Type.VEGETABLE)
				.quantity(5)
				.price(.8)
				.build());
		
		return foodList;
	}

}
