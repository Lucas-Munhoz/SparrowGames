package controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import controllerFxml.Main;
import dao.DaoBiblioteca;
import dao.DaoCarrinho;
import dao.DaoKey;
import dao.DaoPagamento;
import model.Key;
import model.Pagamento;

public class ControlPagamento {

    public void finalizarCompra(Pagamento pg) {
        DaoKey dk = new DaoKey();
        DaoCarrinho dc = new DaoCarrinho();
        DaoBiblioteca db = new DaoBiblioteca();
        DaoPagamento dp = new DaoPagamento();
        Pagamento pgmt = pg;
        Key key = new Key();
        int idJogo;
        try {
            // Procura os id's dos jogos que estao no carrinho
            ResultSet result = dc.findByIdUsu();
            while (result.next()) {
                // Id do jogo que esta no carrinho
                idJogo = result.getInt("IdJogo");

                // Procura as key's dos jogos em questao
                ResultSet resultKey = dk.findByIdJogo(idJogo);
                
                pgmt.setIdJogo(idJogo);
                pgmt.setIdUsuario(Main.idIdent);
                dp.insertDadosPagamento(pgmt);

                // Monta uma key com o resultado na querry anterior
                key.setIdSerial(resultKey.getString("idSerial"));
                key.setDisponivel(resultKey.getBoolean("disponivel"));
                key.setidJogo(resultKey.getInt("idJogo"));

                // Altera a disponibilidade da key capturada do banco
                dk.attDisponivel(resultKey.getString("idSerial"), false);

                // Insere o jogo na biblioteca do usuario ja passando a key
                db.insertJogoBiblioteca(key);
            }

        } catch (SQLException e2) {
            e2.printStackTrace();
        }
    }
}
