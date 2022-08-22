package list和map的转换;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class change {
    public static void main(String[] args) {
        ArrayList<people> list = new ArrayList<people>();
        list.add(new people("杨某人",20));
        list.add(new people("葛大哥",20));
        System.out.println(list.toString());
        HashMap<String,people> map = new HashMap<String, people>();
        for (people ele : list) {
            map.put(ele.getName(), ele);
        }

    }
}
class people {
    public String name;
    public int age;

    public people(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "people{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

