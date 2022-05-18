package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SelectTest01 {

	public static void main(String[] args) {
		List<DepartmentVO> result = findAll();
		for (DepartmentVO vo : result) {
			System.out.println(vo);
		}
	}

	private static List<DepartmentVO> findAll() {
		List<DepartmentVO> result = new ArrayList<DepartmentVO>();
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 1. JDBC Driver(class) 로딩(JDBC Class 로딩: class loader)
			Class.forName("org.mariadb.jdbc.Driver");

			// 2. 연결하기
			String url = "jdbc:mysql://192.168.10.52:3306/webdb?charset=utf8";
			connection = DriverManager.getConnection(url, "webdb", "webdb");

			// 3. Statement 생성
			stmt = connection.createStatement();

			// 4. SQL 실행
			String sql = "select no, name from department order by no desc";
			rs = stmt.executeQuery(sql);

			// 5. 결과처리
			while (rs.next()) {
				Long no = rs.getLong(1);
				String name = rs.getString(2);

				DepartmentVO vo = new DepartmentVO();
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
				if (stmt != null) {
					stmt.close();
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