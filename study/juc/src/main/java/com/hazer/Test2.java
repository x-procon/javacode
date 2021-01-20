package com.hazer;

/**
 * @author Hazer
 * @date 2020-08-31 18:53
 */
class Test2 {


    static boolean foo(char c) {
        System.out.print(c);
        return true;
    }

    public static void main(String[] argv) {
        int i = 0;
        for (foo('A'); foo('B') && (i < 2); foo('C')) {
            i++;
            foo('D');
        }
        System.out.println(2 % 2);
    }

}


class Person {
    String name = "No name";

    public Person(String nm) {
        name = nm;
    }
}

class Employee extends Person {
    String empID = "0000";

    public Employee(String id) {
        super(id);
        empID = id;
    }
}

class Test {
    private String baseName = "base";

    public Test() {
        callName();
    }

    public void callName() {
        System.out.println(baseName);
    }

    static class Sub extends Test {
        private String baseName = "sub";

    }

    public static int a = 1;

    public static boolean isAdmin(String userId) {
        return userId.toLowerCase() == "admin";
    }

    public static void main(String[] args) {
        char myChar = 'g';
        String myStr = Character.toString(myChar);
        System.out.println("String is: " + myStr);
        myStr = String.valueOf(myChar);
        System.out.println("String is: " + myStr);
    }
}


class Base {
    public void method() {
        System.out.println("Base");
    }
}

class Son extends Base {
    public void method() {
        System.out.println("Son");
    }

    public void methodB() {
        System.out.println("SonB");
    }
}

class Test01 {
    public static void main(String[] args) {
        Son base = new Son();
        base.method();
        base.methodB();
    }
}