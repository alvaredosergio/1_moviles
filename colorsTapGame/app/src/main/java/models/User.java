package models;

import android.widget.TextView;

public class User {
    private String nombre;
    private String correo;
    private String color;
    private int puntuacion;

    public User(){};

    public User(String nombre, String color, String correo, int puntuacion){
        this.nombre = nombre;
        this.color = color;
        this.correo = correo;
        this.puntuacion = puntuacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public int compareTo(User user){
        if(user.puntuacion > user.getPuntuacion()){
            return 1;
        }else{
            return -1;
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "nombre='" + nombre + '\'' +
                ", color='" + color + '\'' +
                ", correo='" + correo + '\'' +
                ", puntuacion=" + puntuacion +
                '}';
    }
}
