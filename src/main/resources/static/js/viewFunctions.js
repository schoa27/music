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

function showhideButton(id1, id2) {
    var a1 = document.getElementById(id1);
    var a2 = document.getElementById(id2);

    if (a1 != null && a1.style.display == 'none') {
        a1.style.display = 'block'
    };

    if (a2 != null && a2.style.display == 'block') {
            a2.style.display = 'none'
    };
}

function showhide(id1, id2) {
    var e1 = document.getElementById(id1);
    var e2 = document.getElementById(id2);

    if (e1.style.display == 'block') {
        e1.style.display = 'none'
        e2.style.display = 'block'
    } else {
        e1.style.display = 'block'
        e2.style.display = 'none'
    }
    ;

}