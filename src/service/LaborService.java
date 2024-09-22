package service;

import daoImpl.LaborDaoImpl;
import daoImpl.MaterialDaoImpl;
import model.Labor;
import model.Material;
import utils.db.ModelCrud;

public class LaborService {
    private static final LaborDaoImpl laborDao = new LaborDaoImpl();

    public static void create(Labor l){
        laborDao.create(l);
    }
    public static Labor get(int id){
        return laborDao.get(id);
    }
}
