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
                .addMapping("beschreibung").mapper();
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
            Ausleiher ausleiher = ausleiherJdbcMapper.map(resultSet);
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
            ResultSet resultSet = statement.executeQuery("SELECT * FROM leihobjekt WHERE id = "  + id);
            Leihobjekt leihobjekt = leihobjektJdbcMapper.map(resultSet);
            statement.close();
            return leihobjekt;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void einpflegen(Ausleiher ausleiher){
        try {
            ausleiherIntegerCrud.create(connection, ausleiher);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void einpflegen(Leihobjekt leihobjekt){
        try {
            leihobjektIntegerCrud.create(connection, leihobjekt);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void loeschen(Ausleiher ausleiher){
        try {
            ausleiherIntegerCrud.delete(connection, ausleiher.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void loeschen(Leihobjekt leihobjekt){
        try {
            leihobjektIntegerCrud.delete(connection, leihobjekt.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
