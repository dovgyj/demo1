package com.softserve.ita.demo1.DAO.impl;

import com.softserve.ita.demo1.DAO.exception.DAOException;
import com.softserve.ita.demo1.DAO.interfaces.ItemDAO;
import com.softserve.ita.demo1.db.MySQLConnection;
import com.softserve.ita.demo1.entities.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class ItemDAOImpl implements ItemDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(ItemDAOImpl.class);
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

                Blob blob = rezult.getBlob(7);
                if (blob != null) {
                    InputStream inputStream1 = blob.getBinaryStream();
                    ByteArrayOutputStream outputStream1 = new ByteArrayOutputStream();
                    byte[] buffer1 = new byte[4096];
                    int bytesRead1 = -1;
                    while ((bytesRead1 = inputStream1.read(buffer1)) != -1) {
                        outputStream1.write(buffer1, 0, bytesRead1);
                    }

                    byte[] imageBytes1 = outputStream1.toByteArray();
                    String base64Image = Base64.getEncoder().encodeToString(imageBytes1);
                    item.setImg(base64Image);
                    inputStream1.close();
                    outputStream1.close();
                }

                item.setId(id);

                return item;
            }


        } catch (SQLException | IOException e) {
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

    protected void updatePhoto(Integer id, InputStream inputStream) throws DAOException {
        String query = "UPDATE goods SET img = ? WHERE goods.id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(2, id);
            statement.setBlob(1, inputStream);

            if (statement.executeUpdate() == 0) {
                LOGGER.error("Cannot execute updatePhoto in ItemDAO 0 rows affected");
                throw new DAOException("Cannot updatePhoto add in ItemDAO 0 rows affected");
            }

        } catch (SQLException e) {
            LOGGER.error("Cannot execute updatePhoto in ItemDAO");
            throw new DAOException("Cannot updatePhoto add in ItemDAO");
        }
    }

    @Override
    public void update(Item item) throws DAOException {
        String query = "UPDATE goods SET goods.alias = ?,goods.title = ?,goods.price = ?,goods.description = ?,goods.categories_id = ?"
                + " WHERE goods.id = ?";

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, item.getAlias());
            statement.setString(2, item.getTitle());
            statement.setInt(3, item.getPrice());
            statement.setString(4, item.getDescription());
            statement.setInt(5, item.getCategoriesId());
            if (item.getImgInputStream() != null) {
                updatePhoto(item.getId(), item.getImgInputStream());
            }
            statement.setInt(6, item.getId());


            if (statement.executeUpdate() == 0) {
                LOGGER.error("Cannot execute update in ItemDAO 0 rows afected");
                throw new DAOException("Cannot execute add in ItemDAO 0 rows afected");
            }

        } catch (SQLException e) {
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
    public void add(Item item) throws DAOException {
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

            if (item.getImgInputStream() != null) {
                statement.setBlob(6, item.getImgInputStream());
            } else {
                statement.setNull(6, java.sql.Types.BLOB);
            }
            if (statement.executeUpdate() == 0) {
                LOGGER.error("Cannot execute add in ItemDAO 0 rows affected");
                throw new DAOException("Cannot add add in ItemDAO 0 rows affected");
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
    public void delete(Integer id) throws DAOException {
        String query = "DELETE FROM goods WHERE id = ?";

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.execute();

        } catch (SQLException e) {
            LOGGER.error("Cannot execute delete in ItemDAO");
            throw new DAOException("Cannot execute delete in ItemDAO");
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
    public List<Item> getAll() throws DAOException {
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


                Blob blob = rezult.getBlob(7);
                if (blob != null) {
                    InputStream inputStream1 = blob.getBinaryStream();
                    ByteArrayOutputStream outputStream1 = new ByteArrayOutputStream();
                    byte[] buffer1 = new byte[4096];
                    int bytesRead1 = -1;
                    while ((bytesRead1 = inputStream1.read(buffer1)) != -1) {
                        outputStream1.write(buffer1, 0, bytesRead1);
                    }

                    byte[] imageBytes1 = outputStream1.toByteArray();
                    String base64Image = Base64.getEncoder().encodeToString(imageBytes1);
                    item.setImg(base64Image);
                    inputStream1.close();
                    outputStream1.close();
                }
                item.setId(rezult.getInt(8));
                itemList.add(item);
            }

            return itemList;


        } catch (SQLException | IOException e) {
            LOGGER.error("Cannot execute getAll in ItemDAO");
            throw new DAOException("Cannot execute getAll in ItemDAO");
        } finally {
            try {
                smtatement.close();
            } catch (SQLException e) {
                LOGGER.error("Cannot close statement ItemDAO");
                throw new DAOException("Cannot execute add in ItemDAO");
            }
        }


    }

    @Override
    public List<Item> getByCategoryId(Integer id) throws DAOException {
        String query = "SELECT title,description,alias,price,created_at,categories_id,img,id FROM goods "
                + "WHERE categories_id = ?";

        try (PreparedStatement smtatement = connection.prepareStatement(query)) {
            smtatement.setInt(1, id);
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
                item.setImg(rezult.getString(7));
                Blob blob = rezult.getBlob(7);
                if (blob != null) {
                    InputStream inputStream1 = blob.getBinaryStream();
                    ByteArrayOutputStream outputStream1 = new ByteArrayOutputStream();
                    byte[] buffer1 = new byte[4096];
                    int bytesRead1 = -1;
                    while ((bytesRead1 = inputStream1.read(buffer1)) != -1) {
                        outputStream1.write(buffer1, 0, bytesRead1);
                    }

                    byte[] imageBytes1 = outputStream1.toByteArray();
                    String base64Image = Base64.getEncoder().encodeToString(imageBytes1);
                    item.setImg(base64Image);
                    inputStream1.close();
                    outputStream1.close();
                }
                item.setId(rezult.getInt(8));
                itemList.add(item);
            }

            return itemList;


        } catch (SQLException | IOException e) {
            LOGGER.error("Cannot execute getByCategoryId in ItemDAO");
            throw new DAOException("Cannot execute getByCategoryId in ItemDAO");
        }
    }
}
