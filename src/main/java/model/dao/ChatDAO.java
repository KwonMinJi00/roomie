package model.dao;

import model.Chat;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ChatDAO {
    private JDBCUtil jdbcUtil = null;

    public ChatDAO() {
        jdbcUtil = new JDBCUtil();    // JDBCUtil 객체 생성
    }

    public int create(Chat chat) throws SQLException {
        String sql = "INSERT INTO chat VALUES (?, ?, ?, ?, ?, ?)";
        Object[] param = new Object[]{chat.getCh_id(), chat.getSender(),
                chat.getReceiver(), chat.getMessage(), chat.getDatetime(),
                chat.getS_id()};
        jdbcUtil.setSqlAndParameters(sql, param);    // JDBCUtil 에 insert문과 매개 변수 설정

        String key[] = {"ch_id"};    // PK 컬럼의 이름

        try {
            jdbcUtil.executeUpdate(key);  // insert 문 실행
            ResultSet rs = jdbcUtil.getGeneratedKeys();
            if (rs.next()) {
                int generatedKey = rs.getInt(1);   // 생성된 PK 값
                chat.setCh_id(generatedKey);    // id필드에 저장
            }
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();
        } finally {
            jdbcUtil.commit();
            jdbcUtil.close();    // resource 반환
        }
        return 0;
    }
}
