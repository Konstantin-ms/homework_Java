package seminar#4;

// Реализуйте очередь с помощью LinkedList со следующими методами:
// enqueue() - помещает элемент в конец очереди, 
// dequeue() - возвращает первый элемент из очереди и удаляет его, 
// first() - возвращает первый элемент из очереди, не удаляя.

import java.util.LinkedList; // Класс, который реализует список очередей и т.д.
import java.util.Queue;

public class Zadacha_2 {
    public static void main(String[] args) 
  {

//         Queue<String> queue = new LinkedList<>();
//         //для реализации очереди

//         //Добавление в очередь с помощью метода `add()`
//         queue.add("fist");  
//         queue.add("second"); 
//         queue.add("third"); 
//         queue.add("last");

//         System.out.println("Queue : " + queue); //queue print
//     }
// }




// Класс для представления queue
class Queue
{
    private int[] arr;      // массив для хранения элементов queue
    private int front;      // front указывает на передний элемент в queue
    private int rear;       // задняя часть указывает на последний элемент в queue
    private int capacity;   // максимальная емкость queue
    private int count;      // текущий размер queue

    // Конструктор для инициализации queue
    Queue(int size)
    {
        arr = new int[size];
        capacity = size;
        front = 0;
        rear = -1;
        count = 0;
    }

    // Вспомогательная функция для удаления переднего элемента из очереди
    public int dequeue()
    {
        // проверка на опустошение queue
        if (isEmpty())
        {
            System.out.println("Недостаточный поток\nрограмма завершена");
            System.exit(-1);
        }

        int x = arr[front];

        System.out.println("Удаление " + x);

        front = (front + 1) % capacity;
        count--;

        return x;
    }

    // Вспомогательная функция для добавления элемента в queue
    public void enqueue(int item)
    {
        // проверка на переполнение queue
        if (isFull())
        {
            System.out.println("Переполнение\nрограмма завершена");
            System.exit(-1);
        }

        System.out.println("Вставка " + item);

        rear = (rear + 1) % capacity;
        arr[rear] = item;
        count++;
    }

    // Вспомогательная функция для возврата первого элемента queue
    public int peek()
    {
        if (isEmpty())
        {
            System.out.println("Недостаточный поток\nрограмма завершена");
            System.exit(-1);
        }
        return arr[front];
    }

    // Вспомогательная функция для возврата размера queue
    public int size() {
        return count;
    }

    // Вспомогательная функция для проверки, пуста ли queue или нет
    public boolean isEmpty() {
        return (size() == 0);
    }

    // Вспомогательная функция для проверки того, заполнена ли queue или нет
    public boolean isFull() {
        return (size() == capacity);
    }
}

class Main
{
    public static void main (String[] args)
    {
        // создаем queue емкостью 5
        Queue q = new Queue(5);

        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);

        System.out.println("Передний элемент - это " + q.peek());
        q.dequeue();
        System.out.println("Передний элемент - это " + q.peek());

        System.out.println("Размер очереди составляет " + q.size());

        q.dequeue();
        q.dequeue();

        if (q.isEmpty()) {
            System.out.println("Очередь пуста");
        }
        else {
            System.out.println("Очередь не пуста");
        }
    }
}
}
