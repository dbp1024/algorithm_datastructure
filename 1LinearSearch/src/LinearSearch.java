public class LinearSearch {

    private LinearSearch() {
    }

    public static <E> int search(E[] data, E target) {
        for (int i = 0; i < data.length; i++)
            if (data[i].equals(target)) {
                return i;
            }
        return -1;
    }

    public static void main(String[] args) {
        // Integer[] data = { 24, 18, 12, 9, 16, 66, 32, 4 };

        // int res1 = LinearSearch.search(data, 16);
        // System.out.println(res1);

        // int res2 = LinearSearch.search(data, 666);
        // System.out.println(res2);

        // Student[] students = { new Student("Alice"), new Student("Bobo"), new
        // Student("Charles") };
        // int res3 = LinearSearch.search(students, new Student("Bobo"));
        // System.out.println(res3);

        // 数据规模
        int[] dataSize = { 1000000, 10000000 };
        for (int n : dataSize) {
            Integer[] data = ArrayGenerator.generateOrderedArray(n);

            long startTime = System.nanoTime();
            for (int k = 0; k < 100; k++) {
                LinearSearch.search(data, n);
            }
            long endTime = System.nanoTime();
            double time = (endTime - startTime) / 1000000000.0;

            System.out.println("n=" + n + ", 100 runs: " + time + "s");
        }

    }
}