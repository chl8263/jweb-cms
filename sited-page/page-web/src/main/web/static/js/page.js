window.app = {
    user: function () {
        return $.ajax("/web/api/user/user-info", {
            method: "GET",
            contentType: "application/json",
            dataType: "json",
            accept: "application/json"
        });
    }
};

$(function () {
    $(".page__fragment-carousel").each(function (index, node) {
        $(node).slick({
            prevArrow: "<a href='javascript:void(0)' class='slick-arrow slick-prev'><img src='data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiA/PjxzdmcgaWQ9IkxheWVyXzEiIHN0eWxlPSJlbmFibGUtYmFja2dyb3VuZDpuZXcgMCAwIDQ4IDQ4OyIgdmVyc2lvbj0iMS4xIiB2aWV3Qm94PSIwIDAgNDggNDgiIHhtbDpzcGFjZT0icHJlc2VydmUiIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgeG1sbnM6eGxpbms9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkveGxpbmsiPjxnPjxwb2x5Z29uIHBvaW50cz0iMzAuOCw0NS43IDkuMSwyNCAzMC44LDIuMyAzMi4yLDMuNyAxMS45LDI0IDMyLjIsNDQuMyAgIi8+PC9nPjwvc3ZnPg==' alt=''></a>",
            nextArrow: "<a href='javascript:void(0)' class='slick-arrow slick-next'><img src='data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiA/PjxzdmcgaWQ9IkxheWVyXzEiIHN0eWxlPSJlbmFibGUtYmFja2dyb3VuZDpuZXcgMCAwIDQ4IDQ4OyIgdmVyc2lvbj0iMS4xIiB2aWV3Qm94PSIwIDAgNDggNDgiIHhtbDpzcGFjZT0icHJlc2VydmUiIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgeG1sbnM6eGxpbms9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkveGxpbmsiPjxnPjxwb2x5Z29uIHBvaW50cz0iMTEuOCw0NS43IDEwLjQsNDQuMyAzMC44LDI0IDEwLjQsMy43IDExLjgsMi4zIDMzLjUsMjQgICIvPjwvZz48L3N2Zz4=' alt=''></a>"
        });
    });
});

