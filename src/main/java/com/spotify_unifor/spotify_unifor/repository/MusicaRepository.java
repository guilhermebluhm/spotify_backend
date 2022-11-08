package com.spotify_unifor.spotify_unifor.repository;

import com.spotify_unifor.spotify_unifor.model.Musica;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicaRepository extends JpaRepository<Musica, Integer> {

    @Query(value = "select * from musica where nome like %:titulo%", nativeQuery = true)
    List<Musica> getMusicaByName(@Param("titulo") String titulo);

}
