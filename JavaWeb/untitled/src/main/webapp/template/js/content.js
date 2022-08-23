
function validate() {
    var isValid = true;
    let title = document.getElementById("title").value;
    let brief = document.getElementById("brief").value;
    let content = document.getElementById("content").value;
    clearForm();

    if (title == "") {
        document.getElementById("titleErr").innerHTML = "Please fill out this field.";
        isValid = false;
    }

    else if (title.length < 10 || title.length > 200) {
        document.getElementById("titleErr").innerHTML = "Title must be between 10 and 200 in length";
        isValid = false;
    }

    if (brief == "") {
        document.getElementById("briefErr").innerHTML = "Please fill out this field.";
        isValid = false;
    }

    else if (brief.length < 30 || brief.length > 150) {
        document.getElementById("briefErr").innerHTML = "Brief must be between 30 and 150 in length";
        isValid = false;
    }

    if (content == "") {
        document.getElementById("contentErr").innerHTML = "Please fill out this field.";
        isValid = false;
    }

    else if (content.length < 50 || content.length > 1000) {
        document.getElementById("contentErr").innerHTML = "Brief must be between 50 and 1000 in length";
        isValid = false;
    }

    if(!isValid) {
        return false;
    }
}

function clearForm() {
    document.getElementById("titleErr").innerHTML = "";
    document.getElementById("briefErr").innerHTML = "";
    document.getElementById("contentErr").innerHTML = "";
}

setTimeout(function() {
    $(".loading").addClass("hidden");
    $(".main-content").addClass("display");
},2000)