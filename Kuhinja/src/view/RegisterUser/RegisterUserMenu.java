package view.RegisterUser;

import controllers.registerUserController.RegisterController;
import databasse.ListOfUsers;
import history.History;
import view.startApp.StartApp;

public class RegisterUserMenu {
private final String welcomeUserMessage = "Welcome please 1 - register or 2 - login:";

    public RegisterUserMenu() {
    }

    public void printStartMessage(){
        System.out.println("0 - to go back");
        System.out.println();
        System.out.println(welcomeUserMessage);
        System.out.println();
        String input = StartApp.scanner.nextLine();
        switch (input){
            case "0":
                StartApp startApp = (StartApp) History.history.pop();
                startApp.startapp();
                break;
            case "1":
                History.history.add(this);
                new RegisterUserRegistrationView().printRegisterScreen();
                break;
            case "2":
                History.history.add(this);
                new RegisrerLoginView().loginScreen();
                break;
            default:
                System.out.println("Not valid input");


        }
    }
}
