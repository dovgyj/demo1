package com.softserve.ita.demo1.DAO.impl;

import com.softserve.ita.demo1.DAO.interfaces.BlackListDAO;
import com.softserve.ita.demo1.db.MySQLConnection;
import com.softserve.ita.demo1.entities.BlackList;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BlackListDAOImpl implements BlackListDAO {

    private static final Logger LOGGER = Logger.getLogger(BlackListDAOImpl.class);
    private Connection connection = MySQLConnection.getConnection();

    @Override
    public void add(BlackList blackList) {
        String query = "INSERT INTO blacklist(user_id) VALUES (?)";

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(query);

        } catch (SQLException e){
            LOGGER.error("Cannot execute add BlackListDAO");
        } finally {
            try{
                preparedStatement.close();
            } catch (SQLException e){
                LOGGER.error("Cannot close statement BlackListDAO");
            }
        }
    }

    @Override
    public void remove(Integer userId) {

    }
}
