package br.gs.techmed.controle;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class HomePageServlet
 */
@WebServlet("/homePage")
public class HomePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomePageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ConsultaDAO dao1 = new ConsultaDAO();
		HttpSession session = request.getSession();
		Paciente paciente = (Paciente) session.getAttribute("paciente");
		List<Consulta> lista;
		if (request.getAttribute("medico") == null || request.getAttribute("medico").equals("0")) {
			lista = dao1.relatorioPaciente(paciente.getId());
		} else {
			MedicoDAO dao2 = new MedicoDAO();
			Medico medico = dao2.pesquisar(Integer.parseInt(request.getParameter("medico")));
			lista = dao1.pesquisar(paciente.getId(), medico.getId());
		}
		request.setAttribute("consultas", lista);
	}

}
