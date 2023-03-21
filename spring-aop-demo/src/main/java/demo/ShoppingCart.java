package demo;

import org.springframework.stereotype.Component;

@Component
public class ShoppingCart {

    public void checkout(String status){
        //Logging
        //Authentication @ Authorization
        //Sanitize the Data
        System.out.println("Checout Method from ShoppingCart Called");
    }
}
