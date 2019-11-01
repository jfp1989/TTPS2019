package clasesDAO;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import model.Evento;

public interface EventoDAO extends Dao<Evento> {
	List<Evento> getByDate(LocalDate d);
}
