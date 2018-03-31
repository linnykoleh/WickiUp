package com.linnyk.ocp;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MappingBy {

    public static void main(String[] args) {
        final List<Student> ls = Arrays.asList(
                new Student("S1", Student.Grade.A),
                new Student("S2", Student.Grade.A),
                new Student("S3", Student.Grade.C)
        );

        ls.stream().forEach(student -> student.debug());

        final Map<Student.Grade, List<String>> collect = ls.stream()
                .collect(Collectors.groupingBy(Student::getGrade,
                        Collectors.mapping(Student::getName, Collectors.toList())
        ));
        System.out.println(collect); //{A=[S1, S2], C=[S3]}
    }

    static class Student {

        public void debug(){
            System.out.println();
        }

        public enum Grade {A, B, C, D, F,}

        private String name;
        private Grade grade;

        public Student(String name, Grade grade) {
            this.name = name;
            this.grade = grade;
        }

        public String getName() {
            return name;
        }

        public Grade getGrade() {
            return grade;
        }

        @Override
        public String toString() {
            return name + " : " + grade;
        }
    }

}
