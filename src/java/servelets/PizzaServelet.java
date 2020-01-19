/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servelets;

import businessobjects.CrustType;
import businessobjects.Pizza;
import businessobjects.ToppingBackingBean;
import businessobjects.Toppings;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author monal
 */
public class PizzaServelet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            int topping=0;
            Pizza p = new Pizza();
            CrustType c = new CrustType();
            p.setToppingsId(new ArrayList<Toppings>());
            ToppingBackingBean tb = new ToppingBackingBean();
            for(int i=0;i<10;i++){
            if(request.getParameter("topping"+i)!=null){
                topping=Integer.parseInt(request.getParameter("topping"+i));
                Toppings t = tb.GetToppingById(topping);
                ArrayList<Toppings> tlist=p.getToppingsId();
                tlist.add(t);
                p.setToppingsId(tlist);
            }
            }
            int crust=Integer.parseInt(request.getParameter("crust"));
            p.setCrustType(crust);
            String size=request.getParameter("size");
            p.setSize(size);
     
            String crustName = request.getParameter("crust");
            c.setName(crustName);
            
            double Total=p.CalculatePrice();
            p.setPrice(Total);
            NumberFormat nf= NumberFormat.getCurrencyInstance();
            String formattedTotal = nf.format(Total);
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Your order </title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Your order" + request.getContextPath() + "</h1>");
            out.println(" Crust "+crustName+crust+"</br> "+"Pizza Size "+size + "</br>" + "Total: " +formattedTotal+"</br>"+p.getToppingsId().toString());
            out.println("</br>");
            out.println(p.toString());
            HttpSession session = request.getSession();
            session.setAttribute("order", p);
            out.println("<br>");
            out.println("<a href='CustomerJSP.jsp'>Submit you order</a>");
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
