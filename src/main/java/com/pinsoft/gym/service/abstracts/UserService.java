package com.pinsoft.gym.service.abstracts;

import java.util.List;

import com.pinsoft.gym.model.User;
import com.pinsoft.gym.service.requests.CreateUser;
import com.pinsoft.gym.service.requests.UpdateUser;

public interface UserService {

	List<User> getAll();
	void add(CreateUser createUser);
	void delete(int id);
	void update(UpdateUser updateUser);
}
