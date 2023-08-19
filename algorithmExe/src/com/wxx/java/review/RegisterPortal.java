package com.wxx.java.review;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author wxxstar
 * @create 2023-08-16 20:39
 */
public class RegisterPortal {

    private static final RegisterPortal INSTANCE = new RegisterPortal();

    private List<Student> students = Collections.synchronizedList(new ArrayList<>());

    private RegisterPortal() {

    }

    public RegisterPortal getInstance() {
        return INSTANCE;
    }

    public void register(Student s) {
        students.add(s);
    }

    public List<Student> list() {
        return students;
    }
}

class Student {
}
