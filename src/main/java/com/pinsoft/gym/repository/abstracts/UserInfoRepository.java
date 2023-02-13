package com.pinsoft.gym.repository.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pinsoft.gym.model.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer>{

}
