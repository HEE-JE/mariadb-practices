package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.OrderBookVo;
import vo.OrderVo;

public class OrderDao {
	public boolean insertOrder(OrderVo vo) {
		boolean result = false;
		Connection connection = null;
		PreparedStatement pstmt = null;
		try {
			connection = getConnection();

			// 3. SQL 준비
			String sql = "insert into `order`(no, price, receive, member_no) values(null, ?, ?, ?)";
			pstmt = connection.prepareStatement(sql);

			// 4. Mapping(bind)
			pstmt.setInt(1, vo.getPrice());
			pstmt.setString(2, vo.getReceive());
			pstmt.setLong(3, vo.getMemberNo());

			// 5. SQL 실행
			int count = pstmt.executeUpdate();
			result = count == 1;

		} catch (SQLException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} finally {
			try {
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

	public boolean insertOrderBook(OrderBookVo vo) {
		boolean result = false;
		Connection connection = null;
		PreparedStatement pstmt = null;
		try {
			connection = getConnection();

			// 3. SQL 준비
			String sql = "insert into order_book values(?, ?, ?)";
			pstmt = connection.prepareStatement(sql);

			// 4. Mapping(bind)
			pstmt.setLong(1, vo.getOrderNo());
			pstmt.setLong(2, vo.getBookNo());
			pstmt.setInt(3, vo.getCount());

			// 5. SQL 실행
			int count = pstmt.executeUpdate();
			result = count == 1;

		} catch (SQLException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} finally {
			try {
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

	public List<OrderVo> findOrder() {
		List<OrderVo> result = new ArrayList<OrderVo>();
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			connection = getConnection();

			// 3. SQL 준비
			String sql = "select concat(date_format(a.date, '%Y%m%d'), '-', a.no) as date_no, concat(b.name, '(', b.email, ')') as name_email, a.price, a.receive"
					+ "	from `order` a, member b" + "    where a.member_no = b.no" + "	order by date_no";
			pstmt = connection.prepareStatement(sql);

			// 4. Parameter Mapping

			// 5. SQL 실행
			rs = pstmt.executeQuery();

			// 6. 결과처리
			while (rs.next()) {
				OrderVo vo = new OrderVo();
				vo.setDateNo(rs.getString(1));
				vo.setNameEmail(rs.getString(2));
				vo.setPrice(rs.getInt(3));
				vo.setReceive(rs.getString(4));

				result.add(vo);
			}

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

	public List<OrderBookVo> findOrderBook() {
		List<OrderBookVo> result = new ArrayList<OrderBookVo>();
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			connection = getConnection();

			// 3. SQL 준비
			String sql = "select a.book_no, c.title, a.count, c.price * a.count"
					+ "	from order_book a, `order` b, book c" + "    where a.order_no = b.no"
					+ "    and a.book_no = c.no";
			pstmt = connection.prepareStatement(sql);

			// 4. Parameter Mapping

			// 5. SQL 실행
			rs = pstmt.executeQuery();

			// 6. 결과처리
			while (rs.next()) {
				OrderBookVo vo = new OrderBookVo();
				vo.setBookNo(rs.getLong(1));
				vo.setTitle(rs.getString(2));
				vo.setCount(rs.getInt(3));
				vo.setTotalPrice(rs.getInt(4));

				result.add(vo);
			}

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

	private Connection getConnection() throws SQLException {
		Connection connection = null;
		try {
			// 1. JDBC Driver(class) 로딩(JDBC Class 로딩: class loader)
			Class.forName("org.mariadb.jdbc.Driver");

			// 2. 연결하기
			String url = "jdbc:mysql://192.168.10.52:3306/bookmall?charset=utf8";
			connection = DriverManager.getConnection(url, "bookmall", "bookmall");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이브 로딩 실패:" + e);
		}
		return connection;
	}
}