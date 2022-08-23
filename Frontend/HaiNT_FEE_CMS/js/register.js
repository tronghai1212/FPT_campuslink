document.querySelector("#register-btn").addEventListener("click", validateRegister);

function validateRegister(event) {
    var isValid = true;
    var $email = document.getElementById("email");
    var emailMsg = document.getElementById("emailMsg");
    var $pass = document.getElementById("password");
    var passMgs = document.getElementById("passwordMsg");
    var $userName = document.getElementById("username");
    var userNameMsg = document.getElementById("userNameMsg");
    var $repassword = document.getElementById("repassword");
    var repasswordMsg = document.getElementById("repasswordMsg");
    emailMsg.classList.remove("errorMsg");
    $email.classList.remove("errorInput");
    emailMsg.innerHTML = "";
    passMgs.classList.remove("errorMsg");
    $pass.classList.remove("errorInput");
    passMgs.innerHTML = "";
    userNameMsg.classList.remove("errorMsg");
    $userName.classList.remove("errorInput");
    userNameMsg.innerHTML = "";
    repasswordMsg.classList.remove("errorMsg");
    $repassword.classList.remove("errorInput");
    repasswordMsg.innerHTML = "";
    if ($userName.value.length == 0) {
        isValid = false;
        $userName.classList.add("errorInput");
        userNameMsg.classList.add("errorMsg");
        userNameMsg.innerHTML = "Bạn không được bỏ trống";
    } else if ($userName.value.length < 3 || $userName.value.length > 30) {
        isValid = false;
        $userName.classList.add("errorInput");
        userNameMsg.classList.add("errorMsg");
        userNameMsg.innerHTML = "Sai định dạng";
    }
    if ($repassword.value.length == 0) {
        isValid = false;
        $repassword.classList.add("errorInput");
        repasswordMsg.classList.add("errorMsg");
        repasswordMsg.innerHTML = "Bạn không được bỏ trống";
    } else if ($repassword.value.length < 8 || $repassword.value.length > 30) {
        isValid = false;
        $repassword.classList.add("errorInput");
        repasswordMsg.classList.add("errorMsg");
        repasswordMsg.innerHTML = "Sai định dạng";
    }
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
    } else if ($email.value.length < 6) {
        isValid = false;
        $email.classList.add("errorInput");
        emailMsg.classList.add("errorMsg");
        emailMsg.innerHTML = "Sai định dạng";
    }
    if ($pass != $repassword) {
        isValid = false;
        $pass.classList.add("errorInput");
        passMgs.classList.add("errorMsg");
        $repassword.classList.add("errorInput");
        repasswordMsg.classList.add("errorMsg");
    }

    if (!isValid) {
        event.preventDefault();
    }
}