function loadTable() {
    let request = new XMLHttpRequest();
    console.log("XD")
    request.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            document.getElementById("table").innerHTML = this.responseText;
        }
    };

    let selectedColumnElement = document.getElementById('column');
    let selectedColumn = selectedColumnElement.options[selectedColumnElement.selectedIndex].value;

    let selectedTypeElement = document.getElementById('searchType');
    let selectedType = selectedTypeElement.options[selectedTypeElement.selectedIndex].value;

    request.open("GET", "showRows?column=" + selectedColumn + "&searchType=" + selectedType, true);
    request.send();
}