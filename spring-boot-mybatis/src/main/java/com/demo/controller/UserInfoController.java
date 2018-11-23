package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.UserInfo;
import com.demo.service.UserInfoService;
import com.github.pagehelper.PageInfo;

@RestController
public class UserInfoController {
	
	@Autowired
	private UserInfoService userInfoService;
	
	/**
	 * 
	 * 分页查询
	 *
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@GetMapping("/page")
	public PageInfo<UserInfo> selectByPage(@RequestParam(value="pageNo", defaultValue="1")int pageNo, 
			@RequestParam(value="pageSize",defaultValue="10") int pageSize) {
		
		PageInfo<UserInfo> page = userInfoService.selectByPage(pageNo, pageSize);
		return page;
	}
	
}