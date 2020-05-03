import org.sql2o.Connection;

import java.util.List;

public class NonEndangered extends Animal {
    private final String state = "nonendangered";
    private final String health = " ";
    public NonEndangered(String name, String ranger, String location, String age){
        this.name= name;
        this.ranger = ranger;
        this.location = location;
        this.age= age;
    }

    public String getState(){return state;}
    public String getName(){return name;}
    public String getRangerName(){return ranger;}
    public String getLocation(){return location;}
    public String getAge(){return age;}
    public int getId(){return id;}


    @Override
    public boolean equals(Object otherNonEndangered) {
        if (!(otherNonEndangered instanceof NonEndangered)) {
            return false;
        } else {
            NonEndangered newNonEndangered = (NonEndangered) otherNonEndangered;
            return this.getName().equals(newNonEndangered.getName()) &&
                    this.getAge().equals(newNonEndangered.getAge()) &&
                    this.getRangerName().equals(newNonEndangered.getRangerName()) &&
                    this.getLocation().equals(newNonEndangered.getLocation()) &&
                    this.getState().equals(newNonEndangered.getState()) &&
                    this.getId()==(newNonEndangered.getId());
        }
    }

    public void save() {
        try (Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO Nanimals (name, ranger, location, age, health, state) VALUES (:name, :ranger, :location, :age, :health, :state)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("ranger", this.ranger)
                    .addParameter("location", this.location)
                    .addParameter("age", this.age)
                    .addParameter("health", this.health)
                    .addParameter("state", this.state)
                    .executeUpdate()
                    .getKey();
        }
    }

    public static List<NonEndangered> all() {
        String sql = "SELECT * FROM Nanimals";
        try (Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(NonEndangered.class);
        }
    }
}