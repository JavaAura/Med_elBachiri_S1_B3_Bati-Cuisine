package service;

import daoImpl.MaterialDaoImpl;
import model.Material;
import utils.db.ModelCrud;

public class MaterialService {
    private static final MaterialDaoImpl materialDao = new MaterialDaoImpl();


    public static void create(Material m){
        materialDao.create(m);
    }
    public static Material get(int id){
        return materialDao.get(id);
    }
}
