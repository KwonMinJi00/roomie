package model.service;

import java.sql.SQLException;

import model.Student;
import model.dao.StudentDAO;

/**
 * 사용자 관리 API를 사용하는 개발자들이 직접 접근하게 되는 클래스.
 * StudentDAO를 이용하여 데이터베이스에 데이터 조작 작업이 가능하도록 하며,
 * 데이터베이스의 데이터들을 이용하여 비지니스 로직을 수행하는 역할을 한다.
 * 비지니스 로직이 복잡한 경우에는 비지니스 로직만을 전담하는 클래스를
 * 별도로 둘 수 있다.
 */
public class StudentManager {
    private static StudentManager studentMan = new StudentManager();
    private StudentDAO studentDao;
    private StudentAnalysis userAanlysis;

    private StudentManager() {
        try {
            studentDao = new StudentDAO();
            /*userAanlysis = new UserAnalysis(studentDao);*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static StudentManager getInstance() {
        return studentMan;
    }

    public int create(Student student) throws SQLException, ExistingStudentException {
        if (studentDao.existingStudent(student.getEmail()) == true) {
            throw new ExistingStudentException(student.getEmail() + "는 존재하는 아이디입니다.");
        }
        return studentDao.create(student);
    }

    public int remove(String email) throws SQLException, StudentNotFoundException {
        return studentDao.remove(email);
    }

    public Student findStudent(String email)
            throws SQLException, StudentNotFoundException {
        Student student = studentDao.findStudent(email);

        if (student == null) {
            throw new StudentNotFoundException(email + "는 존재하지 않는 아이디입니다.");
        }
        return student;
    }

    public boolean login(String email, String password)
            throws SQLException, StudentNotFoundException, PasswordMismatchException {
        Student student = findStudent(email);

        if (!student.matchPassword(password)) {
            throw new PasswordMismatchException("비밀번호가 일치하지 않습니다.");
        }
        return true;
    }

    public StudentDAO getStudentDao() {
        return this.studentDao;
    }
}