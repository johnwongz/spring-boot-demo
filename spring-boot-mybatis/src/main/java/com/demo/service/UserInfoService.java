package com.demo.service;

import com.demo.model.UserInfo;
import com.github.pagehelper.PageInfo;

public interface UserInfoService {

	public void insert(UserInfo usrInfo);
	
	public UserInfo selectById(Long id);
	
	public PageInfo<UserInfo> selectByPage(int pageNo, int pageSize);
}
