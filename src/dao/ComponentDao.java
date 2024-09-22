package dao;


import java.util.HashMap;

public interface ComponentDao<C> {
    public HashMap<String, C> getAll();
    public C get(int id);
    public Integer create(C c);
    public void update(C t);
    public void delete(int id);
}
