package hr.dao.test;

import java.util.List;

import hr.dao.EmployeeDao;
import hr.vo.EmployeeVo;

public class EmployeeDaoTest {

	public static void main(String[] args) {
		findByNameFirstNameOrLastName("ken");
	}

	public static void findByNameFirstNameOrLastName(String name) {
		List<EmployeeVo> list = new EmployeeDao().findByNameFirstNameOrLastName(name);
		for (EmployeeVo vo : list) {
			System.out.println(vo);
		}
	}
}