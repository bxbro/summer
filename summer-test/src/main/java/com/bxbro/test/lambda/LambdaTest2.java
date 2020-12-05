package com.bxbro.test.lambda;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author dong
 * @Date 2020/12/5
 */
public class LambdaTest2 {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("zhangsan", 18, 99));
        students.add(new Student("lisi", 19, 60));
        students.add(new Student("wangwu", 20, 85));
        students.add(new Student("maliu", 21, 70));
        students.add(new Student("zhouqi", 22, 74));

//        getByFilter(students, new AgeFilter());
//        System.out.println("=======================");
//        getByFilter(students, new ScoreFilter());


//        getByFilter(students, new StudentFilter() {
//            @Override
//            public boolean compare(Student student) {
//                return student.getAge() > 18;
//            }
//        });
//        System.out.println("kkkkkkkkkkkkkkk");
//        getByFilter(students, new StudentFilter() {
//            @Override
//            public boolean compare(Student student) {
//                return student.getScore() > 80;
//            }
//        });

        getByFilter(students, (a)->a.getAge()>18);
        System.out.println("bbbbbbbbbbb");
        getByFilter(students,(a)->a.getScore()>80);


    }

    public static void getByFilter(List<Student> students, StudentFilter filter) {
        ArrayList<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (filter.compare(student)) {
                result.add(student);
            }
        }
        printStudent(result);
    }
    public static void printStudent(List<Student> students) {
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }
}
