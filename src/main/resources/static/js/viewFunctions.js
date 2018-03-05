function ChangeColor(tableRow, highLight) {
    if (highLight) {
        tableRow.style.backgroundColor = '#949494'; //'donkergrijs'
    } else {
        tableRow.style.backgroundColor = '#D3D3D3'; //'lightgrijs';
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

function disableselection(id) {
    var s1 = document.getElementById(id);

    if (s1.value = 0 && s1 == 'artist') {
        document.getElementById('group').disabled = false;
        document.getElementById('artist').disabled = true;
    } else {
        document.getElementById('artist').disabled = false;
        document.getElementById('group').disabled = true;
    }
}

function enableselection() {
    document.getElementById('group').disabled = false;
    document.getElementById('artist').disabled = false;

}