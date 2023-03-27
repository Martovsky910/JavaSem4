package Sem4;

import java.util.LinkedList;
import java.util.Random;

public class Task1Sem4 {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        RandomList(10, 50, list);
        System.out.println(list);

        LinkedList<Integer> newlist = ReversList(list);
        System.out.println(newlist);
    }

    public static LinkedList<Integer> ReversList(LinkedList<Integer> list) {
        LinkedList<Integer> newList = new LinkedList<>();

        for(int i = list.size(); i > 0; i--) {
            newList.add(list.get(i - 1));
        }
        return newList;
    }

    public static void RandomList(int size, int uprange, LinkedList<Integer> list) {
        Random rand = new Random();
        for(int i = 0; i < size; i++){
            list.add(rand.nextInt(uprange));
        }
    }
}