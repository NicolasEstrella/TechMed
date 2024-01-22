package br.gs.techmed.controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.gs.techmed.DAO.PacienteDAO;
import br.gs.techmed.entidade.Paciente;
import br.gs.techmed.util.Util;

/**
 * Servlet implementation class CadastroServlet
 */
@WebServlet("/Cadastrar")
public class CadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastroServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PacienteDAO dao = new PacienteDAO();
		Paciente paciente = new Paciente();
		Util util = new Util();
		
		paciente.setNome(request.getParameter("nome"));;
		paciente.setCpf(request.getParameter("cpf"));;
		paciente.setEmail(request.getParameter("email"));;
		paciente.setLogin(request.getParameter("login"));;
		paciente.setSenha(util.criptografar(request.getParameter("senha")));
		
		dao.inserir(paciente);
		
		HttpSession session = request.getSession();
		Paciente p = (Paciente) session.getAttribute("paciente");
		
		if (p == null) {
			response.sendRedirect("index.jsp");	
		}else if(p.getLogin().equalsIgnoreCase("admin")){
			response.sendRedirect("homePage.jsp");
		}
	}

}
