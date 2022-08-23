var flag = false;

document.querySelector("#login-btn").addEventListener("click", validateLogin);

function validateLogin(event) {
    var isValid = true;
    var $email = document.getElementById("email");
    var emailMsg = document.getElementById("emailMsg");
    var $pass = document.getElementById("password");
    var passMgs = document.getElementById("passwordMsg");
    emailMsg.classList.remove("errorMsg");
    $email.classList.remove("errorInput");
    emailMsg.innerHTML = "";
    passMgs.classList.remove("errorMsg");
    $pass.classList.remove("errorInput");
    passMgs.innerHTML = "";
    if ($pass.value.length == 0) {
        isValid = false;
        $pass.classList.add("errorInput");
        passMgs.classList.add("errorMsg");
        passMgs.innerHTML = "Bạn không được bỏ trống";
    } else if ($pass.value.length < 8 || $pass.value.length > 30) {
        isValid = false;
        $pass.classList.add("errorInput");
        passMgs.classList.add("errorMsg");
        passMgs.innerHTML = "Sai định dạng";
    }
    if ($email.value.length == 0) {
        isValid = false;
        $email.classList.add("errorInput");
        emailMsg.classList.add("errorMsg");
        emailMsg.innerHTML = "Bạn không được bỏ trống";
    } else if ($email.value.length < 6 || $email.value.length > 50) {
        isValid = false;
        $email.classList.add("errorInput");
        emailMsg.classList.add("errorMsg");
        emailMsg.innerHTML = "Sai định dạng";
    } else {
        flag = true;
    }

    if (!isValid) {
        event.preventDefault();
        // event.stopImmediatePropagation();
    }

}

function nextPage() {
    location.assign("../html/view.html");
}