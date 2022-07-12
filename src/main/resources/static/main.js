



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
    $('#addBtn').on('click', function() {


       // on button click , console.log when input field of id (inputTaskName) is empty
        console.log("Button clicked");

        const taskInput = document.getElementById("taskDesc");

        // alert the user when the task description length is less than or equal to 1
        if(taskInput.value.length <= 1) {
            alert("Description cannot be empty!");
        }


    });

    const body = document.getElementById("bodyId");
    const table = document.querySelector("table")
    const moonBtn = document.getElementById('darkModeBtn');
    const moonIcon = moonBtn.children[0];
    const footer = document.querySelectorAll('a');


    const darkMode = () => {
        body.className = "dark-mode";
        table.style.setProperty("color","white");
        moonBtn.className = "btn btn-light";
        moonIcon.className = "bi bi-moon text-black";
        localStorage.setItem('dark', "true");

        footer.forEach((a) => {
            a.style.setProperty('--social-link-color', 'white');
        });

    }

    const lightMode = () => {
        body.className = "";
        table.style.setProperty("color","black");
        moonBtn.className = "btn btn-dark";
        moonIcon.className = "bi bi-moon text-white";
        localStorage.setItem('dark', "false");


        footer.forEach((a) => {
            a.style.setProperty('--social-link-color', 'black');
        });


    }

    if(localStorage.getItem("dark") === "true") {
        darkMode();
    }

    // Using localStorage to keep darkMode on when an item is added or when page is refreshed
    $('#darkModeBtn').on('click',function () {





        console.log("Dark mode button has been clicked");

        if(localStorage.getItem('dark') === "false") {
            darkMode();
        } else {
            lightMode();
        }



    });



});