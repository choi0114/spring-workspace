package kr.co.jhta.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.jhta.dao.DepartmentDao;
import kr.co.jhta.dao.EmployeeDao;
import kr.co.jhta.vo.Department;
import kr.co.jhta.vo.Employee;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeDao empDao;
	@Autowired
	private DepartmentDao deptDao;
	
	@RequestMapping("/employees.do")
	public String employees(int deptid, Model model) {
		List<Employee> employees = empDao.getEmployeesByDeptId(deptid);
		model.addAttribute("emps", employees);
		
		return "emp/employees";
	}
	
	@RequestMapping("/employee.do")
	public String employee(int empid, Model model) {
		Employee employee = empDao.getEmployeeById(empid);
		model.addAttribute("emp", employee);
		
		return "emp/employee";
	}
	
	@RequestMapping("/form.do")
	public String form(Model model) {
		List<String> jobIds = empDao.getJobId();
		List<Integer> deptIds = empDao.getDeptId();
		
		model.addAttribute("jobIds", jobIds);
		model.addAttribute("deptIds", deptIds);
		
		return "emp/form";
	}
	
	@RequestMapping("/add.do")
	public String add(Employee employee) {
		empDao.insertEmployee(employee);
		
		return "redirect:../department/depts.do";
	}
}

/*
	@RequestMapping("/main.do")
	public String main() {
		return "emp/main";
	}
	
	@RequestMapping("/detail.do")
	public String detail(String id, int pno, Model model) {
		System.out.println("id : " + id + ", pno : " + pno);
		
		// 쿼리스트링 값과 model을 동시에 사용할 때
		// EmployeeDao dao = new EmployeeDao();
		// Employee emp = dao.getEmployeeById(id);
		// model.addAttribute("employee", emp);
		
		HashMap<String, Object> emp = new HashMap<String, Object>();
		emp.put("id", id);
		emp.put("name", "홍길동");
		emp.put("dept", "영업1팀");
		
		model.addAttribute("employee", emp);
		
		return "emp/detail";
	}
	
	@RequestMapping("/registerform.do")
	public String registerform() {
		return "emp/form";
	}
 */

/*
	@RequestMapping("/register.do")
	public String register(String id, String name, String dept, String position) {
		System.out.println("id : " + id + ", name : " + name + ", dept : " + dept + ", position : " + position);
		return "redirect:main.do";
	}
 */
/*
	@RequestMapping("/register.do")
	public String register(EmployeeForm emp) {
		System.out.println(emp);
		
		return "redirect:main.do";
	}
 */