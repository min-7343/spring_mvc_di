package kr.co.sist.annotation;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * DAO를 의존성 주입(DI) 받아서 업무로직에 사용하는일
 */

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {
	//나중에라오 의존성 받을 거야 = false / 무조건 객체화 되어있을 때 true
	@Autowired(required=false)
	@Qualifier("mySql")
//	@Qualifier("ora")
	private DAO dao;
	//anotation 으로 어떤 것을 사용할 지 결정할 수 있다.
	
	/**
	 * 생성자 의존성 주입
	 * @param dao
	 */
//	public ServiceImpl(DAO dao) {
//		this.dao=dao;
//	}//ServiceImpl

	@Override
	public boolean add(TestDTO tDTO) {
		int cnt=0;
		try {
			if("이장훈".equals(tDTO.getName())) {
				tDTO.setName(tDTO.getName()+"님");
			}//end if
			cnt=dao.insert(tDTO);
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch

		return cnt==1 ;
	}//add

	@Override
	public List<TestDomain> search() {
		List<TestDomain> list=null;
		try {
			list=dao.select();
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
		
		return list;
	}//search

}//class
