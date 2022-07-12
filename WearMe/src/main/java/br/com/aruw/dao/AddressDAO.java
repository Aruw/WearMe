package br.com.aruw.dao;

import br.com.aruw.beans.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressDAO extends CrudRepository<Address, Integer> {

}