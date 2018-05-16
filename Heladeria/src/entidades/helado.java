/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.sql.PreparedStatement;
import dao.accesoDatos;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;


/**
 *
 * @author alumno
 */
public class helado {
    
    private int _idhelado;
    private String _sabor;
    
    //metodo estatico que traiga todos los helados y los muestre en la grilla.
    public helado(int id, String sabor){
        this._idhelado = id;
        this._sabor = sabor;
    }    
    public List<helado> retornarHelados() {

        List<helado> listado = new ArrayList<>();
        try {
            //miConexion con= new miConexion();            
            Connection conn = accesoDatos.RetornarConeccion();

            //Connection conn =miConexion..RetornarConeccion();
            PreparedStatement ps = conn.prepareStatement("select * from helado");
            ResultSet rs = ps.executeQuery(); // execute o executeUpdate para insert, update, delete
            System.out.println("==>listando");
            while (rs.next()) {

                listado.add(new helado(Integer.parseInt(rs.getString("idhelado")), rs.getString("sabor")));

            }
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return listado;
    }
}
