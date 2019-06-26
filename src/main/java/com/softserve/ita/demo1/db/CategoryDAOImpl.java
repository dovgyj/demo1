package com.softserve.ita.demo1.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.softserve.ita.demo1.entities.Category;
import org.apache.log4j.Logger;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class CategoryDAOImpl implements CategoryDAO {

    private static final Logger LOGGER = Logger.getLogger(CategoryDAOImpl.class);
    private Connection connection = MySQLConnection.getConnection();

    @Override
    public Category getById(Integer id){
        String query = "SELECT `name`,`alias`,`id` FROM `categories` "
                + "WHERE `categories`.`id` = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,id);
            ResultSet categoryData = statement.executeQuery();

            if(categoryData.first()){
                Category category = new Category();

                category.setId(categoryData.getInt(3));
                category.setName(categoryData.getNString(1));
                category.setAlias(categoryData.getNString(2));

                return category;
            }


        }catch (SQLException e){
            System.out.println("Cannot execute getById category dao.");
            LOGGER.error("Cannot execute getById category dao.");

        }

        return null;
    }

    @Override
    public Category getByAlias(String alias){
        String query = "SELECT categories.name,categories.alias,categories.id FROM categories "
                + "WHERE alias = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,alias);
            ResultSet categoryData = statement.executeQuery();

            if(categoryData.first()) {

                Category category = new Category();

                category.setId(categoryData.getInt(3));
                category.setName(categoryData.getNString(1));
                category.setAlias(categoryData.getNString(2));

                return category;
            }

        }catch (SQLException e){
            System.out.println("Cannot execute `getByAliasAll category dao.");
            LOGGER.error("Cannot execute `getByAliasAll category dao.");

        }

        return null;
    }

    @Override
    public List<Category> getAll() {

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
            e.printStackTrace();
            System.err.println("Cannot execute 'getAll' category dao.");
            LOGGER.error("Cannot execute 'getAll' category dao.", e);

        }finally {
            if(statement != null){
                try {
                    statement.close();
                }catch (SQLException e){

                }
            }

        }
        return null;
    }

    @Override
    public void add(Category category) {
        String query = "INSERT INTO categories(name,alias) VALUES"
                + " (?,?)";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,category.getName());
            statement.setString(2,category.getAlias());
            statement.execute();

        }catch (SQLException e){
            System.out.println("Cannot execute add in CategoryDAO");
            LOGGER.error("Cannot execute add in CategoryDAO");
        }
    }

    @Override
    public void update(Category category) {
        String query = "DELETE FROM categories WHERE categories.id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,id);
            statement.execute();

        }catch (SQLException e){
            System.out.println("Cannot execute delete in UserDAO");
            LOGGER.error("Cannot execute delete in UserDAO");
        }
    }

    @Override
    public void delete(Integer id) {
        String query = "DELETE FROM categories WHERE categories.id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,id);
            statement.execute();

        }catch (SQLException e){
            System.out.println("Cannot execute delete in UserDAO");
            LOGGER.error("Cannot execute delete in UserDAO");
        }
    }

}
