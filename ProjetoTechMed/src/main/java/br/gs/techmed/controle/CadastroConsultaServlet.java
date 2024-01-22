package br.gs.techmed.controle;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

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
 * Servlet implementation class CadastroConsultaServlet
 */
@WebServlet("/cadastrarConsulta")
public class CadastroConsultaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastroConsultaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ConsultaDAO dao1 = new ConsultaDAO();
		MedicoDAO dao2 = new MedicoDAO();
		Consulta consulta = new Consulta();
		Medico medico = new Medico();
		Paciente paciente = new Paciente();
		
		HttpSession session = request.getSession();
		paciente = (Paciente) session.getAttribute("paciente");
		
		// Receber os valores enviados pelo formulário
        String dataString = request.getParameter("data");
        String horaString = request.getParameter("hora");
        
        // Converter as strings para LocalDate e LocalTime
        LocalDate data = LocalDate.parse(dataString);
        LocalTime hora = LocalTime.parse(horaString);

        // Combinar a data e a hora em LocalDateTime, se necessário
        LocalDateTime dataHora = LocalDateTime.of(data, hora);
		
		medico = dao2.pesquisar(Integer.parseInt(request.getParameter("medico")));
		
		consulta.setData(dataHora);
		consulta.setMedico(medico);
		consulta.setPaciente(paciente);
		dao1.inserir(consulta);
		
		response.sendRedirect("homePage.jsp");
	}

}
