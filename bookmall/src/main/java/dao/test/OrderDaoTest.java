package dao.test;

import java.util.List;

import dao.OrderDao;
import vo.OrderBookVo;
import vo.OrderVo;

public class OrderDaoTest {

	public static void main(String[] args) {
		testInsertOrder();
		testInsertOrderBook();
		testFindOrder();
		testFindOrderBook();
	}

	private static void testInsertOrder() {
		OrderDao dao = new OrderDao();
		OrderVo vo = new OrderVo();

		vo.setPrice(69000);
		vo.setReceive("센텀시티");
		vo.setMemberNo(1L);
		dao.insertOrder(vo);
	}

	private static void testInsertOrderBook() {
		OrderDao dao = new OrderDao();
		OrderBookVo vo = new OrderBookVo();

		vo.setOrderNo(1L);
		vo.setBookNo(1L);
		vo.setCount(2);
		dao.insertOrderBook(vo);

		vo.setOrderNo(1L);
		vo.setBookNo(3L);
		vo.setCount(1);
		dao.insertOrderBook(vo);
	}

	private static void testFindOrder() {
		List<OrderVo> list = new OrderDao().findOrder();

		for (OrderVo vo : list) {
			System.out.println(vo);
		}
	}

	private static void testFindOrderBook() {
		List<OrderBookVo> list = new OrderDao().findOrderBook();

		for (OrderBookVo vo : list) {
			System.out.println(vo);
		}
	}
}
