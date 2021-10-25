import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args ){
        try(Connection conectar = DriverManager.getConnection("jdbc:sqlite:meu_banco.db")){

            try(Statement exe = conectar.createStatement()){

                String script_inset = "insert into trabalho (CARROS) values ('Nivus'),('Gol'),('Astra'),('Golf'),('Polo'),('RAM')";
                //String script_update = "update trabalho set PAISES='Jetta' where ID=2";
                //String script_delete = "delete from trabalho";
                //String script_delete = "delete from trabalho where ID=3";

                exe.execute(script_inset);
                //exe.execute(script_update);
                //exe.execute(script_delete);

            }catch(SQLException e){
                e.printStackTrace();
            }finally{
                if(!conectar.isClosed()){
                    conectar.close();
                }
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}