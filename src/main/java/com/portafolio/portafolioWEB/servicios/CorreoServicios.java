package com.portafolio.portafolioWEB.servicios;

import com.portafolio.portafolioWEB.entitis.Correo;
import com.portafolio.portafolioWEB.exceptions.CorreoExceptions;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.stereotype.Service;

@Service
public class CorreoServicios {

    private static String emailFrom = "juan.mitre580@gmail.com";
    private static String passwordFrom = "gtcbhsxfmfqylmtp";

    public void crearCorreo(String nombre, String emailReclutador, String asunto, String comentario) throws CorreoExceptions, MessagingException {
        validarCorreo(nombre, emailReclutador, asunto, comentario);
        Correo correo = new Correo();
        correo.setNombre(nombre);
        correo.setEmailReclutador(emailReclutador);
        correo.setAsunto(asunto);
        correo.setComentario(comentario);
        enviarCorreo(correo);
    }

    public void validarCorreo(String nombre, String emailReclutador, String asunto, String comentario) throws CorreoExceptions {
        if (nombre == null || nombre.isEmpty()) {
            throw new CorreoExceptions("El nombre no puede ser nulo o estar vacio.");
        }

        if (emailReclutador == null || emailReclutador.isEmpty()) {
            throw new CorreoExceptions("El email no puede ser nulo o estar vacio.");
        }

        if (asunto == null || asunto.isEmpty()) {
            throw new CorreoExceptions("El asunto no puede ser nulo o estar vacio.");
        }

        if (comentario == null || comentario.isEmpty()) {
            throw new CorreoExceptions("El comentario no puede ser nulo o estar vacio.");
        }
    }

    private void enviarCorreo(Correo correo) throws CorreoExceptions, MessagingException {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.host.trust", "smtp.gmail.com");
        props.put("mail.smtp.starttls.enable", "true"); // Habilitar STARTTLS
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.user", emailFrom);
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(emailFrom, passwordFrom);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(emailFrom));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(correo.getDestinatario()));
            message.setSubject(correo.getAsunto());
            message.setText("Nombre: " + correo.getNombre() + "\nEmail: " + correo.getEmailReclutador()+ "\nAsunto: " + correo.getAsunto() + "\nComentario: " + correo.getComentario());

            Transport.send(message);

            System.out.println("Correo enviado exitosamente.");

        } catch (MessagingException e) {
            throw new CorreoExceptions("Error al enviar el correo.");
        }
    }

}
