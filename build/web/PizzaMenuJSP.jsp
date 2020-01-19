<%-- 
    Document   : PizzaMenuJSP
    Created on : Dec. 8, 2019, 8:15:19 p.m.
    Author     : monal
--%>

<%@page import="businessobjects.CrustType"%>
<%@page import="businessobjects.CrustTypeBL"%>
<%@page import="businessobjects.Size"%>
<%@page import="businessobjects.SizeBL"%>
<%@page import="businessobjects.ToppingBackingBean"%>
<%@page import="businessobjects.Toppings"%>
<%@page import="java.util.ArrayList"%>
<%@page import="businessobjects.PizzaBL"%>
<%@page import="databeans.PizzaDL"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
<style>


</style>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <a href="Employee.xhtml">Admin Login</a>
    <title>Pizza Ordering Form</title>
</head>
    <h1>Pizza Ordering Form</h1>
    <form method="post" action="PizzaServelet">
        <%--
        Dynamically display toppings from DB
        --%>
        <%
            ToppingBackingBean topping = new ToppingBackingBean();
            ArrayList<Toppings> t = topping.getAllToppings();
            for (int i = 0; i < t.size(); i++) {
                Toppings t1 = t.get(i);

                
                out.println("<input type=\"checkbox\" name=\"topping" + i + "\" value=\"" + t1.getToppingsId() + "\"> " + t1.getName() + " " + t1.getPrice() + "<br>");

            }

        %>
        </br>
        <%--
        Displays Crustss' Name from DB
        --%>
        <%  
            CrustTypeBL crust = new CrustTypeBL();
            ArrayList<CrustType> c = crust.GetCrustsType();
            for (int i = 0; i < c.size(); i++) {
                CrustType c1 = c.get(i);

                out.println("<input type=\"radio\" name=\"crust\" value=\"" + c1.getCrustTypeId() + "\"> " + c1.getName() + " " + "<br>");

            }

        %>
        </br>
        <%--
        Displays sizes from DB
        --%>
        <%  
            SizeBL size = new SizeBL();
            ArrayList<Size> s = size.GetSizes();
            for (int i = 0; i < s.size(); i++) {
                Size s1 = s.get(i);
                out.println("<input type=\"radio\" name=\"size\" value=\"" + s1.getName() + "\"> " + s1.getName() + " " + "<br>");
            }
        %>
        <input type="submit" value="submit"/>
        </br></br>
    </form>
</body>
</html>
