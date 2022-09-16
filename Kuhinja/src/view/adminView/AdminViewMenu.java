package view.adminView;

import controllers.adminController.AdminController;
import history.History;
import model.users.Administrator;
import view.startApp.StartApp;

public class AdminViewMenu {
    private final String headerMessage = "You are in admin menu mode:";
    private int notifications = AdminController.missingWeightIngrediant.size();
    private final String addRecipeMeni = "1 - add recipe: ";
    private final String addWeightIngrediantMenu = "2 - refill ingrediant or add ingredinats: ";
    private final String listOfIngrediants = "3 - see list of ingredinats: ";
    private final String getListOfRecipes = "4 - see list of recipes: ";
    private final String collectMoney = "5 - collect money";
    private final String changePass = "6 - change password";


    Administrator admin;
    AdminController adminController;


    public AdminViewMenu(Administrator admin, AdminController adminController) {
        this.admin = admin;
        this.adminController = adminController;
    }

    public void PrintAdminViewPage(){
        System.out.println();
        System.out.println(History.backMessage);
        System.out.println();
        System.out.println(headerMessage);
        System.out.println("-".repeat(50));
        System.out.println("Your notifications: " + notifications);
        System.out.println(addRecipeMeni);
        System.out.println(addWeightIngrediantMenu);
        System.out.println(listOfIngrediants);
        System.out.println(getListOfRecipes);
        System.out.println(collectMoney);
        System.out.println(changePass);
        System.out.println("7: to see notifications: ");
        addInputComands();
    }

    public void addInputComands(){
        boolean entering = true;
        do {
            String inputCommand = StartApp.scanner.nextLine();
            switch (inputCommand){
                case "0":
                    try {
                        AdminView adminView = (AdminView) History.history.pop();
                        admin.setLoged(false);
                        adminView.loginPrint();
                    }
                    catch (Exception e){
                        System.out.println("error");
                    }

                    break;
                case "1":
                    System.out.println("Add recipe");
                    History.history.add(this);
                    new AddingRecipeView().printRecepiview();
                    entering = false;
                    break;
                case "2":
                    System.out.println("Add ingrediant");
                    History.history.add(this);
                    new AddingIngrediants().printAddIngredinatsScreen();
                    entering = false;

                    break;
                case "3":
                    System.out.println("see list of recipe");
                    History.history.add(this);
                    new ListOfRecipeView().printListOfRecipies();
                    entering = false;

                    break;
                case "4":
                    System.out.println("See list of ingrediant");
                    History.history.add(this);
                    new ListOfRecipeView().printListOfRecipies();
                    entering = false;

                    break;
                case "5":
                    System.out.println("collect money");
                    entering = false;

                    break;
                case "6":
                    History.history.add(this);
                    new ChangePasswordView(admin, adminController).setupNewPassword();
                    break;
                case "7":
                    History.history.add(this);
                    new AdminNotification().printNotification();
                    break;
                default:
                    System.out.println("Not valid input");
            }
        } while (entering);
    }
}
