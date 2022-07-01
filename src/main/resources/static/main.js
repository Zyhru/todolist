

// opening modal and setting previous information inside inputs
$(document).ready(function() {

    $('.table .btn-warning').on('click', function (event) {
        event.preventDefault();

        var href = $(this).attr('href');

        $.get(href,function (task,status) {
            $('.myForm #id').val(task.id);
           $('.myForm #description').val(task.description);
        });

        $('#editModal').modal('show');

        console.log("Clicked on modal");

    });




});