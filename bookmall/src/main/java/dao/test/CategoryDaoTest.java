package dao.test;

import java.util.List;

import dao.CategoryDao;
import vo.CategoryVo;

public class CategoryDaoTest {
	public static void main(String[] args) {
		testInsert();
		testFindAll();
	}

	private static void testInsert() {
		CategoryDao dao = new CategoryDao();
		CategoryVo vo = new CategoryVo();

		vo.setCategory("과학");
		dao.insert(vo);

		vo.setCategory("IT");
		dao.insert(vo);

		vo.setCategory("문학");
		dao.insert(vo);
	}

	private static void testFindAll() {
		List<CategoryVo> list = new CategoryDao().findAll();

		for (CategoryVo vo : list) {
			System.out.println(vo);
		}
	}
}