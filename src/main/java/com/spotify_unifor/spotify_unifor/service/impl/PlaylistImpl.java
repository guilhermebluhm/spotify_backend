package com.spotify_unifor.spotify_unifor.service.impl;

import com.spotify_unifor.spotify_unifor.model.Musica;
import com.spotify_unifor.spotify_unifor.model.Playlist;
import com.spotify_unifor.spotify_unifor.repository.PlaylistRepository;
import com.spotify_unifor.spotify_unifor.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PlaylistImpl implements PlaylistService {

    @Autowired
    private MusicaImpl impl;

    @Autowired
    private PlaylistRepository play_repository;

    @Override
    public List<Playlist> getAll() {
        return this.play_repository.findAll();
    }

    @Override
    public Playlist addNewPlaylist(Playlist playlist) {
        return this.play_repository.save(playlist);
    }

    @Override
    public Playlist getSpecifyPlaylist(Integer id) {
        return this.play_repository.findById(id).orElseThrow(() -> new RuntimeException("erro"));
    }

    @Override
    public void removePlaylist(Integer id) {
        Playlist specifyPlaylist = this.getSpecifyPlaylist(id);
        this.play_repository.delete(specifyPlaylist);
    }

    @Override
    @Transactional
    public Playlist saveMusicOnPlaylist(Integer musicId, Integer playlistId) {
        Optional<Playlist> byId = this.play_repository.findById(playlistId);
        Musica specifyMusic = this.impl.getSpecifyMusic(musicId);

        specifyMusic.setPlaylist(byId.get());
        byId.get().setarMusica(specifyMusic);

        return byId.get();
    }

    @Override
    public Playlist removeMusicOnPlaylist(Integer playlistId, Integer musica) {
        Playlist specifyPlaylist = this.getSpecifyPlaylist(playlistId);

        Musica specifyMusic = this.impl.getSpecifyMusic(musica);

        specifyPlaylist.getLista_musicas().remove(specifyMusic);
        return this.play_repository.save(specifyPlaylist);
    }

}
