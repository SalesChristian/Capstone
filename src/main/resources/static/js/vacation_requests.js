$(document).ready(function() {
    $(".date-picker").flatpickr({
        dateFormat: "Y-m-d"
    });

    $(".approve-button").click(function() {
        const requestId = $(this).attr("data-id");
        $.post("/vacation_requests/approve", { id: requestId }, function() {
            location.reload();
        });
    });

    $(".reject-button").click(function() {
        const requestId = $(this).attr("data-id");
        $.post("/vacation_requests/reject", { id: requestId }, function() {
            location.reload();
        });
    });
});