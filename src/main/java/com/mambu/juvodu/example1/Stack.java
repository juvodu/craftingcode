package com.mambu.juvodu.example1;

import java.util.ArrayList;
import java.util.List;

/**
 * Data container that wraps object in a stack like container
 *
 * @author jtichomirow
 */
public class Stack {

    private final List<Object> objects = new ArrayList<>();

    public int getSize() {
        return objects.size();
    }

    public void push(Object object) {
        objects.add(object);
    }

    public Object pop() {

        if (objects.isEmpty()) {
            throw new IllegalStateException("Cannot pop from stack. Stack is empty.");
        }

        return objects.remove(objects.size() - 1);
    }
}
