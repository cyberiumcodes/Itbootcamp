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

    public RegisterController() {
    }

    public void loginCotroller(String username, String password){
        if (regularUser.getUsername().equals(username) && regularUser.getPassword().equals(password)){
            regularUser.setLoged(true);
        } else {
            System.out.println("Wrong password!");
        }
    }

    public boolean isLoged(){
        return regularUser.isLoged();
    }

    public RegularUser getRegularUser() {
        return regularUser;
    }
}
