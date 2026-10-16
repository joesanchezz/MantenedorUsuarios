package com.sanchez.jorge.model;

import com.sanchez.jorge.dto.UsuarioDto;
import java.util.ArrayList;

public class UsuarioModel {


    private final ArrayList<UsuarioDto> usuarios = new ArrayList<>();

    public void agregarUsuario(UsuarioDto usuario){
        usuarios.add(usuario);
    }

    public void eliminarUsuario(UsuarioDto usuario) {
        usuarios.remove(usuario);
    }

    public ArrayList<UsuarioDto> mostrarUsuarios() {
        return usuarios;
    }
}
