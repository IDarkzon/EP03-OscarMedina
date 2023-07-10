package com.dae.ep4.service;

import com.dae.ep4.entity.Visita;
import com.dae.ep4.repository.VisitaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VisitaServiceImpl implements IVisitaService {

    @Autowired
    private final VisitaRepository visitaRepository;

    @Override
    public List<Visita> Listar(Integer id) {
        if (id != null) {
            return visitaRepository.findAll(id);
        }
        return visitaRepository.findAll();
    }

    @Override
    public void save(Visita visita) {
        visitaRepository.save(visita);
    }

    @Override
    public void delete(Integer id) {
        Visita visitaToDelete = visitaRepository.findById(id).orElseThrow();
        visitaRepository.delete(visitaToDelete);
    }
}
