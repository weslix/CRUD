package ProgramaCRUD.controllerModelDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Cliente {
    private int idCliente;
    private String nome;
    private String fone;
    private ArrayList<Pedido> pedidos;

    public Cliente() {
        pedidos = new ArrayList<>();
    }

    public Cliente(int idCliente) {
        this.idCliente = idCliente;
        pedidos = new ArrayList<>();
    }

    public Cliente(int idCliente, String nome, String fone) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.fone = fone;
        pedidos = new ArrayList<>();
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public void adicionarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public void incluir(Connection conn) {
        String sqlInsert = "INSERT INTO cliente(nome, fone) VALUES (?, ?)";

        try (PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
            stm.setString(1, getNome());
            stm.setString(2, getFone());
            stm.execute();
            // pegar o id criado no banco
            String query = "SELECT LAST_INSERT_ID()";
            try (PreparedStatement stm2 = conn.prepareStatement(query);
                 ResultSet rs = stm2.executeQuery();) {
                if (rs.next()) {
                    setIdCliente(rs.getInt(1));
                } else {
                    throw new SQLException(
                            "Erro para conseguir o id do cliente");
                }
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    conn.rollback();
                } catch (SQLException e1) {
                    System.out.print(e1.getStackTrace());
                }
            }

            // incluir os pedidos
            for (Pedido pedido : pedidos) {
                pedido.incluir(getIdCliente(), conn);
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
        String sqlDelete = "DELETE FROM cliente WHERE id = ?";
        try (PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
            // excluir primeiro os pedidos
            for (Pedido pedido : pedidos) {
                pedido.excluir(conn);
            }
            // depois excluir o cliente
            stm.setInt(1, getIdCliente());
            stm.execute();
            // anular os pedidos e os atributos
            pedidos = new ArrayList<>();
            setNome(null);
            setFone(null);
            setIdCliente(-1);
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
        String sqlUpdate = "UPDATE cliente SET nome=?, fone=? WHERE id = ?";

        try (PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
            stm.setString(1, getFone());
            stm.setString(2, getNome());
            stm.setInt(3, getIdCliente());

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

    public void carregar(Connection conn) {
        String sqlSelect = "SELECT nome, fone FROM cliente WHERE id = ?";

        try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
            stm.setInt(1, getIdCliente());
            try (ResultSet rs = stm.executeQuery();) {
                /*
                 * este outro try e' necessario pois nao da' para abrir o
                 * resultsetno anterior uma vez que antes era preciso configurar
                 * o parametrovia setInt; se nao fosse, poderia se fazer tudo no
                 * mesmo try
                 */
                if (rs.next()) {
                    setNome(rs.getString("nome"));
                    setFone(rs.getString("fone"));
                    pedidos = carregarPedidos(conn);
                } else {
                    setNome(null);
                    setFone(null);
                    pedidos = new ArrayList<>();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (SQLException e1) {
            System.out.print(e1.getStackTrace());
        }
    }

    public ArrayList<Pedido> carregarPedidos(Connection conn) {
        String sqlSelect = "SELECT id, data, valor FROM pedido WHERE id_cliente = ?";
        ArrayList<Pedido> lista = new ArrayList<>();

        try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
            stm.setInt(1, getIdCliente());
            try (ResultSet rs = stm.executeQuery();) {
                /*
                 * este outro try e' necessario pois nao da' para abrir o
                 * resultsetno anterior uma vez que antes era preciso configurar
                 * o parametrovia setInt; se nao fosse, poderia se fazer tudo no
                 * mesmo try
                 */
                while (rs.next()) {
                    Pedido p = new Pedido();
                    p.setId(rs.getInt("id"));
                    p.setData(rs.getDate("data"));
                    p.setValor(rs.getDouble("valor"));
                    lista.add(p);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (SQLException e1) {
            System.out.print(e1.getStackTrace());
        }
        return lista;
    }

    public String listarPedidos() {
        String listagem = "";
        for (Pedido pedido : pedidos) {
            listagem += "\n\t" + pedido.toString();
        }
        return listagem;
    }

    public String toString() {
        return "Cliente [idCliente=" + idCliente + ", nome=" + nome + ", fone="
                + fone + "]" + listarPedidos();
    }
}