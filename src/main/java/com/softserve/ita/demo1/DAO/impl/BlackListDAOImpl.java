package com.softserve.ita.demo1.DAO.impl;

import com.softserve.ita.demo1.DAO.exception.DAOException;
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
    public void add(BlackList blackList) throws DAOException {
        String query = "INSERT INTO blacklist(user_id) VALUES (?)";

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,blackList.getUserId());
            preparedStatement.execute();

        } catch (SQLException e) {
            LOGGER.error("Cannot execute add BlackListDAO");
            throw new DAOException("Cannot execute add BlackListDAO");
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                LOGGER.error("Cannot close statement BlackListDAO");
                throw new DAOException("Cannot execute add BlackListDAO");
            }
        }
    }

    @Override
    public void remove(Integer userId) throws DAOException {
        String query = "DELETE FROM blacklist WHERE user_id = ?";

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, userId);
            preparedStatement.execute();

        } catch (SQLException e) {
            LOGGER.error("Cannot execute add BlackListDAO");
            throw new DAOException("Cannot execute add BlackListDAO");
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                LOGGER.error("Cannot close statement BlackListDAO");
                throw new DAOException("Cannot execute add BlackListDAO");
            }
        }
    }
}
