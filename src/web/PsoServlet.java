package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import pso.logic.FunctionFactory;
import pso.logic.Pso;
import pso.managers.PsoParamsManager;
import pso.view.ConsolePrinter;

/**
 * Servlet implementation class PsoServlet
 */
@WebServlet("/PsoServlet")
public class PsoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PsoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PsoParamsManager psoParams = new PsoParamsManager();
		//Prihvatanje parametara sa frontenda
		psoParams.setDimension(Integer.parseInt(request.getParameter("dimensions")));
		psoParams.setIterations(Integer.parseInt(request.getParameter("iterations")));
		psoParams.setParticlesNumber(Integer.parseInt(request.getParameter("numofparticles")));
		psoParams.setOmegaValue(Double.parseDouble(request.getParameter("omegavalue")));
		psoParams.setC1(Double.parseDouble(request.getParameter("fiparticle")));
		psoParams.setC2(Double.parseDouble(request.getParameter("fiswarm")));
		psoParams.setOmegaMin(Double.parseDouble(request.getParameter("omegaMin")));
		psoParams.setOmegaDif(psoParams.getOmegaValue() - psoParams.getOmegaMin());
		
		//Instanciranje funkcij i njenih granicnih vrednosti na osnovu query parametra "function"
		psoParams.setFunction(request.getParameter("function"));
		
		
		//Inicijalizacija PSO
		Pso pso = new Pso(psoParams);
		
		//Preuzimanje pozicija globalnog minimuma
		List<Double> minimum = pso.getMinimum();
		ConsolePrinter.printResults(minimum, psoParams);
		System.out.println("PSO minimum: " + pso.getS().getLastSwarmBestEval());
		CalculationResult cResult = new CalculationResult(pso.getS().getLastSwarmBestEval(), minimum);
		Gson gson = new GsonBuilder().create();
		String resultJson =  gson.toJson(cResult);
		response.setContentType("application/json");
		response.getWriter().write(resultJson);
		response.setStatus(HttpServletResponse.SC_OK);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
