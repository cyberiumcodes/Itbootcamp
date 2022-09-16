package model.users;

import databasse.ListOfRecipes;
import databasse.ListOfUsers;
import model.recipe.Recipe;

import java.util.ArrayList;
import java.util.List;

public class RegularUser extends User implements UserLogOrReg{
    private String username;
    private String password;
    private Boolean isRegisrer;
    private boolean isLoged;
    private List<Recipe> listOfFavoritesRecipies = new ArrayList<>();
    public RegularUser(String name, String username, String password) {
        super(name);
        this.username = username;
        this.password = password;
        isRegisrer = true;
        setUserAtribute(UserAtribute.REGULAR);
        ListOfUsers.listOfUsers.put(this.getId(), this);
    }

    public RegularUser() {
        this.setUserAtribute(UserAtribute.REGULAR);
        this.username = "Guest";
    }

    public List<Recipe> getListOfFavoritesRecipies() {
        return listOfFavoritesRecipies;
    }

    public void setListOfFavoritesRecipies(Recipe... recipies) {
        for (var el:
             recipies) {
            listOfFavoritesRecipies.add(el);
        }
    }

    public List<Recipe> reecipesForBudget(int budget){
        List<Recipe> temp = new ArrayList<>();
        double sum = 0;
        for (Recipe el:
                ListOfRecipes.listOfRecipes.values()) {
            if (budget >= el.getPrice()) temp.add(el);
        }
        return temp;
    }


    @Override
    public boolean isLogged() {
        return isLoged;
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

    public Boolean getRegisrer() {
        return isRegisrer;
    }

    public void setRegisrer(Boolean regisrer) {
        isRegisrer = regisrer;
    }

    public boolean isLoged() {
        return isLoged;
    }

    public void setLoged(boolean loged) {
        isLoged = loged;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setListOfFavoritesRecipies(List<Recipe> listOfFavoritesRecipies) {
        this.listOfFavoritesRecipies = listOfFavoritesRecipies;
    }

    @Override
    public boolean isRegister() {
        return isRegisrer;
    }
}
