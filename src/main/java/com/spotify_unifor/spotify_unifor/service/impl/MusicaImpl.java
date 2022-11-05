package com.spotify_unifor.spotify_unifor.service.impl;

import com.spotify_unifor.spotify_unifor.model.Musica;
import com.spotify_unifor.spotify_unifor.repository.MusicaRepository;
import com.spotify_unifor.spotify_unifor.service.MusicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MusicaImpl implements MusicaService {

    @Autowired
    private MusicaRepository music_repo;

    @Override
    public List<Musica> getAllMusic() {
        return this.music_repo.findAll();
    }

    @Override
    public Musica getSpecifyMusic(Integer id) {
        return this.music_repo.findById(id).orElseThrow(() -> new RuntimeException("erro"));
    }

    @Override
    public Musica saveMusic(Musica usuario) {
        return this.music_repo.save(usuario);
    }

    @Override
    public Musica updateMusic(Integer id, Musica musica) {
        Optional<Musica> byId = this.music_repo.findById(id);
        if(byId.isPresent()){
            byId.get().setNome(musica.getNome());
            byId.get().setLink(musica.getLink());
            return this.music_repo.save(byId.get());
        }
        throw new RuntimeException("erro");
    }

    @Override
    public void deleteMusic(Integer id) {
        Musica specifyMusic = this.getSpecifyMusic(id);
        this.music_repo.save(specifyMusic);
    }
}
