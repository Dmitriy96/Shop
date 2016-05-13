$(document).ready(function(){
    checkBasketEmpty();
    function checkBasketEmpty() {
        var emptyBasketMessage = document.getElementById("emptyBasket");
        var purchaseButton = document.getElementById("purchaseButton");
        if (emptyBasketMessage)
            purchaseButton.classList.add("disabled");
        else
            purchaseButton.classList.remove("disabled");
    }
    var deleteButtons = document.getElementsByName("removeLaptop");
    for (var i = 0; i < deleteButtons.length; i++) {
        deleteButtons[i].onclick = function() {
            var form = document.getElementById("form");
            form.action = this.getAttribute("data-url");
            form.submit();
        };
    }
    document.getElementById("purchaseButton").onclick = function() {
        var form = document.getElementById("form");
        form.action = this.getAttribute("data-url");
        form.submit();
    };
});