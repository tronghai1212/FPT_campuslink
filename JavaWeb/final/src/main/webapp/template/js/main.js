function validate() {
    var isValid = true;
    var balance = document.getElementById("balance").value;
    var amount = document.getElementById("amount").value;
	
    document.getElementById("err").innerHTML = "";
	
	if (amount == "") {
		document.getElementById("err").innerHTML = " * Amount must not be blank";
        isValid = false;
	}
	else if (amount < 0) {
		document.getElementById("err").innerHTML = " * Amount must be greatter than 0";
        isValid = false;
	}
    else if (amount - balance > 0) {
        document.getElementById("err").innerHTML = " * Amount must be less than balance";
        isValid = false;
    }else {
        isValid = true;
    }

    if (!isValid){
        return false;
    }   
}