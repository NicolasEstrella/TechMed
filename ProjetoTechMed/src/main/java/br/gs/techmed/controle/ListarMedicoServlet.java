package br.gs.techmed.controle;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.gs.techmed.DAO.MedicoDAO;
import br.gs.techmed.entidade.Medico;

/**
 * Servlet implementation class ListarMedicoServlet
 */
@WebServlet("/listarMedico")
public class ListarMedicoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarMedicoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MedicoDAO dao = new MedicoDAO();
		List<Medico> lista = dao.listar();
		request.setAttribute("medicos", lista);
	}

}
