package com.example.demo.models;

import java.util.Date;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.Table;


public class UserModel {

    private Long id;
    private String nombres;
    private String apellidos;
    private String nick_name;
    private Date fecha_nacimiento;
    private Date fecha_creacion;
    private Date fecha_modificacion;


    public Long getId(){
        return id;
    }
 
    public String getNombres(){
        return nombres;
    }

    public String getApellidos(){
        return apellidos;
    }

    public String getNickName(){
        return nick_name;
    }

    public Date getFechaNacimiento(){
        return fecha_nacimiento;
    }
    public Date getFechaCreacion(){
        return fecha_creacion;
    }
    public Date getFechaModificacion(){
        return fecha_modificacion;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setNombres(String nombres){
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos){
        this.apellidos = apellidos;
    }

    public void setNickName(String nick_name){
        this.nick_name = nick_name;
    }

    public void setFechaNacimiento(Date fechaNacimiento){
        this.fecha_nacimiento = fechaNacimiento;
    }

    public void setFechaCreacion(Date fechaCreacion){
        this.fecha_creacion = fechaCreacion;
    }

    public void setFechaModificacion(Date fechaModificacion){
        this.fecha_modificacion = fechaModificacion;
    }


}
