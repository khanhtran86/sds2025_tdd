package Models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Person {
    private int id;
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;

    public void printInfo(){
        System.out.println("First Name: " + first_name);
        System.out.println("Last Name: " + last_name);
        System.out.println("Email: " + email);
    }
}
