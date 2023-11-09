package learn_java基础.api;

public class String相关 {
    public static void main(String[] args) {
        /**
         * StringBuilder相关的使用(stringbuffer也是一样的,多了线程安全)
         */
        /**
         * final的理解：
         * 修饰类，不可继承
         * 修饰变量，不可以修改
         * 修饰方法，不可以重写
         * 修饰字段，是常量
         */
        {
            StringBuilder sb = new StringBuilder();
            sb = sb.append("abc");
            //只是类被final修饰
            sb = new StringBuilder("123");
            System.out.println(sb);
            System.out.println(sb.length());
            System.out.println(sb.capacity());
            sb.setCharAt(0,'a');
            System.out.println(sb.length());
            System.out.println(sb.capacity());
            sb.deleteCharAt(0);
            System.out.println(sb);

            final StringBuilder sb1 = new StringBuilder();
            //Cannot assign a value to final variable 'sb1'
//          sb1 = new StringBuilder("123");

            String s = "123";
            s = new String("1234");
            System.out.println(s);




        }





    }
}
