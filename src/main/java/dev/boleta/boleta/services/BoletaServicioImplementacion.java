package dev.boleta.boleta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.boleta.boleta.model.Boleta;
import dev.boleta.boleta.repositories.BoletaRepositorio;

@Service
public class BoletaServicioImplementacion implements BoletaServicio{
    @Autowired
    BoletaRepositorio boletaRepositorio;

    @Override
    public List<Boleta> obtenerTodo() {
        return boletaRepositorio.findAll();
    }

    @Override
    public Boleta guardar(Boleta Boleta) {
        return boletaRepositorio.save(Boleta);
    }

    @Override
    public Boleta obtenerPorId(long id) {
        return boletaRepositorio.findById(id).orElse(null);
    }

    @Override
    public void eliminar(long id) {
        boletaRepositorio.deleteById(id);
    }
    
}
