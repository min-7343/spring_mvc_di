package kr.co.sist.loosely;

import org.springframework.stereotype.Component;

/**
 * 1. 의존성 주입받을 객체를 생성하고
 * 2. 의존성 주입받을 객체를 생성하여 의존성을 주입하고
 * 3. 의존성 주입받은 객체를 반환
 */
@Component
public class Assembly {

	public Service getBean() {
		//1.
		MySqlDAOImpl dao=new MySqlDAOImpl();
//		OracleDAOImpl dao=new OracleDAOImpl();
		//2.
		Service service=new ServiceImpl(dao);
		//3.
		return service;
		
		
	}//service
}//class
