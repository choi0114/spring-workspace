package kr.co.jhta.app;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.jhta.dao.CustomerDao;
import kr.co.jhta.vo.Customer;

public class CustomerApp {

	public static void main(String[] args) {
		String resource = "classpath:/META-INF/spring/context.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(resource);

		CustomerDao customerDao = ctx.getBean(CustomerDao.class);
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			System.out.println("\n");
			System.out.println("------------------------------------------------------");
			System.out.println("1.전체조회 2.검색 3.등록 4.수정 5.삭제 0.종료");
			System.out.println("------------------------------------------------------");
			
			System.out.print("메뉴선택> ");
			int menu = scanner.nextInt();
			
			if (menu == 1) {
				List<Customer> customers = customerDao.getAllCustomers();
				System.out.println("--------------- 전체 고객 정보 조회 ---------------");
				System.out.println("번호            이름             전화번호");
				System.out.println("---------------------------------------------------");
				for(Customer customer : customers) {
					System.out.println(customer.getNo() + "              " + 
									   customer.getName() + "           " + 
									   customer.getPhone());
					System.out.println("---------------------------------------------------");
				}
			} else if (menu == 2) {
				System.out.println("1. 번호로 검색하기  2. 이름으로 검색하기  3. 닉네임으로 검색하기");
				System.out.print("검색 옵션을 선택해주세요. > ");
				int option = scanner.nextInt();
				
				Map<String, Object> map = new HashMap<String, Object>();
				if(option == 1) {
					System.out.print("번호를 입력해주세요. > ");
					int no = scanner.nextInt();
					
					map.put("sort", "no");
					map.put("keyword", no);
					
				} else if(option == 2) {
					System.out.print("이름을 입력해주세요. > ");
					String name = scanner.next();
					
					map.put("sort", "name");
					map.put("keyword", name);
					
				} else if(option == 3) {
					System.out.print("닉네임을 입력해주세요. > ");
					String nickname = scanner.next();
					
					map.put("sort", "nickname");
					map.put("keyword", nickname);

				} else {
					System.out.println("입력된 값이 올바르지 않습니다.");
				}
				List<Customer> customers = customerDao.getCustomerBySearch(map);
				System.out.println("------------------------- 전체 고객 정보 조회 -------------------------");
				System.out.println("번호   이름   닉네임   전화번호   이메일   거주지   포인트   생성일");
				System.out.println("-----------------------------------------------------------------------");
				for(Customer customer : customers) {
					System.out.println(customer.getNo() + "  " + 
							   customer.getName() + "  " + 
							   customer.getNickName() + "  " + 
							   customer.getPhone() + "  " + 
							   customer.getEmail() + "  " + 
							   customer.getCity() + "  " + 
							   customer.getPoint() + "  " + 
							   customer.getCreateDate());
					System.out.println("-----------------------------------------------------------------------");
				}
			} else if (menu == 3) {
				System.out.println("----- 신규 등록 -----");
				System.out.println("이름, 닉네임, 전화번호, 이메일, 거주지 순으로 입력해주세요.(,사용/공백금지)");
				System.out.print(">> ");
				String newCustomer = scanner.next();
				String[] customerInfo = newCustomer.split(",");
				
				Customer customer = new Customer();
				customer.setName(customerInfo[0]);
				customer.setNickName(customerInfo[1]);
				customer.setPhone(customerInfo[2]);
				customer.setEmail(customerInfo[3]);
				customer.setCity(customerInfo[4]);
				
				customerDao.insertCustomer(customer);
				
				System.out.println("성공적으로 등록되었습니다.");
			} else if (menu == 4) {
				System.out.println("----- 회원 정보 수정 -----");
				System.out.println("번호, 이름, 닉네임, 전화번호, 이메일, 거주지, 적립포인트 순으로 입력해주세요.(,사용/공백금지)");
				System.out.print(">> ");
				String changeCustomer = scanner.next();
				String[] customerInfo = changeCustomer.split(",");
				
				Customer customer = new Customer();
				customer.setNo(Integer.parseInt(customerInfo[0]));
				customer.setName(customerInfo[1]);
				customer.setNickName(customerInfo[2]);
				customer.setPhone(customerInfo[3]);
				customer.setEmail(customerInfo[4]);
				customer.setCity(customerInfo[5]);
				customer.setPoint(Integer.parseInt(customerInfo[6]));
				
				customerDao.updateCustomerByNo(customer);
				System.out.println("성공적으로 수정되었습니다.");
				
			} else if (menu == 5) {
				System.out.println("----- 회원 삭제 -----");
				System.out.print("삭제하고자 하는 회원의 번호를 입력해 주세요. >> ");
				int no = scanner.nextInt();
				
				System.out.println("정말 삭제 하시겠습니까?");
				System.out.println("1. 예     2. 조금만 더 생각해 볼게요..;;");
				int check = scanner.nextInt();
				if(check == 1) {
					customerDao.deleteCustomerByNo(no);
					System.out.println("성공적으로 삭제되었습니다.");
				} else if(check == 2) {
					continue;
				} else {
					System.out.println("잘못 눌렀잖아요 ㅡㅡ");
				}
			} else if (menu == 0) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			
		}
		
	}
}
