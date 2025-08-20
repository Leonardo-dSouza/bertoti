import java.util.ArrayList;
import java.util.List;

public class Roles {
    private String name;
    private String message;

    public Roles(String name, String role) {
        this.name = name;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public void update(Roles role){
        System.out.println("You were mentioned for this role: "+role.getName()+"|"+role.getMessage());
    }
}
