package org.example.test;

public class Test {

    public static void main(String[] args) {
        C c = new C();
        System.out.println(c.x);
    }

    private static class P{
        protected int x = 3;//子类继承

        public P(){
            super();
            System.out.println(x);
            s();
            System.out.println(x);
        }
        protected void s(){
            x = 4;
        }
    }

    private static class C extends P{
       protected int x = 1;

        public C(){
 //           super();先执行父类
            System.out.println(x);
        }
        protected void s(){
            x = 6;
        }
    }
}


