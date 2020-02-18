package ttps.spring.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ttps.spring.DAO.DuenoDAO;
import ttps.spring.DAO.EventoDAO;
import ttps.spring.DTO.EventoDTO;
import ttps.spring.model.Desparasitacion;
import ttps.spring.model.Enfermedad;
import ttps.spring.model.Evento;
import ttps.spring.model.Mascota;

@Service
public class EventoService {
	@Autowired
	private DuenoDAO duenoDAO;
	
	@Autowired
	private EventoDAO eventoDAO;
	
	public List<EventoDTO> getAllEventosDeDueno(int id, String fecha) {
		LocalDate f = LocalDate.parse(fecha);
		List<Mascota> listaMascota = duenoDAO.getAllMascotas(id);
		List<Evento> listaEventos = new ArrayList<>(); 
		List<EventoDTO> resultado = new ArrayList<>();
		for (Mascota m : listaMascota) {
			listaEventos.addAll((List<Evento>) eventoDAO.getByDate(f, m.getId()));
		}
		for (Evento e : listaEventos) {
			String clase = e.getClass().getSimpleName();
			EventoDTO eventoDTO;
			switch (clase) {
				case "Desparasitacion": 
					eventoDTO = new EventoDTO(clase, e.getId(), e.getFecha(),
							((Desparasitacion) e).getDroga(), ((Desparasitacion) e).getResultado());
					resultado.add(eventoDTO);
					break;
				case "Enfermedad":
					eventoDTO = new EventoDTO( clase, e.getId(), e.getFecha(), ( (Enfermedad) e ).getDescripcion() );
					resultado.add(eventoDTO);
					break;					
			}
		}
		return resultado;
	}
}
