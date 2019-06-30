$('.add-shoping-basket-button').on('click', function () {
    if($(this).attr("data-in-bin") == "true") return;
    $(this).attr("data-in-bin","true");
    var itemId = $(this).attr("data-item-id");
    $(this).attr("class","btn btn-raised btn-success ml-5 add-shoping-basket-button");
    $(this).html('<i class="fas fa-check-circle item__shopping-basket-icon"></i>');

    var xhr = new XMLHttpRequest();

    var body = 'id=' + encodeURIComponent(itemId);

    xhr.open("POST", "/bin/add", true);
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');

    xhr.send(body);

    var count = $('#shoping-basket-counter').html();
    var intCount = (count == undefined) ? 0 : parseInt(count);
    intCount++;
    console.log(intCount);
    $('#nav-basket-link').html(`
                <i class="fas fa-shopping-basket"></i>
                <span class="badge badge-primary badge-pill shoping-basket-badge" id="shoping-basket-counter">` + intCount + `</span>
            `);
});