package model.users;

import controllers.adminController.AdminController;
import databasse.ListOfUsers;
import model.recipe.WeightIngrediant;

import java.util.ArrayList;
import java.util.List;

public class Administrator extends User implements UserLogOrReg{
    private String username;
    private String password;
    private boolean isLoged = false;
    private boolean isRegistred = true;



    public Administrator(String name, String username) {
        super(name);
        this.username = username;
        this.password = "admincheatcode";
        setUserAtribute(UserAtribute.ADMIN);
        ListOfUsers.listOfUsers.put(this.getId(), this);

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<WeightIngrediant> missingIngrediants(){
        return new AdminController().getMissingWeightIngrediant();
    }

    @Override
    public boolean isLogged() {
        return isLoged;
    }

    @Override
    public boolean isRegister() {
        return isRegistred;
    }

    public boolean isLoged() {
        return isLoged;
    }

    public void setLoged(boolean loged) {
        isLoged = loged;
    }

    public boolean isRegistred() {
        return isRegistred;
    }

    public void setRegistred(boolean registred) {
        isRegistred = registred;
    }
}
