package view;

import view.routing.Router;

public class Console {
    public static void start(){
        Router.get("main").display();
    }
}
