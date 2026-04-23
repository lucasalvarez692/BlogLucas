package logica;

import java.time.LocalDateTime;
import java.util.*;

public class Blog {
    private static int consecutivo = 1;
    private int codigo;
    private String nombre;
    private String descripcion;
    private LocalDateTime fechaCreacion;

    private List<Publicacion> publicacion;
    private Map<Integer, String> tituloPublicacion;

    public Blog(String nombre, String descripcion) {
        this.codigo = consecutivo++;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaCreacion = LocalDateTime.now();
        this.publicacion = new ArrayList<>();
        this.tituloPublicacion = new HashMap<>();
    }

    public void agregarPublicacion(String titulo, String texto, String nombreCreador) {
        Publicacion p = new Publicacion(titulo, texto, nombreCreador);
        publicacion.add(p);
        tituloPublicacion.put(p.getCodigo(), titulo);
    }

    public boolean eliminarPublicacion(int codigoPublicacion) {
        return publicacion.removeIf(p -> p.getCodigo() == codigoPublicacion);
    }

    public Publicacion buscarPublicacion(int codigoPublicacion) {
        for (Publicacion p : publicacion) {
            if (p.getCodigo() == codigoPublicacion)
                return p;
        }
        return null;
    }

    public List<Publicacion> getPublicacion() {
        return publicacion;
    }

    public Map<Integer, String> obtenerTituloPublicacion() {
        return tituloPublicacion;
    }

    public boolean agregarComentario(int codigoPublicacion, String email, String ip, String texto) {
        Publicacion p = buscarPublicacion(codigoPublicacion);
        if (p == null) return false;

        p.agregarComentario(new Comentario(email, ip, texto));
        return true;
    }

    public boolean eliminarComentario(int codigoPublicacion, int posicion) {
        Publicacion p = buscarPublicacion(codigoPublicacion);
        if (p == null) return false;

        return p.eliminarComentario(posicion);
    }

    @Override
    public String toString() {
        return "Blog: " + nombre + " - " + descripcion;
    }

    public int getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
}