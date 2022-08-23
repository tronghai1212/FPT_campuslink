function loadView() {
    $.ajax({
        url: 'http://localhost:8080/final/get-list', // url where to submit the request
        type: "GET", // type of action POST || GET
        contentType: "application/json",
        dataType: 'json', // data type
        //data: JSON.stringify(data),
        success: function (result) {
        console.log(result);
            for(let i = 0; i < result.length; i++){
                $('#accountReceive').append(
                `<option class="acc">

                </option>`);

            }
            //   console.log(result)
              for (let i = 0; i < result.length; i++) {
                  document.getElementsByClassName("acc")[i].innerHTML = result[i].account;
              }
        },
    });
}

loadView();