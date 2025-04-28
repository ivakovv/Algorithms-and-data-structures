package Structures.Stack;

import Structures.LinkedList;

import java.util.EmptyStackException;

public class StackOnList<T extends Comparable<T>> {

    private LinkedList<T> linkedList;
    public StackOnList(){
        linkedList = new LinkedList<>();
    }
    public void push(T element){
        linkedList.addFirst(element);
    }
    public T peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return linkedList.getFirst();
    }
    public T pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        T returnElement = (T) peek();
        linkedList.removeFirst();
        return returnElement;
    }
    public boolean isEmpty(){
        return linkedList.isEmpty();
    }

    public static void main(String[] args) {
        StackOnList<String> stackOnList = new StackOnList<>();
        stackOnList.push("1");
        System.out.println(stackOnList.peek());
        stackOnList.push("2");
        System.out.println(stackOnList.pop());
        System.out.println(stackOnList.pop());
        System.out.println(stackOnList.pop());

    }
}
