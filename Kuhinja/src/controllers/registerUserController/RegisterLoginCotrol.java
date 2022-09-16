package controllers.registerUserController;

import databasse.ListOfUsers;
import model.users.RegularUser;
import model.users.UserAtribute;

import java.util.ArrayList;

import static databasse.ListOfUsers.listOfUsers;

public class RegisterLoginCotrol {

    RegularUser regularUser;
    public RegisterLoginCotrol() {
    }

    public void loginCotroller(String username, String password){
        ArrayList<RegularUser> regularUsers = new ArrayList<>();
       listOfUsers.forEach((integer, user) -> {
           if (user.getUserAtribute() == UserAtribute.REGULAR) regularUsers.add((RegularUser) user);
       });

       boolean isRegistred = regularUsers.stream().anyMatch(regularUser -> regularUser.getUsername().equals(username) && regularUser.getPassword().equals(password));
        if (isRegistred){
            for (var el:
                 regularUsers) {
                if (el.getUsername().equals(username)){
                    regularUser = el;
                    regularUser.setLoged(true);
                    break;
                }
            }
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
