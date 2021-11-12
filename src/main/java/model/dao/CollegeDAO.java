package model.dao;

import model.College;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CollegeDAO {
    private  JDBCUtil jdbcUtil = null;

    public CollegeDAO() {
        jdbcUtil = new JDBCUtil();
    }

    public List<College> findCollegeList() throws SQLException {
        String sql = "SELECT c_id, c_name "
                + "FROM college "
                + "ORDER BY c_name";
        jdbcUtil.setSqlAndParameters(sql, null);		// JDBCUtil에 query문 설정

        try {
            ResultSet rs = jdbcUtil.executeQuery();			// query 실행
            List<College> collegeList = new ArrayList<College>();	// User들의 리스트 생성
            while (rs.next()) {
                College college = new College(			// User 객체를 생성하여 현재 행의 정보를 저장
                        rs.getInt("c_id"),
                        rs.getString("c_name"));
                collegeList.add(college);				// List에 User 객체 저장
            }
            return collegeList;

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();		// resource 반환
        }
        return null;
    }
}
