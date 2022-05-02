package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.Category;
import com.platzi.market.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")  // Definir que la interfaz sera para mapear componentes de Spring
public interface CategoryMapper {
    @Mappings({                     // Definir listado de componentes a mapear
            @Mapping(source = "idCategoria",target = "categoryId"),
            @Mapping(source = "descripcion",target = "category"),
            @Mapping(source = "estado",target = "active")
    })
    Category toCategory(Categoria categoria);

    @InheritInverseConfiguration // Hace el mismo mapeo anterior pero inverso
    Categoria toCategoria(Category category);
}
