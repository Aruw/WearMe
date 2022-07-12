package br.com.aruw.dao;

import br.com.aruw.beans.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductDAO extends CrudRepository<Product, Integer> {

}