package view.routing;

import java.util.HashMap;
import java.util.Optional;

import interfaces.View;
import view.entry.Entry;
import view.recourses.client.Index;
import view.recourses.client.Search;
import view.recourses.material.Create;
import view.recourses.project.*;
import view.recourses.quite.Quite;
import view.recourses.quotation.Accept;
import view.recourses.quotation.Save;

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
 */
public class Router {
    private static final View entry = new Entry();

    private static final HashMap<String, View> routs = new HashMap<String, View>() {
        {
            put("0/0/entry", entry);
            put("1/0/clients", new Index());
            put("1/1/client_create", new view.recourses.client.Create());
            put("1/2/client_search", new Search());
            put("1/3/display_clients", new view.recourses.client.All());
            put("1/4/back_to_entry", entry);
            put("2/0/projects", new All());
            put("2/1/update_project", new Update());
            put("2/2/accept_quotation", new Accept());
            put("2/3/delete_project", new Delete());
            put("2/4/back_home", entry);
            put("2/x/project_create", new view.recourses.project.Create());
            put("2/x/material_create", new Create());
            put("2/x/labor_create", new view.recourses.labor.Create());
            put("3/0/project_calculate_cost", new CalculateCost());
            put("3/1/project_details", new Details());
            put("3/2/project_before_quotation", new BeforeQuotation());
            put("3/3/project_save_quotation", new Save());
            put("4/0/quite", new Quite());
        }
    };

    /**
     * Get view by view name.
     *
     * @param viewName The name of the view to search.
     * @return The view instance.
     */
    public static View get(String viewName) {
        Optional<String> findView = routs.keySet().stream().filter(a -> a.contains(viewName)).findAny();

        if (findView.isPresent()) {
            return routs.get(findView.get());
        } else {
            System.out.println("\n[-] View not found for: " + viewName + "\n\n");
            return routs.get("0/0/entry");
        }
    }

    /**
     * Get view by view ID.
     *
     * @param viewId The ID of the view.
     * @return The view instance.
     */
    public static View get(int viewId) {
        return get(strOf(viewId) + "/0/");
    }

    /**
     * Get view by parent view ID and subview ID.
     *
     * @param parentViewId The parent view ID.
     * @param subViewId The subview ID.
     * @return The view instance.
     */
    public static View get(int parentViewId, int subViewId) {
        return get(strOf(parentViewId) + "/" + strOf(subViewId) + "/");
    }

    private static String strOf(int i){
        return String.valueOf(i);
    }
}
