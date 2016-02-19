import java.util.HashMap;
import java.util.ArrayList;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String [] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      HashMap<String,Object>model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/words/new", (request, response) -> {
      HashMap<String, Object>model = new HashMap<String, Object>();
      model.put("words", Word.all());
      model.put("template","templates/words.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/words/:id", (request, response) -> {
      HashMap<String, Object>model = new HashMap<String, Object>();
      Word word = Word.find(Integer.parseInt(request.params(":id")));
      model.put("word", word);
      model.put("template", "templates/word.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/words", (request, response) -> {
      HashMap<String, Object>model = new HashMap<String, Object>();
      String userInputWordId = request.queryParams("userInputWordId");
      Word newWord = new Word(userInputWordId);
      model.put("words", Word.all());
      model.put("template", "templates/words.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/definitions/new", (request, response) ->{
      HashMap<String, Object>model= new HashMap<String, Object>();
      Word word = Word.find(Integer.parseInt(request.params(":id")));
      model.put("word", word);
      model.put("template", "templates/definition.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/definitions/:id", (request, response) -> {
      HashMap<String, Object>model= new HashMap<String, Object>();

      Word word = Word.find(Integer.parseInt(request.queryParams(":id")));
      ArrayList<Definition> definitions = word.getDefinitions();

        if (definitions == null) {
          definitions = new ArrayList<Definition>();

        }
        String userInputWordId = request.queryParams("userInputWordId");
        Definition newDefinition = new Definition("userInputWordId");

        definitions.add(newDefinition);

        model.put("definitions", definitions);
        model.put("word", word);
        model.put("template", "templates/definitions.vtl");
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());
    }
  }
