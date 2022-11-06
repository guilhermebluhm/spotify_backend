package com.spotify_unifor.spotify_unifor.service;

import com.spotify_unifor.spotify_unifor.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    List<Usuario> getAllUsers();
    Usuario getSpecifyUser(Integer id);
    Usuario saveUser(Usuario usuario);
    Usuario updateUser(Integer id, Usuario usuario);
    void deleteUser(Integer id);
    Usuario addPlaylist(Integer idPlaylist, Integer idUsuario);

}
