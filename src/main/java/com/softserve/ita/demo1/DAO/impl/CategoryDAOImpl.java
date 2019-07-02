package com.softserve.ita.demo1.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.softserve.ita.demo1.DAO.exception.DAOException;
import com.softserve.ita.demo1.DAO.interfaces.CategoryDAO;
import com.softserve.ita.demo1.db.MySQLConnection;
import com.softserve.ita.demo1.entities.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CategoryDAOImpl implements CategoryDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryDAOImpl.class);

    private Connection connection = MySQLConnection.getConnection();

    @Override
    public Category getById(Integer id) throws DAOException {
        String query = "SELECT `name`,`alias`,`id` FROM `categories` "
                + "WHERE `categories`.`id` = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet categoryData = statement.executeQuery();

            if (categoryData.first()) {
                Category category = new Category();

                category.setId(categoryData.getInt(3));
                category.setName(categoryData.getNString(1));
                category.setAlias(categoryData.getNString(2));

                return category;
            }


        } catch (SQLException e) {
            LOGGER.error("Cannot execute getById category dao.");
            throw new DAOException("Cannot execute getById category dao.");
        }

        return null;
    }

    @Override
    public Category getByAlias(String alias) throws DAOException {
        String query = "SELECT categories.name,categories.alias,categories.id FROM categories "
                + "WHERE alias = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, alias);
            ResultSet categoryData = statement.executeQuery();

            if (categoryData.first()) {

                Category category = new Category();

                category.setId(categoryData.getInt(3));
                category.setName(categoryData.getNString(1));
                category.setAlias(categoryData.getNString(2));

                return category;
            }

        } catch (SQLException e) {
            LOGGER.error("Cannot execute `getByAliasAll category dao.");
            throw new DAOException("Cannot execute `getByAliasAll category dao.");
        }

        return null;
    }

    @Override
    public List<Category> getAll() throws DAOException {
        String query = "SELECT categories.id, categories.name, categories.alias "
                + "FROM categories";


        PreparedStatement statement = null;

        try {

            statement = connection.prepareStatement(query);
            ResultSet categoryData = statement.executeQuery();
            List<Category> categories = new ArrayList<>();
            while (categoryData.next()) {

                Category category = new Category();
                category.setId(categoryData.getInt("categories.id"));
                category.setName(categoryData.getNString("categories.name"));
                category.setAlias(categoryData.getNString("categories.alias"));

                categories.add(category);
            }
            return categories;

        } catch (SQLException e) {
            LOGGER.error("Cannot execute 'getAll' category dao.", e);
            throw new DAOException("Cannot execute 'getAll' category dao.");

        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    throw new DAOException("Cannot execute 'getAll' category dao.");
                }
            }
        }
    }

    @Override
    public void add(Category category) throws DAOException {
        String query = "INSERT INTO categories(name,alias) VALUES"
                + " (?,?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, category.getName());
            statement.setString(2, category.getAlias());
            statement.execute();

        } catch (SQLException e) {
            LOGGER.error("Cannot execute add in CategoryDAO");
            throw new DAOException("Cannot execute add in CategoryDAO");
        }
    }

    @Override
    public void update(Category category) throws DAOException {
        String query = "UPDATE categories SET categories.name = ?, categories.alias = ? "
                + " WHERE categories.id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(3, category.getId());
            statement.setString(1, category.getName());
            statement.setString(2, category.getAlias());
            statement.execute();

        } catch (SQLException e) {
            LOGGER.error("Cannot execute update in CategoryDAO");
            throw new DAOException("Cannot execute update in CategoryDAO");
        }
    }

    @Override
    public void delete(Integer id) throws DAOException {
        String query = "DELETE FROM categories WHERE categories.id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.execute();

        } catch (SQLException e) {
            LOGGER.error("Cannot execute delete in UserDAO");
            throw new DAOException("Cannot execute delete in UserDAO");
        }
    }

}
