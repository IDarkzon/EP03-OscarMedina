package com.dae.ep4.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tbl_usuario")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Usuario {
    @Id
    @Column(name="usuario", length = 40, nullable = false)
    private String usuario;
    @Column(name="password", length = 40, nullable = false)
    private String password;
}
