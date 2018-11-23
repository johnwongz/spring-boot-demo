package com.demo.service.impl;


import java.util.Date;
import java.util.UUID;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.demo.model.UserInfo;
import com.demo.service.UserInfoService;
import com.demo.service.base.SimpleTest;

public class UserInfoServiceImplTest extends SimpleTest{
	
	@Autowired
	private UserInfoService userInfoService;

	@Test
	public void insert() {
		UserInfo usrInfo = new UserInfo();
		usrInfo.setUsername(UUID.randomUUID().toString());
		usrInfo.setPassword("12345678");
		usrInfo.setEmail("test@gmail.com");
		usrInfo.setCreated(new Date());
		usrInfo.setUpdated(new Date());
		userInfoService.insert(usrInfo);
	}

	@Test
	public void selectById() {
		Long id = 1L;
		System.err.println(JSON.toJSONString(userInfoService.selectById(id)));
	}
	
	@Test
	public void selectByPage() {
		System.err.println(JSON.toJSONString(userInfoService.selectByPage(2, 2)));
	}

}
