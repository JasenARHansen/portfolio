package Java.code.ctci.source.ch_13_Java.introduction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Vector;

@SuppressWarnings("SpellCheckingInspection")
public class IntroductionCollections {
    public static void main(String[] args) {
        // ArrayList
        ArrayList<String> myArr = new ArrayList<>();
        myArr.add("one");
        myArr.add("two");
        System.out.println(myArr.get(0));
        // Vector
        Vector<String> myVect = new Vector<>();
        myVect.add("one");
        myVect.add("two");
        System.out.println(myVect.get(0));
        // Linked List
        LinkedList<String> myLinkedList = new LinkedList<>();
        myLinkedList.add("two");
        myLinkedList.addFirst("one");
        for (String s : myLinkedList) {
            System.out.println(s);
        }
        // Hash Map
        HashMap<String, String> map = new HashMap<>();
        map.put("one", "uno");
        map.put("two", "dos");
        System.out.println(map.get("one"));
    }
}
