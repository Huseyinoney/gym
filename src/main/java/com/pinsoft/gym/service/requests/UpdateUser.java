package com.pinsoft.gym.service.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUser {
	
	 	private String firstName;
	    private String lastName;
	    private String address;
	    private String phone;
}
