package seminar#4;

import java.util.*;


public class Zadacha_1 {
    public static void main(String[] args)
    {
        // Объявление linkedlist без какого-либо начального размера
        LinkedList<String> linkedli = new LinkedList<String>();
        // Добавление элементов в конце списка
        linkedli.add("Бентли");
        linkedli.add("Мерседес");
        linkedli.add("Газель");
        System.out.print("Элементы перед обращением : " + linkedli);
        linkedli = reverseLinkedList(linkedli);
        System.out.print(" Элементы после реверсирования: " + linkedli);
    }

    // Принимает linkedlist в качестве параметра и возвращает обратный связанный список
    public static LinkedList<String> reverseLinkedList(LinkedList<String> llist)
    {
        LinkedList<String> revLinkedList = new LinkedList<String>();
        for (int i = llist.size() - 1; i >= 0; i--) {

            // Добавим элементы в обратном порядке
            revLinkedList.add(llist.get(i));
        }
        // Возвращает перевернутый список массива
        return revLinkedList;
    }
}
