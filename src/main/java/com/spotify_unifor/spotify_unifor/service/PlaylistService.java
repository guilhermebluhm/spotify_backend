package com.spotify_unifor.spotify_unifor.service;

import com.spotify_unifor.spotify_unifor.model.Playlist;

import java.util.List;

public interface PlaylistService {

    List<Playlist> getAll();
    Playlist addNewPlaylist(Playlist playlist);
    Playlist getSpecifyPlaylist(Integer id);
    void removePlaylist(Integer id);
    Playlist saveMusicOnPlaylist(Integer musicId, Integer playlistId);
    Playlist removeMusicOnPlaylist(Integer playlistId, Integer musica);

}
