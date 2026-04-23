package logica;

import java.time.LocalDateTime;

public class Comentario {
    private LocalDateTime fecha;
    private String email;
    private String direccionIP;
    private String texto;

    public Comentario(String email, String direccionIP, String texto) {
        this.fecha = LocalDateTime.now();
        this.email = email;
        this.direccionIP = direccionIP;
        this.texto = texto;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccionIP() {
        return direccionIP;
    }

    public void setDireccionIP(String direccionIP) {
        this.direccionIP = direccionIP;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public String toString() {
        return email + " (" + direccionIP + "): " + texto;
    }
}