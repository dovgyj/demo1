package com.softserve.ita.demo1.DAO.impl;

import com.softserve.ita.demo1.DAO.exception.DAOException;
import com.softserve.ita.demo1.DAO.impl.CategoryDAOImpl;
import com.softserve.ita.demo1.DAO.interfaces.UserDAO;
import com.softserve.ita.demo1.db.MySQLConnection;
import com.softserve.ita.demo1.entities.User;
import org.apache.log4j.Logger;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    private static final Logger LOGGER = Logger.getLogger(CategoryDAOImpl.class);
    private Connection connection = MySQLConnection.getConnection();

    @Override
    public User getById(Integer id) throws DAOException {
        String query = "SELECT name,email,role,password FROM users "
                + "WHERE id = ?";

        try (PreparedStatement smtatement = connection.prepareStatement(query)) {
            smtatement.setInt(1, id);
            ResultSet rezult = smtatement.executeQuery();

            if (rezult.first()) {
                User user = new User();
                user.setId(id);
                user.setName(rezult.getNString(1));
                user.setEmail(rezult.getNString(2));
                user.setRole(rezult.getNString(3));
                user.setPassword(rezult.getNString(4));

                return user;
            }

            return null;

        } catch (SQLException e) {
            System.out.println("Cannot execute getById in UserDAO");
            LOGGER.error("Cannot execute getById in UserDAO");
            throw new DAOException("Cannot execute getById in UserDAO");
        }

    }

    @Override
    public void update(User user) throws DAOException {
        throw new NotImplementedException();
    }

    @Override
    public List<User> getAllUsers() throws DAOException {
        String query = "SELECT name,email,role,password,users.id,NOT(ISNULL(blacklist.id)) as blocked FROM users "
                + "LEFT JOIN blacklist ON users.id = blacklist.user_id"
                + " WHERE role = 'USER'";

        try (PreparedStatement smtatement = connection.prepareStatement(query)) {
            ResultSet rezult = smtatement.executeQuery();
            List<User> userList = new ArrayList<>();

            while (rezult.next()) {
                User user = new User();
                user.setName(rezult.getNString(1));
                user.setEmail(rezult.getNString(2));
                user.setRole(rezult.getNString(3));
                user.setPassword(rezult.getNString(4));
                user.setId(rezult.getInt(5));
                user.setBlocked(rezult.getBoolean(6));
                userList.add(user);
            }

            return userList;

        } catch (SQLException e) {
            System.out.println("Cannot execute getAllUsers in UserDAO");
            LOGGER.error("Cannot execute getAllUsers in UserDAO");
            throw new DAOException("Cannot execute getAllUsers in UserDAO");
        }
    }

    @Override
    public void add(User user) throws DAOException {
        String query = "INSERT INTO users(name,email,password,role) VALUES"
                + " (?,?,?,?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getRole().name());
            statement.execute();

        } catch (SQLException e) {
            System.out.println("Cannot execute add in UserDAO");
            LOGGER.error("Cannot execute add in UserDAO");
            throw new DAOException("Cannot execute add in UserDAO");
        }
    }

    @Override
    public User getByEmail(String email) throws DAOException {
        String query = "SELECT id,name,email,role,password FROM users"
                + " WHERE email = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.first()) {
                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setName(resultSet.getNString(2));
                user.setEmail(resultSet.getNString(3));
                user.setRole(resultSet.getNString(4));
                user.setPassword(resultSet.getNString(5));

                return user;
            }

            return null;


        } catch (SQLException e) {
            System.out.println("Cannot execute getByEmailAndPassword in UserDAO");
            LOGGER.error("Cannot execute getByEmailAndPassword in UserDAO");
            throw new DAOException("Cannot execute getByEmailAndPassword in UserDAO");
        }

    }

    @Override
    public void delete(Integer id) throws DAOException {
        String query = "DELETE FROM users WHERE id = ?";

        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.execute();

        } catch (SQLException e) {
            System.out.println("Cannot execute delete in ItemDAO");
            LOGGER.error("Cannot execute delete in ItemDAO");
            throw new DAOException("Cannot execute delete in ItemDAO");
        }  finally {
            try {
                statement.close();
            } catch (SQLException e) {
                LOGGER.error("Cannot close statement UserDAO");
                throw new DAOException("Cannot execute delete in UserDAO");
            }
        }
    }
}
