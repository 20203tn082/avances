package mx.com.siso.controler;

import mx.com.siso.model.users.BeanUsers;
import mx.com.siso.model.users.DaoUsers;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

@WebServlet(name = "ServletEmail", value = "/ServletEmail")
public class ServletEmail extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        switch (action) {
            case "enviar":
                int longitud = 10;
                String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
                StringBuilder token = new StringBuilder();
                Random rnd = new Random();

                for (int i = 0; i < longitud; i++)
                {
                    int indice = rnd.nextInt(alfabeto.length());
                    token.append(alfabeto.charAt(indice));
                }
                String parseToken = String.valueOf(token);
                String correo = request.getParameter("email") != null ? request.getParameter("email") : "";
                BeanUsers beanUsers = new BeanUsers(0,"","","","","",correo,0,parseToken,null,null,null);
                Properties props = System.getProperties();
                if(new DaoUsers().checkEmail(beanUsers)) {
                    props.put("mail.smtp.host", "smtp.gmail.com");  //El servidor SMTP de Google
                    props.put("mail.smtp.user", "sisowebutez@gmail.com");
                    props.put("mail.smtp.auth", "true");    //Usar autenticación mediante usuario y clave
                    props.put("mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
                    props.put("mail.smtp.port", "587"); //El puerto SMTP seguro de Google

                    Session session = Session.getDefaultInstance(props);
                    MimeMessage message = new MimeMessage(session);

                    try {
                        message.setFrom(new InternetAddress("sisowebutez@gmail.com"));
                        message.addRecipients(Message.RecipientType.TO, correo);   //Se podrían añadir varios de la misma manera
                        message.setSubject("Recuperacion de Contraseña Token");
                        message.setText("Este token de recuperacion, por favor introducelo en la casilla correspondiente: " + parseToken);
                        Transport transport = session.getTransport("smtp");
                        transport.connect("smtp.gmail.com", "sisowebutez@gmail.com", "sisoutez");
                        transport.sendMessage(message, message.getAllRecipients());
                        transport.close();
                        request.getRequestDispatcher("/views/users/changePassword.jsp").forward(request, response);
                    } catch (MessagingException me) {
                        me.printStackTrace();   //Si se produce un error
                    }
                }else{
                    System.out.println("El correo no es valido");
                    request.getRequestDispatcher("/views/users/requestToken.jsp").forward(request, response);
                }
                break;
            case "retrieval":
                String password = request.getParameter("password") != null ? request.getParameter("password") : "";
                String token1 = request.getParameter("token") != null ? request.getParameter("token") : "";
                BeanUsers beanUsers1 = new BeanUsers(0,"",password,"","","","",0,token1,null,null,null);

                if(new DaoUsers().checkToken(beanUsers1)){
                    System.out.println("Se actualizo la contraseña");
                    request.getRequestDispatcher("/views/users/login.jsp").forward(request, response);

                }else{
                    System.out.println("No se actualizo la contraseña");
                    request.getRequestDispatcher("/views/users/changePassword.jsp").forward(request, response);
                }

                break;
            default:
        }


    }
}
