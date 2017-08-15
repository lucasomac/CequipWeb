
import model.Usuario;
import model.UsuarioDao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author lomacedo
 */
public class UserDao {

    public static void main(String[] args) {
        Usuario usu = new Usuario();
        UsuarioDao dao = new UsuarioDao();
        usu = dao.getUsuario("lucas", "1234");
        System.out.println(usu);
    }
}
