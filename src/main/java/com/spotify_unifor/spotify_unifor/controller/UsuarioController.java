package com.spotify_unifor.spotify_unifor.controller;

import com.spotify_unifor.spotify_unifor.model.Playlist;
import com.spotify_unifor.spotify_unifor.model.Usuario;
import com.spotify_unifor.spotify_unifor.service.impl.UsuarioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioImpl usuario;

    @GetMapping(value = "")
    public List<Usuario> getAll(){
        return this.usuario.getAllUsers();
    }

    @PostMapping(value = "")
    public Usuario saveUser(@RequestBody Usuario usuario){
        return this.usuario.saveUser(usuario);
    }

    @DeleteMapping(value = "{id}")
    public void deleteUser(@PathVariable int id){
        this.usuario.deleteUser(id);
    }

    @PutMapping(value = "{id}")
    public Usuario updateUser(@PathVariable int id, @RequestBody Usuario usuario){
        return this.usuario.updateUser(id, usuario);
    }

    @PostMapping("{idUsuario}/playlist/{idPlaylist}")
    public Usuario addMusicOnPlaylist(@PathVariable("idUsuario") Integer idUsuario,
                                       @PathVariable("idPlaylist") Integer idPlaylist){
        return this.usuario.addPlaylist(idPlaylist, idUsuario);
    }
}
