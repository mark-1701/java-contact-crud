package interfaces;

import java.util.LinkedList;
import model.Contact;

public interface CRUDContact {
    public LinkedList<Contact> listContacts();
    public void add(Contact contact);
    public void edit(Contact contact);
    public void delete(int id);
}
