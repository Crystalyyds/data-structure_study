package 逆波兰计算器;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {
        //定义逆波兰表达式
        //（ 30 + 4）*5-6  =》    30 4 + 5 * 6 -
        // 4 * 5 - 8 + 60 + 8 => 4 5 * 8 - 60 + 8 2 / +
        //说明了方便
        String suffixExperssion ="4 5 * 8 - 60 + 8 2 / +";
        //思路
        // 1. 先将 “3 4 + 5 * 6 - ” =》 放到ArrayList
        //2. Arraylist 传递给一个方法，配合栈完成计算
        List<String> list = getListString(suffixExperssion);
        System.out.println("rpnList =" + list);
        int res = calculate(list);
        System.out.println("计算的结果是"+res);
    }
    //将一个你波兰表达式，一次方法哦ArrayList
    public static List<String> getListString(String suffixExpression){
        String[] split = suffixExpression.split(" ");
        ArrayList<String> list = new ArrayList<String>();
        for (String ele : split) {
            list.add(ele);
        }
        return list;
    }
    //完成对逆波兰表达式的运算
    /*
    * 从左至右的扫描，将3和4压入堆栈
    * 将5入栈
    * 接下来是x运算符，因此弹出5和7，计算出3+4，值7，再将7和入栈
    * 将6入栈
    * 最后是-运算符，计算出35-6，即29，由此得出最终结果
    * */
    public static int calculate(List<String> ls){
        //创造一个栈
        Stack<String> stack = new Stack<String>();
        for (String item: ls) {
            //这里使用正则表达式来取出数
            if (item.matches("\\d+")){
                //匹配的是多位数
                stack.push(item);
            }else{
                //pop出两个数，并运算，在入栈
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                int res = 0;
                if(item.equals("+")){
                    res = num1 + num2;
                }else if (item.equals("-")) {
                    //要注意顺序
                    res = num2 - num1;
                }else if (item.equals("*")) {
                    res = num1 * num2;
                }else if (item.equals("/")) {
                    //顺序
                    res = num2 / num1;
                }else {
                    throw new RuntimeException("运算符有误");
                }
                //把res入栈
                stack.push(""+res);
            }
        }
        //最后留在栈中的就是结果
        return  Integer.parseInt(stack.pop());
    }
}

