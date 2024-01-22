package br.gs.techmed.controle;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.gs.techmed.DAO.ConsultaDAO;
import br.gs.techmed.DAO.MedicoDAO;
import br.gs.techmed.entidade.Consulta;
import br.gs.techmed.entidade.Medico;
import br.gs.techmed.entidade.Paciente;

/**
 * Servlet implementation class PesquisarConsultaServlet
 */
@WebServlet("/pesquisarConsulta")
public class PesquisarConsultaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PesquisarConsultaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MedicoDAO dao1 = new MedicoDAO();
		ConsultaDAO dao2 = new ConsultaDAO();
		Medico medico = dao1.pesquisar(Integer.parseInt(request.getParameter("especialidade")));
		HttpSession session = request.getSession();
		Paciente paciente = (Paciente) session.getAttribute("paciente");
		
		List<Consulta> lista = dao2.pesquisar(paciente.getId(), medico.getId());
		request.setAttribute("consultas", lista);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("form/formPesquisarConsulta.jsp");
		dispatcher.forward(request, response);
	}

}
