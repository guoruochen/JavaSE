import java.util.concurrent.*;

/**
 * @author 郭若辰
 * @create 2017-10-09 8:58
 */
public class Test37 {

//    public static void main(String[] args) {
//        Scanner s = new Scanner(System.in);
//        int a = s.nextInt();
//        String str = s.nextLine();
//        System.out.println(a + str);


//        System.out.println(Arrays.toString(new Test37().aa(new int[]{1,2,3,4},5)));
//        //获取输入
//        Scanner s = new Scanner(System.in);
//        int length = s.nextInt();
//        String str = "";
//        while(true){
//            if (s.hasNext()){
//                str = s.nextLine();
//            }else{
//                break;
//            }
//        }
//
//        s.close();
//
//
//        //转换为int数组
//        String[] arrStr = str.trim().split("\\s+");
//        int[] arr = new int[length];
//        for (int i = 0; i < length; i++) {
//            arr[i] = Integer.parseInt(arrStr[i]);
//        }
//
//        //求连续子数组的最大和
//        int[] maxArr = new int[length];
//        for (int i = 1; i < length; i++) {
//            int sum = arr[i - 1];
//            int max = 0;
//            int[] temp = new int[length];
//            temp[i - 1] = arr[i - 1];
//            for (int j = i; j < length; j++) {
//                sum += arr[j];
//                max = (sum > temp[j - 1]) ? sum : temp[j - 1];
//                temp[j] = max;
//            }
//            maxArr[i - 1] = max;
//            maxArr[length - 1] = arr[length - 1];
//        }
//        Arrays.sort(maxArr);
//        System.out.println(maxArr[maxArr.length - 1]);

//        //获取输入
//        Scanner s = new Scanner(System.in);
//        int n = s.nextInt();
//
//        //阶乘
//        BigInteger sum = new BigInteger("1");
//        for (int i = 1; i <= n; i++) {
//            sum = sum.multiply(new BigInteger("" + i));
//        }
//        System.out.println(sum);
//
//        //求末尾有多少个0
//        String str = "" + sum;
//        int count = 0;
//            StringBuilder sb = new StringBuilder(str);
//            for (int i = sb.length() - 1; i >= 0; i--) {
//                if (str.charAt(i) == '0') {
//                    sb.delete(i, i + 1);
//                    count++;
//                } else {
//                    break;
//                }
//            }
//            System.out.println(count);

//        //获取输入
//        Scanner s = new Scanner(System.in);
//        int n = s.nextInt();
//        int x = s.nextInt();
//
//        //进制转换
//        StringBuilder sb = new StringBuilder();
//        boolean flag = true;
//        System.out.println(n+"%"+x+"="+(n)%x);
//        while (flag) {
//            int yu = (n) % x;
//            switch (yu) {
//                case 10:
//                    sb.append("A");
//                    break;
//                case 11:
//                    sb.append("B");
//                    break;
//                case 12:
//                    sb.append("C");
//                    break;
//                case 13:
//                    sb.append("D");
//                    break;
//                case 14:
//                    sb.append("E");
//                    break;
//                case 15:
//                    sb.append("F");
//                    break;
//                default:
//                    sb.append(yu);
//            }
//            n = n / x;
//            if (n == 0) {
//                flag = false;
//            }
//        }
//        System.out.println(sb.toString());
//        //字符串倒序
//        char[] cArr = sb.toString().toCharArray();
//        char[] res = new char[sb.length()];
//        for (int i = sb.length() - 1; i >= 0; i--) {
//            res[Math.abs(i - sb.length()) - 1] = cArr[i];
//        }
//        System.out.println(new String(res));
//    }

//    public int[] aa(int[] arr,int target){
//        int[] res = new int[2];
//        for (int i = 0;i<arr.length;i++){
//            for (int j = i+1;j<arr.length;j++){
//                if ((arr[i]+arr[j]) == target){
//                    res[0] = i;
//                    res[1] = j;
//                     return res;
//                }
//            }
//        }
//        return null;
//    }

    static {
        System.out.println("a");
    }

    private int a;

    public static void main(String[] args) {

        //1/关于==和equals
        String s1 = "abc";
        String s2 = "a" + "bc";
        String s3 = "a" + new String("bc");
        String s4 = "a" + String.valueOf("bc");
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1 == s4);
    }


}

class Test {
    public static void main(String[] args) {

        //替换
        String s = "abcd   af gr";
        String s1 = s.replace('a', 's');//sbcd   sf gr
        String s2 = s.replace("a", "%20");//abcd%20%20%20af%20gr
        String s3 = s.replaceAll(" ", "%20");//abcd%20%20%20af%20gr，如果replaceAll()不使用正则，其与replace()效果相同
        String s4 = s.replaceAll("\\s", "%20");//abcd%20%20%20af%20gr
        String s5 = s.replaceAll("\\s+", "%20");//abcd%20af%20gr
        System.out.println(s2);

        int x = 0;
        int y = 0;
        int k = 0;
        for (int z = 0; z < 5; z++) {
            if ((++x > 2) && (++y > 2) && (k++ > 2)) {
                x++;
                ++y;
                k++;
            }
        }
    }
}

class score {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(5000);
                return "sss";
            }
        });
//        System.out.println(future.get());
        System.out.println("aaa");
    }
}
