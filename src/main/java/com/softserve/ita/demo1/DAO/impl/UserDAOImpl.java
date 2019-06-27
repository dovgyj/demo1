package com.softserve.ita.demo1.DAO.impl;

import com.softserve.ita.demo1.DAO.impl.CategoryDAOImpl;
import com.softserve.ita.demo1.DAO.interfaces.UserDAO;
import com.softserve.ita.demo1.db.MySQLConnection;
import com.softserve.ita.demo1.entities.User;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {

    private static final Logger LOGGER = Logger.getLogger(CategoryDAOImpl.class);
    private Connection connection = MySQLConnection.getConnection();

    @Override
    public User getById(Integer id) {
        String query = "SELECT name,email,role,password FROM users "
                + "WHERE id = ?";

        try{
            PreparedStatement smtatement = connection.prepareStatement(query);
            smtatement.setInt(1,id);
            ResultSet rezult = smtatement.executeQuery();

            rezult.next();

            User user = new User();
            user.setId(id);
            user.setName(rezult.getNString(1));
            user.setEmail(rezult.getNString(2));
            user.setRole(rezult.getNString(3));
            user.setPassword(rezult.getNString(4));

            return user;


        }catch (SQLException e){
            System.out.println("Cannot execute getById in UserDAO");
            LOGGER.error("Cannot execute getById in UserDAO");
        }

        return null;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void add(User user) {
        String query = "INSERT INTO users(name,email,password,role) VALUES"
                + " (?,?,?,?)";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,user.getName());
            statement.setString(2,user.getEmail());
            statement.setString(3,user.getPassword());
            statement.setString(4,user.getRole().name());
            statement.execute();

        }catch (SQLException e){
            System.out.println("Cannot execute add in UserDAO");
            LOGGER.error("Cannot execute add in UserDAO");
        }
    }

    @Override
    public User getByEmail(String email){
        String query = "SELECT id,name,email,role,password FROM users"
                + " WHERE email = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,email);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.first()){
                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setName(resultSet.getNString(2));
                user.setEmail(resultSet.getNString(3));
                user.setRole(resultSet.getNString(4));
                user.setPassword(resultSet.getNString(5));

                return user;
            }


        }catch (SQLException e){
            System.out.println("Cannot execute getByEmailAndPassword in UserDAO");
            LOGGER.error("Cannot execute getByEmailAndPassword in UserDAO");
        }

        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}