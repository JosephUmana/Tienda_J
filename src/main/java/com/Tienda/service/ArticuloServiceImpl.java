/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Tienda.service;

import com.Tienda.dao.ArticuloDao;
import com.Tienda.domain.Articulo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArticuloServiceImpl implements ArticuloService {
@Autowired
private ArticuloDao articuloDao;

    @Override
    @Transactional(readOnly = true) 
    public List<Articulo> getArticulos(boolean activo) {
    
        var lista=(List<Articulo>) articuloDao.findAll();
        
        if(activo){
            lista.removeIf(e-> !e.isActivo());
        }
        return lista;
    
    
    }

    @Override
    @Transactional
    public void save(Articulo articulo) {
     articuloDao.save(articulo);
    }

    @Override
    @Transactional
    public void delete(Articulo articulo) {
       articuloDao.delete(articulo);
    }

    @Override
    @Transactional(readOnly = true)
    public Articulo getArticulo(Articulo articulo) {
     return articuloDao.findById(articulo.getIdArticulo()).orElse(null);
    }
    
}
