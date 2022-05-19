package main;

import java.util.List;

import dao.BookDao;
import dao.CartDao;
import dao.CategoryDao;
import dao.MemberDao;
import dao.OrderDao;
import vo.BookVo;
import vo.CartVo;
import vo.CategoryVo;
import vo.MemberVo;
import vo.OrderBookVo;
import vo.OrderVo;

public class BookMall {

	public static void main(String[] args) {
		insertAll();
		findAll();
	}

	private static void findAll() {
		System.out.println("==========Member==========");
		List<MemberVo> memberList = new MemberDao().findAll();
		for (MemberVo vo : memberList) {
			System.out.println(vo);
		}
		System.out.println("==========Category==========");
		List<CategoryVo> CategoryList = new CategoryDao().findAll();

		for (CategoryVo vo : CategoryList) {
			System.out.println(vo);
		}
		System.out.println("==========Book==========");
		List<BookVo> bookList = new BookDao().findAll();

		for (BookVo vo : bookList) {
			System.out.println(vo);
		}
		System.out.println("==========Cart==========");
		List<CartVo> cartList = new CartDao().findAll();

		for (CartVo vo : cartList) {
			System.out.println(vo);
		}
		System.out.println("==========Order==========");
		List<OrderVo> orderList = new OrderDao().findOrder();

		for (OrderVo vo : orderList) {
			System.out.println(vo);
		}
		System.out.println("==========Order_Book==========");
		List<OrderBookVo> orderBookList = new OrderDao().findOrderBook();

		for (OrderBookVo vo : orderBookList) {
			System.out.println(vo);
		}
	}

	private static void insertAll() {
		insertCategory();
		insertBook();
		insertMember();
		insertCart();
		insertOrder();
		insertOrderBook();
	}

	private static void insertCategory() {
		CategoryDao dao = new CategoryDao();
		CategoryVo vo = new CategoryVo();

		vo.setCategory("과학");
		dao.insert(vo);

		vo.setCategory("IT");
		dao.insert(vo);

		vo.setCategory("문학");
		dao.insert(vo);
	}

	private static void insertBook() {
		BookDao dao = new BookDao();
		BookVo vo = new BookVo();

		vo.setTitle("이것이 MariaDB다");
		vo.setPrice(27000);
		vo.setCategoryNo(2L);
		dao.insert(vo);

		vo.setTitle("러닝 react.js");
		vo.setPrice(31500);
		vo.setCategoryNo(2L);
		dao.insert(vo);

		vo.setTitle("코스모스");
		vo.setPrice(15000);
		vo.setCategoryNo(1L);
		dao.insert(vo);
	}

	private static void insertMember() {
		MemberDao dao = new MemberDao();
		MemberVo vo = new MemberVo();

		vo.setName("둘리");
		vo.setTel("010-1234-5678");
		vo.setEmail("qwe123@naver.com");
		vo.setPassword("qwer1234");
		dao.insert(vo);

		vo.setName("마이콜");
		vo.setTel("010-9876-5432");
		vo.setEmail("zxc789@naver.com");
		vo.setPassword("zxcv9876");
		dao.insert(vo);
	}

	private static void insertCart() {
		CartDao dao = new CartDao();
		CartVo vo = new CartVo();

		vo.setBookNo(1L);
		vo.setMemberNo(1L);
		vo.setCount(2);
		dao.insert(vo);

		vo.setBookNo(3L);
		vo.setMemberNo(1L);
		vo.setCount(1);
		dao.insert(vo);
	}

	private static void insertOrder() {
		OrderDao dao = new OrderDao();
		OrderVo vo = new OrderVo();

		vo.setPrice(69000);
		vo.setReceive("센텀시티");
		vo.setMemberNo(1L);
		dao.insertOrder(vo);
	}

	private static void insertOrderBook() {
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
}