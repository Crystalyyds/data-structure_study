package 双链表;
public class No3 {
    public static void main(String[] args) {
        System.out.println("双向链表的测试");
        System.out.println("-----------添加---------------");
        HeroNode1 hero1 = new  HeroNode1(1,"杨某人","反恐专家");
        HeroNode1 hero2 = new  HeroNode1(2,"梁某人","自动化干饭");
        HeroNode1 hero3 = new  HeroNode1(3,"孙某人","吃里扒外");
        HeroNode1 hero4 = new  HeroNode1(4,"蒋某人","人生导师 ");
        manage1 queue = new manage1();
        queue.add(hero1);
        queue.add(hero2);
        queue.add(hero3);
        queue.add(hero4);
        queue.list();
        System.out.println("-------------修改-------------");
        HeroNode1 newHeroNode = new HeroNode1(4,"葛某人","全能大佬");
        queue.Update(newHeroNode);
        System.out.println("修改过后");
        queue.list();
        System.out.println("------------删除--------------");
        queue.Del(3);
        System.out.println("删除过后");
        queue.list();
        System.out.println("------------插入--------------");
        HeroNode1 hero5 =new HeroNode1(3,"周某人","嗜睡小王子");
        queue.Insert(hero5);
        queue.list();
    }
}
//创建一个双向链表类
class HeroNode1{
    public int no;
    public String name;
    public String nickname;
    public HeroNode1 next;
    public HeroNode1 pre;//指向前一个..默认为null
    public HeroNode1(int no,String name,String nickname){
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }
    //全部显示，重写toString

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
class manage1{
    //先初始化一个头结点，头结点不要动
    private HeroNode1 head = new HeroNode1(0,"","");
    //返回偷节点
    public  HeroNode1 getHead() {
        return head;
    }
    //遍历双线链表
    public void list(){
        //判断链表是否为空
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        //因为头结点为空，不能动，所以我们需要一个辅助节点来遍历
        HeroNode1 temp = head.next;
        while (true) {
            //判断是否以为链表最后
            if(temp== null){
                break;
            }
            //输出节点
            System.out.println(temp.toString());
            //讲temp后移,要小心
            temp = temp.next;

        }
    }
    //添加，默认为最后一位添加
    public void add(HeroNode1 heroNode){
        //因为head节点不能动，因此我们需要一个辅助节点
        HeroNode1 temp = head;
        while (true){
            if (temp.next==null) {
                break;
            }
            //如果没有找到最后,讲temp后移
            temp = temp.next;
        }
        //当退出while循环是，形成一个双向链表
        temp.next=heroNode;
        heroNode.pre=temp;

    }
    //修改
    public void Update(HeroNode1 newHeroNode) {
        boolean flag = false;
        //判断是否为空
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        //定义一个辅助变量
        HeroNode1 temp= head.next;
        while (true){
            if (temp==null) {
                break;//链表已经遍历结束
            }
            if (temp.no==newHeroNode.no){
                flag = true;
                break;
            }
            temp=temp.next;
        }
        //根据flag判断是否找到
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickname=newHeroNode.nickname;
        }else {
            System.out.println("没有找到编号等于这个的节点");
        }
    }


    public void Insert(HeroNode1 heroNode){
        HeroNode1 temp = head;
        boolean flag =false;//标志添加的办好是否纯在，默认为false
        while(true){
            if(temp.next == null){
                //说明链表是空的
                break;
            }
            if(temp.next.no>heroNode.no ){//位置找到了
                break;
            }else if (temp.next.no == heroNode.no){
                flag=true;//说明编号存在
                break;
            }
            temp = temp.next;//后移，遍历当前链表
        }
        //判断flag
        if(flag){
            System.out.println("准备插入的英雄编号"+heroNode.no + "已经存在，不能添加\n");
        }else {
            heroNode.next=temp.next;
            temp.next=heroNode;
            heroNode.pre=temp;
            heroNode.next.pre=heroNode;

        }
    }
    //删除
    public void  Del(int no){
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        HeroNode1 temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                //已经到最后
                break;
            }
            if (temp.no == no) {
                System.out.println("有运行吗");
                flag = true;
                break;
            }
            temp = temp.next;//temp后移
        }
        if (flag) {
            //可以删除
            temp.pre.next=temp.next;
            //如果最后一个节点不需要执行这句话，会出现空指针异常
            temp.next.pre=temp.pre;
        }else {
            System.out.println("要删除的"+no+"节点不存在\n");
        }

    }

}
