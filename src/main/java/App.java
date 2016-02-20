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
      model.put("words", Word.all());
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/", (request, response) -> {
      HashMap<String,Object>model = new HashMap<String, Object>();
      String word= request.queryParams("word");
        if(!word.equals("")) {
          Word newWord = new Word (word);
          model.put("word", Word.all());
        }
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/words/new", (request, response) -> {
      HashMap<String, Object>model = new HashMap<String, Object>();
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

    get("/words/:id/definitions/new", (request, response) ->{
      HashMap<String, Object>model= new HashMap<String, Object>();
      Word word = Word.find(Integer.parseInt(request.params(":id")));
      model.put("word", word);
      // model.put("definitions", Definition.all());
      model.put("template", "templates/definition-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/definition-new", (request, reponse) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();

      String definition = request.queryParams("definition");
      Word word = Word.find(Integer.parseInt(request.queryParams("wordInput")));

      if(!(definition.equals(""))) {
        Definition newDefinition = new Definition(definition);
        Word.find(word.getId()).addDefinition(newDefinition);
        model.put("definitions", Definition.all());
      }

      model.put("word", word);
      model.put("template","templates/word.vtl");
      return new ModelAndView(model, layout);
     }, new VelocityTemplateEngine());
    }
   }
