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
import br.gs.techmed.DAO.PacienteDAO;
import br.gs.techmed.entidade.Consulta;
import br.gs.techmed.entidade.Paciente;

/**
 * Servlet implementation class RelatorioPacienteServlet
 */
@WebServlet("/relatorioPaciente")
public class RelatorioPacienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RelatorioPacienteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ConsultaDAO dao = new ConsultaDAO();
		PacienteDAO dao1 = new PacienteDAO();
		List<Consulta> lista = dao.relatorioPaciente(Integer.parseInt(request.getParameter("paciente")));
		Paciente paciente = dao1.pesquisar(Integer.parseInt(request.getParameter("paciente")));
		
		request.setAttribute("relatorio", lista);
		request.setAttribute("paciente", paciente);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("form/formRelatorioPaciente.jsp");
		dispatcher.forward(request, response);
	}

}
