package com.costacarol.cloudnative.tema3.annotation.service;

import com.costacarol.cloudnative.tema3.annotation.app.AppConfig;
import com.costacarol.cloudnative.tema3.annotation.model.OperationType;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet (name = "CalculatorServlet", urlPatterns = {"/calculate"})
public class CalculatorServlet extends HttpServlet {

    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
    CalculatorService calculatorService = (CalculatorService) applicationContext.getBean("calculatorService");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<title>Calculator</title>");
        out.println("<body>");
        out.println("<h1> ===== Calculator ==== </h1><br>");
        out.println("<h2>To make a new calculate, you must replace the letters A, B and C with the parameters as you wish: localhost:8080/calculator/calculate?n1=<b>A</b>&n1=<b>B</b>&op=<b>C</b><br><br> Where:<br>A is a first number of operation;<br>B is a second number of operation;<br> And C is the name of operation (sum/sub/div/mult/pow).<br>");
        double n1 = Double.parseDouble(request.getParameter("n1"));
        double n2 = Double.parseDouble(request.getParameter("n2"));
        String operation = request.getParameter("op");
        String subtitle = "<h2>==== Your current operation ==== </h2>";
        switch (operation){
            case "sum":
                out.println(subtitle);
                out.println("<h2>" + n1 + " " + OperationType.SUM.getOperationSymbol() + " " + n2 + " = " + calculatorService.execute(OperationType.SUM, n1, n2) + "</h2>");
                break;
            case "sub":
                out.println(subtitle);
                out.println("<h2>" + n1 + " " + OperationType.SUB.getOperationSymbol() +  " " + n2 + " = " + calculatorService.execute(OperationType.SUB, n1, n2) + "</h2>");
                break;
            case "div":
                out.println(subtitle);
                out.println("<h2>" + n1 + " " + OperationType.DIVISION.getOperationSymbol() + " " + n2 + " = " + calculatorService.execute(OperationType.DIVISION, n1, n2) + "</h2>");
                break;
            case "mult":
                out.println(subtitle);
                out.println("<h2>" + n1 + " " + OperationType.MULTIPLY.getOperationSymbol() +  " " + n2 + " = " + calculatorService.execute(OperationType.MULTIPLY, n1, n2) + "</h2>");
                break;
            case "pow":
                out.println(subtitle);
                out.println("<h2>" + n1 + " " + OperationType.POW.getOperationSymbol() +  " " + n2 + " = " + calculatorService.execute(OperationType.POW, n1, n2) + "</h2>");
                break;
            default:
                out.println("<h2> Insert a valid option! <b> (sum/sub/div/mult/pow) </b></h2>");
        }
        out.println("</body>");
        out.println("</html>");
    }
}
