import models.Animal;
import models.EndangeredAnimal;

import models.Sighting;
import models.SightingInfo;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;
import static spark.Spark.*;

import static spark.Spark.staticFileLocation;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        get("/", (req, res) -> {
            Map<String,Object> model=new HashMap<>();
         return new ModelAndView(model,"index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/sightings", (req, res) -> {
            Map<String,Object> model=new HashMap<>();
            model.put("sightings",SightingInfo.all());
            model.put("animals",Animal.all());
            model.put("endangeredanimals",EndangeredAnimal.all());
            return new ModelAndView(model,"sighted.hbs");
        }, new HandlebarsTemplateEngine());


        get("/sightingendangered/new", (req, res) -> {
            Map<String,Object> model=new HashMap<>();
            model.put("sightings",SightingInfo.all());
            model.put("animals",Animal.all());
            model.put("endangeredanimals",EndangeredAnimal.all());
            return new ModelAndView(model,"sighting-form.hbs");
        }, new HandlebarsTemplateEngine());

        get("/sightingnonendangered/new", (req, res) -> {
            Map<String,Object> model=new HashMap<>();
            model.put("sightings",SightingInfo.all());
            model.put("animals",Animal.all());
            model.put("endangeredanimals",EndangeredAnimal.all());
            return new ModelAndView(model,"sightnonendangered-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/sightingsendangered/new",(req,res)->{
            Map<String,Object> model=new HashMap<>();
            String name = req.queryParams("name");
            String ranger_name = req.queryParams("ranger_name");
            String location = req.queryParams("location");
            String health = req.queryParams("health");
            String age =req.queryParams("age");
            SightingInfo newSightingInfo = new SightingInfo(name,ranger_name, health, age, location);
            newSightingInfo.save();
            EndangeredAnimal endangeredAnimal = new EndangeredAnimal(name, health, age);
            endangeredAnimal.save();
            model.put("name",name);
            endangeredAnimal.save();
            model.put("sightings",SightingInfo.all());
            model.put("animals", Animal.all());
            model.put("endangeredanimals", EndangeredAnimal.all());
            model.put("age", age);
            return new ModelAndView(model,"success.hbs");
        },new HandlebarsTemplateEngine());

        post("/sightingnonendangered/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String name = request.queryParams("name");
             Animal animal = new Animal(name);
             animal.save();

            model.put("sightings",SightingInfo.all());
            model.put("animals",Animal.all());
            model.put("endangeredanimals",EndangeredAnimal.all());
           String ranger_name = request.queryParams("ranger_name");

            String location = request.queryParams("location");

            SightingInfo newSightingInfo = new SightingInfo(name,ranger_name,location);
             animal.save();
             newSightingInfo.save();
          //  sighting.save();
            model.put("sightings", SightingInfo.all());
             model.put("animals", Animal.all());
            model.put("endangeredAnimals", EndangeredAnimal.all());
            return new ModelAndView(model,"success.hbs");
        },new HandlebarsTemplateEngine());

      /*  get("/animal/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            Animal animal = Animal.find(Integer.parseInt(request.params("id")));
            model.put("animal", animal);
            return new ModelAndView(model,"sighting-form.hbs");
        },new HandlebarsTemplateEngine());

        get("/endangered_animal/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            EndangeredAnimal endangeredAnimal = EndangeredAnimal.find(Integer.parseInt(request.params("id")));
            model.put("endangeredAnimal", endangeredAnimal);
            return new ModelAndView(model,"sighting-form.hbs");
        },new HandlebarsTemplateEngine());*/


    }


}
