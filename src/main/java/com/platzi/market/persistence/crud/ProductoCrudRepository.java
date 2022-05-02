package com.platzi.market.persistence.crud;

import com.platzi.market.persistence.entity.Producto;
// import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {

    //@Query(value = "SELECT * FROM productos WHERE id_categoria = ?", nativeQuery = true)
    //List<Producto> getByCategoria(int idCategoria);
    // Se puede hacer de la forma anterior si quisieramos usar querys nativos.

    // Pero usar Query Methods
    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);

    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);

    Optional<List<Producto>> findByNombreLike(String nombre);

}
