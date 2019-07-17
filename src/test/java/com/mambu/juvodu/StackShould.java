package com.mambu.juvodu;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Test suite for {@link Stack}
 *
 * @author jtichomirow
 */
public class StackShould {

    @Test
    public void increaseSizeWhenPush() {

        // setup
        Stack stack = new Stack();
        Object object = new Object();

        // execute
        stack.push(object);

        // verify
        assertEquals(1, stack.getSize());
    }

    @Test
    public void decreaseSizeWhenPop() {

        // setup
        Stack stack = new Stack();
        Object object = new Object();
        stack.push(object);

        // execute
        stack.pop();

        // verify
        assertEquals(0, stack.getSize());
    }

    @Test
    public void removeAndReturnTopObjectWhenPop() {

        // setup
        Stack stack = new Stack();
        Object object = new Object();
        stack.push(object);

        // execute
        Object result = stack.pop();

        // verify
        assertEquals(object, result);
    }

    @Test(expected = IllegalStateException.class)
    public void throwExceptionWhenPopObjectOnEmptyStack() {

        Stack stack = new Stack();

        // execute
        stack.pop();
    }
}
