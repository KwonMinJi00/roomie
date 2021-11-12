package model.dao;

import model.Profile;
import model.Scrap;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ScrapDAO {

    private JDBCUtil jdbcUtil = null;

    public ScrapDAO() {
        jdbcUtil = new JDBCUtil();
    }

    public int create(Scrap scrap) throws SQLException {
        String sql = "INSERT INTO myroomie VALUES(IDSEQ.nextval, ?, ?)";
        Object[] param = new Object[] {scrap.getS_id(), scrap.getScrap_id()};
        jdbcUtil.setSqlAndParameters(sql, param);

        try {
            int result = jdbcUtil.executeUpdate();
            return result;
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();
        } finally {
            jdbcUtil.commit();
            jdbcUtil.close();
        }
        return 0;
    }

    public int remove(Scrap scrap) throws SQLException {
        String sql = "DELETE FROM scrap WHERE scrap_id=?";
        jdbcUtil.setSqlAndParameters(sql, new Object[] {scrap.getScrap_id()});

        try {
            int result = jdbcUtil.executeUpdate();
            return result;
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();
        }
        finally {
            jdbcUtil.commit();
            jdbcUtil.close();
        }
        return 0;
    }

    public boolean isScraped(Scrap scrap) {
        String sql = "SELECT count(*) FROM scrap WHERE scrap_id=?";
        jdbcUtil.setSqlAndParameters(sql, new Object[] {scrap.getScrap_id()});

        try {
            ResultSet rs = jdbcUtil.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return (count == 1 ? true : false);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();
        }
        return false;
    }

    public List<Profile> findScarpList() throws SQLException {
        String sql = "SELECT scrap_id, activation, name, pr_img, age, sleep_habit, lifestyle, smoking, grade, major, mbti, cleaning, indoor_eation, sharting, habitude "
                + "FROM scrap s JOIN profile p ON s.scrap_id=p.s_id "
                + "ORDER BY sc_id DESC";
        jdbcUtil.setSqlAndParameters(sql, null);

        try {
            ResultSet rs = jdbcUtil.executeQuery();
            List<Profile> ScrapList = new ArrayList<Profile>();
            while (rs.next()) {
                Profile scrap = new Profile(
                        rs.getInt("scrap_id"),
                        rs.getBoolean("activation"),
                        rs.getString("name"),
                        rs.getInt("pr_img"),
                        rs.getInt("age"),
                        rs.getInt("sleep_habit"),
                        rs.getInt("lifestyle"),
                        rs.getInt("smoking"),
                        rs.getInt("grade"),
                        rs.getString("major"),
                        rs.getInt("mbti"),
                        rs.getInt("cleaning"),
                        rs.getInt("indoor_eation"),
                        rs.getInt("sharting"),
                        rs.getInt("habitude"));
                ScrapList.add(scrap);				// List에 User 객체 저장
            }
            return ScrapList;

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();		// resource 반환
        }
        return null;
    }
}
