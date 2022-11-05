package com.spotify_unifor.spotify_unifor.repository;

import com.spotify_unifor.spotify_unifor.model.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicaRepository extends JpaRepository<Musica, Integer> {
}
