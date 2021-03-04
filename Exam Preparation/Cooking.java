import java.util.*;

public class Cooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> liquids = new ArrayDeque<>();
        int[] arr1 = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        for (int j : arr1) {
            liquids.add(j);
        }
        Deque<Integer> ingredients = new ArrayDeque<>();
        int[] arr2 = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        for (int i : arr2) {
            ingredients.push(i);
        }
        int breadCunt = 0;
        int cakeCount = 0;
        int fruitPieCount = 0;
        int pastryCount = 0;
        while (!liquids.isEmpty() && !ingredients.isEmpty()) {
            int sum = liquids.peek() + ingredients.peek();
            switch (sum) {
                case 25:
                    liquids.removeFirst();
                    ingredients.removeFirst();
                    breadCunt++;
                    break;
                case 50:
                    liquids.removeFirst();
                    ingredients.removeFirst();
                    cakeCount++;
                    break;
                case 75:
                    liquids.removeFirst();
                    ingredients.removeFirst();
                    pastryCount++;
                    break;
                case 100:
                    liquids.removeFirst();
                    ingredients.removeFirst();
                    fruitPieCount++;
                    break;
                default:
                    liquids.removeFirst();
                    int m = ingredients.pop() + 3;
                    ingredients.push(m);
                    break;
            }
        }
        if (breadCunt > 0 && cakeCount > 0 && fruitPieCount > 0 && pastryCount > 0) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to to cook everything.");
        }
        if (liquids.size() > 0) {
            System.out.printf("Liquids left: %s%n", liquids.toString().replaceAll("[\\[\\]]", ""));
        } else {
            System.out.println("Liquids left: none");
        }
        if (ingredients.size() > 0) {
            System.out.printf("Ingredients left: %s%n", ingredients.toString().replaceAll("[\\[\\]]", ""));
        } else {
            System.out.println("Ingredients left: none");
        }
        System.out.println("Bread: " + breadCunt);
        System.out.println("Cake: " + cakeCount);
        System.out.println("Fruit Pie: " + fruitPieCount);
        System.out.println("Pastry: " + pastryCount);
    }
}