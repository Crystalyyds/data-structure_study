package 单链表;

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
}


