document.addEventListener('DOMContentLoaded', function() {
    let calendarEl = document.getElementById('calendar');
    let calendar = new FullCalendar.Calendar(calendarEl, {
        initialView: 'dayGridMonth',
        headerToolbar: {
            left: 'prev,next today',
            center: 'title',
            right: 'dayGridMonth,timeGridWeek,timeGridDay'
        },
        events: function (fetchInfo, successCallback, failureCallback) {
            $.ajax({
                url: '/api/vacation_requests',
                method: 'GET',
                success: function (data) {
                    const events = data.map(function (request) {
                        return {
                            title: request.username,
                            start: request.startDate,
                            end: request.endDate,
                            color: request.role === 'ROLE_ADMIN' ? 'red' : 'yellow'
                        };
                    });
                    successCallback(events);
                },
                error: function () {
                    failureCallback([]);
                }
            });
        }
    });
    calendar.render();
});
