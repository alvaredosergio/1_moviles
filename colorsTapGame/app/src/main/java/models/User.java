package models;

public class User {
    private String nombre;
    private String correo;
    private String puntuacion;

    public User(){};

    public User(String nombre, String correo, String puntuacion){
        this.nombre = nombre;
        this.correo = correo;
        this.puntuacion = puntuacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(String puntuacion) {
        this.puntuacion = puntuacion;
    }
}
