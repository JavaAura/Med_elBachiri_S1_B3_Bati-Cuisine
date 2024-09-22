package daoImpl;

import dao.ComponentDao;
import model.Labor;
import utils.db.ModelCrud;

import java.util.HashMap;

public class LaborDaoImpl implements ComponentDao<Labor> {
    private final ModelCrud model = new ModelCrud(ModelCrud.Table.LABORS);

    public LaborDaoImpl(){model.setColumns("name", "component_type", "project_id", "hourly_rate", "hours_worked", "worker_productivity");}

    @Override
    public HashMap<String, Labor> getAll() {
        return null;
    }

    @Override
    public Labor get(int id) {
        return null;
    }

    @Override
    public Integer create(Labor l) {
        model.setValues(l.getName(), l.getComponentType(), l.getProjectId(), l.getHourlyRate(), l.getHoursWorked(), l.getWorkerProductivity());
        return model.create();
    }

    @Override
    public void update(Labor t) {

    }

    @Override
    public void delete(int id) {

    }
}
