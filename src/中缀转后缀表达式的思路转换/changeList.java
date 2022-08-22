//package 中缀转后缀表达式的思路转换;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Stack;
//
//public class changeList {
//    public static void main(String[] args) {
//        //完成将一个中缀表达式转成后缀表达式的功能
//        //1.1+（（2+3）*4）-5= ——> 1 2 3 + 4 * + 5 -
//        //2.因为直接对str进行操作，不方便，先将字符串转为中缀的list的表达式对应的list
//        // 即 ”1+（（2+3）*4）-5=“  =》 ArrayList[1,+,（,（,2,+,3,）,*,4,）,-,5]
//        //3. 将得到的中缀表达式list=》转为后缀表达式
//        //ArrayList[1,+,(,(,2,+,3,）*,4,),-,5]=>ArrayList[1,2,3,+,*,+,5,-]
//        String expression = "1+((2+3)*4)-5";
//        List<String> infixExpression = toINfixExpressionList(expression);
//        System.out.println(infixExpression);
//
//
//
//
//
//
//
//
//
//
//       /* //定义逆波兰表达式
//        //（ 30 + 4）*5-6  =》    30 4 + 5 * 6 -
//        // 4 * 5 - 8 + 60 + 8 => 4 5 * 8 - 60 + 8 2 / +
//        //说明了方便
//        String suffixExperssion ="4 5 * 8 - 60 + 8 2 / +";
//        //思路
//        // 1. 先将 “3 4 + 5 * 6 - ” =》 放到ArrayList
//        //2. Arraylist 传递给一个方法，配合栈完成计算
//        List<String> list = getListString(suffixExperssion);
//        System.out.println("rpnList =" + list);
//        int res = calculate(list);
//        System.out.println("计算的结果是"+res);*/
//    }
//    //方法，将得到的中缀表达式list=》转为后缀表达式
//    public static List<String> parseSuffixExperssionList(List<String> ls){
//        Stack<String> s1 =new Stack<String>();//符号栈
//        //应为s2在整个转换过程中，没有pop操作，而且后面我们还需要逆序输出
//        //因为比较麻烦，这里我们就不用了Stack了，直接使用List《String》 s2
////        Stack<String> s2 = new Stack<String>();
//        List<String> s2 = new ArrayList<String>();
//        for(String item : ls){
//            //如果是一个数，入栈s2
//            if(item.matches("\\d+")){
//                s2.add(item);
//            }else if (item.equals("(")){
//                s1.push(item);
//            }else if(item.equals(")")){
//                while(!s1.peek().equals("(") ){
//                    //peek()查看栈底，但不弹出
//                    s2.add(s1.pop());
//                }
//                s1.pop();//！！！！把符号栈的s1的一个（弹出
//            } else {
//                //当item的优先级小于等于s1栈顶的运算符的优先，再转到（4,1）于s1中的新栈运算符比较
//                //我们缺少一个比较优先级高低的
//                while(s1.size() !=0)
//            }
//        }
//    }
//
//    //方法，讲中缀表达式转为list
//    public static List<String> toINfixExpressionList(String s){
//        //定义一个list，存放
//        List<String> ls = new ArrayList<String>();
//        int i = 0;//相当于一个指针,用于遍历字符串
//        String str;//多位数的拼接
//        char c;//遍历放到c中
//        do {
//            //如果c是一个非数字。就需要加入到ls中
//            if((c=s.charAt(i)) < 48|| (c=s.charAt(i)) > 57) {
//                ls.add(""+c);
//                i++;
//            }else {
//                //如果是一个数,需要考虑多位数的问题
//                str = "";//先将str置成“0"[48] -> '9'[57]
//                while (i<s.length()&&(c=s.charAt(i))>=48&&(c=s.charAt(i))<=47) {
//                    str += c;//拼接
//                    i++;
//                }
//                ls.add(str);
//            }
//        }while (i <s.length());
//        return ls;
//    }
//
//    //将一个你波兰表达式，一次方法哦ArrayList
//    public static List<String> getListString(String suffixExpression){
//        String[] split = suffixExpression.split(" ");
//        ArrayList<String> list = new ArrayList<String>();
//        for (String ele : split) {
//            list.add(ele);
//        }
//        return list;
//    }
//    //完成对逆波兰表达式的运算
//    /*
//     * 从左至右的扫描，将3和4压入堆栈
//     * 将5入栈
//     * 接下来是x运算符，因此弹出5和7，计算出3+4，值7，再将7和入栈
//     * 将6入栈
//     * 最后是-运算符，计算出35-6，即29，由此得出最终结果
//     * */
//    public static int calculate(List<String> ls){
//        //创造一个栈
//        Stack<String> stack = new Stack<String>();
//        for (String item: ls) {
//            //这里使用正则表达式来取出数
//            if (item.matches("\\d+")){
//                //匹配的是多位数
//                stack.push(item);
//            }else{
//                //pop出两个数，并运算，在入栈
//                int num1 = Integer.parseInt(stack.pop());
//                int num2 = Integer.parseInt(stack.pop());
//                int res = 0;
//                if(item.equals("+")){
//                    res = num1 + num2;
//                }else if (item.equals("-")) {
//                    //要注意顺序
//                    res = num2 - num1;
//                }else if (item.equals("*")) {
//                    res = num1 * num2;
//                }else if (item.equals("/")) {
//                    //顺序
//                    res = num2 / num1;
//                }else {
//                    throw new RuntimeException("运算符有误");
//                }
//                //把res入栈
//                stack.push(""+res);
//            }
//        }
//        //最后留在栈中的就是结果
//        return  Integer.parseInt(stack.pop());
//    }
//}
//
