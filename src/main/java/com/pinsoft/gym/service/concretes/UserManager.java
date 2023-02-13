package com.pinsoft.gym.service.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pinsoft.gym.model.User;
import com.pinsoft.gym.repository.abstracts.UserRepository;
import com.pinsoft.gym.service.abstracts.UserService;
import com.pinsoft.gym.service.requests.User.CreateUser;
import com.pinsoft.gym.service.requests.User.UpdateUser;
@Service
public class UserManager implements UserService {
	private UserRepository userRepository;
	
	public UserManager(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public List<User> getAll() {
		
		return userRepository.findAll();
	}

	@Override
	public void add(CreateUser createUser) {
		User user = new User();
		user.setFirstName(createUser.getFirstName());
		user.setLastName(createUser.getLastName());
		user.setAddress(createUser.getAddress());
		user.setPhone(createUser.getPhone());
		userRepository.save(user);
		
	}

	@Override
	public void delete(int id) {
		userRepository.deleteById(id);
		
	}

	@Override
	public void update(UpdateUser updateUser) {
		User user = new User();
		user.setFirstName(updateUser.getFirstName());
		user.setLastName(updateUser.getLastName());
		user.setAddress(updateUser.getAddress());
		user.setPhone(updateUser.getPhone());
		userRepository.save(user);
		
	}

}
