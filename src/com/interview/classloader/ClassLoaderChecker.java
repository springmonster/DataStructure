package com.interview.classloader;

public class ClassLoaderChecker {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        CustomClassLoader customClassLoader = new CustomClassLoader("C:\\Users\\kuanghaochuan\\IdeaProjects\\DataStructure\\src\\com\\interview\\classloader\\", "kuanghaochuan");
        Class c = customClassLoader.findClass("Wali");
        System.out.println(c.getClassLoader());
        System.out.println(c.getClassLoader().getParent());
        System.out.println(c.getClassLoader().getParent().getParent());
        System.out.println(c.getClassLoader().getParent().getParent().getParent());
        c.newInstance();
    }
}
