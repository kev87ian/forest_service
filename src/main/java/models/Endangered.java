package models;
import java.util.List;
import java.util.Objects;

public class Endangered extends Animals {
    private String health;
    private final String state = "endangered";

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getHealth() {
        return health;
    }

    public String getState() {
        return state;
    }

    public String getRanger() {
        return ranger;
    }

    public String getLocation() {
        return location;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public int getId() {
        return idanimal;
    }
    public void setId(int id){
        this.idanimal = id;
    }
    public Endangered(String name, String age, String ranger, String location, String health) {
        this.name = name;
        this.age = age;
        this.ranger = ranger;
        this.location = location;
        this.health = health;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Endangered)) return false;
        Endangered that = (Endangered) o;
        return getHealth().equals(that.getHealth()) &&
                getState().equals(that.getState());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHealth(), getState());
    }
}
