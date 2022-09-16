package view.adminView;

import controllers.adminController.AdminController;

import java.util.concurrent.atomic.AtomicInteger;

public class AdminNotification {

    public AdminNotification() {
    }

    public void printNotification(){
        AtomicInteger counter = new AtomicInteger();
        AdminController.missingWeightIngrediant.forEach(ingrediant -> {
            System.out.println(counter + " : " + ingrediant.getName());
            counter.getAndIncrement();
        });
    }
}
