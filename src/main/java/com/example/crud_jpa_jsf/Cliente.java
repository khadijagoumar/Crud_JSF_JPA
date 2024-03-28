package com.example.crud_jpa_jsf;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="Cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column
    private String nombres;
    @Column
    private String apellidos;
    @Column
    private String direccion;
    @Column
    private String email;
    @Column
    private String telefono;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fregistro;
    @Temporal(TemporalType.TIMESTAMP)
    private Date factualizar;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFregistro() {
        return fregistro;
    }

    public void setFregistro(Date fregistro) {
        this.fregistro = fregistro;
    }


    public Date getFactualizar() {
        return factualizar;
    }

    public void setFactualizar(Date factualizar) {
        this.factualizar = factualizar;
    }

    @Override
    public String toString() {
        return "Cliente [id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", direccion=" + direccion
                + ", email=" + email + ", telefono=" + telefono + ", fregistro=" + fregistro + "]";
    }

}
