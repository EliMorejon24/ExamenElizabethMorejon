package ec.edu.espe.arquitectura.examen.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class OfiEdificioPK implements Serializable{
    @Column(name = "COD_EDIFICIO", nullable = false, length = 8)
    private String codigoEdificio;
    @Column(name = "COD_SEDE", nullable = false, length = 8)
    private String codigoSede;
    public OfiEdificioPK() {
    }
    public OfiEdificioPK(String codigoEdificio, String codigoSede) {
        this.codigoEdificio = codigoEdificio;
        this.codigoSede = codigoSede;
    }
    public String getCodigoEdificio() {
        return codigoEdificio;
    }
    public void setCodigoEdificio(String codigoEdificio) {
        this.codigoEdificio = codigoEdificio;
    }
    public String getCodigoSede() {
        return codigoSede;
    }
    public void setCodigoSede(String codigoSede) {
        this.codigoSede = codigoSede;
    }
    @Override
    public String toString() {
        return "OfiEdificioPK [codigoEdificio=" + codigoEdificio + ", codigoSede=" + codigoSede + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigoEdificio == null) ? 0 : codigoEdificio.hashCode());
        result = prime * result + ((codigoSede == null) ? 0 : codigoSede.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        OfiEdificioPK other = (OfiEdificioPK) obj;
        if (codigoEdificio == null) {
            if (other.codigoEdificio != null)
                return false;
        } else if (!codigoEdificio.equals(other.codigoEdificio))
            return false;
        if (codigoSede == null) {
            if (other.codigoSede != null)
                return false;
        } else if (!codigoSede.equals(other.codigoSede))
            return false;
        return true;
    }

    
    
}
