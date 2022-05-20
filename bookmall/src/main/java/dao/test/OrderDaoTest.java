package dao.test;

import java.util.ArrayList;
import java.util.List;

import dao.OrderDao;
import vo.OrderBookVo;
import vo.OrderVo;

public class OrderDaoTest {

	public static void main(String[] args) {
		testInsertOrder();
		testFindOrder();
		testFindOrderBook();
	}

	private static void testInsertOrder() {
		OrderDao dao = new OrderDao();
		OrderVo vo = new OrderVo();
		OrderBookVo odvo = new OrderBookVo();
		List<OrderBookVo> list = new ArrayList<OrderBookVo>();

		vo.setReceive("센텀시티");
		vo.setMemberNo(1L);

		odvo.setOrderNo(1L);
		odvo.setBookNo(1L);
		odvo.setPrice(54000);
		odvo.setCount(2);
		list.add(odvo);
		odvo = new OrderBookVo();

		odvo.setOrderNo(1L);
		odvo.setBookNo(3L);
		odvo.setPrice(10000);
		odvo.setCount(1);
		list.add(odvo);

		dao.insertOrder(vo, list);
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
