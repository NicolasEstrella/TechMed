package br.gs.techmed.controle;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.gs.techmed.DAO.PacienteDAO;
import br.gs.techmed.entidade.Paciente;

/**
 * Servlet implementation class ListarPacienteServlet
 */
@WebServlet("/listarPaciente")
public class ListarPacienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarPacienteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PacienteDAO dao = new PacienteDAO();
		List<Paciente> lista = dao.listar();

		request.setAttribute("pacientes", lista);
	}

}
