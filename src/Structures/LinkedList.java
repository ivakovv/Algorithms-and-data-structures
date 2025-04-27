package Structures;

import java.util.NoSuchElementException;

public class LinkedList<T extends Comparable<T>> {
    private Node<T> head;
    private int size;

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    public LinkedList() {
        head = new Node<>(null);
        size = 0;
    }

    public void addFirst(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.next = head.next;
        head.next = newNode;
        size++;
    }

    public T removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Список пуст!");
        }
        T removedData = head.next.data;
        head.next = head.next.next;
        size--;
        return removedData;
    }
    public void insert(int index, T value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Неверный индекс: " + index);
        }

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        Node<T> newNode = new Node<>(value);
        newNode.next = current.next;
        current.next = newNode;
        size++;
    }

    public T getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Список пуст!");
        }
        return head.next.data;
    }

    public void addLast(T value) {
        Node<T> newNode = new Node<>(value);
        Node<T> current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        size++;
    }

    public T removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Список пуст!");
        }
        Node<T> current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        T removedData = current.next.data;
        current.next = null;
        size--;
        return removedData;
    }

    public T getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Список пуст!");
        }
        Node<T> current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public boolean contains(T value) {
        Node<T> current = head.next;
        while (current != null) {
            if (current.data.equals(value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public boolean remove(T value) {
        Node<T> prev = head;
        Node<T> current = head.next;
        while (current != null) {
            if (current.data.equals(value)) {
                prev.next = current.next;
                size--;
                return true;
            }
            prev = current;
            current = current.next;
        }
        return false;
    }

    public void insertOrderedDescending(T value) {
        Node<T> newNode = new Node<>(value);
        Node<T> current = head;
        while (current.next != null && current.next.data.compareTo(value) > 0) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
        size++;
    }

    public double calculateAverage() {
        if (!(head.next != null && head.next.data instanceof Number)) {
            throw new UnsupportedOperationException("Метод поддерживает только числовые типы");
        }
        double sum = 0.0;
        int count = 0;
        Node<T> current = head.next;
        while (current != null) {
            sum += ((Number) current.data).doubleValue();
            count++;
            current = current.next;
        }
        return count == 0 ? 0 : sum / count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> current = head.next;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(30);
        System.out.println("Список: " + list);  // [30, 20, 10]
        System.out.println("Первый элемент: " + list.getFirst());  // 30
        System.out.println("Последний элемент: " + list.getLast());  // 10
        System.out.println("Размер: " + list.size());  // 3

        list.removeFirst();
        System.out.println("После удаления первого: " + list);  // [20, 10]

        list.insertOrderedDescending(15);
        System.out.println("После вставки 15: " + list);  // [20, 15, 10]
    }
}