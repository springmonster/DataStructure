package com.interview.tips;

/**
 * 如何获取泛型的class
 */
public class Tip {
    public static void main(String[] args) {
        Foo<String> foo = new Foo<String>() {
            @Override
            public Class<String> getTClass() {
                return super.getTClass();
            }
        };
        System.out.println(foo.getTClass());

        Bar<String, Integer> bar = new Bar<String, Integer>() {
            @Override
            public Class<String> getTClass1() {
                return super.getTClass1();
            }

            @Override
            public Class<Integer> getTClass2() {
                return super.getTClass2();
            }
        };

        System.out.println("----------------------------");
        System.out.println(bar.getTClass1());
        System.out.println(bar.getTClass2());
        System.out.println("----------------------------");

        Bar<Integer, Integer> bar1 = new Bar<Integer, Integer>() {
            @Override
            public Class<Integer> getTClass1() {
                return super.getTClass1();
            }

            @Override
            public Class<Integer> getTClass2() {
                return super.getTClass2();
            }
        };

        System.out.println("----------------------------");
        System.out.println(bar1.getTClass1());
        System.out.println(bar1.getTClass2());
        System.out.println("----------------------------");
    }
}
