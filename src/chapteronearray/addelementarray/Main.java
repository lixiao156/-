package chapteronearray.addelementarray;

public class Main {

    public static void main(String[] args) {
        Array arr = new Array(20);
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        System.out.println(arr);
        arr.addFirst(10);
        System.out.println(arr);
        arr.add(0, 50);
        System.out.println(arr);
    }
}
