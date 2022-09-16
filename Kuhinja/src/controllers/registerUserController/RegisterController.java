package controllers.registerUserController;

import databasse.ListOfUsers;
import model.users.RegularUser;

public class RegisterController {
    private String name;
    private String username;
    private String password;

    RegularUser regularUser ;

    public RegisterController(String name, String username, String password) {

            this.name = name;
            this.username = username;
            this.password = password;
            regularUser = new RegularUser(name,username,password);


    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RegisterController() {
    }



    public RegularUser getRegularUser() {
        return regularUser;
    }
}
