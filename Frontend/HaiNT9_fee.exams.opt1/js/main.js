function clearForm() {
    document.getElementById("firstNameError").innerHTML = "";
    document.getElementById("lastNameError").innerHTML = "";
    document.getElementById("emailError").innerHTML = "";
    document.getElementById("phoneError").innerHTML = "";
}

var countryObject = {
    "Vietnam": {},
    "Singapore": {},
    "Malaysia": {},
    "Indonesia": {},
    "Phillippine": {},
    "Lao": {},
    "Cambodia": {}

}

var positionObject = {
    "Operator": {},
    "Manager": {},
    "Developer": {},
    "Designer": {},
    "Tester": {}

}
window.onload = function() {
    var countrySel = document.getElementById("country");
    for (var x in countryObject) {
        countrySel.options[countrySel.options.length] = new Option(x, x);
    }
    var positionSel = document.getElementById("position");
    for (var x in positionObject) {
        positionSel.options[positionSel.options.length] = new Option(x, x);
    }

}


document.getElementById("submit").addEventListener('click', validate);

function validate(event) {
    var isValid = true;
    var firstName = document.getElementById("firstName").value;
    var lastName = document.getElementById("lastName").value;
    var email = document.getElementById("email").value;
    var phone = document.getElementById("phone").value;
    var countrySelect = document.getElementById("country").value;
    var positionSelect = document.getElementById("position").value;
    var regexEmail = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
    var regexPhone = "[0-9]{3}-[0-9]{3}-[0-9]{4}";
    document.getElementById("firstNameError").innerHTML = "";
    document.getElementById("lastNameError").innerHTML = "";
    document.getElementById("emailError").innerHTML = "";
    document.getElementById("phoneError").innerHTML = "";
    document.getElementById("countryError").innerHTML = "";
    document.getElementById("positionError").innerHTML = "";
    if (firstName == "") {
        isValid = false;
        document.getElementById("firstNameError").innerHTML = "The First Name should not be blank";
    }
    if (lastName == "") {
        isValid = false;
        document.getElementById("lastNameError").innerHTML = "The Last Name should not be blank.";
    }
    if (email.length == 0) {
        console.log(email);
        isValid = false;
        document.getElementById("emailError").innerHTML = "The Email should not be blank.";
    } else if (!email.match(regexEmail)) {
        isValid = false;
        document.getElementById("emailError").innerHTML = "Please enter your correct email address.";
    }
    if (!phone.match(regexPhone)) {
        isValid = false;
        document.getElementById("phoneError").innerHTML = "Please enter your correct phone number.";
    }
    if (countrySelect == "") {
        isValid = false;
        document.getElementById("countryError").innerHTML = "Please select your country.";
    }
    if (positionSelect == "") {
        isValid = false;
        document.getElementById("positionError").innerHTML = "Please select your position.";
    }
    if (!isValid) {
        event.preventDefault();
    }

}


function phone_formatting(ele, restore) {
    var new_number,
        selection_start = ele.selectionStart,
        selection_end = ele.selectionEnd,
        number = ele.value.replace(/\D/g, '');

    // automatically add dashes
    if (number.length > 2) {
        // matches: 123 || 123-4 || 123-45
        new_number = number.substring(0, 3) + '-';
        if (number.length === 4 || number.length === 5) {
            // matches: 123-4 || 123-45
            new_number += number.substr(3);
        } else if (number.length > 5) {
            // matches: 123-456 || 123-456-7 || 123-456-789
            new_number += number.substring(3, 6) + '-';
        }
        if (number.length > 6) {
            // matches: 123-456-7 || 123-456-789 || 123-456-7890
            new_number += number.substring(6);
        }
    } else {
        new_number = number;
    }

    ele.value = (new_number.length > 12) ? new_number.substring(0, 12) : new_number;

}

function phone_number_check(field, e) {
    var key_code = e.keyCode,
        key_string = String.fromCharCode(key_code),
        press_delete = false,
        dash_key = 189,
        delete_key = [8, 46],
        direction_key = [33, 34, 35, 36, 37, 38, 39, 40],
        selection_end = field.selectionEnd;

    // delete key was pressed
    if (delete_key.indexOf(key_code) > -1) {
        press_delete = true;
    }

    // only force formatting is a number or delete key was pressed
    if (key_string.match(/^\d+$/) || press_delete) {
        phone_formatting(field, press_delete);
    }
    // do nothing for direction keys, keep their default actions
    else if (direction_key.indexOf(key_code) > -1) {
        // do nothing
    } else if (dash_key === key_code) {
        if (selection_end === field.value.length) {
            field.value = field.value.slice(0, -1)
        } else {
            field.value = field.value.substring(0, (selection_end - 1)) + field.value.substr(selection_end)
            field.selectionEnd = selection_end - 1;
        }
    }
    // all other non numerical key presses, remove their value
    else {
        e.preventDefault();
        //    field.value = field.value.replace(/[^0-9\-]/g,'')
        phone_formatting(field, 'revert');
    }

}
document.getElementById("phone").onkeyup = function(e) {
    phone_number_check(this, e);
}