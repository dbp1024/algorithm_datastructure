import java.util.Arrays;

public class InsertSort {
    private InsertSort(){}

    public static <E extends Comparable<E>> void sort1(E[] arr){
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

    // 平移代替交换
    public static <E extends Comparable<E>> void sort(E[] arr){
        for (int i=0; i<arr.length; i++){
            // arr[0,i)已排序，arr[i,length)未排序
            // 把arr[i]放到合适的位置
            E t = arr[i];
            int j;
            for (j=i;j-1>=0;j--){
                if (arr[j-1].compareTo(t)>0)
                    arr[j] = arr[j-1];
                else break;;
            }
            arr[j] = t;
        }
    }

    public static <E extends Comparable<E>> void sort(E[] arr, int l, int r){
        for (int i=l; i<=r; i++){
            // arr[l,i)已排序，arr[i,r]未排序
            // 把arr[i]放到合适的位置
            E t = arr[i];
            int j;
            for (j=i;j-1>=l;j--){
                if (arr[j-1].compareTo(t)>0)
                    arr[j] = arr[j-1];
                else break;;
            }
            arr[j] = t;
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
            System.out.println("Random array:");
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            Integer[] arr2 = Arrays.copyOf(arr, arr.length);
            SortHelper.testSort("InsertSort", arr);
            SortHelper.testSort("SelectSort", arr2);

            System.out.println("Ordered array:");
            arr = ArrayGenerator.generateOrderedArray(n);
            arr2 = Arrays.copyOf(arr, arr.length);
            SortHelper.testSort("InsertSort", arr);
            SortHelper.testSort("SelectSort", arr2);
        }
    }
}
