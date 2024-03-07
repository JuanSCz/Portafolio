package com.portafolio.portafolioWEB.entitis;

public class Correo {

    private String nombre;
    private String emailReclutador;
    private String asunto;
    private String comentario;
    private String destinatario;

    public Correo() {
        this.destinatario = "juan_mitre580@hotmail.com";
    }

    public Correo(String nombre, String emailReclutador, String asunto, String comentario) {
        this.nombre = nombre;
        this.emailReclutador = emailReclutador;
        this.asunto = asunto;
        this.comentario = comentario;
        this.destinatario = "Juan_mitre580@hotmail.com";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmailReclutador() {
        return emailReclutador;
    }

    public void setEmailReclutador(String emailReclutador) {
        this.emailReclutador = emailReclutador;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }
}
