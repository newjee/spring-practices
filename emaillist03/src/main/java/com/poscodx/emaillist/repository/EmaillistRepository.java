package com.poscodx.emaillist.repository;

import com.poscodx.emaillist.vo.EmaillistVo;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmaillistRepository {

    public List<EmaillistVo> findAll() {
        List<EmaillistVo> result = new ArrayList<>();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();

            //3. SQL 준비
            String sql = "select no, first_name, last_name, email from emaillist order by no desc";
            pstmt = conn.prepareStatement(sql);

            //4. binding

            //5. SQL 실행
            rs = pstmt.executeQuery();

            //6. 결과 처리
            while(rs.next()) {
                Long no = rs.getLong(1);
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);
                String email = rs.getString(4);

                EmaillistVo vo = new EmaillistVo();
                vo.setNo(no);
                vo.setFirstName(firstName);
                vo.setLastName(lastName);
                vo.setEmail(email);

                result.add(vo);
            }

        } catch (SQLException e) {
            System.out.println("error:" + e);
        } finally {
            try {
                // 7. 자원정리
                if(rs != null) {
                    rs.close();
                }
                if(pstmt != null) {
                    pstmt.close();
                }
                if(conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    public void insert(EmaillistVo vo) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = getConnection();

            String sql = "insert into emaillist values(null, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, vo.getFirstName());
            pstmt.setString(2, vo.getLastName());
            pstmt.setString(3, vo.getEmail());

            pstmt.executeQuery();
        } catch (SQLException e) {
            System.out.println("error:" + e);
        } finally {
            try {
                if(pstmt != null) {
                    pstmt.close();
                }
                if(conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteByEmail(String email) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = getConnection();

            String sql = "delete from emaillist where email=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);

            pstmt.executeQuery();
        } catch (SQLException e) {
            System.out.println("error:" + e);
        } finally {
            try {
                if(pstmt != null) {
                    pstmt.close();
                }
                if(conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private Connection getConnection() throws SQLException {
        Connection conn = null;

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            String url = "jdbc:mariadb://localhost:3306/shopping_db?charset=utf8";
            conn = DriverManager.getConnection(url, "shopping", "shopping");
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버 로딩 실패:" + e);
        }

        return conn;
    }
}