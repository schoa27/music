function ChangeColor(tableRow, highLight) {
    if (highLight) {
        tableRow.style.backgroundColor = '#c0c0c0';//#dcfac9
    } else {
        tableRow.style.backgroundColor = '#ffffff'; //'white';
    }
}

function DetailGegevens(servlet) {
    document.location.href = servlet;
}
