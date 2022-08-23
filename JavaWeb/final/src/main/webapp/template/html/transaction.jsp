<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="entities.AccountEntity"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="./template/css/style.css">
  </head>
<body>
    <div class="container mt-3">
        <div class="card border-custom">
            <div class="card-header bg-white p-3 pl-5">
                <p class="mb-0 form-title">Banking System</p>
            </div>
        	<div class="card-body m-0 p-0">
            	<div class="row m-0 ">
                	<div class="col-3 col-boder m-0 p-0">
                    	<div class="ml-5">
                        	<p class="h4 mt-3 mb-3">HaiNT9</p>
                        	<a href="/final/transaction">Transfer</a>
                        	<br>
                        	<a href="/final/logout">Logout</a>
                    	</div>
                	</div>
                	<div class="col-9">
                    	<form method='POST' action="/final/transaction" class="m-3" onsubmit="return validate()">
                        	<div class="form-group">
                            	<label for="balance"><b>Your Balance</b></label>
                            	<%AccountEntity entity = (AccountEntity)request.getSession().getAttribute("account"); %>
                            	<input type="number" class="form-control" id="balance" readonly name="balance" value="<%=entity.getBalance()%>">
                        	</div>
                        	<div class="form-group">
                            	<label for="amount"><b>Enter amount</b><span class="err" id="err"></span></label>
                            	<input type="number" class="form-control" id="amount" name="amount">
                        	</div>
                        	<div class="form-group" >
                            	<label for="accountReceive"><b>Select account to transfer</b></label>
                            	<select class="select form-control" name="accountReceive" id="accountReceive">
                            	</select>
                        	</div>
                        	<div class="form-group">
                            	<label for="note"><b>Transaction note</b></label>
                            	<textarea class="form-control" name="note" id="note" rows="3"></textarea>
                        	</div>
                        	<button type="submit" class="btn btn-light text-dark pr-lg-5 pl-lg-5">Transfer</button>
                        	<p class="err">${NOTIFICATION}</p>
                    	</form>
                	</div>
            	</div>
            </div>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
    <script src="./template/js/main.js"></script>
    <script src="./template/js/ajax.js"></script>
</body>
</html>