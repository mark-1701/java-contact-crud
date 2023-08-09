package modelDAO;

import config.Access;
import interfaces.CRUDContact;
import java.util.LinkedList;
import model.Contact;
import java.sql.*;
import javax.swing.JOptionPane;

public class ContactDAO implements CRUDContact {

    Access ac = new Access();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public LinkedList<Contact> listContacts() {
        LinkedList<Contact> list = new LinkedList<Contact>();
        String sql = "SELECT * FROM vista_principal";
        try {
            //Inicializa la base de datos
            con = ac.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Contact contact = new Contact();
                contact.setId(rs.getInt(1));
                contact.setName(rs.getString(2));
                contact.setLastName(rs.getString(3));
                contact.setEmail(rs.getString(4));
                contact.setCategory(rs.getString(5));
                list.add(contact);
            }
        } catch (Exception e) {
            System.out.println("ERROR LISTA CONTACTOS: " + e);
        }
        return list;
    }

    @Override
    public void add(Contact contact) {
        try {
            String query = "SELECT * FROM contactos WHERE correo = ?;";
            con = ac.getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, contact.getEmail());
            rs = ps.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Email no disponible");
            } else {
                String query2 = "INSERT INTO contactos VALUES (0,?,?,?,?);";
                con = ac.getConnection();
                ps = con.prepareStatement(query2);
                ps.setString(1, contact.getName());
                ps.setString(2, contact.getLastName());
                ps.setString(3, contact.getEmail());
                ps.setInt(4, Integer.valueOf(contact.getCategory()));
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Nuevo usuario registrado");
            }
        } catch (Exception e) {
            System.out.println("ERROR AGREGAR CLIENTE: " + e);
        }
    }

    @Override
    public void edit(Contact contact) {
        String query = "UPDATE contactos SET nombre=?, apellido=?, correo=?, categoria=? WHERE id=?;";
        try {
            con = ac.getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, contact.getName());
            ps.setString(2, contact.getLastName());
            ps.setString(3, contact.getEmail());
            ps.setInt(4, Integer.valueOf(contact.getCategory()));
            ps.setInt(5, contact.getId());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuario actualizado correctamente");
        } catch (Exception e) {
            System.out.println("ERROR AL MODIFICAR CLIENTE: " + e);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE from contactos WHERE id=?";
        try {
            con = ac.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuario eliminado exitosamente");
        } catch (Exception e) {
        }

    }

}
