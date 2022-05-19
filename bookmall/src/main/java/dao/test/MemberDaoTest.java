package dao.test;

import java.util.List;

import dao.MemberDao;
import vo.MemberVo;

public class MemberDaoTest {

	public static void main(String[] args) {
		testInsert();
		testFindAll();
	}

	private static void testInsert() {
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

	private static void testFindAll() {
		List<MemberVo> list = new MemberDao().findAll();

		for (MemberVo vo : list) {
			System.out.println(vo);
		}
	}
}