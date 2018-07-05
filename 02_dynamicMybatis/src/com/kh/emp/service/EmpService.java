package com.kh.emp.service;

import java.util.List;
import java.util.Map;

public interface EmpService {

	List<Map<String, String>> selectAll();

	List<Map<String, String>> searchCol(Map<String, String> map);


	List<Map<String, String>> searchArr(Map<String, String[]> map1);

	List<Map<String, String>> selectEmpList(int cPage,int numPerPage);
	
	int selectCount();

	

}
