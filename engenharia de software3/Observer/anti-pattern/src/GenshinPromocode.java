import java.util.ArrayList;
import java.util.List;

public class GenshinPromocode {
    private Roles role;
    private List<UserWithRole> users = new ArrayList<>();

    public GenshinPromocode(Roles role) {
        this.role = role;
    }


    public void update(Roles role) {
        this.role = role;
        System.out.println("You were mentioned for this role: "+role.getName()+"|"+role.getMessage());
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

}
