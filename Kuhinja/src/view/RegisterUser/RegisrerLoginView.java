package view.RegisterUser;

import controllers.registerUserController.RegisterController;
import history.History;
import view.startApp.StartApp;

public class RegisrerLoginView {
    public RegisrerLoginView() {
    }

    public void loginScreen(){
        System.out.println("Please enter your username: ");
        String username = StartApp.scanner.nextLine();
        System.out.println("Please enter your password");
        String password = StartApp.scanner.nextLine();
        RegisterController registerController = new RegisterController();
        registerController.loginCotroller(username, password);
        if (registerController.isLoged()){
            System.out.println("enter menu");
            History.history.add(this);
        } else System.out.println("not loged");
    }
}
