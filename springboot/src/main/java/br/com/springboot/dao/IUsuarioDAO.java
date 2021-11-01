package br.com.springboot.dao;

import br.com.springboot.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUsuarioDAO {

    Usuario save(Usuario usuario);
    Usuario update(Usuario usuario);
    void delete(Long id);
    List<Usuario> findAll();
    Optional<Usuario> findById(Long id);

}
