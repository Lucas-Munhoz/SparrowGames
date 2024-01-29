package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controllerFxml.Main;

public class DaoDesejo {
    
    private PreparedStatement declaracao;
    private String command = "";
    
    public ResultSet findByIdUsu(){
        ConnectBd bd = new ConnectBd();

        try{
            command = "SELECT Jogo.idJogo, Jogo.nomeJogo, Jogo.precoJogo, Jogo.imgJogo FROM jogo, desejo WHERE desejo.idUsuario = ? and desejo.idJogo = Jogo.idJogo";
            declaracao = bd.getConnection().prepareStatement(command);
            declaracao.setInt(1, Main.idIdent);
            ResultSet resultado = declaracao.executeQuery();
            System.out.println("Transacao realizada com sucesso!");
            return resultado;
        }
        catch(SQLException ex){
            try{
                bd.getConnection().rollback();
                System.out.println("Transacao cancelada!");
                System.err.println("Erro na transacao: " + ex.getMessage());
                return null;
            }
            catch(SQLException exe){
                System.err.println("Erro ao cancelar transacao: " + exe.getMessage());
                return null;
            }
        }
    }

    public ResultSet findByIdJogo(){
        ConnectBd bd = new ConnectBd();

        try{
            command = "SELECT Jogo.idJogo FROM jogo, desejo WHERE desejo.idUsuario = ? and desejo.idJogo = jogo.idJogo";
            declaracao = bd.getConnection().prepareStatement(command);
            declaracao.setInt(1, Main.idIdent);
            ResultSet resultado = declaracao.executeQuery();
            System.out.println("Transacao realizada com sucesso!");
            return resultado;
        }
        catch(SQLException ex){
            try{
                bd.getConnection().rollback();
                System.out.println("Transacao cancelada!");
                System.err.println("Erro na transacao: " + ex.getMessage());
                return null;
            }
            catch(SQLException exe){
                System.err.println("Erro ao cancelar transacao: " + exe.getMessage());
                return null;
            }
        }
    }

    public void insertDesejo(){
        ConnectBd bd = new ConnectBd();
        try{
            command = "INSERT INTO desejo VALUES (?, ?)";
            declaracao = bd.getConnection().prepareStatement(command);
            declaracao.setInt(1, Main.idJogoAux);
            declaracao.setInt(2, Main.idIdent);
            declaracao.execute();
            bd.getConnection().commit();
            System.out.println("Adicionou com sucesso o jogo aos favoritos!");
            }
        catch(SQLException ex){
            try{
                bd.getConnection().rollback();
                System.out.println("Transacao de adicao cancelada!");
                System.err.println("Erro na transacao de adicao: " + ex.getMessage());
            }
            catch(SQLException exe){
                System.err.println("Erro ao cancelar a transacao de adicao: " + exe.getMessage());
            }
        }
    }

    public void deleteDesejo(){
        ConnectBd bd = new ConnectBd();
        try{
            command = "DELETE from desejo WHERE idJogo = ? and idUsuario = ?  ";
            declaracao = bd.getConnection().prepareStatement(command);
            declaracao.setInt(1, Main.idJogoAux);
            declaracao.setInt(2, Main.idIdent);
            declaracao.execute();
            bd.getConnection().commit();
            System.out.println("Deletou o jogo dos desejos com sucesso");
            }
        catch(SQLException ex){
            try{
                bd.getConnection().rollback();
                System.out.println("Transacao de adicao cancelada!");
                System.err.println("Erro na transacao na adicao: " + ex.getMessage());
            }
            catch(SQLException exe){
                System.err.println("Erro ao cancelar a transacao de adicao: " + exe.getMessage());
            }
        }
    }

    public void deleteUsingIdUsu(int id){
        ConnectBd bd = new ConnectBd();
        
        try{
            command = "DELETE FROM Desejo WHERE idUsuario = ?";
            declaracao = bd.getConnection().prepareStatement(command);
            declaracao.setInt(1, id);
            declaracao.execute();
            bd.getConnection().commit();
            System.out.println("Transacao realizada com sucesso!");
        }
        catch(SQLException ex){
            try{
                bd.getConnection().rollback();
                System.out.println("Transacao cancelada!");
                System.err.println("Erro na transacao: " + ex.getMessage());
            }
            catch(SQLException exe){
                System.err.println("Erro ao cancelar transacao: " + exe.getMessage());
            }
        }
    }
}
