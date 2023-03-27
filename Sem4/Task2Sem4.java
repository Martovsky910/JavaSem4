package Sem4;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Task2Sem4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> reslist = new LinkedList<>();
        RandomList(10, 50, reslist);
        System.out.println("Введиет номер операции: \n 1 - поместить элемент в конец очереди\n 2 - вернуть первый элемент из очереди и удалить его\n 3 - вернуть первый элемент из очереди, не удаляя его");
        System.out.println("Текущие элементы списка: " + reslist);
        int oper = sc.nextInt();
        
        switch (oper) {
            case 1:
                System.out.println("Введите элемент, который надо добавить: ");
                Scanner sc2 = new Scanner(System.in);
                int value = sc2.nextInt(); 
                enqueue(reslist, value);
                System.out.println(reslist);
                break;

            case 2:
                System.out.println("Первый элемент: " + dequeue(reslist));
                System.out.println(reslist);
                break;

            case 3:
                System.out.println("Первым элементом был: " + first(reslist));
                System.out.println(reslist);
                break;
        }

    }
    
    public static void enqueue(LinkedList<Integer> reslist, int value) {
        reslist.addLast(value);
    }

    public static int dequeue(LinkedList<Integer> reslist) {
        return reslist.removeFirst();
    }

    public static int first(LinkedList<Integer> reslist) {
        return reslist.getFirst();
    }

    public static void RandomList(int size, int uprange, LinkedList<Integer> reslist) {
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            reslist.add(rand.nextInt(uprange));
        }
    }
}