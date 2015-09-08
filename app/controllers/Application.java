package controllers;


import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public Result index() {
    	/*
     	System.out.println("Inside index");
    	 
    	int a = 5;
    	int b = a + 3;
    	*/
        return ok(index.render("Your new application is ready."));
    }

}
