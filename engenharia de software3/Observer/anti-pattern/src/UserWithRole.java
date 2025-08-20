public class UserWithRole {
    private String name;
    private Roles role;


    public UserWithRole(Roles role) {
        this.role = role;
    }


    public void update(Roles roles) {
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Roles getRole() {
        return role;
    }
}
