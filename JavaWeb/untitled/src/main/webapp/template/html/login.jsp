<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="./template/css/login.css">
    <link rel="stylesheet" href="./template/css/login.css">
</head>

<body>
    <div class="wrapper">
        <p>Please Sign in</p>
        <form name="form" action="/untitled/login" method='POST'>
            <div class="form-group mb-3">
                <input type="email" size="50" name="email" id="email" class="form-control mb-1" placeholder="E-mail">
                <span id="emailMsg"></span>
            </div>

            <div class="form-group mb-3">
                <input type="password" size="50" name="password" id="password" class="form-control mb-1" placeholder="Password">
                <span id="passwordMsg"></span>
            </div>

            <div class="form-check mb-3">
                <input type="checkbox" name="checkbox" id="checkbox" class="form-check-input">
                <label for="checkbox" class="form-check-label">Remember Me</label>
            </div>
            <input type="submit" class="btn btn-block btn-success mb-3" id="login-btn" value="Login" >
            <a href="/untitled/register" class="text-primary ">Click here to Register</a>
        </form>
    </div>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js " integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN " crossorigin="anonymous "></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js " integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q " crossorigin="anonymous "></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js " integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl " crossorigin="anonymous "></script>
    <script src="./template/js/login.js"></script>
</body>

</html>