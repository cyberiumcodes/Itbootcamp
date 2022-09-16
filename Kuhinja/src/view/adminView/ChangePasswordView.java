package view.adminView;

import controllers.adminController.AdminController;
import history.History;
import model.users.Administrator;
import view.startApp.StartApp;

public class ChangePasswordView {
    private final String oldPasswordMessage = "Please type your old password: ";
    private final String newPasswordMessage = "Please enter your new password: ";
    AdminController adminController;
    Administrator administrator;

    public ChangePasswordView(Administrator administrator, AdminController adminController) {
        this.administrator = administrator;
        this.adminController = adminController;
    }
    public void setupNewPassword(){
        int count = 0;
        boolean isMatched = false;
        do {
            System.out.println(oldPasswordMessage);
            String input = StartApp.scanner.nextLine();
            if (input.equals(administrator.getPassword())) {
                isMatched = true;
                break;
            }
            count++;
        }while (count < 3);
        System.out.println(newPasswordMessage);
        String newPaasInput = StartApp.scanner.nextLine();
        administrator.setPassword(newPaasInput);
        AdminViewMenu adminViewMenu = (AdminViewMenu) History.history.pop();
        adminViewMenu.PrintAdminViewPage();
    }
}
