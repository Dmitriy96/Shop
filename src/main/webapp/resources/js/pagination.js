$.getScript("resources/js/paginationPlugin.min.js", function () {
    $('#pagination').twbsPagination({
        totalPages: document.getElementById("pagesNumber").value,
        visiblePages: 5,
        onPageClick: function () {
            //ajax data request
        }
    });
});