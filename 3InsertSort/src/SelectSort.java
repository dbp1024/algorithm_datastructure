public class SelectSort {
    private SelectSort(){}

    public static <E extends Comparable<E>> void sort(E[] arr){
        for (int i=0; i<arr.length; i++){
            // arr[0,i)是已排序，arr[i,n)是未排序
            // 在arr[i]位置上，放置arr[i,n)中的最小值
            int minIndex = i;
            for (int j=i; j<arr.length; j++){
                // 将arr[minIndex]和arr[j]进行比较
                if (arr[minIndex].compareTo(arr[j])>0)
                    minIndex = j;
            }

            // arr[i]和arr[minIndex]交换
            swap(arr, i, minIndex);
        }
    }

    private static <E> void swap(E[] arr, int i, int j){
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] dataSize ={10000,100000};
        for (int n:dataSize){
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            SortHelper.testSort("SelectSort", arr);
        }
    }
}
