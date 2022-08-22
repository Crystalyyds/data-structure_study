package 环形链表;

//约瑟夫问题
public class No4  {
    public static void main(String[] args) {
        Manage queue= new Manage();
        queue.add(5);
        queue.list();
        //测试一把小孩出圈2 4 1 5 3
        queue.countPeople(1,2,5);
    }
}

class People{

    public int no;
    public People next;
    public People(int no){
        this.no = no;
    }

    @Override
    public String toString() {
        return "People{" +
                ", no=" + no +
                '}';
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public People getNext() {
        return next;
    }

    public void setNext(People next) {
        this.next = next;
    }
}
//创建一个环形的单项列表
class Manage{
    private People temp=new People(-1);
    public void add(int nums){
        //nums简单的做一个校验
        if(nums<1){//至少一个
            System.out.println("nums不正确");
        }
        People cur = null;//构造环形链表
        //使用for创建
        for (int i = 1; i <= nums; i++) {
            //根据编号，创建小孩节点
            People people = new People(i);
            //如果是第一个小孩
            if(i==1){
                temp=people;
                temp.setNext(temp);//构循环
                cur = temp;
            }else {
                cur.setNext(people);
                people.setNext(temp);
                cur=people;
            }
        }
    }
    //遍历当前的环形链表
    public void list() {
        if (temp==null) {
            System.out.println("链表为空");
            return;
        }
        //因为temp不能动,辅助
        People cur = temp;
        while ((true)){
            System.out.println("小孩的编号是"+cur.getNo()+"号\n");
            if (cur.getNext()==temp) {
                System.out.println("遍历完毕");
                break;
            }
            //没有完毕，next后移
            cur=cur.getNext();
        }
    }
    //根据用户的输入，计算出小孩出圈的顺序
    //starNo表示第几个小孩开始数数
    //countNum表示数几下
    //nums表示最初有多少小孩
    //补充。小孩报数钱，先让temp和helper，事先应该指向环形链表的最后这一个节点
    public void countPeople(int starNo,int countNum,int nums) {
        //先对数据开始校验
        if (temp == null||starNo<1||starNo >nums){
            System.out.println("输入参数有问题");
            return;
        }
        //创建辅助helper，帮助出圈
        People helper = temp;
        while (true){
            if (helper.getNext()==temp) {
                break;//遍历结束
            }
            helper=helper.getNext();
        }
        //小孩报数前，先让temp和helper 移动 k - 1 次
        //一定到k这里来

        for (int i = 0; i < starNo-1; i++) {
            temp=temp.getNext();
            helper=helper.getNext();
        }
        //当小孩报数前，让temp和helper指针同时的移动 m - 1次，然后出题
        //这是一个操作，直到只有一个节点
        while (true) {
            if (helper == temp){
                break;
            }
            //rang temp 和helper同时移动countNum-1
            for (int i = 0; i < countNum-1; i++) {
                temp = temp.getNext();
                helper = helper.getNext();
            }
            //这是temp指向的节点就是要出圈的节点
            System.out.println("小孩的编号是"+temp.getNo()+"号\n");
            ///这是temp指向小孩出圈
            temp = temp.getNext();
            helper.setNext(temp);
        }
        System.out.println("最好喝留在圈内的编号是"+temp.getNo() + "号");
    }
}