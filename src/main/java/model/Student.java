package model;

import jdk.nashorn.internal.objects.NativeString;

public class Student {

    private int s_id;
    private String email;
    private String password;
    private String name;
    private String college;
    private int gender;

    public Student() {
    }

    public Student(int s_id, String email, String password, String name, String college, int gender) {
        this.s_id = s_id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.college = college;
        this.gender = gender;
    }
    public Student(String name, String email, String password, int gender, String college) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.college = college;
        this.gender = gender;
    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public String getEmail() { return email; }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }


    public boolean matchPassword(String password) {
        if (password == null) {
            return false;
        }
        return this.password.equals(password);
    }

    public boolean isSameStudent(String studentId) {
        return this.email.equals(studentId);
    }
}
