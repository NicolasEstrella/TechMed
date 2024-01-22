package br.gs.techmed.controle;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.gs.techmed.DAO.ConsultaDAO;
import br.gs.techmed.DAO.MedicoDAO;
import br.gs.techmed.entidade.Consulta;
import br.gs.techmed.entidade.Medico;

/**
 * Servlet implementation class RelatorioMedicoServlet
 */
@WebServlet("/relatorioMedico")
public class RelatorioMedicoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RelatorioMedicoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ConsultaDAO dao = new ConsultaDAO();
		MedicoDAO dao1 = new MedicoDAO();
		
		if (request.getParameter("medico") == null) {
			response.sendRedirect("form/formPesquisarMedico.jsp");
		}else {
		
		List<Consulta> lista = dao.relatorioMedico(Integer.parseInt(request.getParameter("medico")));
		
		Medico medico = dao1.pesquisar(Integer.parseInt(request.getParameter("medico")));
		request.setAttribute("relatorio", lista);
		request.setAttribute("medico", medico);			
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("form/formRelatorioMedico.jsp");
		dispatcher.forward(request, response);
		}
	}

}
