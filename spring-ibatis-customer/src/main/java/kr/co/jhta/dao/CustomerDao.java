package kr.co.jhta.dao;

import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.SqlMapClientTemplate;

import kr.co.jhta.vo.Customer;

public class CustomerDao {
	
	private SqlMapClientTemplate template;
	
	public void setTemplate(SqlMapClientTemplate template) {
		this.template = template;
	}

	@SuppressWarnings("unchecked")
	public List<Customer> getAllCustomers() {
		return (List<Customer>) template.queryForList("getAllCustomers");
	}
	
	public Customer getCustomerByNo(int no) {
		return (Customer) template.queryForObject("getCustomerByNo", no);
	}
	
	@SuppressWarnings("unchecked")
	public List<Customer> getCustomerBySearch(Map<String, Object> map) {
		return (List<Customer>) template.queryForList("getCustomerBySearch", map);
	}
	
	public void updateCustomerByNo(Customer customer) {
		template.update("updateCustomerByNo", customer);
	}
	
	public void deleteCustomerByNo(int no) {
		template.delete("deleteCustomerByNo", no);
	}
	
	public void insertCustomer(Customer customer) {
		template.insert("insertCustomer", customer);
	}
}
