$(document).ready(function(){
    console.log("on scroll file");
    window.onscroll = function() {
        console.log("scrolled");
        var container = document.getElementsByClassName("container").value;
        var currentPageNumber = document.getElementById("currentPageNumber").value;
        /*$.ajax({
            type : "GET",
            contentType : "application/json",
            url : "laptops",
            data : 2,
            dataType : 'json',
            timeout : 100000,
            success : function(data) {
                console.log("SUCCESS: ", data);
                display(data);
            },
            error : function(e) {
                console.log("ERROR: ", e);
                display(e);
            },
            done : function(e) {
                console.log("DONE");
            }
        });*/
        /*$.get("/test/ajaxtest", function(data,status){
            alert("Data: " + data + "\nStatus: " + status);
        });*/
    }
});