package dev.boleta.boleta.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.boleta.boleta.model.Boleta;
import dev.boleta.boleta.services.BoletaServicioImplementacion;

@RestController
@RequestMapping("/api/boleteria")
public class BoletaControlador {

    @Autowired
    BoletaServicioImplementacion BoletaServicio;

    @GetMapping("/Boleta")
    public List<Boleta> obtenerBoleta() {
        return BoletaServicio.obtenerTodo();
    }

    @PostMapping("/Guardar")
    public ResponseEntity<Boleta> guardarBoleta(@RequestBody Boleta Boleta) {
        Boleta nuevBoleta = BoletaServicio.guardar(Boleta);
        return new ResponseEntity<Boleta>(nuevBoleta, HttpStatus.CREATED);
    }

    @GetMapping("/Boleta/{id}")
    public ResponseEntity<Boleta> obtenerBoletaId(@PathVariable long id){
        Boleta BoletaPorId = BoletaServicio.obtenerPorId(id);
        return ResponseEntity.ok(BoletaPorId);
    }

    @PutMapping("/Actualizar/{id}")
    public ResponseEntity <Boleta> actualizar(@PathVariable long id, @RequestBody Boleta Boleta){
        Boleta boletaPorId = BoletaServicio.obtenerPorId(id);
        boletaPorId.setNombre_evento(Boleta.getNombre_evento());
        boletaPorId.setFecha_evento(Boleta.getFecha_evento());
        boletaPorId.setCategoria(Boleta.getCategoria());
        boletaPorId.setUbicacion(Boleta.getUbicacion());
        boletaPorId.setZona(Boleta.getZona());
        boletaPorId.setPrecio(Boleta.getPrecio());

        Boleta BoletaActualizada = BoletaServicio.guardar(boletaPorId);
        return new ResponseEntity<>(BoletaActualizada, HttpStatus.CREATED);
    }

    @DeleteMapping("/Eliminar/{id}")
    public ResponseEntity<HashMap<String, Boolean>> eliminarBoleta(@PathVariable long id){
        this.BoletaServicio.eliminar(id);
        HashMap<String, Boolean> estadoBoletaEliminado = new HashMap<>();
        estadoBoletaEliminado.put("Eliminado", true);
        return ResponseEntity.ok(estadoBoletaEliminado);
    }
}
