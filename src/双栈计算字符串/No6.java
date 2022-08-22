package 双栈计算字符串;

import java.util.ArrayList;

public class No6 {
    public static void main(String[] args) {
        String expression = "3+2*6-2";
        ArrayStack Array1 = new ArrayStack(10);
        ArrayStack Array2 = new ArrayStack(10);
        //用于扫描
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';
        while (true) {
            //一个一个获得字符
            ch = expression.substring(index,index+1).charAt(0);
            //判断
            if(Array2.Isoper(ch)) {
                //判断符号栈是否为空
                if (Array2.isEmpty()) {
                    //处理
                    if (Array2.poiority(ch) <= Array2.poiority(Array1.peek())) {
                        //数栈中pop出2数运算
                        num1 = Array1.pop();
                        num2 = Array1.pop();
                        oper = Array2.pop();
                        res = Array1.cal(num1, num2, oper);
                        Array1.push(res);
                        Array2.push(ch);
                    } else {
                        Array2.push(ch);
                    }
                } else {
                    //空，直接入栈
                    Array2.push(ch);
                }
            }else{
                Array1.push(ch-48);
            }
            //让index + 1，判断是否扫描到expression
            index++;
            if (index >= expression.length()) {
                break;
            }
        }
        //扫描完毕，开始运算
        while (true){
            //如果符号栈为空，数栈中只有最后一个数字
            if(Array2.isEmpty()){
                break;
            }
            num1 = Array1.pop();
            num2 = Array1.pop();
            oper = Array2.pop();
            res = Array1.cal(num1, num2, oper);
            Array1.push(res);
        }
        System.out.printf("表达式是 %s = %d",expression,Array1.pop());
    }
}
//先
class ArrayStack {
    private int maxStack;
    private int[] stack;
    private int top = -1;//栈顶

    public ArrayStack(int maxStack) {
        this.maxStack = maxStack;
        stack = new int[this.maxStack];
    }

    //栈满
    public boolean isFull() {
        return top == maxStack - 1;
    }

    public boolean isEmpty() {
        return top == 1;
    }

    public void push(int value) {
        if ((isFull())) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }

    //出站
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("站空");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //遍历
    public void list() {
        if (isEmpty()) {
            System.out.println("没有数据");
            return;
        }
        for (int i = top; i > 0; i++) {
            System.out.println("stack[" + i + "]=" + stack[i]);
        }
    }
    //返回运算符的优先级，优先级又程序员表示，优先级用数字表示
    public int poiority(int oper){
        if(oper=='*'||oper =='/'){
            return 1;
        }else if (oper == '+'||oper =='-') {
            return 0;
        }else {
            return -1;
        }
    }
    //判断是否为运算符
    public boolean Isoper(char val){
        return  val == '+'||val == '-'||val == '*'||val == '/';
    }
    //计算
    public int cal(int num1,int num2,int oper){
        int res =0;//存放计算结果
        switch (oper) {
            case '+':
                res = num1+num2;
                break;
            case '-' :
                res = num2-num1;
                break;
            case '*' :
                res = num1*num2;
                break;
            case '/' :
                res = num2/num1;
                break;
        }
        return res;
    }
    //增加一个出站，但不是真正的出栈
    public int peek(){
        return stack[top];
    }

}

