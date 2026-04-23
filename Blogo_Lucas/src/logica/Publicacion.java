package logica;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Publicacion {
    private static int consecutivo = 1;
    private int codigo;
    private String titulo;
    private String texto;
    private String nombreCreador;
    private LocalDateTime fechaPublicacion;
    private List<Comentario> comentarios;

    public Publicacion(String titulo, String texto, String nombreCreador) {
        this.codigo = consecutivo++;
        this.titulo = titulo;
        this.texto = texto;
        this.nombreCreador = nombreCreador;
        this.fechaPublicacion = LocalDateTime.now();
        this.comentarios = new ArrayList<>();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getNombreCreador() {
        return nombreCreador;
    }

    public void setNombreCreador(String nombreCreador) {
        this.nombreCreador = nombreCreador;
    }

    public LocalDateTime getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void agregarComentario(Comentario comentario) {
        comentarios.add(comentario);
    }

    public boolean eliminarComentario(int indice) {
        if (indice >= 0 && indice < comentarios.size()) {
            comentarios.remove(indice);
            return true;
        }
        return false;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    @Override
    public String toString() {
        String res = "Publicacion: " + titulo + "\n" + texto + "\nAutor: " + nombreCreador + "\n";
        for (Comentario c : comentarios) {
            res += " - " + c.toString() + "\n";
        }
        return res;
    }
}