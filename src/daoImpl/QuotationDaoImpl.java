package daoImpl;

import dao.QuotationDao;
import model.Project;
import model.Quotation;
import utils.db.ModelCrud;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class QuotationDaoImpl implements QuotationDao {
    private ModelCrud model = new ModelCrud(ModelCrud.Table.QUOTATIONS);

    public QuotationDaoImpl(){model.setColumns("estimated_amount", "issue_date", "valid_until", "project_id");}

    @Override
    public Integer create(Quotation q) {
        model.setValues(q.getEstimatedAmount(), q.getIssueDate(), q.getValidUntil(), q.getProjectId());
        model.setThroughMsg(false);
        return model.create();
    }

    @Override
    public boolean getAllQuotationsProjects() {
        model.setQuery(
                "SELECT p.id, p.name, p.benefit_margin, p.status, p.kitchen_area_m2, " +
                        "q.id, q.estimated_amount, q.issue_date, q.valid_until, q.accepted " +
                        "FROM quotations q " +
                        "RIGHT JOIN projects p ON q.project_id = p.id"
        );
        HashMap<Integer, List<Object>> data = model.getAll();

        data.forEach((k, v) -> {
            System.out.println(
                    "\n\tPROJECT ID: " + v.get(0) + " | Name: " + v.get(1) +
                            " | Benefit Margin: " + v.get(2) + " | Status: " + v.get(3) +
                            " | Kitchen Surface: " + v.get(4)
            );
            if (v.get(5) != null) {
                System.out.println(
                        "\tQUOTATION ID: " + v.get(5) + " | Estimated Amount: " + v.get(6) +
                                " | Issue Date: " + v.get(7) + " | Valid Until: " + v.get(8) +
                                " | Accepted: " + (((boolean) v.get(9)) ? "YES" : "NO")
                );
            } else {
                System.out.println("\tNo Quotation available for this project.");
            }
        });

        System.out.println("\n\n");
        return data.isEmpty();
    }


    public boolean accept(int quotationId){
        model.activateWhere(true);
        model.setColumns("accepted");
        model.setValues(true);
        model.where("id"); model.equalsTo(quotationId);
        model.setThroughMsg(false);
        return model.update();
    }
}
