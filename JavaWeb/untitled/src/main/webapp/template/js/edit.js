function validate() {
	let isValid = true;
    let fname = document.getElementById("firstname").value;
    let lname = document.getElementById("lastname").value;
    let phone = document.getElementById("phone").value;
    let description = document.getElementById("description").value;

    document.getElementById("fNameErr").innerHTML = "";
    document.getElementById("lNameErr").innerHTML = "";
    document.getElementById("phoneErr").innerHTML = "";
    document.getElementById("desErr").innerHTML = "";

    if (fname == "") {
        document.getElementById("fNameErr").innerHTML = "Please fill out this field.";
        isValid = false;
    }

    else if (fname.length < 3 || fname.length > 30) {
        document.getElementById("fNameErr").innerHTML = "First name must be between 3 and 30 in length";
        isValid = false;
    }

    if (lname == "") {
        document.getElementById("lNameErr").innerHTML = "Please fill out this field.";
        isValid = false;
    }

    else if (lname.length < 3 || lname.length > 30) {
        document.getElementById("lNameErr").innerHTML = "Last name must be between 3 and 30 in length";
        isValid = false;
    }

    if (phone == "") {
        document.getElementById("phoneErr").innerHTML = "Please fill out this field.";
        isValid = false;
    }

    else if (phone.length < 9 || phone.length > 13) {
        document.getElementById("phoneErr").innerHTML = "Phone must be between 9 and 13 in length";
        isValid = false;
    }

    else if (phone.match('[^0-9]')) {
        document.getElementById("phoneErr").innerHTML = "Phone doesn't contain letter";
        isValid = false;
    }

    if (description.length > 200) {
        document.getElementById("desErr").innerHTML = "Description must max 200 in length";
        isValid = false;
    }

    if(!isValid) {
		return false;
	}
}

function resetForm() {
	document.getElementById("firstName").value = "";
    document.getElementById("lastName").value = "";
    document.getElementById("phone").value = "";
    document.getElementById("description").value = "";
    document.getElementById("fNameErr").innerHTML = "";
    document.getElementById("lNameErr").innerHTML = "";
    document.getElementById("phoneErr").innerHTML = "";
    document.getElementById("desErr").innerHTML = "";
}