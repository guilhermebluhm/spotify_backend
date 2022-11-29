package com.spotify_unifor.spotify_unifor.controller;

import com.spotify_unifor.spotify_unifor.model.Playlist;
import com.spotify_unifor.spotify_unifor.service.impl.PlaylistImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/playlist")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PlaylistController {

    @Autowired
    private PlaylistImpl playlist;

    @GetMapping(value = "")
    public List<Playlist> getAll(){
        return this.playlist.getAll();
    }

    @PostMapping(value = "")
    public Playlist savePlaylist(@RequestBody Playlist playlist){
        return this.playlist.addNewPlaylist(playlist);
    }

    @GetMapping("{id}")
    public Playlist getSpecifyPlaylist(@PathVariable Integer id){
        return this.playlist.getSpecifyPlaylist(id);
    }

    @PostMapping("{idPlaylist}/musica/{idMusica}")
    public Playlist addMusicOnPlaylist(@PathVariable("idPlaylist") Integer idPlaylist,
                                       @PathVariable("idMusica") Integer idMusica){
        return this.playlist.saveMusicOnPlaylist(idMusica, idPlaylist);
    }

    @DeleteMapping("{idPlaylist}/musica/{idMusica}")
    public Playlist removeMusicOnPlaylist(@PathVariable("idPlaylist") Integer idPlaylist,
                                       @PathVariable("idMusica") Integer idMusica){
        return this.playlist.removeMusicOnPlaylist(idMusica, idPlaylist);
    }

}
