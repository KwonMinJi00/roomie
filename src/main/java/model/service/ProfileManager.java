package model.service;

import model.Profile;
import model.dao.ProfileDAO;

import java.sql.SQLException;

public class ProfileManager {

    private ProfileDAO profileDAO;
    private static ProfileManager manager = new ProfileManager();
    //private StudentAnalysis userAanlysis;

    private ProfileManager() {
        try {
            profileDAO = new ProfileDAO();
            /*userAanlysis = new UserAnalysis(studentDao);*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ProfileManager getInstance() {
        return manager;
    }

    public int create(Profile profile) throws SQLException, ExistingStudentException {
        return profileDAO.create(profile);
    }

    public int update(Profile profile) {return 1;}


    public Profile findProfile(int studentId)
            throws SQLException, StudentNotFoundException {
        Profile profile = profileDAO.findProfile(studentId);

        if (profile == null) {
            throw new StudentNotFoundException(studentId + "는 존재하지 않는 프로필입니다.");
        }
        return profile;
    }


}
