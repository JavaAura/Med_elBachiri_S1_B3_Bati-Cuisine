package view.recourses.client;

import utils.Input;
import interfaces.View;

public class Search extends View {
    private Input input = new Input();

    public void display(){
        System.out.println("Cient Search");
        input.getNum("");
        input.getPhone("");
    }
}
