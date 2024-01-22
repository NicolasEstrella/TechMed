package br.gs.techmed.controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.gs.techmed.DAO.MedicoDAO;
import br.gs.techmed.entidade.Medico;

/**
 * Servlet implementation class CadastroMedicoServlet
 */
@WebServlet("/CadastrarMedico")
public class CadastroMedicoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastroMedicoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MedicoDAO dao = new MedicoDAO();
		Medico medico = new Medico();
		
		medico.setNome(request.getParameter("nome"));
		medico.setCrm(request.getParameter("crm"));
		medico.setEspecialidade(request.getParameter("especialidade"));
		medico.setValorConsulta(Double.parseDouble(request.getParameter("valor_consulta")));
		dao.inserir(medico);
		
		response.sendRedirect("homePage.jsp");
	}

}
