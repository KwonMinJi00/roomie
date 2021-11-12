package model.dao;
import model.Point;
import model.Profile;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PointDAO {
    private JDBCUtil jdbcUtil = null;

    public PointDAO() {
        jdbcUtil = new JDBCUtil();	// JDBCUtil 객체 생성
    }

    public Point create(Point point) throws SQLException {
        String sql = "INSERT INTO point VALUES (Idseq.nextval, ?, ?)";
        Object[] param = new Object[] {point.getPoint_binary(), point.getPoint_dec()};
        jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil 에 insert문과 매개 변수 설정

        String key[] = {"s_id"};	// PK 컬럼의 이름

        try {
            jdbcUtil.executeUpdate(key);  // insert 문 실행
            ResultSet rs = jdbcUtil.getGeneratedKeys();
            if(rs.next()) {
                int generatedKey = rs.getInt(1);   // 생성된 PK 값
                point.setS_id(generatedKey);
            }
            return point;
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();
        } finally {
            jdbcUtil.commit();
            jdbcUtil.close();	// resource 반환
        }
        return null;
    }

    public int update(Point point) throws SQLException {
        String sql = "UPDATE point "
                + "SET point_binary=?, point_dec=? "
                + "WHERE s_id=?";

        Object[] param = new Object[] { point.getPoint_binary(), point.getPoint_dec()};
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

    public Point findPoint(int sId) throws SQLException {
        String sql = "SELECT s_id, point_binary, point_dec " +
                "FROM point " + "WHERE s_id=?";
        jdbcUtil.setSqlAndParameters(sql, new Object[]{sId});    // JDBCUtil에 query문과 매개 변수 설정

       Point point = null;
        try {
            ResultSet rs = jdbcUtil.executeQuery();        // query 실행
            if (rs.next()) {                        // 학생 정보 발견
                point = new Point(        // Community 객체를 생성하여 커뮤니티 정보를 저장
                        rs.getInt("s_id"),
                        rs.getLong("point_binary"),
                        rs.getInt("point_dec"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();        // resource 반환
        }
        return point;
    }
}
