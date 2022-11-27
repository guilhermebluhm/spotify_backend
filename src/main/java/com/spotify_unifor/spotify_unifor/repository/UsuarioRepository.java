package com.spotify_unifor.spotify_unifor.repository;

import com.spotify_unifor.spotify_unifor.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

    @Query(value = "SELECT * from USUARIO where email = :criterio", nativeQuery = true)
    Usuario getUserByEmail(@Param("criterio") String criterio);

}
