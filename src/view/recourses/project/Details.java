package view.recourses.project;

// import views.Router;
import interfaces.View;
import model.Material;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Details implements View{
    // private Router router = new Router();
    public void display(Object... params){
        Array materials = (Array) params[0]; // array of materials
        Array labors = (Array) params[0]; // array of labors


        System.out.println("\t\t-Projects-\n");
        System.out.println("\tProject 1:");
        System.out.println("\n\tName: Bati-Cuisine");
        System.out.println("\tCient: Med Assami");
        // router.get("main");
    }
}
