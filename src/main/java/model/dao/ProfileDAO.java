package model.dao;

import model.Profile;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfileDAO {
    private JDBCUtil jdbcUtil = null;

    public ProfileDAO() {
        jdbcUtil = new JDBCUtil();	// JDBCUtil 객체 생성
    }

    public int create(Profile profile) throws SQLException {
        String sql = "INSERT INTO PROFILE VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Object[] param = new Object[] {profile.getS_id(), profile.getActivation(),
                profile.getName(), profile.getPr_img(), profile.getAge(), profile.getSleep_habit(),
                profile.getLifestyle(), profile.getSmoking(), profile.getGrade(), profile.getMajor(),
                profile.getMbti(), profile.getCleaning(), profile.getIndoor_eating(),
                profile.getSharing(), profile.getHabitude()};
        jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil 에 insert문과 매개 변수 설정

        try {
            int result = jdbcUtil.executeUpdate();	// insert 문 실행
            return result;
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();
        } finally {
            jdbcUtil.commit();
            jdbcUtil.close();	// resource 반환
        }
        return 0;
    }

    public int update(Profile profile) throws SQLException {
        String sql = "UPDATE PROFILE "
                + "SET activation=?, name=?, pr_img=?, age=?, sleep=?, lifestyle=?, smoking=?, grade=?, " +
                "major=?, mbti=?, cleaning=?, indoor_eating=?, sharing=?, habitude=?"
                + "WHERE s_id=?";
        Object[] param = new Object[] {profile.getActivation(),
                profile.getName(), profile.getPr_img(), profile.getAge(), profile.getSleep_habit(),
                profile.getLifestyle(), profile.getSmoking(), profile.getGrade(), profile.getMajor(),
                profile.getMbti(), profile.getCleaning(), profile.getIndoor_eating(),
                profile.getSharing(), profile.getHabitude(),
                profile.getS_id()};
        jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil에 update문과 매개 변수 설정

        try {
            int result = jdbcUtil.executeUpdate();	// update 문 실행
            return result;
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();
        }
        finally {
            jdbcUtil.commit();
            jdbcUtil.close();	// resource 반환
        }
        return 0;
    }


    /**
     * 주어진 사용자 ID에 해당하는 사용자 정보를 데이터베이스에서 찾아 Profile 도메인 클래스에
     * 저장하여 반환.
     */
    public Profile findProfile(int s_Id) throws SQLException {
        String sql = "SELECT activation, name, pr_img, age, sleep, lifestyle, smoking, grade, " +
                "major, mbti, cleaning, indoor_eating, sharing, habitude "
                + "FROM PROFILE "
                + "WHERE s_id=? ";
        jdbcUtil.setSqlAndParameters(sql, new Object[] {s_Id});	// JDBCUtil에 query문과 매개 변수 설정

        try {
            ResultSet rs = jdbcUtil.executeQuery();		// query 실행
            if (rs.next()) {						// 학생 정보 발견
                Profile profile = new Profile(		// Profile 객체를 생성하여 정보를 저장
                        s_Id,
                        rs.getBoolean("activation"),
                        rs.getString("name"),
                        rs.getInt("pr_img"),
                        rs.getInt("age"),
                        rs.getInt("sleep_habit"),
                        rs.getInt("lifestyle"),
                        rs.getInt("smoking"),
                        rs.getInt("grade"),
                        rs.getString("major"),
                        rs.getInt("cleaning"),
                        rs.getInt("indoor_eating"),
                        rs.getInt("mbti"),
                        rs.getInt("sharing"),
                        rs.getInt("habitude")
                );
                return profile;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();		// resource 반환
        }
        return null;
    }

    /**
     * 해당 학교 전체 사용자 정보를 검색하여 List에 저장 및 반환
     */
    public List<Profile> findProfileList(int c_Id, int gender) throws SQLException {
        String sql = "SELECT activation, name, pr_img, age, sleep, lifestyle, smoking, grade, " +
                "major, mbti, cleaning, indoor_eating, sharing, habitude "
                + "FROM PROFILE p JOIN STUDENT s ON p.s_id = s.s_id "
                + "WHERE s.c_id=? AND s.gender=? "
                + "ORDER BY s_id";
        jdbcUtil.setSqlAndParameters(sql, new Object[] {c_Id, gender});		// JDBCUtil에 query문 설정

        try {
            ResultSet rs = jdbcUtil.executeQuery();			// query 실행
            List<Profile> profileList = new ArrayList<Profile>();	// Profile들의 리스트 생성
            while (rs.next()) {
                Profile profile = new Profile(			// Profile 객체를 생성하여 현재 행의 정보를 저장
                        rs.getInt("s_id"),
                        rs.getBoolean("activation"),
                        rs.getString("name"),
                        rs.getInt("pr_img"),
                        rs.getInt("age"),
                        rs.getInt("sleep"),
                        rs.getInt("lifestyle"),
                        rs.getInt("smoking"),
                        rs.getInt("grade"),
                        rs.getString("major"),
                        rs.getInt("cleaning"),
                        rs.getInt("indoor_eating"),
                        rs.getInt("mbti"),
                        rs.getInt("sharing"),
                        rs.getInt("habitude"));
                profileList.add(profile);				// List에 Profile 객체 저장
            }
            return profileList;

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();		// resource 반환
        }
        return null;
    }

    /**
     * 전체 사용자 정보를 검색한 후 현재 페이지와 페이지당 출력할 사용자 수를 이용하여
     * 해당하는 사용자 정보만을 List에 저장하여 반환.
     */
    public List<Profile> findUserList(int currentPage, int countPerPage, int c_Id, int gender) throws SQLException {
        String sql = "SELECT activation, name, pr_img, age, sleep, lifestyle, smoking, grade, " +
                "major, mbti, cleaning, indoor_eating, sharing, habitude "
                + "FROM PROFILE p JOIN STUDENT s ON p.s_id = s.s_id "
                + "WHERE s.c_id=? AND s.gender=? "
                + "ORDER BY s_id";
        jdbcUtil.setSqlAndParameters(sql, new Object[] {c_Id, gender},					// JDBCUtil에 query문 설정
                ResultSet.TYPE_SCROLL_INSENSITIVE,				// cursor scroll 가능
                ResultSet.CONCUR_READ_ONLY);

        try {
            ResultSet rs = jdbcUtil.executeQuery();				// query 실행
            int start = ((currentPage-1) * countPerPage) + 1;	// 출력을 시작할 행 번호 계산
            if ((start >= 0) && rs.absolute(start)) {			// 커서를 시작 행으로 이동
                List<Profile> profileList = new ArrayList<Profile>();	// Profile들의 리스트 생성
                do {
                    Profile profile = new Profile(			// Profile 객체를 생성하여 현재 행의 정보를 저장
                            rs.getInt("s_id"),
                            rs.getBoolean("activation"),
                            rs.getString("name"),
                            rs.getInt("pr_img"),
                            rs.getInt("age"),
                            rs.getInt("sleep"),
                            rs.getInt("lifestyle"),
                            rs.getInt("smoking"),
                            rs.getInt("grade"),
                            rs.getString("major"),
                            rs.getInt("cleaning"),
                            rs.getInt("indoor_eating"),
                            rs.getInt("mbti"),
                            rs.getInt("sharing"),
                            rs.getInt("habitude"));
                    profileList.add(profile);							// 리스트에 Profile 객체 저장
                } while ((rs.next()) && (--countPerPage > 0));
                return profileList;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();		// resource 반환
        }
        return null;
    }

    /**
     * 특정 필터 사용자들을 검색하여 List에 저장 및 반환
     */
    /*public List<Profile> findUsersInSearch(Profile profile) throws SQLException {
        String sql = "SELECT userId, name, email, phone FROM UserInfo "
                + "WHERE commId = ?";
        jdbcUtil.setSqlAndParameters(sql, new Object[] {profile});	// JDBCUtil에 query문과 매개 변수 설정

        try {
            ResultSet rs = jdbcUtil.executeQuery();		// query 실행
            List<User> memList = new ArrayList<User>();	// member들의 리스트 생성
            while (rs.next()) {
                User member = new User(			// User 객체를 생성하여 현재 행의 정보를 저장
                        rs.getString("userId"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone"));
                memList.add(member);			// List에 Community 객체 저장
            }
            return memList;

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();		// resource 반환
        }
        return null;
    }*/


    /**
     * 주어진 사용자 ID에 해당하는 프로필이 존재하는지 검사
     */
    //Student가 존재하면 무조건 Profile도 존재하므로 굳이 필요없다고 생각됨
    
    /*public boolean existingProfile(String s_id) throws SQLException {
        String sql = "SELECT count(*) FROM USERINFO WHERE userid=?";
        jdbcUtil.setSqlAndParameters(sql, new Object[] {s_id});	// JDBCUtil에 query문과 매개 변수 설정

        try {
            ResultSet rs = jdbcUtil.executeQuery();		// query 실행
            if (rs.next()) {
                int count = rs.getInt(1);
                return (count == 1 ? true : false);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();		// resource 반환
        }
        return false;
    }*/

}
