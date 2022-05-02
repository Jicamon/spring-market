package com.platzi.market.domain.service;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service                        // Anotacion para decirle a Spring que esta clase es un servicio de nuestra logica de negocios
public class ProductService {

    @Autowired  // Podemos utilizar @Autowired en esta interfaz ya que, aunque ella no tenga anotaciones, la clase que la implementa (ProductoRepository) si tiene una anotacion
    private ProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.getAll();
    }

    public Optional<Product> getProduct(int productId){
        return productRepository.getProduct(productId);
    }

    public Optional<List<Product>> getByCategory(int categoryId){
        return productRepository.getByCategory(categoryId);
    }

    public Optional<List<Product>> getScarseProducts(int quantity){
        return productRepository.getScarseProducts(quantity);
    }

    public Product save(Product product){
        return productRepository.save(product);
    }

    public boolean delete(int productId){
        return getProduct(productId).map(product -> {
            productRepository.delete(productId);
            return  true;
        }).orElse(false);

/*        if(getProduct(productId).isPresent()){
            productRepository.delete(productId);
            return true;
        } else {
            return false;
        }*/
    }

}
