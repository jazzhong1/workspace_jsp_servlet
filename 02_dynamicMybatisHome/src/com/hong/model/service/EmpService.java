package com.hong.model.service;

import java.util.List;
import java.util.Map;

public interface EmpService {

	List<Map<String, String>> selectAll();

	List<Map<String, String>> selectCol(Map<String, String> map);


}
