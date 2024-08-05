package com.example.api.repositories;

import com.example.api.domain.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {

//    Consultar o usuario pelo login
//    O JPA, identifica alguns metodos automaticos e gera a query deles automaticmanete
    UserDetails findByLogin(String login);
}
