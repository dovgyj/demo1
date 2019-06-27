package com.softserve.ita.demo1.DAO.impl;

import com.softserve.ita.demo1.DAO.interfaces.AuntificationDAO;
import com.softserve.ita.demo1.db.MySQLConnection;
import com.softserve.ita.demo1.entities.Auntification;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuntificationDAOImpl implements AuntificationDAO {

    private static final Logger LOGGER = Logger.getLogger(CategoryDAOImpl.class);
    private Connection connection = MySQLConnection.getConnection();

    @Override
    public void delete(String selector) {
        String query = "DELETE FROM auntification WHERE selector = ?";

        try(PreparedStatement statement = connection.prepareStatement(query)){
            statement.setString(1,selector);
            statement.execute();

        } catch (SQLException e){
            LOGGER.error("Cannot execute delete in Auntification Dao");
            System.out.println("Cannot execute delete in Auntification Dao");
        }
    }

    @Override
    public void add(Auntification auntification) {
        String query = "INSERT INTO auntification(user_id,selector,validator)"
                + " VALUES (?,?,?)";

        try(PreparedStatement statement = connection.prepareStatement(query)){
            statement.setInt(1,auntification.getUserId());
            statement.setString(2,auntification.getSelector());
            statement.setString(3,auntification.getValidator());
            statement.execute();

        } catch (SQLException e){
            LOGGER.error("Cannot execute add in Auntification Dao");
            System.out.println("Cannot execute add in Auntification Dao");
        }
    }

    @Override
    public Auntification getBySelector(String selector) {
        String query = "SELECT id,user_id,selector,validator FROM auntification"
                + " WHERE selector = ?";

        try(PreparedStatement statement = connection.prepareStatement(query)){
            statement.setString(1, selector);
            ResultSet resultSet = statement.executeQuery();
            Auntification auntification = new Auntification();

            if(resultSet.first() != false){
                auntification.setId(resultSet.getInt(1));
                auntification.setUserId(resultSet.getInt(2));
                auntification.setSelector(resultSet.getNString(3));
                auntification.setValidator(resultSet.getNString(4));
                return auntification;
            }

        } catch (SQLException e){
            LOGGER.error("Cannot execute getBySelector in Auntification Dao");
            System.out.println("Cannot execute getBySelector in Auntification Dao");
        }

        return null;
    }
}
