package ec.edu.espe.arquitectura.examen.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.examen.model.OfiSede;
import ec.edu.espe.arquitectura.examen.repository.OfiSedeRepository;
import jakarta.transaction.Transactional;

@Service
public class OfiSedeService {
    private final OfiSedeRepository ofiSedeRepository;

    public OfiSedeService(OfiSedeRepository ofiSedeRepository) {
        this.ofiSedeRepository = ofiSedeRepository;
    }

    public Optional<OfiSede> obtainByCode(Integer code){
        return this.ofiSedeRepository.findById(code);
    }
    
    @Transactional
    public OfiSede create(OfiSede ofiSede){
        OfiSede sedeTmp = this.ofiSedeRepository.findByEsPrincipalLikeOrderByEsPrincipal(ofiSede.getEsPrincipal());
        if (sedeTmp == null) {
            return this.ofiSedeRepository.save(ofiSede); 
        }else{
            throw new RuntimeException("Cliente ya existe");
        }
    }
}
