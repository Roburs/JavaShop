function acceptForm(){
    var name = document.getElementById('name').value.toString();
    var surname = document.getElementById('surname').value.toString();
    var orderId = document.getElementById('orderNumber').value.toString();

    $.ajax({
        url : "/cancel/order/" + orderId + "/" + name + "/" + surname,
        method : "post",
        data : JSON.stringify({
            "productId": orderId,
            "name": name,
            "surname": surname
        }),
        contentType: "application/json"
    })
}