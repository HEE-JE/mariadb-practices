package hr.dao.test;

import java.util.List;

import hr.dao.EmployeeDao;
import hr.vo.EmployeeVo;

public class EmployeeDaoTest {

	public static void main(String[] args) {
		// testFindByNameFirstNameOrLastName("ken");
		testFindBysalary(10000, 50000);
	}

	public static void testFindByNameFirstNameOrLastName(String name) {
		List<EmployeeVo> list = new EmployeeDao().findByNameFirstNameOrLastName(name);
		for (EmployeeVo vo : list) {
			System.out.println(vo);
		}
	}

	public static void testFindBysalary(int minSalary, int maxSalary) {
		List<EmployeeVo> list = new EmployeeDao().findBysalary(minSalary, maxSalary);
		for (EmployeeVo vo : list) {
			System.out.println(vo);
		}
	}
}