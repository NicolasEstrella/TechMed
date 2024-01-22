package br.gs.techmed.controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PacienteDAO dao = new PacienteDAO();
		Util util = new Util();
		Paciente paciente = new Paciente();
		String login, senha;
		
		login = request.getParameter("login");
		senha = util.criptografar(request.getParameter("senha"));
		
		paciente = dao.validar(login, senha);
		
		RequestDispatcher dispatcher;
		HttpSession session = request.getSession();
		
		session.setAttribute("paciente", paciente);
		
		if(paciente != null) {	
			dispatcher = request.getRequestDispatcher("homePage.jsp");
			dispatcher.forward(request, response);
		}else {
			response.sendRedirect("index.jsp");
		}
	}

}
