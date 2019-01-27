package linkedlist.linklist;

/**
 * 局部变量还是全局变量
 * 需要看变量声明的位置   声明在方法体内部就是局部变量
 *
 *
 *
 * 加载的顺序是先加载成员变量  再  加载构造代码块  再  按照 main方法中的书写的方法先后调用
 *
 *
 *
 * @author lixw
 * @date created in 21:50 2019/1/26
 */
public class Test {

    public static void main(String[] args) {
        Test test = new Test();
        test.test();
        test.test2();
        test.test3();
        System.out.println(test.i + "    main");

    }
    /**
     *  全局变量
     */
    int i = 10;

    public void test() {
        System.out.println(i  +  "   test111");
        //根据输出 后面调用的test3 输出的值可以看出 这个i 不是局部变量
        //是不是局部变量看的是声明的位置
        i = 3;
        System.out.println(i+  "   test1");
    }
    public void test3() {
        //也是局部？？？
        System.out.println(i+  "   test3");
    }

    public void test2() {
        //局部变量
        int i = 6;
        System.out.println(i+  "   test2");
//          {
//              int i = 10;
//          }
    }

    /**
     * 构造代码块
     */
    {

        System.out.println(i  +" 构造代码块");
    }




}
