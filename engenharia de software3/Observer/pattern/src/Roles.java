import java.util.ArrayList;
import java.util.List;

public class Roles {
    private String name;
    private String message;
    private List<UserAllowMention> observers = new ArrayList<>();


    public Roles(String name, String message) {
        this.name = name;
        this.message = message;
    }

    public void addObserver(UserAllowMention obs) {
        observers.add(obs);
    }

    public void removeObserver(UserAllowMention obs) {
        observers.remove(obs);
    }

    public void notifyObservers() {
        for (UserAllowMention obs : observers) {
            obs.update(Roles.this);
        }
    }

    public void setName(String name) {
        this.name = name;

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
        notifyObservers();
    }

    public List<UserAllowMention> getObservers() {
        return observers;
    }

    public void setObservers(List<UserAllowMention> observers) {
        this.observers = observers;
    }

    public String getName() {
        return name;
    }


}
