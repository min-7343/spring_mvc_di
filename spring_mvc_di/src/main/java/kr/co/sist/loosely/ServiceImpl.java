package kr.co.sist.loosely;

import java.sql.SQLException;
import java.util.List;

/**
 * DAO를 의존성 주입(DI) 받아서 업무로직에 사용하는일
 */
public class ServiceImpl implements Service {
	private DAO dao;
	
	/**
	 * 생성자 의존성 주입
	 * @param dao
	 */
	public ServiceImpl(DAO dao) {
		this.dao=dao;
	}//ServiceImpl

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
