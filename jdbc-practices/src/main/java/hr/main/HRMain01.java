package hr.main;

import java.util.List;
import java.util.Scanner;

import hr.dao.EmployeeDao;
import hr.vo.EmployeeVo;

public class HRMain01 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("이름을 입력하세요: ");
		String name = scanner.nextLine();

		EmployeeDao dao = new EmployeeDao();
		List<EmployeeVo> list = dao.findByNameFirstNameOrLastName(name);

		for (EmployeeVo vo : list) {
			System.out.println(vo.getNo() + ":" + vo.getFirstName() + ":" + vo.getLastName() + ":" + vo.getHireDate());
		}

		scanner.close();
	}
}