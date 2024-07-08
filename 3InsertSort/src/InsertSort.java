public class InsertSort {
    private InsertSort(){}

    public static <E extends Comparable<E>> void sort(E[] arr){
        for(int i=0; i<arr.length; i++){
            // arr[0,i)已排序，arr[i,length)未排序
            // 将arr[i]插入到前面的合适位置
            for (int j=i; j-1>=0; j--){
                if (arr[j].compareTo(arr[j-1])<0){
                    swap(arr, j, j-1);
                }else break;
            }
        }
    }

    private static <E extends Comparable<E>> void swap(E[] arr, int i, int j){
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] dataSize = {10000, 100000};
        for (int n:dataSize){
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            SortHelper.testSort("InsertSort", arr);
        }
    }
}
