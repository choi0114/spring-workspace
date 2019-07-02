package kr.co.jhta.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import kr.co.jhta.vo.Employee;

@Repository
public class EmployeeDao {

	@Autowired
	private SqlMapClientTemplate template;
	
	@SuppressWarnings("unchecked")
	public List<Employee> getEmployeesByDeptId(int deptId) {
		return template.queryForList("getEmployeesByDeptId", deptId);
	}
	
	public Employee getEmployeeById(int empId) {
		return (Employee) template.queryForObject("getEmployeeById", empId);
	}
	
	public void insertEmployee(Employee employee) {
		template.insert("insertEmployee", employee);
	}
	
	@SuppressWarnings("unchecked")
	public List<String> getJobId() {
		return template.queryForList("getJobId");
	}
	
	@SuppressWarnings("unchecked")
	public List<Integer> getDeptId() {
		return template.queryForList("getDeptId");
	}
}
