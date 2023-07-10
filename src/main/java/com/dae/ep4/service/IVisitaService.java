package com.dae.ep4.service;

import com.dae.ep4.entity.Visita;

import java.util.List;

public interface IVisitaService {

    public List<Visita> Listar(Integer id);
    public void save(Visita visita);
    public void delete(Integer id);
}
