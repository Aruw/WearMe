package br.com.aruw.dao;

import br.com.aruw.beans.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderDAO extends CrudRepository<Order, Integer> {

}