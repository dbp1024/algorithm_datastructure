public class Main {

//    public static void main(String[] args) {
//        // java中的传统数组
//        int[] arr = new int[10];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = i;
//        }
//        for (int e : arr)
//            System.out.print(e+" ");
//        System.out.println();
//
//        String[] names = {"bob", "alice", "charles"};
//        for(String name: names)
//            System.out.print(name+" ");
//        System.out.println();
//    }

    public static void main(String[] args) {
        Array<Integer> arr = new Array<>(20);
        for (int i=0; i<10; i++)
            arr.addLast(i);
        System.out.println(arr);

        arr.add(1, 100);
        System.out.println(arr);

        arr.addFirst(10);
        System.out.println(arr);
        // [10, 0, 100, 1, 2, 3, 4, 5, 6, 7, 8, 9]

        arr.remove(5);
        System.out.println(arr);

        arr.removeElement(100);
        System.out.println(arr);

        arr.removeFirst();
        System.out.println(arr);

        arr.removeLast();
        System.out.println(arr);
    }
}
