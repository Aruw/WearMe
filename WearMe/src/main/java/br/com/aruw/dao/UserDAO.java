package br.com.aruw.dao;

import br.com.aruw.beans.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDAO extends CrudRepository<User, Integer> {

}