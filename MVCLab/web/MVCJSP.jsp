<%-- 
    Document   : MVCJSP
    Created on : Apr 8, 2021, 9:33:08 AM
    Author     : markb
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mark's Card Market</title>
        
        <style>
            h4 {
                background-color: blanchedalmond;
            }
        </style>
    </head>
    <body>
        <form action="MVCJSP.jsp" method="get">
            
            <h1>Mark's Card Market Bestsellers</h1>
            <br>
            
            <h4>
                <%
                    String fname = "";
                    String lname = "";
                    String street = "";
                    String county = "";
                    String state = "";
                    String zip = "";
                    String credit = "";
                    String creddate = "";
                    String credsec = "";
                    String month = "";
                    String day = "";
                    String year = "";
                    String code = "";
                
                    fname = request.getParameter("fname");
                    lname = request.getParameter("lname");
                    street = request.getParameter("street"); 
                    county = request.getParameter("county");
                    state = request.getParameter("state");
                    zip = request.getParameter("zip");
                    credit = request.getParameter("credit");
                    creddate = request.getParameter("creddate");
                    credsec = request.getParameter("credsec");
                    month = request.getParameter("month");
                    day = request.getParameter("day");
                    year = request.getParameter("year");
                    code = request.getParameter("code");
                    
                    double totalBeforeTax = 0;
                    final double TAX_PERCENT = .06;
                    final double SHIPPING_AND_HANDLING = .1;
                    final double BINDER_PRICE = 24.99;
                    final double SLEEVES_PRICE = 5.99;
                    final double BOX_PRICE = 4.99;
                        
                    if (request.getParameter("item1") != null || request.getParameter("item2") != null|| request.getParameter("item3") != null) {
                        if (request.getParameter("item1") != null){
                            totalBeforeTax += BINDER_PRICE;
                        }
                        if (request.getParameter("item2") != null){
                            totalBeforeTax += SLEEVES_PRICE;
                        }
                        if (request.getParameter("item3") != null){
                            totalBeforeTax += BOX_PRICE;
                        }
                        out.println("***     RECEIPT     ***");
                        out.println("<br />");
                    }
                    
                    if (request.getParameter("item1") != null) {
                        out.println("1 Premium Card Binder - $24.99");
                        out.println("<br />");
                    }
                    
                    if (request.getParameter("item2") != null) {
                        out.println("1 Card Sleeves - $5.99");
                        out.println("<br />");
                    }
                    
                    if (request.getParameter("item3") != null) {
                        out.println("1 Deck Box - $4.99");
                        out.println("<br />");
                    }
                    
                    if (request.getParameter("item1") != null || request.getParameter("item2") != null|| request.getParameter("item3") != null) {
                        out.println("Total before Tax: " + totalBeforeTax);
                        out.println("<br />");
                        out.println("Tax (6%): " + (totalBeforeTax * TAX_PERCENT));
                        out.println("<br />");
                        out.println("Shipping and Handling(10%): " + (totalBeforeTax * SHIPPING_AND_HANDLING));
                        out.println("<br />");
                        out.println("_____________________________");
                        out.println("<br />");    
                        out.println("Your total cost: " + (totalBeforeTax + (totalBeforeTax * TAX_PERCENT) + (totalBeforeTax * SHIPPING_AND_HANDLING)));        
                        out.println("<br />"); 
                        out.println("<br />"); 
                        
                        out.println("Thank you for your purchase, " + fname + " " + lname + "!");
                        out.println("<br />");
                        out.println("Your purchase will be shipped to " + street + ", " + county + ", " + state + ", " + zip + ".");
                        out.println("<br />");
                        out.println("The date of purchase is " + month + " / " + day + " / " + year + ".");
                        out.println("<br />");
                        out.println("Your card with number " + credit + ", date " + creddate + ", and code " + credsec + " has been charged.");
                        out.println("<br />");
                        out.println("If applicable, we will include your coupon code (" + code + ").");
                        out.println("<br />");
                    }
                    
                %>
            </h4>
        
            <h2>Premium Card Binder</h2>
            <img id="item1" src="Images/cardBinder.jpg" title="item1" width="200px" height="200px">
            <p>"This is a high-quality card binder that can hold all of your favorite<br>
                collectible cards. The outer case is very durable, and the inner<br>
                plastic will stop your cards from being scratched."</p>
            <p><b>$24.99 + Shipping and Handling</b><p>
            <label for="item1">Buy Now:</label>
            <input type="checkbox" id="item1" name="item1">
            <br /><br /><br /><br />
        
            <h2>Card Sleeves</h2>
            <img id="item2" src="Images/cardSleeves.jpg" title="item2" width="200px" height="200px">
            <p>"This item includes 50 plastic sleeves for added protection for collectible<br> 
            cards. This includes for storage and for play. Includes smooth, matte, and <br> 
            image sleeves. "</p>
            <p><b>$5.99 + Shipping and Handling</b><p>
            <label for="item2">Buy Now:</label>
            <input type="checkbox" id="item2" name="item2">
            <br /><br /><br /><br />
        
            <h2>Deck Box</h2>
            <img id="item3" src="Images/deckBox.jpg" title="item3" width="200px" height="200px">
            <p>"This is a plastic box to hold all of your favorite cards. Made of a <br>
                patented rough plastic, and holds at most 50 sleeved cards.<br>
                Many colors available. "</p>
            <p><b>$4.99 + Shipping and Handling</b><p>
            <label for="item3">Buy Now:</label>
            <input type="checkbox" id="item3" name="item3">
            <br /><br /><br /><br />
        
            <label for="fname">First name:</label>
            <input type="text" id="fname" name="fname">
            <label for="lname">Last name:</label>
            <input type="text" id="lname" name="lname"><br /><br />
        
            <label for="street">Street Address:</label>
            <input type="text" id="street" name="street">
            <label for="county">County:</label>
            <input type="text" id="county" name="county">
            <label for="state">State:</label>
            <input type="text" id="state" name="state">
            <label for="zip">ZIP Code:</label>
            <input type="text" id="zip" name="zip"><br /><br />
        
            <label for="credit">Credit Card Number:</label>
            <input type="text" id="credit" name="credit">
            <label for="creddate">Credit Card Date:</label>
            <input type="text" id="creddate" name="creddate">
            <label for="credsec">Credit Card Security Code:</label>
            <input type="text" id="credsec" name="credsec"><br /><br />
        
            <label for="month">Today's Month:</label>
            <input type="text" id="month" name="month">
            <label for="day">Day:</label>
            <input type="text" id="day" name="day">
            <label for="year">Year:</label>
            <input type="text" id="year" name="year"><br /><br />
        
            <label for="code">Coupon Code:</label>
            <input type="text" id="code" name="code"><br /><br />
        
            <input type="submit" value="Submit">
            
        </form>
    </body>
</html>

<!--s
The solution will calculate the total costs. Include 6% tax and a 10% shipping 
cost. The view will detail the products purchased, an itemized receipt 
(including totals) and the customer information (name, address, credit card 
information).

Zip the entire project and submit.
-->