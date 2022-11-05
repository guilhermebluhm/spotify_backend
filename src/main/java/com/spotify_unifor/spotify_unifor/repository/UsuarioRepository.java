package com.spotify_unifor.spotify_unifor.repository;

import com.spotify_unifor.spotify_unifor.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}
