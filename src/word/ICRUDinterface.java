package word;

public interface ICRUDinterface {
    public Object Creat();
    public int update(Object obj);
    public int delete(Object obj);
    public void selectOne(int id);
}
