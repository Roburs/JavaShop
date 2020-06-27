function order(productId){
    var name = document.getElementById('name').value.toString();
    var surname = document.getElementById('surname').value.toString();
    var id = productId;

    $.ajax({
        url : "/save/order/" + id + "/" + name + "/" + surname,
        method : "post",
        data : JSON.stringify({
            "productId": id,
            "name": name,
            "surname": surname
        }),
        contentType: "application/json"
    })


}