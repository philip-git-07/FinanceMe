<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<script>

function createBanking(){
	var form = document.getElementById("bankingForm");
	form.action="createbanking";
	//alert (document.getElementById("bankingForm").action);
	form.method="POST";
	form.method.type="POST";
	//alert (document.getElementById("bankingForm").method);
	form.submit();
}

function updateBanking(){
	var form = document.getElementById("bankingForm");
	form.action="updatebanking";
	form.method="PUT";
	form.method.type="PUT";
	form.submit();
}

function deleteBanking(){
	var form = document.getElementById("bankingForm");
	form.action="deletebanking";
	form.method="DELETE";
	form.method.type="DELETE";
	form.submit();
}
</script>    

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>FinanceMe Banking Project</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #a6ddbc;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            
            height: 100vh;
        }
        .container {
            width: 80%;
            max-width: 600px;
            padding: 20px;
            background-color: #ccffcc;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
        }
        .form-header {
            text-align: center;
            margin-bottom: 20px;
        }
        label {
            display: block;
            margin-bottom: 5px;
        }
        input[type="text"] {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #cccccc;
            border-radius: 3px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
            background-color: #f2f2f2;
        }
        .buttons {
            text-align: center;
            margin-top: 20px;
        }
        input[type="submit"], input[type="button"] {
            background-color: #007bff;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 3px;
            cursor: pointer;
            margin: 5px;
        }
    </style>
</head>
<body>
    <div style="margin: 5px 10px 5px 0;">
        <h3 class="form-header">FinanceMe Bank Registartion</h3>
        <form action="addbanking" id="bankingForm" type="POST">
            <label for="id">Enter your Account number:</label>
            <input type="text" name="id" id="id" size="20">

            <label for="name">Enter your name:</label>
            <input type="text" name="name" id="name" size="20">

            <label for="address">Enter your address:</label>
            <input type="text" name="address" id="address" size="50">

            <label for="contact">Enter your contact:</label>
            <input type="text" name="contact" id="contact" size="50">
            
            <div class="buttons">
                <input type="submit" value="Create Account" onclick="createBanking()">
                <input type="button" value="Update Account" onclick="updateBanking()">
                <input type="button" value="Delete Account" onclick="deleteBanking()">
            </div>
             </form>
    </div>    
    <div>  
    <h4>Account Details</h4>
            <table>
                <thead>
                    <tr>
                        <th>Account No</th>
                        <th>Customer Name</th>
                        <th>Customer Address</th>
                        <th>Contact Number</th>
                    </tr>
                </thead>
                <tbody>
                    
                  <c:forEach items="${bankingList}" var="banking">
      
			        <tr>
			          <td style="border: 1px solid #ddd; padding: 8px; text-align: left; background-color: #f2f2f2;">${banking.bankingId}</td>
			          <td style="border: 1px solid #ddd; padding: 8px; text-align: left; background-color: #f2f2f2;">${banking.customerName}</td>
			          <td style="border: 1px solid #ddd; padding: 8px; text-align: left; background-color: #f2f2f2;">${banking.customerAddress}</td>
			          <td style="border: 1px solid #ddd; padding: 8px; text-align: left; background-color: #f2f2f2;">${banking.contactNumber}</td>
			        </tr>
			      </c:forEach>
                </tbody>
            </table>

            
       </div>
       
    
</body>
</html>

