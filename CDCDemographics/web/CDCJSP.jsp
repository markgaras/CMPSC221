<%-- 
CMPSCI 221 CDC Demographics Final Project
index.html
Purpose: Using SQL, Java, and HTML to display the CDC's numbers to the user who 
inputs their desired parameters. 

@author Mark Garas, Alvin Chen, Gabriel Fleming, Kaiqi Yang
@version 1.0 4/20/2021
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CDC COVID-19 Info</title>
        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        
        <script type="text/javascript">
            
            <!-- This is javaScript to configure the dropdown menus according to what the user selects. -->
            
            <!-- The arrays of possible user options. -->
            
            var listA = [{name:'Male', value:'Male'}, {name:'Female', value:'Female'}, {name:'Other', value:'Other'}];

            var listB = [{name:'0-17', value:'0-17'}, {name:'18-29', value:'18-29'}, 
                {name:'30-39', value:'30-39'}, {name:'40-49', value:'40-49'}, 
                {name:'50-64', value:'50-64'}, {name:'65-74', value:'65-74'}, 
                {name:'75+', value:'75+'}];
            
            var listC = [{name:'White', value:'White'}, {name:'Hispanic / Latino', value:'Hispanic / Latino'},
                {name:'Black', value:'Black'}, {name:'Asian', value:'Asian'}, 
                {name:'American Indian / Alaska Native', value:'American Indian / Alaska Native'}, 
                {name:'Hawaiian Native / Other Pacific Islander', value:'Hawaiian Native / Other Pacific Islander'}, 
                {name:'Multiple', value:'Multiple'}];

            <!-- According to what radio button is pressed, a different menu is shown. -->
            
            $(document).ready( function() {
                $("input[name='group1']").on('change',function() {
          
                if($(this).is(':checked') && $(this).val() == 'Sex') {
                    $('#demo1').empty()
                    $.each(listA, function(index, value) {
                        $('#demo1').append('<option value="'+value.value+'">'+value.name+'</option>');
                    });                  
                }
                
                else if($(this).is(':checked') && $(this).val() == 'Age') {
                    $('#demo1').empty()
                    $.each(listB, function(index, value) {
                        $('#demo1').append('<option value="'+value.value+'">'+value.name+'</option>');
                    }); 
                }
                
                else if($(this).is(':checked') && $(this).val() == 'Race') {
                    $('#demo1').empty()
                    $.each(listC, function(index, value) {
                        $('#demo1').append('<option value="'+value.value+'">'+value.name+'</option>');
                    }); 
                }
                
                else {}
                });
                
                $("input[name='group2']").on('change',function() {
          
                if($(this).is(':checked') && $(this).val() == 'Sex') {
                    $('#demo2').empty()
                    $.each(listA, function(index, value) {
                        $('#demo2').append('<option value="'+value.value+'">'+value.name+'</option>');
                    });                  
                }
                
                else if($(this).is(':checked') && $(this).val() == 'Age') {
                    $('#demo2').empty()
                    $.each(listB, function(index, value) {
                        $('#demo2').append('<option value="'+value.value+'">'+value.name+'</option>');
                    }); 
                }
                
                else if($(this).is(':checked') && $(this).val() == 'Race') {
                    $('#demo2').empty()
                    $.each(listC, function(index, value) {
                        $('#demo2').append('<option value="'+value.value+'">'+value.name+'</option>');
                    }); 
                }
                
                else {}
                });
            });

        </script>
        
    </head>
    <body>
        <h1>CDC COVID-19 Information</h1>
        
        <mark>
            <%
                // Gets the string output from the servlet that does all the logic.
                if (request.getParameter("group1") != null) {
                    out.println("Output: <br />");
                    out.println(request.getAttribute("results1"));
                }

                if (request.getParameter("group2") != null) {
                    out.println("<br />");
                    out.println(request.getAttribute("results2"));
                }
            %>
        </mark>
        
        <form action="CDCServlet" method="post">
            
            <p>Please select the desired parameter and filter. If two are selected, there will be two search results displayed. </p>
            
            <h4>Search Query 1</h4>
            <input type="radio" id="sex1" name="group1" value="Sex"> Sex <br/>
            <input type="radio" id="age1" name="group1" value="Age" > Age Range <br/>
            <input type="radio" id="race1" name="group1" value="Race" > Race <br/>
            <br/>
            <select name="demo1" id="demo1">
                <option name="pop1" value="1"></option>
            </select>
            
            <br /><br />
            
            <select name="question1" id="question1">
                <option value="Population">Population</option>
                <option value="Percent of total population">Percent of total population</option>
                <option value="Number of cases">Number of cases</option>
                <option value="Percent of all cases">Percent of all cases</option>
                <option value="Percent infected">Percent infected</option>
                <option value="Number of deaths">Number of deaths</option>
                <option value="Percent of all deaths">Percent of all deaths</option>
                <option value="Percent Dead">Percent Dead</option>
                <option value="Number with one dose of vaccine">Number with one dose of vaccine</option>
                <option value="Percent of all people with one dose">Percent of all people with one dose</option>
                <option value="Percent who have one dose">Percent who have one dose</option>
                <option value="Number fully vaccinated">Number fully vaccinated</option>
                <option value="Percent of all people fully vaccinated">Percent of all people fully vaccinated</option>
                <option value="Percent who are fully vaccinated">Percent who are fully vaccinated</option>
            </select>
            
            <br /><br />
            
            <h4>Search Query 2</h4>
            <input type="radio" id="sex2" name="group2" value="Sex"> Sex <br/>
            <input type="radio" id="age2" name="group2" value="Age" > Age Range <br/>
            <input type="radio" id="race2" name="group2" value="Race" > Race <br/>
            <br/>
            <select name="demo2" id="demo2">
                <option name="pop2" value="1"></option>
            </select>
            
            <br /><br />
            
            <select name="question2" id="question">
                <option value="Population">Population</option>
                <option value="Percent of total population">Percent of total population</option>
                <option value="Number of cases">Number of cases</option>
                <option value="Percent of all cases">Percent of all cases</option>
                <option value="Percent infected">Percent infected</option>
                <option value="Number of deaths">Number of deaths</option>
                <option value="Percent of all deaths">Percent of all deaths</option>
                <option value="Percent Dead">Percent Dead</option>
                <option value="Number with one dose of vaccine">Number with one dose of vaccine</option>
                <option value="Percent of all people with one dose">Percent of all people with one dose</option>
                <option value="Percent who have one dose">Percent who have one dose</option>
                <option value="Number fully vaccinated">Number fully vaccinated</option>
                <option value="Percent of all people fully vaccinated">Percent of all people fully vaccinated</option>
                <option value="Percent who are fully vaccinated">Percent who are fully vaccinated</option>
            </select>
            
            <br /><br /><br />
            
            <input type="submit" value="Submit">
        </form>
        
        <h3>All numbers are from the CDC's website. For more information, go to https://covid.cdc.gov/covid-data-tracker/#demographics</h3>
    </body>
</html>