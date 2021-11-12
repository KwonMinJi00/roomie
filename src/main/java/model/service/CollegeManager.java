package model.service;

import model.College;
import model.dao.CollegeDAO;

import java.sql.SQLException;
import java.util.List;

public class CollegeManager {
    private static CollegeManager collegeManager = new CollegeManager();
    private CollegeDAO collegeDao;

    private CollegeManager() {
        try {
            collegeDao = new CollegeDAO();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static CollegeManager getInstance() {
        return collegeManager;
    }

    public List<College> findCollegeList() throws SQLException {
        return collegeDao.findCollegeList();
    }

}
