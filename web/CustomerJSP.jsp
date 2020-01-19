<%-- 
    Document   : CustomerJSP
    Created on : Nov. 26, 2019, 3:44:17 p.m.
    Author     : monal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="Customer.css" rel="stylesheet">
        <title>JSP Page</title>
    </head>
    <body>
       <div>
            <form method="post" action="CustomerServlet">
                <label for="fname">First Name</label>
                <input type="text" id="fname" name="firstname" placeholder="Your name.." required>

                <label for="lname">Last Name</label>
                <input type="text" id="lname" name="lastname" placeholder="Your last name.." required>
                
                <label for="phone">Phone Number</label>
                <input type="text" id="phonenumber" name="phonenumber" required placeholder="Your phone number">
                
                <label for="email">Email</label>
                <input type="email" id="email" name="email" placeholder="Your email">

                <label for="housenumber">House Number</label>
                <input type="text" id="housenumber" name="housenum" placeholder="House Number" required>
                
                <label for="street">Street</label>
                <input type="text" id="street" name="street" placeholder="Your street" required>

                <label for="province">Province</label>
                <select id="province" name="province">
                    <option value="BC">British Columbia</option>
                    <option value="AB">Alberta</option>
                    <option value="SK">Saskatchewan"</option>
                    <option value="MB">Manitoba</option>
                    <option value="ON">Ontario</option>
                    <option value="QC">Quebec</option>
                    <option value="NB">New Brunswick</option>
                    <option value="PEI">Prince Edward Island</option>
                    <option value="NS">Nova Scotia</option>
                    <option value="NL">Newfoundland and Labrador</option>
                    <option value="NT">Northwest Territories</option>
                    <option value="NU">Nunavut</option>
                    <option value="YT">Yukon</option>
                </select>
                
                <label for="postalCode">Postal Code</label>
                <input type="text" id="postalCode" name="postalCode" placeholder="Your postal code" required>
                 <input type="radio" id="delivery" value="Delivery" name="radio"/>Delivery
                <input type="radio" id="pickup" value="Pick Up" name="radio"/>Pick Up
                <input type="submit" value="Submit">
               
            </form>
        </div>

    </body>
</html>
