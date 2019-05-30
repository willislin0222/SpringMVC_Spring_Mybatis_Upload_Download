package com.learn.test;
 

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.learn.pojo.LearnVO;
import com.learn.service.LearnService;

 
 
 
public class LearnTest extends Junit4Test{
 
	@Autowired
	private LearnService learnService;	
	
 
	@Test
	@Transactional
	@Rollback(false)//防止事务自动回滚
	public void test() {
		testUser();
	}
	
	private void testUser() {
//		learnStaff
		LearnVO learnVO = new LearnVO();
		learnVO.setNo(7);
		learnVO.setName("TEST");
		learnVO.setUrl("C:/Downloads");
		learnService.addLearn(learnVO);	
		
	}
}