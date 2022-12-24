package seminar#6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class task1 {
    public static void main(String[] args) throws IOException {
        LinkedHashSet<notebook> my_list = my_read();
        LinkedHashSet<notebook> my_filterd = new LinkedHashSet<>();
        int max_art = my_read_art();
        int sel = 0;
        Scanner scan = new Scanner(System.in);
        notebook my_book = new notebook(0, null, 0, 0, 
        0, 0, 0, 0);
        while (sel!=5) {
            System.out.println("\n1. Вывести весь список.");
            System.out.println("2. Добавить элемент в список.");
            System.out.println("3. Удалить элемент из списка.");
            System.out.println("4. Фильтровать список по min-значениям параметров.");
            System.out.println("5. Завершить.");
            System.out.print("Выберите пункт меню (1-5) : ");
            sel = scan.nextInt();
            switch (sel) {
                case 1: for (notebook item : my_list) 
                        System.out.println(item.toString()); break; 
                case 2: my_book = get_params();
                        my_book.art = ++max_art;
                        my_list.add(my_book); break;
                case 3: System.out.print("Укажите артикул удаляемой позиции : ");
                        int art = scan.nextInt();
                        my_book = new notebook(0, null, 0, 
                        0, 0, 0, 0, 0);
                        for (notebook item : my_list) {if (item.art==art) {my_book = item;
                        System.out.println(my_book.toString()+" - удален из списка");}}
                        my_list.remove(my_book); break;
                case 4: my_filterd = my_filter(get_params(), my_list);
                        for (notebook item : my_filterd) 
                        System.out.println(item.toString()); break;
                case 5: break;}}
        scan.close();
        my_write(max_art, my_list);}

public static notebook get_params(){
    Scanner scan = new Scanner(System.in);
    notebook params = new notebook(0, null, 0, 
                0, 0, 0, 0, 0);

    System.out.print("Введите название производителя (0-не важно) : ");
    params.firm = scan.nextLine();
    for (int i = 0; i < params.sizes_diag.length; i++) 
        System.out.println(i+". "+params.sizes_diag[i]);        
    System.out.print("Выберите диагональ : ");
    params.diag = scan.nextInt();
    System.out.print("Введите размер ОЗУ(RAM) : ");
    params.ram = scan.nextInt();
    System.out.print("Введите размер ПЗУ(HD) : ");
    params.hd = scan.nextInt();
    for (int i = 0; i < params.ops_system.length; i++) 
        System.out.println(i+". "+params.ops_system[i]);       
    System.out.print("Введите операционную систему : ");
    params.ops = scan.nextInt();
    for (int i = 0; i < params.colors.length; i++) 
        System.out.println(i+". "+params.colors[i]);       
    System.out.print("Введите цвет : ");
    params.color = scan.nextInt();
    System.out.print("Введите цену(руб.) : ");
    params.price = scan.nextInt();
    return params;}

public static void my_write(int max_art1, LinkedHashSet<notebook> my_list1) throws IOException {
    FileWriter f_w = new FileWriter("db_book.txt");
    f_w.append(max_art1+"\n");
    for (notebook item : my_list1) {
        f_w.append(item.art+"\n");
        f_w.append(item.firm+"\n");
        f_w.append(item.diag+"\n");
        f_w.append(item.ram+"\n");
        f_w.append(item.hd+"\n");
        f_w.append(item.ops+"\n");
        f_w.append(item.color+"\n");
        f_w.append(item.price+"\n");}        
    f_w.close();}

public static int my_read_art() throws IOException {
    int art1=0;
    BufferedReader f_r = new BufferedReader(new FileReader("db_book.txt"));
    art1 = Integer.parseInt(f_r.readLine());
    f_r.close();
    return art1;}

public static LinkedHashSet<notebook> my_read() throws IOException {
    LinkedHashSet<notebook> my_list1 = new LinkedHashSet<>();
    BufferedReader f_r = new BufferedReader(new FileReader("db_book.txt"));
    LinkedList<String> log_list = new LinkedList<>();
    String line;
    notebook my_book = new notebook(0, null, 0, 0, 
                                    0, 0, 0, 0);                                    
    while ((line=f_r.readLine())!=null) log_list.add(line); 
    f_r.close();

    for (int i = 1; i < log_list.size(); i++) {
        my_book = new notebook(0, null, 0, 0, 
                    0, 0, 0, 0);
        my_book.art = Integer.parseInt(log_list.get(i));
        my_book.firm = log_list.get(++i);
        my_book.diag = Integer.parseInt(log_list.get(++i));
        my_book.ram = Integer.parseInt(log_list.get(++i));
        my_book.hd = Integer.parseInt(log_list.get(++i));
        my_book.ops = Integer.parseInt(log_list.get(++i));
        my_book.color = Integer.parseInt(log_list.get(++i));
        my_book.price = Integer.parseInt(log_list.get(++i));
        my_list1.add(my_book);}
    return my_list1;}  

    public static LinkedHashSet<notebook> my_filter(notebook my_book1, LinkedHashSet<notebook> my_list1) throws IOException {
        LinkedHashSet<notebook> filtered_book = new LinkedHashSet<>();
        LinkedHashSet<notebook> filtered_book1 = new LinkedHashSet<>();
        LinkedHashSet<notebook> filtered_book2 = new LinkedHashSet<>();
        LinkedHashSet<notebook> filtered_book3 = new LinkedHashSet<>();

        if (!my_book1.firm.equals("0")) {
            for (notebook item : my_list1){
                if (item.firm.equals(my_book1.firm)) filtered_book1.add(item);}}
        else filtered_book1 = my_list1;

        if (my_book1.ops!=0) {
            for (notebook item : filtered_book1){
                if (item.ops==my_book1.ops) filtered_book2.add(item);}}
        else filtered_book2 = filtered_book1;

        if (my_book1.color!=0) {
            for (notebook item : filtered_book2){
                if (item.color==my_book1.color) filtered_book3.add(item);}}
        else filtered_book3 = filtered_book2; 
        for (notebook item : filtered_book3) {
            if ((item.diag>=my_book1.diag)&&(item.ram>=my_book1.ram)&&
            (item.hd>=my_book1.hd)&&(item.price>=my_book1.price)) filtered_book.add(item);}

    return filtered_book;
    }
}

