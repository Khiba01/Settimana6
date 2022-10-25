package it.unibo.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        final ArrayList<Integer> array = new ArrayList<>();
        for (int i = 1000; i < 2000; i++){
            array.add(Integer.valueOf(i));
        }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        final LinkedList<Integer> lList = new LinkedList<>(array);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        final Integer temp = array.get(0);
        final Integer temp2 = array.get((array.size()-1));
        array.set(0, temp2);
        array.set(array.size()-1, temp);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for (Integer i : array) {
            System.out.println(i);
        }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        long time = System.nanoTime();
        for (int i = 0; i <= 100_000; i++) {
            array.add(i);
        }
        time = System.nanoTime() - time;
        System.out.println("ArrayList 100.000 elementi in :" + time);

        time = System.nanoTime();
        for (int i = 0; i <= 100_000; i++) {
            lList.add(i);
        }
        time = System.nanoTime() - time;
        System.out.println("LinkedList 100.000 elementi in :" + time);
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example PerfTest.java.
         */
        time = System.nanoTime();
        for (int i = 0; i < 1000; i++){
            array.get((array.size()-1)/2);
        }
        time = System.nanoTime() - time;
        System.out.println("ArrayList 1000 letture :" + time);

        time = System.nanoTime();
        for (int i = 0; i < 1000; i++){
            lList.get((lList.size()-1)/2);
        }
        time = System.nanoTime() - time;
        System.out.println("LinkedList 1000 letture :" + time);
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        final Map<String, Long> continents = new TreeMap<>();
        continents.put("Africa", 1_110_635_000L);
        continents.put("Americas", 972_005_000L);
        continents.put("Antartica", 0L);
        continents.put("Asia", 4_298_723_000L);
        continents.put("Europe", 742_452_000L);
        continents.put("Oceania", 38_304_000L);
        /*
         * 8) Compute the population of the world
         */
        long total = 0;
        for (Long long1 : continents.values()) {
            total += Long.valueOf(long1);
        }
        System.out.println("Global Population is: " + total);
    }
}
