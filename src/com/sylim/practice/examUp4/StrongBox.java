package com.sylim.practice.examUp4;

// generic = type에 제한을 둔다
public class StrongBox<T> {
    private T data;
    private int count;

    // 열쇠의 종류를 나타내는 필드 변수
    KeyType padlock = KeyType.PADLOCK;
    KeyType button = KeyType.BUTTON;
    KeyType dial = KeyType.DIAL;
    KeyType finger = KeyType.FINGER;

    // 열쇠의 종류를 받는 생성자
    public StrongBox(KeyType key) {
        if (key == padlock) {
            count = 1024;
        } else if (key == button) {
            count = 10000;
        } else if (key == dial) {
            count = 30000;
        } else {
            count = 1000000;
        }
    }

    public void put(T data) {
        this.data = data;
    }

    public T get() {
        count--;
        if (count > 0) {
            return null;
        }
        return this.data;
    }

    public static void main(String[] args) {
        StrongBox<String> button = new StrongBox<>(KeyType.BUTTON);
        button.put(new String("과자"));

        for (int i = 0; i < 10000; i++) {
             //button.get();
             System.out.println(button.get());
        }
        //System.out.println();

    }
}
