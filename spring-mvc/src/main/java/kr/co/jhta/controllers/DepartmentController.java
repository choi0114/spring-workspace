package kr.co.jhta.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.jhta.dao.DepartmentDao;
import kr.co.jhta.vo.Department;

@Controller
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	private DepartmentDao deptDao;
	
	@RequestMapping("/depts.do")
	public String depts(Model model) {
		List<Department> departments = deptDao.getAllDepartments();
		model.addAttribute("depts", departments);
		
		return "emp/depts";
	}
}
