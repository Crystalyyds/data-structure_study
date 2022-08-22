package 栈;

import java.util.Scanner;

public class No5 {
    public static void main(String[] args) {
        ArrayStack stack= new ArrayStack(4);
        boolean loop = true;
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (loop) {
            System.out.println("show 显示");
            System.out.println("exit 退出");
            System.out.println("push 表示添加");
            System.out.println("pop 表示出站");
            System.out.println("请确定你的选择");
            key = scanner.next();
            switch ("key"){
                case "show":
                    stack.list();
                    break;
                case "push":
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        int res = stack.pop();
                        System.out.println("出站的顺序是"+res);
                    }catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop=false;
                    break;
            }
        }

        System.out.println("程序退出");
    }
}

class ArrayStack{
    private int maxStack;
    private int[] stack;
    private int top = -1;//栈顶
    public ArrayStack(int maxStack){
        this.maxStack = maxStack;
        stack = new int[this.maxStack];
    }
    //栈满
    public  boolean isFull(){
        return top==maxStack-1;
    }
    public  boolean isEmpty() {
        return  top ==1;
    }
    public void push(int value){
        if ((isFull())){
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }
    //出站
    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("站空");
        }
        int value = stack[top];
        top--;
        return  value;
    }
    //遍历
    public void list(){
        if (isEmpty()) {
            System.out.println("没有数据");
            return;
        }
        for (int i = top; i >0; i++) {
            System.out.println("stack["+i+"]="+stack[i]);
        }
    }

}
