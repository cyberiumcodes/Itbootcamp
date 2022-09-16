package view.RegisterUser;

import controllers.registerUserController.RegisterController;
import controllers.registerUserController.RegisterLoginCotrol;
import history.History;
import model.users.RegularUser;
import view.startApp.StartApp;

public class RegisrerLoginView {
    public RegisrerLoginView() {
    }

    public void loginScreen(){
        System.out.println("Please enter your username: ");
        String username = StartApp.scanner.nextLine();
        System.out.println("Please enter your password");
        String password = StartApp.scanner.nextLine();
        RegisterLoginCotrol registerLoginCotrol = new RegisterLoginCotrol();
        registerLoginCotrol.loginCotroller(username, password);
        if (registerLoginCotrol.isLoged()){
            System.out.println("enter menu");
            History.history.add(this);
            RegularUser regularUser = registerLoginCotrol.getRegularUser();
            new RegiaterLogedMenu(regularUser).PrintScreen();
        } else System.out.println("not loged");
    }
}
