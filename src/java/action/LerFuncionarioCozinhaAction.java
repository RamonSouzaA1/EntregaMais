/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.FuncionarioChefeCozinha;
import model.FuncionarioAjudante;
import model.FuncionarioEstagiario;

/**
 *
 * @author Ramon
 */
public class LerFuncionarioCozinhaAction implements Action {

    public LerFuncionarioCozinhaAction() {
    }
    

    public void execute(HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        try {
            FuncionarioChefeCozinha chefeCozinha = new FuncionarioChefeCozinha(null);
            
            FuncionarioAjudante ajudante = new FuncionarioAjudante(chefeCozinha);
            
            FuncionarioEstagiario estagiario = new FuncionarioEstagiario(ajudante);
            
            request.setAttribute("chefeCozinha", chefeCozinha);
            request.setAttribute("ajudante", ajudante);
            request.setAttribute("estagiario", estagiario);
            
            RequestDispatcher view = request.getRequestDispatcher("funcionarioCozinhaConsulta.jsp");
            view.forward(request, response);
        
        } catch (ServletException ex) {
            Logger.getLogger(LerEntregadorAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
