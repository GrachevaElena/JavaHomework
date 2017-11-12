package com.netcracker.time;

import com.netcracker.list.ILinkedList;
import com.netcracker.list.MyLinkedList;

import java.util.*;

/*
//N=100000
//выводы касательно асимптотики сделаны на основе множества запусков
//приведен результат одного из запусков

java.util.ArrayList (number of operations=30):
add: 92372 //линия
remove: 48518 //линия

java.util.LinkedList (number of operations=30):
add: 5598 //константа
remove: 41988 //линия

MyLinkedList (number of operations=30):
add: 8864 //добавления в основном немного медленнее работают
remove: 51784 //а удаления также
//вообще на java время измерять так себе затея,
//т.к. при разных запусках полученные значения могут отличаться во много раз
//ладно хоть порядок числа более-менее сохраняется

java.util.HashSet (number of operations=30):
add: 299980 //за константу
remove: 66714 //за константу

java.util.LinkedHashSet (number of operations=30):
add: 2977398 //медленнее(что логично)
remove: 53184 //за константу

java.util.TreeSet (number of operations=30):
add: 411014 //примерно логарифм
remove: 104970 //логарифм

java.util.HashMap (number of operations=30):
put: 170750 //константа
remove: 37320 //константа

java.util.LinkedHashMap (number of operations=30):
put: 123630 //константа, не отличается от HashMap
//это потому, что в обоих случаях map заполняется ключами от 100000 до 100029 упорядоченно
//т.е. на таких данных HashMap и LinkedHashMap работают одинаково
remove: 32658 //константа

java.util.TreeMap (number of operations=30):
put: 527646 //дольше HashMap, логарифм
remove: 111502 //логарифм

//списки работают быстрее всех
*/
public class Main {
    public static void main(String[] args) {
        int N = 100000;
        int NOp = 30;
        Time time = new Time();

        List<Double> list = new ArrayList(N);
        time.measureTime(list, NOp);

        list = new LinkedList();
        for (int i = 0; i < N; i++)
            list.add((double) i);
        time.measureTime(list, NOp);

        ILinkedList<Double> myList = new MyLinkedList();
        for (int i = 0; i < N; i++)
            myList.add((double) i);

        System.out.println("MyLinkedList (number of operations=" + NOp + "): ");
        long t1 = System.nanoTime();
        for (int i = 0; i < NOp; i++)
            myList.add(new Double(i));
        long t2 = System.nanoTime();
        System.out.println("add: " + (t2 - t1));
        t1 = System.nanoTime();
        for (int i = 0; i < NOp; i++)
            myList.remove(i);
        t2 = System.nanoTime();
        System.out.println("remove: " + (t2 - t1));
        System.out.println("");


        Set<Double> set = new HashSet(N);
        time.measureTime(set, NOp);

        set = new LinkedHashSet(N);
        time.measureTime(set, NOp);

        set = new TreeSet();
        for (int i = 0; i < N; i++)
            set.add((double) i);
        time.measureTime(set, NOp);


        Map<Integer, Double> map = new HashMap(N);
        time.measureTime(map, NOp);

        map = new LinkedHashMap(N);
        time.measureTime(map, NOp);

        map = new TreeMap();
        for (int i = 0; i < N; i++)
            map.put(i, (double) i);
        time.measureTime(map, NOp);

    }
}
