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
            if (!isEqual(insert(arr_1), rightMethod(arr_2))) {
                success = false;
                System.out.println("错误用例：" + Arrays.toString(arr_3));
                break;
            }
        }
        System.out.println(success ? "算法正确" : "算法错误");

        int[] arr = {1, 2, 32, 54, 66, 32, 55, 2, 5, 6, 7, 34, 27};
        System.out.println(Arrays.toString(heap(arr)));
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

    //随机快速排序
    //随机一个元素为划分值，将数组分为小于区、等于区和大于区
    //经典快速排序使用最后一个元素为划分值，经典快排有最好情况O(N)和O(N^2)
    //随机快排时间复杂度O(N*logN)，原理与归并排序相同，额外空间复杂度O(logN)，是不稳定排序
    private static int[] quick(int[] arr, int L, int R) {
        if (L < R) {
            swap(arr, L + (int) (Math.random() * (R - L + 1)), R);//随机选一个位置的元素，与数组最后一个元素交换，作为划分值
            int[] p = partition(arr, L, R);
            quick(arr, L, p[0] - 1);//将小于区再划分
            quick(arr, p[1] + 1, R);//将大于区再划分
        }
        return arr;
    }

    private static int[] partition(int[] arr, int L, int R) {
        int less = L - 1;//小于区起始位置
        int more = R;//大于区起始位置
        while (L < more) {
            if (arr[L] < arr[R]) {//如果当前指针的元素小于划分值
                swap(arr, ++less, L++);//就将当前指针的元素与小于区右边的元素交换，小于区向右扩，当前指针也向右移一位
            } else if (arr[L] > arr[R]) {//如果当前指针的元素大于划分值
                swap(arr, --more, L);//就将当前指针的元素与大于区左边的元素交换，大于区向左扩，当前指针不变
            } else {//如果当前指针的元素等于划分值
                L++;//只将当前指针右移一位
            }
        }
        swap(arr, more, R);//由于大于区最后一个元素是划分值，要将大于区第一个元素与划分值交换
        return new int[]{less + 1, more};//返回等于区的起始位置和结束位置
    }

    //堆排序
    //将数组想象为完全二叉树，左子节点2i+1，右子节点2i+2，父节点(i-1)/2
    //第一步：建立大根堆结构（根节点大于等于子树所有值）--->往上走
    //第二步：将大根堆第一个和最后一个交换，依次去掉最后一个，再从第一个往子节点比 --->往下走
    //建立大根堆时间复杂度O(N)
    //堆排序时间复杂度O(N*logN)，原理与归并排序相同，额外空间复杂度O(1)，是不稳定排序
    private static int[] heap(int[] arr) {
        for (int i = 0; i < arr.length; i++) {//第一步：建立大根堆结构
            heapInsert(arr, i);
        }
        int heapSize = arr.length;
        swap(arr, 0, --heapSize);//完成大根堆结构建立之后，第一个一定是最大的，交换到数组最后一个，然后堆长度减一
        while (heapSize > 0) {//循环进行从高阶树比到低阶树（实际上还是建立大根堆结构）
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
        return arr;
    }

    private static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {//和父节点比大小，如果比父节点大就交换
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    private static void heapify(int[] arr, int index, int size) {
        int left = index * 2 + 1;//左子节点
        while (left < size) {
            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;//返回子节点值较大的下标
            largest = arr[largest] > arr[index] ? largest : index;//返回当前节点和子节点值较大的下标
            if (largest == index) {//如果发现还是当前节点最大，结束遍历
                break;
            }
            swap(arr, largest, index);//如果某个子节点比当前节点大，将两者交换
            index = largest;
            left = index * 2 + 1;
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
