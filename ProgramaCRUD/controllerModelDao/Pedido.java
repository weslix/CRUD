package ProgramaCRUD.controllerModelDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Pedido {
    private int id;
    private Date data;
    private double valor;

    public Pedido() {
    }

    public Pedido(int id) {
        this.id = id;
    }

    public Pedido(int id, Date data, double valor) {
        this.id = id;
        this.data = data;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void incluir(int idCliente, Connection conn) {
        String sqlInsert = "INSERT INTO pedido(data, valor, id_cliente) VALUES (?, ?,?)";

        try (PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
            stm.setDate(1, new java.sql.Date(getData().getTime()));
            stm.setDouble(2, getValor());
            stm.setInt(3, idCliente);
            stm.execute();
            String query = "SELECT LAST_INSERT_ID()";
            try (PreparedStatement stm2 = conn.prepareStatement(query);
                 ResultSet rs = stm2.executeQuery();) {
                if (rs.next()) {
                    setId(rs.getInt(1));
                } else {
                    throw new SQLException("Erro para conseguir o id do pedido");
                }
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    conn.rollback();
                } catch (SQLException e1) {
                    System.out.print(e1.getStackTrace());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException e1) {
                System.out.print(e1.getStackTrace());
            }
        }
    }

    public void excluir(Connection conn) {
        String sqlDelete = "DELETE FROM pedido WHERE id = ?";
        try (PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
            stm.setInt(1, getId());

            stm.execute();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException e1) {
                System.out.print(e1.getStackTrace());
            }
        }
    }

    public void atualizar(Connection conn) {
        String sqlUpdate = "UPDATE pedido SET data=?, valor=? WHERE id=?";

        try (PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
            stm.setDate(1, new java.sql.Date(getData().getTime()));
            stm.setDouble(2, getValor());
            stm.setInt(3, getId());
            stm.execute();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException e1) {
                System.out.print(e1.getStackTrace());
            }
        }
    }

    public int carregar(Connection conn) {
        String sqlSelect = "SELECT data, valor, id_cliente FROM pedido WHERE id = ?";
        int idCliente = -1;
        try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
            stm.setInt(1, getId());
            try (ResultSet rs = stm.executeQuery();) {
                /*
                 * este outro try e' necessario pois nao da' para abrir o
                 * resultsetno anterior uma vez que antes era preciso configurar
                 * o parametrovia setInt; se nao fosse, poderia se fazer tudo no
                 * mesmo try
                 */
                if (rs.next()) {
                    setData(rs.getDate(1));
                    setValor(rs.getDouble(2));
                    idCliente = rs.getInt(3);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (SQLException e1) {
            System.out.print(e1.getStackTrace());
        }
        return idCliente;
    }

    @Override
    public String toString() {
        return "Pedido [id=" + id + ", data=" + data + ", valor=" + valor + "]";
    }

}

