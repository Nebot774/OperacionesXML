package org.example;

import java.util.List;
public class AtletaFemenina {

    private String nombre;
    private List<String> prueba;
    private int edad;
    private String pais;

    public AtletaFemenina(String nombre, List<String> prueba, int edad, String pais) {
        this.nombre = nombre;
        this.prueba = prueba;
        this.edad = edad;
        this.pais = pais;
    }

    public AtletaFemenina() {
        // Constructor sin argumentos
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<String> getPrueba() {
        return prueba;
    }

    public void setPrueba(List<String> prueba) {
        this.prueba = prueba;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

}
