import java.util.Scanner;

public class No1 {
    public static void main(String[] args) {
        queue array = new queue(3);
        char key = ' ';
        Scanner scanner= new Scanner(System.in);
        boolean o= true;
        while (o)
        {
            System.out.println("----s----显示队列");
            System.out.println("----e----退出队列");
            System.out.println("----a----添加队列");
            System.out.println("----g----取出队列");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    array.show();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    array.add(value);
                    break;
                case 'g':
                    try {
                        int res = array.out();
                        System.out.println("取出的是");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = array.HeadData();
                        System.out.println("取出头部的是" + res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    o = false;
                    break;
            }
        }
    }
}


class queue{
    private int maxSize;
    private int front;
    private int rear;
    private int[] array;//储存

    public queue(int arraymaxSize) {
        maxSize = arraymaxSize;
        array = new int[maxSize];
        front = -1;//没有用时在队列前一个位置
        rear = -1;//指向队列尾巴
    }
    //判断是否为满了
    public Boolean isFull(){  return rear ==maxSize-1;}
    //判断是否为空
    public boolean isEmpty() {
        return rear == front;
    }
    public void add(int n){
        if(isFull()){
            System.out.println("队列满了");
            return;
        }
        rear++;
        array[rear]=n;
    }
    //一个一个显示
    public int out(){
        //判断
        if(isEmpty()){
            throw new RuntimeException("队列是空的");
        }
        front++;
        return array[front];
    }
    public void show(){
        if(isEmpty()){
            throw new RuntimeException("队列是空的");
        }
        for (int i = 0; i <array.length;i++ ) {
            System.out.println("array["+i+"]=="+array[i]);
        }
    }
    public int  HeadData(){
        if (isEmpty()) {
            System.out.println("队列是空的");
        }
        return array[front+1];
    }
}