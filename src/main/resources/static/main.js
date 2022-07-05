
let x;
// opening modal and setting previous information inside inputs
$(document).ready(function() {

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



    x = 0;
    // when user clicks on the 'Finished Button'
    $('.table .btn-success').on('click',function(event) {
        event.preventDefault();
        const status = document.getElementById("statusId");

        if(x === 0) {
            status.innerText = "Complete";
            x = 1;
        } else {
            status.innerText = "In progress";
            x = 0;
        }


        console.log(x);

    });











});