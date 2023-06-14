package ec.edu.espe.arquitectura.examen.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.arquitectura.examen.model.Cliente;
import ec.edu.espe.arquitectura.examen.service.ClienteService;

@RestController
@RequestMapping("/api/v1/cliente")
public class ClienteController {
    public final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("{code}")
    public ResponseEntity<Cliente> obtainByCode(@PathVariable(name= "code") Integer code){
        Optional<Cliente> cliente = this.clienteService.obtainByCode(code);
        if (cliente.isPresent()){
            return ResponseEntity.ok(cliente.get()); /*--okcon entidad cliente.get */
        } else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{tipoIdentificacion}/{nombre}")
    public ResponseEntity<List<Cliente>> obtainByTipoIdentificacionAndName(
        @PathVariable(name = "tipoIdentificacion") String tipoIdentificacion,
        @PathVariable(name = "nombre") String nombre){
        List<Cliente> clientes = this.clienteService.listByTipoIdentificacionAndPattern(tipoIdentificacion, nombre);
        return ResponseEntity.ok(clientes);
        
    }

    @PostMapping(value = "")
    public ResponseEntity<Cliente> create(@RequestBody Cliente cliente) {
        /*--try and catch porque el cliente lanza una exp de tipo runtime */
        try{
            Cliente clienteResponse =this.clienteService.create(cliente);
            return ResponseEntity.ok(clienteResponse);
        }catch (RuntimeException rte){
            return ResponseEntity.badRequest().build();
        }
        
    }

    /*--actualizar-- */
    @PutMapping
    public ResponseEntity<Cliente> update (@RequestBody Cliente cliente){
        try{
            Cliente clienteResponse = this.clienteService.update(cliente);
            return ResponseEntity.ok(clienteResponse);
        } catch (RuntimeException rte){
            return ResponseEntity.badRequest().build();
        }
    }
    
}
