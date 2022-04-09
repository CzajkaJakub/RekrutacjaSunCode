function loadTable() {
    let request = new XMLHttpRequest();
    request.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {

            let parsedJSON = JSON.parse(this.responseText);

            let htmlTable =`<table class="container" id="table"><thead><tr>
                                <th scope="col"><h1>Id</h1></th>
                                <th scope="col"><h1>Kolumna1</h1></th>
                                <th scope="col"><h1>Kolumna2</h1></th>
                                <th scope="col"><h1>Kolumna3</h1></th>
                                <th scope="col"><h1>Kolumna4</h1></th>
                            </tr></thead><tbody>`

            for (let i = 0; i < parsedJSON.length; i++) {
                htmlTable = htmlTable + "<tr>" +
                    "<td>" + parsedJSON[i].id + "</td>" +
                    "<td>" + parsedJSON[i].kolumna1 + "</td>" +
                    "<td>" + parsedJSON[i].kolumna2 + "</td>" +
                    "<td>" + parsedJSON[i].kolumna3 + "</td>" +
                    "<td>" + parsedJSON[i].kolumna4 + "</td>" +
                    "</tr>"
            }

            htmlTable = htmlTable +"</tbody></table>";
            console.log(htmlTable)
            document.getElementsByClassName("content")[0].innerHTML = htmlTable;
        }
    };

    let selectedColumnElement = document.getElementById('column');
    let selectedColumn = selectedColumnElement.options[selectedColumnElement.selectedIndex].value;

    let selectedTypeElement = document.getElementById('searchType');
    let selectedType = selectedTypeElement.options[selectedTypeElement.selectedIndex].value;

    request.open("GET", "showRows?column=" + selectedColumn + "&searchType=" + selectedType, true);
    request.send();
}