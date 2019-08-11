package com.example.pruebatalent.modelo;

import javax.persistence.*;
import java.util.List;

@Entity
@Access(AccessType.FIELD)
public class CollecionComic {

    @Id
    @Column(name = "comic_id" , unique = true, nullable = false)
    private int comic_id;
    @Column(name = "nombre" , nullable = false)
    private String nombre;
    @Column(name = "descripcion", nullable = false)
    private String descripcion;
    @Column(name = "thumail", nullable = false)
    private String thumail;
    @ManyToOne
    private Usuario usuario;

    public CollecionComic() {
    }

    public CollecionComic(int comic_id, String nombre, String descripcion, String thumail, Usuario usuario) {
        this.comic_id = comic_id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.thumail = thumail;
        this.usuario = usuario;
    }


    public int getComic_id() {
        return comic_id;
    }

    public void setComic_id(int comic_id) {
        this.comic_id = comic_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getThumail() {
        return thumail;
    }

    public void setThumail(String thumail) {
        this.thumail = thumail;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
