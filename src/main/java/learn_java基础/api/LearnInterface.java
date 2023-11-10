package learn_java基础.api;
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

public class LearnInterface {

}
