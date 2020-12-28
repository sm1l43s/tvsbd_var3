package program.DAO;

import program.entities.User;

import java.util.List;

public interface UserDAO {

    List<User> list();
    User getById(int id);
    User getByName(String name);
    void add(User user);
    void edit(User user);
    void delete(User user);

}
