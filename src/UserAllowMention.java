public class UserAllowMention implements UserWithRole {
    private Roles role;

    public UserAllowMention(Roles product) {
        this.role = role;
    }


    @Override
    public void update(Roles role){
        System.out.println("You were mentioned for this role: "+role.getName()+"|"+role.getMessage());
    }
}
