package com.Collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorDemo {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");

        // 1. Get the iterator from the collection
        Iterator<String> iterator = names.iterator();

        // 2. Loop while the iterator has a 'next' item
        while (iterator.hasNext()) {
            String name = iterator.next();
            
            if (name.equals("Bob")) {
                // SAFE REMOVAL: This will not throw an exception!
                iterator.remove(); 
            }
        }
        
        System.out.println(names); // Output: [Alice, Charlie]
    }
}
