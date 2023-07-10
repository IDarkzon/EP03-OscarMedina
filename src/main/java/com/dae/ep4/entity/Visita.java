package com.dae.ep4.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name="tbl_visitas")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Visita {
    @Id
    @Column(name="id", columnDefinition = "int", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "local", length = 50, nullable = false)
    private String local;
    @Column(name = "dni_afiliado", columnDefinition = "char(8)", nullable = false, unique = true)
    private String dni_afiliado;
    @Column(name = "fecha", columnDefinition = "date", nullable = false)
    private LocalDate fecha;
    @Column(name = "hora", columnDefinition = "time", nullable = false)
    private LocalTime hora;
}
