package ec.edu.espe.arquitectura.examen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.edu.espe.arquitectura.examen.model.OfiSede;

public interface OfiSedeRepository extends JpaRepository<OfiSede, Boolean>{

    List<OfiSede> findByEsPrincipalLikeOrderByEsPrincipal (Boolean esPrincipal);
    
    List<OfiSede> findBycodigoInstitucion (Integer codigoInstitucionPattern);
}
