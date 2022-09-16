package view.adminView;

import controllers.adminController.AdminController;
import history.History;
import model.users.Administrator;
import view.startApp.StartApp;

public class AdminView {
    private final String welcomeMessage = "Welcome administrator";
    private final String logginMessage = "Please login to enter admin mode: ";
    Administrator admin;
    AdminController adminController = new AdminController();

    public AdminView() {
        admin = new Administrator("Admin", "administartor");
    }

    public void loginPrint(){
        System.out.println(History.backMessage + " ".repeat(30));
        System.out.println(welcomeMessage);
        System.out.println(logginMessage);
        System.out.println("Enter password: ");
        int counter = 0;
        do {
            String password = StartApp.scanner.nextLine();
            if (adminController.isLoginSucsesfull(password, admin)){
                System.out.println("Login successful");
                admin.setLoged(true);
                History.history.add(this);
                new AdminViewMenu(admin, adminController).PrintAdminViewPage();

            }else if (password.equals("0")){
                // calling the object from history stack to use his method startApp to
                // display previus page on console
                 StartApp startApp = (StartApp) History.history.pop();
                 startApp.startapp();
            } else {
                System.out.println("Wrong password please try again: ");
            }
            counter++;
        } while (counter < 3);
        if (!admin.isLoged()){
            new StartApp().startapp();
        }
    }

}
