package com.spotify_unifor.spotify_unifor.service;

import com.spotify_unifor.spotify_unifor.model.Musica;
import com.spotify_unifor.spotify_unifor.model.Usuario;

import java.util.List;

public interface MusicaService {

    List<Musica> getAllMusic();
    Musica getSpecifyMusic(Integer id);
    Musica saveMusic(Musica usuario);
    Musica updateMusic(Integer id, Musica usuario);
    void deleteMusic(Integer id);

}
