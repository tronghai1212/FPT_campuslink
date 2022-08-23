function loadView() {
    $.ajax({
        url: 'http://localhost:8081/untitled/get-list', // url where to submit the request
        type: "GET", // type of action POST || GET
        contentType: "application/json",
        dataType: 'json', // data type
        //data: JSON.stringify(data),
        success: function (result) {
            for(let i = 1; i < result.length; i++){
                $('#output').append(
                `<tr>
                    <td class="id"> </td>
                    <td class="title"> </td>
                    <td class="brief"> </td>
                    <td class="date"> </td>
                </tr>`);

            }
            //   console.log(result)
              for (let i = 0; i < result.length; i++) {
                  document.getElementsByClassName("id")[i].innerHTML = result[i].id;
                  document.getElementsByClassName("title")[i].innerHTML = result[i].title;
                  document.getElementsByClassName("brief")[i].innerHTML =result[i].brief;
                  document.getElementsByClassName("date")[i].innerHTML = result[i].createdDate;
              }
        },
    });
}

loadView();