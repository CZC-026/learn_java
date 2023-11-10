package learn_java基础.api;
import lombok.var;

import java.util.*;
/**
 * 1.接口中所有方法默认public
 * 2.接口中中不能有实例字段
 * 3.接口可以实现简单的方法，但是这些方法不能引用实例字段
 */
interface Comparable {
    int compareTo(Object other);
}

class Employee implements java.lang.Comparable {
    private String name;
    private double salary;
    public Employee(String name,double salary) {
        this.name = name;
        this.salary = salary;
    }
    //理解compareTo,类似的还有equals,hashcode，重写的时候都是当前对象与传入的other对象进行比较
    public int compareTo(Object other) {
        //如果强转出现异常该怎么处理,使用instanceof方法
        if(other == null) {
            throw new NullPointerException();
        }
        if(!(other instanceof Employee)) {
            throw new ClassCastException();
        }
        Employee otherEmployee = (Employee) other;
//        return Double.compare(this.salary, otherEmployee.salary);
        if (this.salary < otherEmployee.salary) {
            return -1;
        }
        if (this.salary > otherEmployee.salary) {
            return 1;
        }
        return 0;
    }
    public String getName() {
        return this.name;
    }
    public double getSalary() {
        return this.salary;
    }

}

/**
 * 1.接口不是类，不能用new来实例化接口
 * 2.接口可以进行声明，但是声明的接口变量必须引用实现了该接口的类的对象
 * Comparable c = new Employee("Harry Hacker",35000);
 * 3.同样可以使用instanceOf来判断一个对象是否实现了某个接口
 * 4.接口之间可以继承，使用extends关键字，拓展接口
 * 5.接口中不可以包含实例，但是可以包含常量，所有的常量都是public static final的，继承接口的类可以直接使用这些常量
 *
 */

/**
 * 接口与抽象类
 * 抽象类的问题：每个类只能扩展一个类，Employee扩展Person就不能扩展Comparable
 * class Employee extends Person,Comparable //错误
 * class Employee extends Person implements Comparable //正确
 *
 */
abstract class Comparable1 {
    public abstract int compareTo(Object other);

}

/**
 * Comparator和 Comparable接口的区别和使用场景
 * 1.Comparable接口是在类中实现的，而Comparator是在类外部实现的
 * 2.本身固有顺序的class适合实现Comparable接口，比如String，Integer，这些类中方法已经重写了，我们不能再改，
 * 想要其他的排序方式，就需要使用Comparator接口
 */
class LengthComparator implements Comparator<String> {
    public int compare(String first,String second) {
        return first.length() - second.length();
    }
}

public class LearnInterface {
    public static void main(String[] args) {
        var staff = new Employee[3];
        staff[0] = new Employee("Harry Hacker",35000);
        staff[1] = new Employee("Carl Cracker",75000);
        staff[2] = new Employee("Tony Tester",38000);
        Arrays.sort(staff);
        for(Employee employee : staff) {
            System.out.println("name="+employee.getName()+",salary="+employee.getSalary());
        }
        //使用Comparator接口
        var comp = new LengthComparator();
        if(comp.compare("hello","world") > 0) {
            System.out.println("hello大于world");
        }
        else {
            System.out.println("hello小于world");
        }
        String[] friends = new String[]{"123","4567","123456789"};
        Arrays.sort(friends , comp);
    }
}
