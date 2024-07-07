public class SortHelper {
    private SortHelper(){}

    public static <E extends Comparable<E>> boolean isSorted(E[] arr){
        for (int i=1; i<arr.length; i++){
            if (arr[i-1].compareTo(arr[i])>0)
                return false;
        }
        return true;
    }

    public static <E extends Comparable<E>> void testSort(String sortName,E[] arr){
        long startTime = System.nanoTime();
        if (sortName.equals("SelectSort"))
            SelectSort.sort(arr);
        long endTime = System.nanoTime();
        double time = (endTime-startTime)/1000000000.0;

        if (!SortHelper.isSorted(arr))
            throw new RuntimeException("SelectSort failed");
        System.out.println(String.format("%s, n=%d: %fs", sortName, arr.length, time));
    }
}
