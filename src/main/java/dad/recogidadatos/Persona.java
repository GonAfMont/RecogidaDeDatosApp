package dad.recogidadatos;

import com.google.gson.annotations.SerializedName;

// Java Bean
public class Persona {

    private String nombre;
    private String apellidos;
    private String edad;

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getEdad() {
        return edad;
    }
    public void setEdad(String edad) {
        this.edad = edad;
    }



}

