
let x;

$(document).ready(function() {


    // opening modal and setting previous information inside inputs
    $('.table .btn-warning').on('click', function (event) {
        event.preventDefault();

        var href = $(this).attr('href');

        $.get(href,function (task,status) {
            $('.myForm #id').val(task.id);
           $('.myForm #description').val(task.description);
        });

        $('#editModal').modal();

        console.log("Clicked on modal");

    });


   // const emptyInput = false;
    $('#addBtn').on('click', function(event) {


       // on button click , console.log when input field of id (inputTaskName) is empty
        console.log("Button clicked");

        const taskInput = document.getElementById("taskDesc");

        if(taskInput.value.length === 0) {
            alert("Description cannot be empty!");
        }


    });


    // when user click on the add button and the input is empty then provide a message
    // $('##addTask').validate({
    //
    //     rules: {
    //         task: "required",
    //         description: {
    //             required: true,
    //             minlength: 1
    //         },
    //         message: {
    //             task: "Task must not be empty!"
    //         }
    //
    //     }
    //
    //     }
    // )






    // x = 0;
    // // when user clicks on the 'Finished Button'
    // $('.table .btn-success').on('click',function(event) {
    //     event.preventDefault();
    //     const status = document.getElementById("statusId");
    //
    //     if(x === 0) {
    //         status.innerText = "Complete";
    //         x = 1;
    //     } else {
    //         status.innerText = "In progress";
    //         x = 0;
    //     }
    //
    //
    //     console.log(x);
    //
    // });











});