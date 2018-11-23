package com.demo.mapper.ext;

import com.demo.model.UserInfo;
import com.github.pagehelper.Page;

public interface UserInfoExtMapper {
    
    Page<UserInfo> selectByPage();
}