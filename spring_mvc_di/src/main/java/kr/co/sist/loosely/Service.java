package kr.co.sist.loosely;

import java.util.List;

/**
 * 업무로직 정의 
 */
public interface Service {

	public boolean add(TestDTO tDTO);
	public List<TestDomain> search();
	
}
