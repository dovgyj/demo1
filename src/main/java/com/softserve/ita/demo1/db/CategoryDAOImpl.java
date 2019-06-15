package com.softserve.ita.demo1.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.softserve.ita.demo1.entities.Category;
import org.apache.log4j.Logger;

public class CategoryDAOImpl implements CategoryDAO {

    private static final Logger LOGGER = Logger.getLogger(CategoryDAOImpl.class);
    private Connection connection = MySQLConnection.getConnection();

    @Override
    public Category getById(Integer id){
        String query = "SELECT `name`,`alias`,`id` FROM `categories` "
                + "FROM `categories`";

        return new Category();
    }

    @Override
    public Category getByAlias(String alias){
        String query = "SELECT name,alias,id FROM categories"
                + "WHERE alias = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,alias);
            ResultSet categoryData = statement.executeQuery();

            categoryData.next();

            Category category = new Category();

            category.setId(categoryData.getInt(3));
            category.setName(categoryData.getNString(1));
            String categoryAlias = category.getName().replaceAll("\\s","-");
            category.setAlias(categoryAlias);

            return category;

        }catch (SQLException e){
            System.out.println("Cannot execute `getByAliasAll category dao.");
            LOGGER.error("Cannot execute `getByAliasAll category dao.");
            return null;
        }
    }

    @Override
    public List<Category> getAll() {
        String query = "SELECT categories.id, categories.name, categories.alias "
                + "FROM categories";

        try {

            PreparedStatement statement = connection.prepareStatement(query);
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
            e.printStackTrace();
            System.err.println("Cannot execute 'getAll' category dao.");
            LOGGER.error("Cannot execute 'getAll' category dao.", e);
            return null;
        }
    }

    @Override
    public void add(Category category) {

    }

    @Override
    public void update(Category category) {

    }

    @Override
    public void delete(Integer id) {

    }

}
