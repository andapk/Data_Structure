package com.company;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public class Main {

    public static void main(String[] args) {
        Assignment_1();
        Assignment_2Stack();
        Assignment_2Queue();
        Assignment2();
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

    public static void Assignment_2Stack() {
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
        BlockingQueue<String> queueforPalidrome = new ArrayBlockingQueue(4);
        queueforPalidrome.add("Mom");
        queueforPalidrome.add("Was it a car or a cat I saw?");
        queueforPalidrome.add(" Madam, in Eden, I’m Adam.");
        queueforPalidrome.add(" Yo, banana boy!");

        for (String sentence : queueforPalidrome) {
            System.out.println(sentence);
            if (isPalindrome(sentence)) {
                System.out.println("This sentence is a palindrome");
            } else {
                System.out.println("This sentence is not a palindrome");
            }
        }
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

    public static void Assignment2() {
        Deque<String> deque = new ArrayDeque<>();
        deque.add("Mom");
        deque.add("Was it a car or a cat I saw?");
        deque.add(" Madam, in Eden, I’m Adam.");
        deque.add(" Yo, banana boy!");

        for (String sentence : deque) {
            System.out.println(sentence);
            if (isPalindrome(sentence)) {
                System.out.println("This sentence is a palindrome");
            } else {
                System.out.println("This sentence is not a palindrome");
            }
        }
    }

    public static void Assignment3() {
        HashMap<Double, String> products = new HashMap<>();
        products.put(3.09, "Peanut Butter");
        products.put(0.73, "Bananas");
        products.put(0.98, "Apples");
        products.put(6.55, "Strawberries");
        products.put(9.99, "Salmon");
        products.put(4.39, "Olive oil");
        products.put(1.57, "Almond milk");
        products.put(1.49, "Eggs");
        products.put(1.99, "Cheese");

        Double minPrice = Collections.min(products.keySet());
        System.out.println("Lowest price: " + products.get(minPrice) + " " + minPrice + " eur");
        Double maxPrice = Collections.max(products.keySet());
        System.out.println("Highest price: " + products.get(maxPrice) + " " + maxPrice + " eur");

        int count = 0; // under 1 eur
        for (Double price : products.keySet()) {
            if (price < 1) {
                count++;
            }
        }
        System.out.println("How many products are under 1 eur? " + count);

        HashMap<Double, String> moreProducts = new HashMap<>();
        moreProducts.put(2.19, "Lentils");
        moreProducts.put(1.35, "beans");
        moreProducts.put(0.79, "Bread");
        moreProducts.put(1.49, "Chocolate");
        moreProducts.put(0.99, "Smoothie");
        moreProducts.put(3.29, "Macadamia nuts");
        moreProducts.put(1.89, "Butter");
        moreProducts.put(0.89, "Napkins");

        products.putAll(moreProducts);
        System.out.println("Merged list:");
        for (Map.Entry list : products.entrySet()) {
            System.out.println(list.getKey() + " " + list.getValue());
        }
        System.out.println("Products in the merged list: " + products.size());
        System.out.println("Sorted in ascending order:");
        Map<Double, String> sortedProducts = new TreeMap<>(products); //sort the merged HashMap
        for (Map.Entry sort : sortedProducts.entrySet()) {
            System.out.println(sort.getKey() + " " + sort.getValue());
        }
    }

    public static void Assignment3HashTable() {
        Hashtable<Double, String> products = new Hashtable<>();
        products.put(3.09, "Peanut Butter");
        products.put(0.73, "Bananas");
        products.put(0.98, "Apples");
        products.put(6.55, "Light bulb");
        products.put(9.99, "Salmon");
        products.put(4.39, "Olive oil");
        products.put(1.57, "Almond milk");
        products.put(1.49, "Eggs");
        products.put(1.99, "Cheese");

        Double minPrice = Collections.min(products.keySet());
        System.out.println("Lowest price: " + products.get(minPrice) + " " + minPrice + " eur");
        Double maxPrice = Collections.max(products.keySet());
        System.out.println("Highest price: " + products.get(maxPrice) + " " + maxPrice + " eur");

        int count = 0;
        for (Double price : products.keySet()) {
            if (price < 1) {
                count++;
            }
        }
        System.out.println("How many products are under 1 eur? " + count);

        Hashtable<Double, String> moreProducts = new Hashtable<>();
        moreProducts.put(2.19, "Lentils");
        moreProducts.put(1.35, "beans");
        moreProducts.put(0.79, "Bread");
        moreProducts.put(1.49, "Chocolate");
        moreProducts.put(0.99, "Smoothie");
        moreProducts.put(5.29, "Strawberry");
        moreProducts.put(1.89, "Butter");
        moreProducts.put(0.89, "Napkins");

        products.putAll(moreProducts);

        System.out.println("How many products in the merged list? " + products.size());
        System.out.println("Sorted in ascending order:");
        Map<Double, String> sortedProducts = new TreeMap<>(products); //sort the merged HashMap
        for (Map.Entry sort : sortedProducts.entrySet()) {
            System.out.println(sort.getKey() + " " + sort.getValue());
        }

    }
}



