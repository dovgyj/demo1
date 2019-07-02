package com.softserve.ita.demo1.DAO.impl;

import com.softserve.ita.demo1.DAO.exception.DAOException;
import com.softserve.ita.demo1.DAO.interfaces.OrderDAO;
import com.softserve.ita.demo1.db.MySQLConnection;
import com.softserve.ita.demo1.entities.Item;
import com.softserve.ita.demo1.entities.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderDAOImpl.class);

    private Connection connection = MySQLConnection.getConnection();

    @Override
    public void add(Order order) throws DAOException {
        String orderQuery = "INSERT INTO orders(created_at,payed_at,user_id,total_price) "
                + "VALUES (CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,?,?)";

        ResultSet orderRezult = null;
        try (PreparedStatement orderStatement = connection.prepareStatement(orderQuery, Statement.RETURN_GENERATED_KEYS)) {
            orderStatement.setInt(1, order.getUserId());
            orderStatement.setInt(2, order.getTotalPrice());
            int affectedRows = orderStatement.executeUpdate();
            if (affectedRows == 0) {
               throw new SQLException("creating order failed no rows affected");
            }

            try (ResultSet generatedKeys = orderStatement.getGeneratedKeys()) {
                if(generatedKeys.first()){
                    order.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("creating user failed no Id obtained");
                }
            }
        } catch (SQLException e) {
            LOGGER.error("Cannot execute add in Order dao");
            throw new DAOException("Cannot execute add in Order dao");
        }

        String orderGoods = "INSERT INTO orders_goods(order_id, goods_id) VALUES (?,?)";
        for (Item item : order.getItemList()) {
            try (PreparedStatement statement = connection.prepareStatement(orderGoods)) {
                statement.setInt(1, order.getId());
                statement.setInt(2, item.getId());
                statement.execute();
            } catch (SQLException e) {
                LOGGER.error("Cannot execute add in Order dao");
                throw new DAOException("Cannot execute add in Order dao");
            }
        }

    }

    @Override
    public List<Order> getAll() throws DAOException {
        List<Order> orderList = new ArrayList<Order>();
        String orderQuery = "SELECT id,created_at,payed_at,user_id,total_price FROM orders";

        try (PreparedStatement orderStatement = connection.prepareStatement(orderQuery)) {
            ResultSet ordersSet = orderStatement.executeQuery();

            while (ordersSet.next()) {
                Order order = new Order();
                order.setId(ordersSet.getInt(1));
                order.setCreatedAt(ordersSet.getString(2));
                order.setPayedAt(ordersSet.getString(3));
                order.setUserId(ordersSet.getInt(4));
                order.setTotalPrice(ordersSet.getInt(5));

                String listQuery = "SELECT title,description,alias,price,created_at,categories_id,img,id FROM goods "
                        + "WHERE id IN(" +
                        "SELECT goods_id FROM orders_goods WHERE order_id = ?"
                        + ")";

                PreparedStatement statement = connection.prepareStatement(listQuery);
                statement.setInt(1, order.getId());
                ResultSet itemResultSet = statement.executeQuery();

                List<Item> itemList = new ArrayList<>();

                while (itemResultSet.next()) {
                    Item item = new Item();
                    item.setTitle(itemResultSet.getNString(1));
                    item.setDescription(itemResultSet.getNString(2));
                    item.setAlias(itemResultSet.getNString(3));
                    item.setPrice(itemResultSet.getInt(4));
                    item.setCreatedAt(itemResultSet.getString(5));
                    item.setCategoriesId(itemResultSet.getInt(6));
                    // item.setImg(itemResultSet.getBinaryStream(7));
                    item.setId(itemResultSet.getInt(8));
                    itemList.add(item);
                }
                orderList.add(order);
            }

            return orderList;

        } catch (SQLException e) {
            LOGGER.error("Cannot execute getAll in Order dao");
            e.printStackTrace();
            throw new DAOException("Cannot execute getAll in Order dao");
        }
    }

    @Override
    public Order getById(Integer id) throws DAOException {
        String orderQuery = "SELECT id,created_at,payed_at,user_id,total_price FROM orders "
                + "WHERE id = ?";

        try (PreparedStatement orderStatement = connection.prepareStatement(orderQuery)) {
            orderStatement.setInt(1, id);
            ResultSet ordersSet = orderStatement.executeQuery();

            if (ordersSet.first()) {
                Order order = new Order();
                order.setId(ordersSet.getInt(1));
                order.setCreatedAt(ordersSet.getNString(2));
                order.setPayedAt(ordersSet.getNString(3));
                order.setUserId(ordersSet.getInt(4));
                order.setTotalPrice(ordersSet.getInt(5));

                String listQuery = "title,description,alias,price,created_at,categories_id,img,id FROM goods "
                        + "WHERE id IN(" +
                        "SELECT goods_id FROM orders_goods WHERE order_id = ?"
                        + ")";

                PreparedStatement statement = connection.prepareStatement(listQuery);
                statement.setInt(1, order.getId());
                ResultSet itemResultSet = statement.executeQuery();

                List<Item> itemList = new ArrayList<>();

                while (itemResultSet.next()) {
                    Item item = new Item();
                    item.setTitle(itemResultSet.getNString(1));
                    item.setDescription(itemResultSet.getNString(2));
                    item.setAlias(itemResultSet.getNString(3));
                    item.setPrice(itemResultSet.getInt(4));
                    item.setCreatedAt(itemResultSet.getString(5));
                    item.setCategoriesId(itemResultSet.getInt(6));
                    // item.setImg(itemResultSet.getBinaryStream(7));
                    item.setId(itemResultSet.getInt(8));
                    itemList.add(item);
                }

                return order;
            }

            return null;

        } catch (SQLException e) {
            LOGGER.error("Cannot execute getById in Order dao");
            throw new DAOException("Cannot execute getById in Order dao");
        }
    }

    @Override
    public void delete(Integer id) throws DAOException {
        String query = "DELETE FROM orders WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)){
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            LOGGER.error("Cannot execute delete in OrderDAO");
            throw new DAOException("Cannot execute delete in OrderDAO");
        }
    }
}
