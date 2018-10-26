package com.resfull.core.controller;

import com.resfull.core.entity.Nota;
import com.resfull.core.model.MNota;
import com.resfull.core.service.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class NotaController {
    @Autowired
    @Qualifier("servicio")
    NotaService service;

    @PutMapping("/nota")
    public boolean agregarNota(@RequestBody @Valid Nota nota){
        return service.crear(nota);
    }

    @PostMapping("/nota")
    public boolean actualizarNota(@RequestBody @Valid Nota nota){
        return service.actualizar(nota);
    }

    @DeleteMapping("/nota/{id}/{nombre}")
    public boolean borrarNota(@PathVariable("id") long id, @PathVariable("nombre") String nombre){
        return service.borrar(nombre, id);
    }

    @GetMapping("/notas")
    public List<MNota> obtenerNotas(Pageable pageable){
        return service.obtenerPorPaginacion(pageable);
    }
}
