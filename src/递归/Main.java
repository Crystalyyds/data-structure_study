package 递归;

//public class Main{
//    public static void main(String[] args) {
//        //先创建一个二维数组模逆一个迷宫
//        int[][] map = new int[8][7];
//        //使用1 表示强
//        //先把上下全部放为1
//        for (int i = 0; i < 7; i++) {
//            map[0][i] = 1;
//            map[7][i] = 1;
//        }
//        //左右都为1
//        for (int i = 0; i < 8; i++) {
//            map[i][0] = 1;
//            map[i][6] = 1;
//        }
//        //设置挡板 用 1表示
//        map[3][1] = 1;
//        map[3][2] = 1;
//        map[1][2] = 1;
//        map[2][2] = 1;
//        System.out.println("地图的情况");
//        for (int i = 0; i < 8; i++) {
//            for (int j = 0; j < 7; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }
//        //使用递归回溯，给小球找路
//        setWay(map, 1, 1);
//        //输出新的地图
//        System.out.println("新的地图和路线是");
//        for (int i = 0; i < 8; i++) {
//            for (int j = 0; j < 7; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }
//
//    //使用递归回溯来给小球找路
//
//    //map表示地图
//    // i j 表示 哪个位置开始找。。现在出发点(1,1)
//    //如果小球能到[6][5]，说明通路找到
//    // 约定，但map【[i][j]为0时，表示没有走过，1表示墙，如果为2则表示通路可以走，如果为3表示已经走过，但是走不通
//    // 在走迷宫时，需要一个策略（方法） 下 -> 右 -> 左 -> 上，如果该点走不通再回溯
//
//    //
//    // 如果找到通路了就返回true ，否则返回false
//    public static boolean setWay(int[][] map, int i, int j) {
//        if (map[6][5] == 2) {
//            return true;
//        } else {
//            if (map[i][j] == 0) {//如果该点还没有走过
//                //按策略玩一把下 -> 右 -> 左 -> 上
//                map[i][j] = 2;//假定该点可以走通的
//                if (setWay(map, i + 1, j)) {
//                    //向下走
//                    return true;
//                } else if (setWay(map, i, j + 1)) {
//                    //向右走
//                    return true;
//                } else if (setWay(map, i - 1, j)) {//向是哪个走
//                    return true;
//                } else if (setWay(map, i, j - 1)) {//向左走
//                    return true;
//                } else {
//                    //说明该点是走不通的，是死路
//                    map[i][j] = 3;
//                    return false;
//                }
//            } else {
//                //if (map[i][j]!=0)  可能是1,2,3
//                return false;
//            }
//        }
//    }
//}



import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        String[][] array = new String[10][10];
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = scanner.next();
            }
        }
        boolean key = setWay(array, 0, 0, m, n);
        if (key){
            System.out.println("yes");
        }else {
            System.out.println("no");
        }

    }

    public static boolean setWay(String[][] map, int i, int j, int m, int n) {
        if (map[m][n] == "T") {
            return true;
        } else {
            if (map[i][j] == ".") {
                if (setWay(map, i + 1, j, m, n)) {
                    //向下走
                    return true;
                } else if (setWay(map, i, j + 1, m, n)) {
                    //向右走
                    return true;
                } else if (setWay(map, i - 1, j, m, n)) {
                    return true;
                } else if (setWay(map, i, j - 1, m, n)) {
                    return true;
                } else {

                    return false;
                }
            } else {

                return false;
            }
        }
    }
}
