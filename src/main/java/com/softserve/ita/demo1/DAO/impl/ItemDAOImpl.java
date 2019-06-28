package com.softserve.ita.demo1.DAO.impl;

import com.softserve.ita.demo1.DAO.exception.DAOException;
import com.softserve.ita.demo1.DAO.interfaces.ItemDAO;
import com.softserve.ita.demo1.db.MySQLConnection;
import com.softserve.ita.demo1.entities.Item;
import com.softserve.ita.demo1.entities.Item;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ItemDAOImpl implements ItemDAO {

    private static final Logger LOGGER = Logger.getLogger(ItemDAOImpl.class);
    private Connection connection = MySQLConnection.getConnection();

    @Override
    public Item getById(Integer id) throws DAOException {
        String query = "SELECT title,description,alias,price,created_at,categories_id,img FROM goods "
                + "WHERE id = ?";

        PreparedStatement smtatement = null;

        try {
            smtatement = connection.prepareStatement(query);
            smtatement.setInt(1, id);
            ResultSet rezult = smtatement.executeQuery();

            if (rezult.first()) {
                Item item = new Item();
                item.setTitle(rezult.getNString(1));
                item.setDescription(rezult.getNString(2));
                item.setAlias(rezult.getNString(3));
                item.setPrice(rezult.getInt(4));
                item.setCreatedAt(rezult.getString(5));
                item.setCategoriesId(rezult.getInt(6));
                item.setImg(rezult.getNString(7));
                item.setId(id);

                return item;
            }


        } catch (SQLException e) {
            System.out.println("Cannot execute getById in ItemDAO");
            LOGGER.error("Cannot execute getById in ItemDAO");
            throw new DAOException("Cannot execute getById in ItemDAO");
        } finally {
            try {
                smtatement.close();
            } catch (SQLException e) {
                LOGGER.error("Cannot close statement ItemDAO");
                throw new DAOException("Cannot execute getById in ItemDAO");
            }
        }

        return null;
    }

    @Override
    public void update(Item item) throws DAOException{
        String query = "UPDATE goods SET goods.alias = ?,goods.title = ?,goods.price = ?,goods.description = ?,goods.img = ?,goods.categories_id = ?"
                + " WHERE goods.id = ?";

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, item.getAlias());
            statement.setString(2, item.getTitle());
            statement.setInt(3, item.getPrice());
            statement.setString(4, item.getDescription());
            statement.setString(5, item.getImg());
            statement.setInt(6, item.getCategoriesId());
            statement.setInt(7, item.getId());
            statement.execute();

        } catch (SQLException e) {
            System.out.println("Cannot execute update in ItemDAO");
            LOGGER.error("Cannot execute update in ItemDAO");
            throw new DAOException("Cannot execute add in ItemDAO");
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                LOGGER.error("Cannot close statement ItemDAO");
                throw new DAOException("Cannot execute add in ItemDAO");
            }
        }
    }

    @Override
    public void add(Item item) throws DAOException{
        String query = "INSERT INTO goods(title, description, alias, price, created_at, categories_id, img) VALUES"
                + " (?,?,?,?,CURRENT_TIMESTAMP,?,?)";

        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, item.getTitle());
            statement.setString(2, item.getDescription());
            statement.setString(3, item.getAlias());
            statement.setInt(4, item.getPrice());
            statement.setInt(5, item.getCategoriesId());
            statement.setString(6, item.getImg());
            statement.execute();

        } catch (SQLException e) {
            System.out.println("Cannot execute add in ItemDAO");
            LOGGER.error("Cannot execute add in ItemDAO");
            throw new DAOException("Cannot execute add in ItemDAO");
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                LOGGER.error("Cannot close statement ItemDAO");
                throw new DAOException("Cannot execute add in ItemDAO");
            }
        }
    }

    @Override
    public void delete(Integer id) throws DAOException{
        String query = "DELETE FROM goods WHERE id = ?";

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
                LOGGER.error("Cannot close statement ItemDAO");
                throw new DAOException("Cannot execute add in ItemDAO");
            }
        }
    }

    @Override
    public List<Item> getAll() throws DAOException{
        String query = "SELECT title,description,alias,price,created_at,categories_id,img,id FROM goods";

        PreparedStatement smtatement = null;

        try {
            smtatement = connection.prepareStatement(query);
            ResultSet rezult = smtatement.executeQuery();
            List<Item> itemList = new ArrayList<>();

            while (rezult.next()) {
                Item item = new Item();
                item.setTitle(rezult.getNString(1));
                item.setDescription(rezult.getNString(2));
                item.setAlias(rezult.getNString(3));
                item.setPrice(rezult.getInt(4));
                item.setCreatedAt(rezult.getString(5));
                item.setCategoriesId(rezult.getInt(6));
                item.setImg(rezult.getNString(7));
                item.setId(rezult.getInt(8));
                itemList.add(item);
            }

            return itemList;


        } catch (SQLException e) {
            System.out.println("Cannot execute getAll in ItemDAO");
            LOGGER.error("Cannot execute getAll in ItemDAO");
            throw new DAOException("Cannot execute getAll in ItemDAO");
        } finally {
            try {
                smtatement.close();
                return Collections.emptyList();
            } catch (SQLException e) {
                LOGGER.error("Cannot close statement ItemDAO");
                throw new DAOException("Cannot execute add in ItemDAO");
            }
        }


    }
}
