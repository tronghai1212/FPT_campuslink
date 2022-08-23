<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="./template/css/style.css">
    <link rel="stylesheet" href="./template/css/register.css">
</head>

<body>
    <div class="wrapper">
        <p>Register</p>
        <form name="form" action='/untitled/register' method='POST'>
            <div><input type="text" name="username" id="username" class="form-control mb-3" placeholder="User name">
                <span id="userNameMsg"></span>
            </div>
            <div><input type="text" size="50" name="email" id="email" class="form-control mb-3" placeholder="E-mail">
                <span id="emailMsg"></span>
            </div>
            <div><input type="password" size="50" name="password" id="password" class="form-control mb-3" placeholder="Password">
                <span id="passwordMsg"></span>
            </div>
            <div><input type="password" size="50" name="repassword" id="repassword" class="form-control mb-3" placeholder="Re password">
                <span id="repasswordMsg"></span>
            </div>
            <input type="submit" class="btn btn-block btn-success mb-3" id="register-btn" value="Register"></input>
            <a href="/untitled/login" class="text-primary">Click here to Login</a>
        </form>
    </div>

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <script src="./template/js/register.js"></script>
</body>

</html>