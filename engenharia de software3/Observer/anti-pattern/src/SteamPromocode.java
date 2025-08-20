import java.util.ArrayList;
import java.util.List;

public class SteamPromocode {
    private Roles role;
    private String message;
    private List<UserWithRole> users = new ArrayList<>();

    public SteamPromocode(Roles role) {
        this.role = role;
    }

    public void update(Roles role) {
        this.role = role;
        System.out.println("You were mentioned for this role: "+role.getName()+"|"+role.getMessage());
    }

    public void notifyUsers() {
        for (UserWithRole user : users) {
            user.update(getRole());
        }
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
        notifyUsers();
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

}
