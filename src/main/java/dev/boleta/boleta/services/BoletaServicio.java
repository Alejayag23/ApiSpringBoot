package dev.boleta.boleta.services;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.boleta.boleta.model.Boleta;

@Service
public interface BoletaServicio {
    public List<Boleta> obtenerTodo();

    public Boleta guardar(Boleta Boleta);
    
    public Boleta obtenerPorId(long id);

    public void eliminar(long id);
}