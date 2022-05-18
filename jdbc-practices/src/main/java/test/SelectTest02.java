package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SelectTest02 {

	public static void main(String[] args) {
		List<DepartmentVo> result = findAll();
		for (DepartmentVo vo : result) {
			System.out.println(vo);
		}
	}

	private static List<DepartmentVo> findAll() {
		List<DepartmentVo> result = new ArrayList<DepartmentVo>();
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 1. JDBC Driver(class) 로딩(JDBC Class 로딩: class loader)
			Class.forName("org.mariadb.jdbc.Driver");

			// 2. 연결하기
			String url = "jdbc:mysql://192.168.10.52:3306/webdb?charset=utf8";
			connection = DriverManager.getConnection(url, "webdb", "webdb");

			// 3. SQL 준비
			String sql = "select no, name from department order by no desc";
			pstmt = connection.prepareStatement(sql);

			// 4. Parameter Mapping

			// 5. SQL 실행
			rs = pstmt.executeQuery();

			// 6. 결과처리
			while (rs.next()) {
				Long no = rs.getLong(1);
				String name = rs.getString(2);

				DepartmentVo vo = new DepartmentVo();
				vo.setNo(no);
				vo.setName(name);

				result.add(vo);
			}

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} catch (SQLException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}