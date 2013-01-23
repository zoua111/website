package ua.com.itinterview.service;

import org.springframework.beans.factory.annotation.Autowired;

import ua.com.itinterview.dao.UserDao;
import ua.com.itinterview.entity.UserEntity;
import ua.com.itinterview.web.command.UserCommand;

public class UserService {

    @Autowired
    UserDao userDao;

    public void createUser(UserCommand userCommand) {
	if (userDao.doesUserExistsWithUserName(userCommand.getUserName())) {
	    throw new RuntimeException("User " + userCommand
		    + " already exists");
	} else {
	    UserEntity user = new UserEntity(userCommand);
	    userDao.save(user);
	}
    }

}