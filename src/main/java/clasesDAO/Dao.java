package clasesDAO;

import java.util.List;

public interface Dao<T> {
	T getById(int id);
	List<T> getAll();
	void save(T t);
	void update(T t);
	void delete(T t);
}
