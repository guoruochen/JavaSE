import java.util.Arrays;

/**
 * @author 郭若辰
 * @create 2018-01-23 8:50
 * 常见的排序算法
 */
public class Test38 {
    public static void main(String[] args) {
        int testTime = 500000;
        int size = 10;
        int value = 100;
        boolean success = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr_1 = generateRandomArray(size, value);
            int[] arr_2 = copyArray(arr_1);
            int[] arr_3 = copyArray(arr_1);
            if (!isEqual(recursive(arr_1, 0, arr_1.length - 1), rightMethod(arr_2))) {
                success = false;
                System.out.println("错误用例：" + Arrays.toString(arr_3));
                break;
            }
        }
        System.out.println(success ? "算法正确" : "算法错误");
    }

    //冒泡排序第一种写法
    //时间复杂度O(N^2)，额外空间复杂度O(1)，是稳定排序
    private static int[] bubble_1(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
        return arr;
    }

    //冒泡排序第二种写法
    //时间复杂度O(N^2)，额外空间复杂度O(1)，是稳定排序
    private static int[] bubble_2(int[] arr) {
        for (int end = arr.length - 1; end > 0; end--) {
            for (int i = 0; i < end; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
        }
        return arr;
    }

    //选择排序
    //时间复杂度O(N^2)，额外空间复杂度O(1)，是不稳定排序
    private static int[] select(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
        return arr;
    }

    //插入排序
    //默认第一个是有序的
    //时间复杂度O(N^2)，额外空间复杂度O(1)，是稳定排序
    private static int[] insert(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
        return arr;
    }

    //归并排序
    //原理就是递归，将数组分为两部分分别排序（递归实现），然后再将排序好的两部分进行排序，最终细分到两个单个元素进行排序
    //时间复杂度O(N*logN)，额外空间复杂度O(N)，是稳定排序
    //时间复杂度，设为T(N),T(N) = T(N/2)+ T(N/2) + O(N) = 2T(N/2) + O(N)  -- O(N)是排序复杂度 ,T(N/2)是部分递归的复杂度
    //master定理，当时间复杂度可以写成T(N) = aT(N/b) + O(N^d)，可以根据公式求出时间复杂度
    //①当log(b,a)>d -> T(N)=O(N^log(b,a)) ②当log(b,a)<d -> T(N)=O(N^d) ③当log(b,a)=d -> T(N)=O(N^d*logN)
    private static int[] recursive(int[] arr, int L, int R) {
        if (L == R) {//递归终止条件
            return arr;
        }
        int mid = (L + R) >> 1;//思路忘记的话，可以想想L=2 R=3，此时mid=2
        recursive(arr, L, mid);//在上述情况下，此时本方法终止递归
        recursive(arr, mid + 1, R);//在上述情况下，此时本方法终止递归
        merge(arr, L, mid, R);//将排序好的两部分合并
        return arr;
    }

    private static void merge(int[] arr, int L, int mid, int R) {
        int[] help = new int[R - L + 1];//借助额外空间，额外空间复杂度为O(N)
        int i = 0;
        int p1 = L;//第一部分的初始指针
        int p2 = mid + 1;//第二部分的初始指针
        //在第一部分和第二部分指针不越界的情况下往help数组
        while (p1 <= mid && p2 <= R) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        //第一部分和第二部分的指针必定有且仅有一个越界，这证明指针没有越界的部分剩余的是较大元素
        // 直接将指针没越界部分的剩余元素全置入help数组
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        //将help数组写回原数组的对应位置
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
    }

    //交换元素的通用方法
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //随机数组生成器
    //生成大小1-size，元素值为-value到value的数组
    private static int[] generateRandomArray(int size, int value) {
        int[] arr = new int[(int) ((size + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((value + 1) * Math.random()) - (int) (value * Math.random());
        }
        return arr;
    }

    //比较数组是否相等
    private static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 != null && arr2 == null) || (arr1 == null && arr2 != null)) {
            return false;
        }
        if (arr1 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    //复制数组
    private static int[] copyArray(int[] arr) {
        int[] arrCopy = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arrCopy[i] = arr[i];
        }
        return arrCopy;
    }

    //绝对正确的方法
    private static int[] rightMethod(int[] arr) {
        Arrays.sort(arr);
        return arr;
    }
}
