public class Endangered extends Animal {
    private String health;
    private final String state = "Endangered";

    public Endangered (String name, String ranger, String location, String health, String age){
        this.name = name;
        this.ranger = ranger;
        this.location = location;
        this.health = health;
        this.age = age;
    }
public String getState(){
        return state;
}
    public String getName(){
        return name;
    }
    public String getAge(){
        return age;
    }
    public String getHealth(){
        return health;
    }
    public String getRangerName(){
        return ranger;
    }
    public String getLocation(){
        return location;
    }
    public int getId(){
        return id;}

}
