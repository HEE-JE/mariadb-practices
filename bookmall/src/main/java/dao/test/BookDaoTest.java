package dao.test;

import java.util.List;

import dao.BookDao;
import vo.BookVo;

public class BookDaoTest {

	public static void main(String[] args) {
		testInsert();
		testFindAll();
	}

	private static void testInsert() {
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

	private static void testFindAll() {
		List<BookVo> list = new BookDao().findAll();

		for (BookVo vo : list) {
			System.out.println(vo);
		}
	}
}