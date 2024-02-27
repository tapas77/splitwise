package Controllers;

import Dtos.Transaction;
import Services.UserService;

import java.util.List;

public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public List<Transaction> settleUser(String userName, String groupName){

        return userService.settleUser(userName, groupName);
    }
}
