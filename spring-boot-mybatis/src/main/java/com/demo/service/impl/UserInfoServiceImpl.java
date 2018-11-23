package com.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.mapper.UserInfoMapper;
import com.demo.mapper.ext.UserInfoExtMapper;
import com.demo.model.UserInfo;
import com.demo.service.UserInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class UserInfoServiceImpl implements UserInfoService {
	
	@Autowired
	private UserInfoMapper userInfoMapper;
	
	@Autowired
	private UserInfoExtMapper userInfoExtMapper;

	@Override
	public void insert(UserInfo usrInfo) {
		userInfoMapper.insertSelective(usrInfo);
	}

	@Override
	public UserInfo selectById(Long id) {
		return userInfoMapper.selectByPrimaryKey(id);
	}

	@Override
	public PageInfo<UserInfo> selectByPage(int pageNo, int pageSize) {
		PageHelper.startPage(pageNo,pageSize);
		List<UserInfo> list = userInfoExtMapper.selectByPage();
		PageInfo<UserInfo> page = new PageInfo<UserInfo>(list);
		return page;
	}

}
