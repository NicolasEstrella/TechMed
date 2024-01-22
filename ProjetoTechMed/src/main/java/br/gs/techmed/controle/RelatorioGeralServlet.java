package br.gs.techmed.controle;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.gs.techmed.DAO.ConsultaDAO;
import br.gs.techmed.entidade.Consulta;

/**
 * Servlet implementation class RelatorioGeralServlet
 */
@WebServlet("/relatorioGeral")
public class RelatorioGeralServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RelatorioGeralServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ConsultaDAO dao = new ConsultaDAO();
		List<Consulta> lista = dao.relatorioGeral();
		
		request.setAttribute("relatorio", lista);
	}

}
