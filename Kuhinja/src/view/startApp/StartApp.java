package view.startApp;

import history.History;
import view.RegisterUser.RegisterUserMenu;
import view.adminView.AdminView;
import view.regularUser.RegularMenuView;

import java.util.Scanner;

public class StartApp {
   public final String  welcomeMessage = "Arigato- Welcome to food ATM";
   public final String chooseUserMessage = "To enter application please loggin-register or continue as guest";
   public final String registerMessage = "1. login-register";
   public final String guestMesage = "2. continue as guest";


   // static scanner for using alongside all others classes in app
   public static Scanner scanner = new Scanner(System.in);

   public void startapp(){
       System.out.println(" ".repeat(20) + welcomeMessage);
       System.out.println("_".repeat(  chooseUserMessage.length()));
       System.out.println(chooseUserMessage);
       System.out.print(registerMessage);
       System.out.print("                            ");
       System.out.print(guestMesage);
       System.out.println();
       System.out.println("_".repeat(  chooseUserMessage.length()));
do {
    String choose = scanner.nextLine();

    switch (choose){
        case "1":
            History.history.add(this);
            new RegisterUserMenu().printStartMessage();
            break;
        case "2":
            History.history.add(this);
            new RegularMenuView().printRegularUserScreen();
            break;
        case "admincheatcode":
            // add this object to stack History for back to previus menu situation
            History.history.add(this);
            new AdminView().loginPrint();
            break;
        default:
            System.out.println("not walid input");
    }
} while (true);

   }
}
