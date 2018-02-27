/**
 * @author 郭若辰
 * @create 2018-01-29 9:45
 */
    /*
    在一个二维数组中，每一行都按照从左到右递增的顺序排序，
    每一列都按照从上到下递增的顺序排序。
    请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
     */
public class Algorithm01 {
    public static void main(String[] args) {
        int[][] arr_1 = {{1, 2, 5, 6, 7}, {3, 4, 6, 9}, {7, 8, 9}};
        int[][] arr_2 = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}};
//        System.out.println(findByTraversal(arr_1, 8));
        System.out.println(findByTraversal(arr_2, 8));
        System.out.println(findByBinarySearch(arr_1, 8));
        System.out.println(findByBinarySearch(arr_2, 8));
    }


    /*
    通过遍历
    首先选取数组右上角（或左下角）的数字，如果目标数字等于该数字，查找结束；如果目标数字大于该数字，剔除行；
    如果目标数字小于该数字，剔除列
    注：形参中的二维数组只能是方阵
     */
    private static boolean findByTraversal(int[][] array, int target) {

        if (null == array || array.length == 0 || array[0].length == 0) {
            return false;
        }

        int row = 0;//右上角初始行
        int column = array[0].length - 1;//右上角初始列
        while (row <= array.length - 1 && column >= 0) {//如果超出二维数组范围，终止循环
            if (target == array[row][column]) {//如果目标数字等于该数字，查找结束
                return true;
            } else if (target > array[row][column]) {//如果目标数字大于该数字，剔除行
                row++;
            } else {//如果目标数字小于该数字，剔除列
                column--;
            }
        }
        return false;
    }

    //通过二分
    //遍历每一行，每一行使用二分查找
    private static boolean findByBinarySearch(int[][] array, int target) {
        if (null == array || array.length == 0) {
            return false;
        }

        for (int i = 0; i < array.length; i++) {
            int low = 0;
            int high = array[i].length - 1;
            while (low <= high) {
                int mid = low + ((high - low) >>> 1);
                if (target > array[i][mid]) {
                    low = mid + 1;
                } else if (target < array[i][mid]) {
                    high = mid - 1;
                } else {
                    return true;
                }
            }
        }
        return false;
    }
}
