package Structures.Stack;

import java.util.EmptyStackException;

public class StackOnArray<T> {
    private int maxSize;
    private Object[] stackArray;
    private int top;

    public StackOnArray(int s){
        maxSize = s;
        stackArray = new Object[maxSize];
        top = -1;
    }

    public void push(T element){
        if(isFull()){
            throw new StackOverflowError();
        }
        stackArray[++top] = element;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T returnElement = (T) stackArray[top];
        stackArray[top] = null;
        top--;
        return returnElement;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return (T) stackArray[top];
    }
    public boolean isFull(){
        return top >= maxSize - 1;
    }

    public static void main(String[] args) {
        StackOnArray<String> stackOnArray = new StackOnArray<>(4);
        stackOnArray.push("str1");
        stackOnArray.push("str2");
        stackOnArray.push("str3");
        stackOnArray.push("str4");
        System.out.println(stackOnArray.pop());
        System.out.println(stackOnArray.peek());
        System.out.println(stackOnArray.pop());
        System.out.println(stackOnArray.pop());
        System.out.println(stackOnArray.pop());
        System.out.println(stackOnArray.pop());
//        stackOnArray.pop();
//        System.out.println(stackOnArray.peek());
    }

}
