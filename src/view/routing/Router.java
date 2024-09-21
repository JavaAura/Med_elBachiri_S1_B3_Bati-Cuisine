package view.routing;

import java.util.HashMap;

import interfaces.View;
import view.entry.Entry;
import view.recourses.client.Index;
import view.recourses.client.Search;
import view.recourses.project.Calculate;
import view.recourses.project.Show;
import view.recourses.quite.Quite;


/**
 * {@code Router} Class is for displaying View Classes by a Name or ID that is
 * given to the view first when they were added.
 * <p>
 * To start, go to Router and:
 * <p>
 * </blockquote>
 * <p>
 * - add View Class Instance and give it a Name and ID, in Router constructor method.
 * <p>
 * - get view by Name or ID
 * <p>
 * <blockquote>
 * 
 * <pre>
 * Here are some more examples of how Routers can be used:
 * <blockquote><pre>
 *     Router router = new Router()
 *     Menu menu = router.get(1); // get menu view by ID
 *     Login login = router.get("login_view"); // get login view by Name
 *     menu.display();
 *     login.display();
 * </pre>
 * 
 * </blockquote>
 * <blockquote>
 * 
 * <pre>
 * Example of how to add a routing view:
 * <blockquote><pre>
 *     public Router(){
        routs.put("1-main_menu", new Main());
        routs.put("2-search_client_menu", new SearchClient());
        // add as many routes as you want.
    }
 * </pre>
 * 
 * </blockquote>
 * <p>
 * 
 * @author
 *         Bachiri Med
 */
public class Router {
    private static View main = new Entry();

    private static HashMap<String, View> routs = new HashMap<String, View>() {
        {
            put("0/0/main", main);
            put("1/0/clients", new Index());
            put("1/1/client_create", new view.recourses.client.Create());
            put("1/2/client_search", new Search());
            put("1/3/main", main);
            put("2/0/projects", new Show());
            put("2/1/project_create", new view.recourses.project.Create());
            put("3/0/coute_project", new Calculate());
            put("4/0/quite", new Quite());
        }
    };

    public static View get(String viewName) {
        String findView = routs.keySet().stream().filter(a -> a.contains(viewName)).findAny().get();
        return routs.get(findView);
    }

    public static View get(int viewId) {
        return get(String.valueOf(viewId) + "/0/");
    }

    public static View get(int parentViewId, int subViewId) {
        return get(String.valueOf(parentViewId) + "/" + String.valueOf(subViewId) + "/");
    }
}