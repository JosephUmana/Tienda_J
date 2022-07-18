package com.Tienda.service;

import com.Tienda.domain.Categoria;
import java.util.List;

public interface CategoriaService {

    public List<Categoria> getCategorias(boolean activo);

    public void save(Categoria categoria);

    public void delete(Categoria categoria);

    public Categoria getCategoria(Categoria categoria);

}
