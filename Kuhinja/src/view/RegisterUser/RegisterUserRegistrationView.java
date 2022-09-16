package view.RegisterUser;

import controllers.registerUserController.RegisterController;
import history.History;
import view.startApp.StartApp;

public class RegisterUserRegistrationView {

    public RegisterUserRegistrationView() {
    }

    public void printRegisterScreen(){
        System.out.println("Enter your name: ");
        String name = StartApp.scanner.nextLine();
        System.out.println("Enter username; ");
        String username = StartApp.scanner.nextLine();
        System.out.println("Enter password: ");
        String password = StartApp.scanner.nextLine();
        new RegisterController(name, username, password);
        RegisterUserMenu registerUserMenu = (RegisterUserMenu) History.history.pop();
        registerUserMenu.printStartMessage();

    }
}
