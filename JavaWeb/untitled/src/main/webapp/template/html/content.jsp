<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Index</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">
    <link rel="stylesheet" href="./template/css/style.css">
    <link rel="stylesheet" href="./template/css/main.css">
</head>

<body>
    <div class="container-fluid p-0">
        <nav class="navbar bg-light navbar-light d-flex justify-content-between p-0">
            <a href="#" class="navbar-brand px-3">CMS</a>
            <div class="user">
                <div class="nav-user btn btn-light text-info" id="nav-user">
                    <i class="fas fa-user"></i>
                    <i class="fas fa-sort-down sort-down"></i>
                </div>
                <div class="user-option" id="user-option">
                    <div class="user-profile btn btn-light" id="btn-profile">
                        <i class=" fas fa-user"></i>
                        <a href="/untitled/profile"><span>User Profile</span></a>
                    </div>
                    <div class="logout btn btn-light">
                        <i class="fas fa-sign-out-alt"></i>
                        <a href="/untitled/logout"><span>Logout</span></a>
                    </div>
                </div>
            </div>
        </nav>

        <div class="main row">
            <div class="col-3 p-0 bg-light" id="menu">
                <ul class="list-group d-flex flex-column">
                    <li class="list-group-item d-flex px-3 border-top-0 border-right-0">
                        <input type="text" size="50" id="search-input" class="form-control form-control-fluid" placeholder="Search...">
                        <button class="btn btn-light border" id="search-btn"><i class="fas fa-search"></i></button>
                    </li>
                    <li class="list-group-item px-3 btn btn-light text-left text-primary border-right-0" id="btn-view-content">
                        <i class="fas fa-table"></i>
                        <a href="/untitled/view"><span>View contents</span></a>
                    </li>
                    <li class="list-group-item px-3 btn btn-light text-left text-primary border-right-0" id="btn-form-content">
                        <i class="far fa-edit"></i>
                        <a href="/untitled/content"><span>Form content</span></a>
                    </li>
                </ul>
            </div>
            <div class="col-9" id="content-view">
                <h3 id="loading">Loading</h3>



                <!-- Form content -->
                <div class="container">
                    <h1 class="mt-4" id="h1">Add Content</h1>
                    <hr>
                    <div class="wrapper-form-content mt-3" id="wrapper-form-content">
                        <p class="px-3 py-2 bg-light mb-2">Content Form Elements</p>
                        <form class="px-3" name="form" action="/untitled/content" method='POST' onsubmit="return validate()">
                            <div class="form-group mb-3">
                                <label for="title" class="mb-1">Title</label>
                                <input type="text" size="50" id="title" name="title" class="form-control form-control-sm" placeholder="Enter the title">
                                <span id="titleErr"></span>
                            </div>
                            <div class="form-group mb-3">
                                <label for="brief" class="mb-1">Brief</label>
                                <textarea id="brief" name="brief" cols="30" rows="3" class="form-control form-control-sm"></textarea>
                                <span id="briefErr"></span>
                            </div>
                            <div class="form-group mb-3">
                                <label for="content" class="mb-1">Content</label>
                                <textarea id="content" name="content" cols="30" rows="5" class="form-control form-control-sm"></textarea>
                                <span id="contentErr"></span>
                            </div>
                            <div class="btn-group mb-3">
                                <input class="btn btn-light btn-sm border mr-2" value="Submit" type="submit" ></input>
                                <input class="btn btn-light btn-sm border" onclick="clearForm()" value="Reset" type="reset"></input>
                            </div>
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
    <script src="./template/js/content.js"></script>
</body>

</html>