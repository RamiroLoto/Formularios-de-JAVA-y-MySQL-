/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author alumno
 */
public class accesoDatos {

    String jdbc_driver = "com.mysql.jdbc.Driver";
    String jdbc_db_url = "jdbc:mysql://localhost:3306/heladeria";
    String jdbc_user = "root";
    String jdbc_pass = "";
    private static Connection UnaConeccion;

    /**
     *
     * privado para el patron singleton
     *
     * @throws ClassNotFoundException
     */
    private accesoDatos() throws ClassNotFoundException {

        try {
            Class.forName(jdbc_driver);
            UnaConeccion = DriverManager.getConnection(jdbc_db_url, jdbc_user, jdbc_pass);

            // conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(accesoDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * statico , retorna la unica instancia del conector a base de datos
     *
     * @return
     */
    public static Connection RetornarConeccion() {
        accesoDatos conec;
        //si no esta instanciado, lo instacio y retorno
        //si esta instanciado, simplemente lo retorno
        try {
            if (UnaConeccion == null || UnaConeccion.isClosed()) {
                try {
                    conec = new accesoDatos();
                } catch (Exception e) {
                }

            }
        } catch (Exception e) {

            System.out.println("error" + e);
        }

        return UnaConeccion;
    }

}
