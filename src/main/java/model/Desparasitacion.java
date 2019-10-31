package model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Desparacitacion")
public class Desparasitacion extends Evento {
	@Column(name = "droga", length = 100)
	private String droga;
	
	@Column(name = "resultado", length = 200)
	private String resultado;
	
	public Desparasitacion() {}

	public Desparasitacion(Date fecha, Mascota mascota, String droga, String resultado) {
		super(fecha, mascota);
		this.droga = droga;
		this.resultado = resultado;
	}

	public String getDroga() {
		return droga;
	}
	public void setDroga(String droga) {
		this.droga = droga;
	}
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
    @Override
    public boolean equals(Object obj)
    {
        if ( obj == null ) return false;
        if ( this == obj ) return true;
        if ( ! (obj instanceof Desparasitacion ) ) return false;
        Desparasitacion d = (Desparasitacion) obj;
        return this.getId() == d.getId();
    }
}
