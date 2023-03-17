package com.sylim.practice.examUp4;

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
        switch(key) {
            case PADLOCK:
                count = 1024;
                break;
            case BUTTON:
                count = 10000;
                break;
            case DIAL:
                count = 30000;
                break;
            case FINGER:
                count = 1000000;
                break;
            default: 
        }
    }

    public void put(T data) {
        this.data = data;
    }
    
    // 열쇠의 종류에 따라 미리 정해진 count를 호출될때마다 1씩 감소시킨다.
    public T get() {
        count--;
        if (count > 0) {
            return null;
        }
        return this.data;
    }

    public static void main(String[] args) {
        StrongBox<String> box = new StrongBox<>(KeyType.BUTTON);
        box.put(new String("과자"));

        for (int i = 0; i < 10000; i++) {
             System.out.println(box.get());
        }

    }
}
