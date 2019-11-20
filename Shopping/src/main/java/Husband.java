import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Husband extends Wife{

    public static void husbandMain() {
        DataBase db = new DataBase();
        ArrayList productsToBuy = wifeMain();
        ResultSet resultSetProducts = null;
        ResultSet resultSetAppliance = null;
        try {
            Connection connect = db.connectDb();
            Statement statement = connect.createStatement();

            ArrayList allProductsCanBuyList = getAllProductsCanBuyPrice(productsToBuy, resultSetProducts, resultSetAppliance, statement);

            getAllProductsCanBuyName(productsToBuy, resultSetProducts, resultSetAppliance, statement);

            printAllProducts(getAllProductsName(statement, resultSetAppliance, resultSetProducts), getAllProductsPrice(statement, resultSetAppliance, resultSetProducts));
            printAllProductsCanBuy(allProductsCanBuyList, getAllProductsCanBuyName(productsToBuy, resultSetProducts, resultSetAppliance, statement));
            printAllProductsCanBuyPrice(countProductPriceListCanBuy(allProductsCanBuyList));
        }catch (SQLException e) {
            System.out.println("Can`t connect to db!");
        }
    }

    public static ArrayList getAllProductsCanBuyPrice(ArrayList productsToBuy, ResultSet resultSetProducts, ResultSet resultSetAppliance, Statement statement){
        ArrayList allProductsCanBuyPrice = new ArrayList();
        ArrayList allProductsCanBuyName = new ArrayList();
        int priceAppProductCanBuy = 0;
        try {
            for (int i=0;i<productsToBuy.size();i++){
                resultSetProducts = statement.executeQuery("select * from products WHERE productName=\'" + productsToBuy.get(i).toString() + "\'");
                allProductsCanBuyPrice.addAll(getProductCanBuyPriceList(resultSetProducts));
                allProductsCanBuyName.addAll(getProductCanBuyNameList(resultSetProducts));

                resultSetAppliance = statement.executeQuery("select * from appliances WHERE appliances.productName=\'" + productsToBuy.get(i).toString() + "\'");
                allProductsCanBuyPrice.addAll(getProductCanBuyPriceList(resultSetAppliance));
                allProductsCanBuyName.addAll(getProductCanBuyNameList(resultSetAppliance));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allProductsCanBuyPrice;
    }

    public static ArrayList getAllProductsCanBuyName(ArrayList productsToBuy, ResultSet resultSetProducts, ResultSet resultSetAppliance, Statement statement){
        ArrayList allProductsCanBuyName = new ArrayList();
        try {
            for (int i=0;i<productsToBuy.size();i++){
                resultSetProducts = statement.executeQuery("select * from products WHERE productName=\'" + productsToBuy.get(i).toString() + "\'");
                allProductsCanBuyName.addAll(getProductCanBuyNameList(resultSetProducts));

                resultSetAppliance = statement.executeQuery("select * from appliances WHERE appliances.productName=\'" + productsToBuy.get(i).toString() + "\'");
                allProductsCanBuyName.addAll(getProductCanBuyNameList(resultSetAppliance));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allProductsCanBuyName;
    }

    public static ArrayList getProductCanBuyNameList(ResultSet resultSet) {
        ArrayList allProductsCanBuyName = new ArrayList();
        try {
            while (resultSet.next()) {
                String q = resultSet.getString("productName");
                allProductsCanBuyName.add(q);
                break;
            }
        }catch (SQLException e) {
            System.out.println("Can`t connect with db!");
        }
        return allProductsCanBuyName;
    }

    public static ArrayList getProductCanBuyPriceList(ResultSet resultSet) {
        ArrayList allProductsCanBuyPrice = new ArrayList();
        try {
            while (resultSet.next()) {
                int q = resultSet.getInt("productPrice");
                allProductsCanBuyPrice.add(q);
                break;
            }
        }catch (SQLException e) {
            System.out.println("Can`t connect with db!");
        }
        return allProductsCanBuyPrice;
    }

    public static int countProductPriceListCanBuy(ArrayList allProductsCanBuyPrice) {
        int count = 0;
        for (int i=0;i<allProductsCanBuyPrice.size();i++) {
            count += (Integer) allProductsCanBuyPrice.get(i);
        }
        return count;
    }

    public static ArrayList getAllProductsName(Statement statement, ResultSet resultSetAppliances, ResultSet resultSetProducts){
        ArrayList allProductsName = new ArrayList();
        try {
            resultSetProducts = statement.executeQuery("select * from products");
            allProductsName.addAll(getProductName(resultSetProducts));

            resultSetAppliances = statement.executeQuery("select * from appliances");
            allProductsName.addAll(getProductName(resultSetAppliances));

        }catch (SQLException e){
            System.out.println("Can`t connect to database!");
        }
        return allProductsName;
    }

    public static ArrayList getProductName(ResultSet resultSet){
        ArrayList productsName = new ArrayList();
        try {
            while (resultSet.next()) {
                String q = resultSet.getString("productName");
                productsName.add(q);
            }
        }catch (SQLException e) {
            System.out.println("Can`t connect with db!");
        }
        return productsName;
    }

    public static ArrayList getAllProductsPrice(Statement statement, ResultSet resultSetAppliances, ResultSet resultSetProducts){
        ArrayList allProductsPrice = new ArrayList();
        try {
            resultSetProducts = statement.executeQuery("select * from products");
            allProductsPrice.addAll(getProductPrice(resultSetProducts));

            resultSetAppliances = statement.executeQuery("select * from appliances");
            allProductsPrice.addAll(getProductPrice(resultSetAppliances));

        }catch (SQLException e){
            System.out.println("Can`t connect to database!");
        }
        return allProductsPrice;
    }

    public static ArrayList getProductPrice(ResultSet resultSet){
        ArrayList productsPrice = new ArrayList();
        try {
            while (resultSet.next()) {
                int q = resultSet.getInt("productPrice");
                productsPrice.add(q);
            }
        }catch (SQLException e) {
            System.out.println("Can`t connect with db!");
        }
        return productsPrice;
    }
}
