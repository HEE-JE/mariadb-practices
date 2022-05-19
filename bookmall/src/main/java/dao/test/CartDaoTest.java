package dao.test;

import java.util.List;

import dao.CartDao;
import vo.CartVo;

public class CartDaoTest {

	public static void main(String[] args) {
		testInsert();
		testFindAll();
	}

	private static void testInsert() {
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

	private static void testFindAll() {
		List<CartVo> list = new CartDao().findAll();

		for (CartVo vo : list) {
			System.out.println(vo);
		}
	}
}