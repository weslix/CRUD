package ProgramaCRUD.controllerModelDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Vendedor{

    public void listarClientes(Connection conn){
        ArrayList<Cliente> lista = buscarClientes(conn);
        for(Cliente cliente:lista){
            System.out.println(cliente);
        }
    }

    public ArrayList<Cliente> buscarClientes(Connection conn){
        String sqlSelect = "SELECT id, nome, fone FROM CLIENTE";
        ArrayList<Cliente> lista = new ArrayList<>();

        try(PreparedStatement stm = conn.prepareStatement(sqlSelect);
            ResultSet rs = stm.executeQuery();){
            //veja que desta vez foi possivel usar o mesmo try
            while(rs.next()){
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setFone(rs.getString("fone"));
                lista.add(cliente);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return lista;
    }
}