package learn_java基础.api;

import lombok.extern.slf4j.Slf4j;
class Parent{}
class Child extends Parent{}

@Slf4j
class MyClass{
    private int fields1;
    private String fields2;
    public MyClass(int fields1,String fields2) {
        this.fields1 = fields1;
        this.fields2 = fields2;
    }
    public boolean equals(Object other){
        if(other == null) return false;
        if(other == this) return true;
/**
 * 强转什么时候会出现异常
 * 1.类型不兼容的强转 ClassCastException
 * 2.对象为null时候异常 NullPointerException
 * 3.类继承关系中，没有继承关系，或者有继承关系却由父类到子类也会抛出异常
 * 另外：数据类型强转的时候可能会有精度丢失
 */

        if(!(other instanceof MyClass)){
            //应该记录日志或者抛出异常
//            log.error("MyClass equals error");
            throw new ClassCastException("MyClass equals error");
        }
        //对Object进行强转
        MyClass otherMyClass = (MyClass) other;
        return this.fields1==otherMyClass.fields1 && this.fields2.equals(otherMyClass.fields2);
    }
    public int getFields1() {
        return this.fields1;
    }
    public String getFields2() {
        return this.fields2;
    }
    private void setFields1(int fields1) {
        this.fields1 = fields1;
    }
    private void setFields2(String fields2) {
        this.fields2 = fields2;
    }
}

class MyChildClass extends MyClass{

    public MyChildClass(int fields1, String fields2) {
        super(fields1, fields2);
    }
}
@Slf4j
public class LearnEquals {
    public static void main(String[] args) {
//        Parent p = new Parent();
//        Child c = (Child) p; // ClassCastException

        MyClass myClass1 = new MyClass(1,"1");
        MyClass myClass2 = new MyClass(1,"1");

        System.out.printf("两者的地址比较:%s\n",myClass1 == myClass2);
        System.out.printf("两者的equal比较：%s\n",myClass1.equals(myClass2));
    //子类转为父类不会抛出异常
        MyChildClass myChildClass = new MyChildClass(1,"1");
        System.out.printf("字父类的地址比较:%s\n",myClass1 == myChildClass);
        System.out.printf("字父类的equal比较：%s\n",myClass1.equals(myChildClass));

        System.out.println("====================================");
//        Integer a = new Integer("1");
//        System.out.println(myClass1.equals(a));//MyClass equals error

    }

}
