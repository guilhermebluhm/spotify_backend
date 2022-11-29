package com.spotify_unifor.spotify_unifor.controller;

import com.spotify_unifor.spotify_unifor.model.Musica;
import com.spotify_unifor.spotify_unifor.service.impl.MusicaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/musica")
@CrossOrigin("*")
public class MusicaController {

    @Autowired
    private MusicaImpl musica;

    @GetMapping(value = "")
    public List<Musica> getAll(){
        return this.musica.getAllMusic();
    }

    @PostMapping(value = "")
    public Musica saveMusica(@RequestBody Musica musica){
        return this.musica.saveMusic(musica);
    }

    @DeleteMapping(value = "{id}")
    public void deleteUser(@PathVariable int id){
        this.musica.deleteMusic(id);
    }

    @PutMapping(value = "{id}")
    public Musica updateMusica(@PathVariable int id, @RequestBody Musica musica){
        return this.musica.updateMusic(id, musica);
    }

    @GetMapping(value = "/pesquisa")
    public List<Musica> getMusicaByQuery(@RequestParam("alias") String alias){

        return this.musica.getMusicaByNameWithQuery(alias);

    }

}
