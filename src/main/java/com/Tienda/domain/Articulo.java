package com.Tienda.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="articulo")
public class Articulo implements Serializable{
     @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idArticulo;
    private Long idCategoria;
    private Long descripcion;
    private Long precio;
    private Long detalle;
    private Long existencias;
    private Long activo;

    public Articulo() {
    }

    public Articulo(Long idCategoria, Long descripcion, Long precio, Long detalle, Long existencias, Long activo) {
        this.idCategoria = idCategoria;
        this.descripcion = descripcion;
        this.precio = precio;
        this.detalle = detalle;
        this.existencias = existencias;
        this.activo = activo;
    }

    public boolean isActivo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
    
    
       
}
