window.addEventListener('DOMContentLoaded', function (){

    const GET_BOOKS_URL ="http://localhost:8080/books"
    const div = document.querySelector("#div")

    function books() {
        fetch(GET_BOOKS_URL)
            .then(function (response) {
                return response.json();
            })
            .then(function (response) {
                console.log(response);
                response.forEach((element) => {
                    const h2 = document.createElement("h2");
                    h2.innerText = element.title;
                    const h31 = document.createElement("h3");
                    h31.innerText = element.isbn;
                    const h32 = document.createElement("h3");
                    h32.innerText = element.author;
                    div.appendChild(h2);
                    div.appendChild(h31);
                    div.appendChild(h32);
                });
            });
    }

    books();


















})