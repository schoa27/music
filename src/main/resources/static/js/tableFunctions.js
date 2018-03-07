
$('#add-row').on('click', function (e) {
    e.preventDefault();
    var tableBody = $('.table > tbody'),
        lastRowClone = $('tr:last-child', tableBody).clone();
    $('input[type=text]', lastRowClone).val('');
    tableBody.append(lastRowClone);
});

$('.table').on('click', '.remove-row', function (e) {
    e.preventDefault();
    var row = $(this).parent().parent();
    row.remove();
})