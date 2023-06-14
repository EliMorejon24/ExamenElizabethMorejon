package ec.edu.espe.arquitectura.examen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.edu.espe.arquitectura.examen.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
    List<Cliente> findByApellidoLikeOrderByApellido (String apellidoPattern);

    List<Cliente> findByRazonSocialLikeOrderByRazonSocial (String razonSocialPattern);

    Cliente findByTipoIdentificacionAndIdentificacion (String tipoIdentificacion, String identificacion);

}
