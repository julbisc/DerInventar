package oszimt;

import org.simpleflatmapper.jdbc.Crud;
import org.simpleflatmapper.jdbc.JdbcMapper;
import org.simpleflatmapper.jdbc.JdbcMapperFactory;

import java.sql.*;
import java.util.ArrayList;


public class DBManager {
    private Connection connection;
    private JdbcMapper<Leihobjekt> leihobjektJdbcMapper;
    private JdbcMapper<Ausleiher> ausleiherJdbcMapper;
    private Crud<Leihobjekt, Integer> leihobjektIntegerCrud;
    private Crud<Ausleiher, Integer> ausleiherIntegerCrud;

    public DBManager() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://localhost/DerInventar?user=root");

            leihobjektJdbcMapper = JdbcMapperFactory.newInstance().newBuilder(Leihobjekt.class)
                    .addMapping("id")
                    .addMapping("name")
                    .addMapping("beschreibung")
                    .addMapping("aid").mapper();
            ausleiherJdbcMapper = JdbcMapperFactory.newInstance().newBuilder(Ausleiher.class)
                    .addMapping("id")
                    .addMapping("nachname")
                    .addMapping("vorname").mapper();

            leihobjektIntegerCrud = JdbcMapperFactory.newInstance().crud(Leihobjekt.class, Integer.class).table(connection, "leihobjekte");
            ausleiherIntegerCrud = JdbcMapperFactory.newInstance().crud(Ausleiher.class, Integer.class).table(connection, "ausleiher");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

/*    public ResultSet query(String query) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }*/

    public ArrayList<Ausleiher> getAusleiher(){
        ArrayList<Ausleiher> ausleihers = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM ausleiher");
            ausleiherJdbcMapper.stream(resultSet).forEach(ausleihers::add);
            statement.close();
            return ausleihers;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Leihobjekt> getLeihobjekte(){
        ArrayList<Leihobjekt> leihobjekts = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM leihobjekte");
            resultSet.next();
            leihobjektJdbcMapper.stream(resultSet).forEach(leihobjekts::add);
            statement.close();
            return leihobjekts;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Ausleiher getAusleiherByID(int id) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM ausleiher WHERE id = "  + id);
            resultSet.next();
            Ausleiher ausleiher = ausleiherJdbcMapper.stream(resultSet).findAny().get();
            statement.close();
            return ausleiher;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Leihobjekt getLeihobjektByID(int id) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM leihobjekte WHERE id = "  + id);
            System.out.println(resultSet.getMetaData().getColumnCount());
            Leihobjekt leihobjekt = leihobjektJdbcMapper.stream(resultSet).findAny().get();
            statement.close();
            return leihobjekt;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean einpflegen(Ausleiher ausleiher){
        try {
            ausleiherIntegerCrud.create(connection, ausleiher);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean einpflegen(Leihobjekt leihobjekt){
        try {
            leihobjektIntegerCrud.create(connection, leihobjekt);
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    public boolean loeschen(Ausleiher ausleiher){
        try {
            ausleiherIntegerCrud.delete(connection, ausleiher.getId());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean loeschen(Leihobjekt leihobjekt){
        try {
            leihobjektIntegerCrud.delete(connection, leihobjekt.getId());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean update(Ausleiher ausleiher) {
        try {
            ausleiherIntegerCrud.update(connection, ausleiher);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean update(Leihobjekt leihobjekt) {
        try {
            leihobjektIntegerCrud.update(connection, leihobjekt);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public int getMaxID(String table){
        String query = "SELECT MAX(id) FROM " + table + ";";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();
            int maxID = resultSet.getInt(1) + 1;
            statement.close();
            return maxID;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
