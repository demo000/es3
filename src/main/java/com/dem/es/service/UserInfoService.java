package com.dem.es.service;

import com.dem.es.domain.UserInfo;

import java.util.List;

public interface UserInfoService {

    UserInfo findById(Long id);

    List<UserInfo> findAll();

    List<UserInfo> findByName(String name);
}
