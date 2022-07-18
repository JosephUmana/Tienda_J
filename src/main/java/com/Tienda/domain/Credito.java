
package com.Tienda.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="credito")
public class Credito implements Serializable{

private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id_credito") //esto indica contra que campo se va a asociar
private Long idCredito; //id_credito
private double limite;
    

public Credito(double limite){
this.limite = limite;

}

}
