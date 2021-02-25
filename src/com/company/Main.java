package com.company;

import java.text.DecimalFormat;
import java.util.*;


public class Main {
    public static DecimalFormat df = new DecimalFormat("0.00");

    public static void main(String[] args) {
        Assignment_1();
        Stack();
        Assignment_2Queue();
        Assignment3HashTable();
        Assignment3();
    }

    public static void Assignment_1() {

        String[] array = {
                "Computer",
                "Plate",
                "Chair",
                "Girl",
                "Boy",
                "Cat",
                "Dog",
                "Shirt",
                "Determination"};

        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(array));

        int startsWith = 0;
        int endsWith = 0;
        int valuesWithLength5 = 0;
        int CountainingE = 0;
        int substring = 0;

        for (int i = 0; i < arrayList.size(); i++) {

            if (arrayList.get(i).charAt(0) == 'C') {
                startsWith++;
            }

            if (arrayList.get(i).charAt(arrayList.get(i).length() - 1) == 'e') {
                endsWith++;
            }

            if (arrayList.get(i).length() == 5) {
                valuesWithLength5++;
            }

            if (arrayList.get(i).contains("e")) {
                CountainingE++;
            }

            if (arrayList.get(i).contains("te")) {
                substring++;
            }
        }
        System.out.printf("Values are starting with 'C': %d", startsWith);
        System.out.println();
        System.out.printf("Values are ending with 'e':  %d", endsWith);
        System.out.println();
        System.out.printf("Values whit lenght of 5: %d", valuesWithLength5);
        System.out.println();
        System.out.printf("Letter e occours  %d", CountainingE);
        System.out.println();
        System.out.printf("Elements consists of the subString “te” in %d words", substring);
        System.out.println();
        System.out.println(sortList(arrayList));

    }

    public static ArrayList<String> sortList(ArrayList<String> arrayList) {
        ArrayList<String> newlist = new ArrayList<>();
        Collections.sort(arrayList);
        for (String x : arrayList) {
            if (!Character.isDigit(x.charAt(0))) {
                newlist.add(x);
            }
        }
        for (String x : arrayList) {
            if (Character.isDigit(x.charAt(0))) {
                newlist.add(x);
            }
        }

        return newlist;
    }

    public static void Stack() {
        Stack<String> stringsForPalidrome = new Stack<>();
        stringsForPalidrome.push("Mom");
        stringsForPalidrome.push("Was it a car or a cat I saw?");
        stringsForPalidrome.push(" Madam, in Eden, I’m Adam.");
        stringsForPalidrome.push(" Yo, banana boy!");


        System.out.printf("Are those strings a palindrome?" +
                        "Mom: %s   Was it a car or a cat I saw?: %s  " +
                        "Madam, in Eden, I’m Adam.: %s  Yo, banana boy!: %s",
                isPalindrome(stringsForPalidrome.elementAt(0)),
                isPalindrome(stringsForPalidrome.elementAt(1)),
                isPalindrome(stringsForPalidrome.elementAt(2)),
                isPalindrome(stringsForPalidrome.elementAt(3)));
    }

    public static void Assignment_2Queue() {
        System.out.print("Enter any string:");
        Scanner in = new Scanner(System.in);
        String string = in.nextLine();
        Queue queue = new LinkedList();

        String inputString = string.toLowerCase().replaceAll("[^a-z]*", "");
        for (int i = inputString.length() - 1; i >= 0; i--) {
            queue.add(inputString.charAt(i));
        }

        String reverseString = "";

        while (!queue.isEmpty()) {
            reverseString = reverseString + queue.remove();
        }
        if (inputString.equals(reverseString))
            System.out.println("The input String is a palindrome.");
        else
            System.out.println("The input String is not a palindrome.");

    }


    public static boolean isPalindrome(String text) {
        StringBuilder reverse = new StringBuilder();
        String clean = text.toLowerCase().replaceAll("[^a-z]*", "");
        char[] plain = clean.toCharArray();
        for (int i = plain.length - 1; i >= 0; i--) {
            reverse.append(plain[i]);
        }
        return (reverse.toString()).equals(clean);
    }

    public static int under1eur(Map<String, Double> map) {
        int counter = 0;
        for (double price : map.values()) {
            if (price < 1) {
                counter++;
            }
        }
        return counter;
    }

    public static String priceLowest(Map<String, Double> map) {
        String minProduct = null;
        double minPrice = Double.MAX_VALUE;
        for (String product : map.keySet()) {
            double price = map.get(product);
            if (price < minPrice) {
                minProduct = product;
                minPrice = price;
            }
        }
        return minProduct;
    }

    public static String priceLargest(Map<String, Double> map) {
        String maxProduct = null;
        double maxPrice = Double.MIN_VALUE;
        for (String product : map.keySet()) {
            double price = map.get(product);
            if (price > maxPrice) {
                maxProduct = product;
                maxPrice = price;
            }
        }
        return maxProduct;
    }

    public static void sortedHashTable(Hashtable<String, Double> map) {
        map.entrySet().stream()
                .sorted((k1, k2) -> +k1.getValue().compareTo(k2.getValue()))
                .forEach(k -> System.out.print(" " + df.format(k.getValue()) + " = " + k.getKey() + " "));
    }

    public static void sortedHashmap(HashMap<String, Double> map) {
        map.entrySet().stream()
                .sorted((k1, k2) -> +k1.getValue().compareTo(k2.getValue()))
                .forEach(k -> System.out.print(" " + df.format(k.getValue()) + " = " + k.getKey() + " "));
    }

    public static void Assignment3() {
        HashMap<String, Double> products = new HashMap<>();
        products.put("Peanut Butter", 3.89);
        products.put("Bananas", 0.74);
        products.put("Apples", 0.89);
        products.put("Strawberries", 6.87);
        products.put("Salmon", 9.99);
        products.put("Olive oil", 4.39);
        products.put("milk", 0.79);
        products.put("Eggs", 1.49);
        products.put("Cheese", 3.12);

        System.out.format("%d products are under 1 EUR\n" +
                        "%s price is the lowest and %s price is the largest",
                under1eur(products), priceLowest(products), priceLargest(products));


        HashMap<String, Double> moreProducts = new HashMap<>();
        moreProducts.put("Lentils", 2.19);
        moreProducts.put("Peanut Butter", 5.34);
        moreProducts.put("Bread", 0.87);
        moreProducts.put("Chocolate", 2.35);
        moreProducts.put("Smoothie", 1.46);
        moreProducts.put("Macadamia nuts", 3.26);
        moreProducts.put("Butter", 2.89);
        moreProducts.put("Napkins", 0.50);

        products.putAll(moreProducts);
        System.out.println("Merged list:");
        for (Map.Entry list : products.entrySet()) {
            System.out.println(list.getKey() + " " + list.getValue());
        }
        System.out.println("Products in the merged list: " + products.size());

        HashMap<String, Double> productsMerged = new HashMap<>(products);
        moreProducts.forEach((key, value) -> productsMerged.merge(key, value, (v1, v2) -> (v1 + v2) / 2));
        System.out.println("Merged HashMap is: ");
        productsMerged.forEach((key, value) -> System.out.print(" " + key + " = " + df.format(value)));
        System.out.format("\nThere are %d products in merged HashMap \n", productsMerged.size());

        System.out.println("Sorting ascending HashMap: ");
        sortedHashmap(productsMerged);
    }

    public static void Assignment3HashTable() {
        Hashtable<String, Double> products = new Hashtable<>();
        products.put("Peanut Butter", 3.89);
        products.put("Bananas", 0.74);
        products.put("Apples", 0.89);
        products.put("Strawberries", 6.87);
        products.put("Salmon", 9.99);
        products.put("Olive oil", 4.39);
        products.put("milk", 0.79);
        products.put("Eggs", 1.49);
        products.put("Cheese", 3.12);

        System.out.format("Products are under 1 EUR %s \n" +
                        "%s price is the lowest and %s price is the largest",
                under1eur(products), priceLowest(products), priceLargest(products));

        Hashtable<String, Double> moreProducts = new Hashtable<>();
        moreProducts.put("Lentils", 2.19);
        moreProducts.put("Peanut Butter", 5.34);
        moreProducts.put("Bread", 0.87);
        moreProducts.put("Chocolate", 2.35);
        moreProducts.put("Smoothie", 1.46);
        moreProducts.put("Macadamia nuts", 3.26);
        moreProducts.put("Butter", 2.89);
        moreProducts.put("Napkins", 0.50);

        Hashtable<String, Double> productsMerged = new Hashtable<>(products);
        moreProducts.forEach((key, value) -> productsMerged.merge(key, value, (v1, v2) -> (v1 + v2) / 2));
        System.out.println("Merged HashTable is: ");
        productsMerged.forEach((key, value) -> System.out.print(" " + key + " = " + df.format(value)));

        System.out.println("How many products in the merged list? " + productsMerged.size());
        System.out.println("Sorted in ascending order:");
        sortedHashTable(productsMerged);

    }
}



