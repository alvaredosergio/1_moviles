package models;

// Model class for User
public class User {
    private String nombre;
    private String email;
    private int puntuacion;

    public User(){};

    // Constructor
    public User(String nombre, String email, int puntuacion){
        this.nombre = nombre;
        this.email = email;
        this.puntuacion = puntuacion;
    }

    // Getters & Setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public int getPuntuacion() {
        return puntuacion;
    }
    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    // compareTo order by score
    public int compareTo(User user){
        if(user.puntuacion > user.getPuntuacion()){
            return 1;
        }else{
            return -1;
        }
    }

    // toString
    @Override
    public String toString() {
        return "User{" +
                "nombre='" + nombre + '\'' +
                ", correo='" + email + '\'' +
                ", puntuacion=" + puntuacion +
                '}';
    }
}