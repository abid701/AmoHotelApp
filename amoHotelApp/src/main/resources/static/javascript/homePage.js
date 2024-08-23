function myFunction(x) {
      x.classList.toggle("change");
      var menu = document.getElementById("menu");
      menu.classList.toggle("show");
    }

document.addEventListener('click', function(event) {
    var menu = document.getElementById("menu");
    var threeLineMenu = document.getElementById("three_line_menu");
    if (!menu.contains(event.target) && !threeLineMenu.contains(event.target)) {
        menu.classList.remove("show");
        threeLineMenu.classList.remove("change");
    }
});



document.addEventListener("DOMContentLoaded", function () {

    let zimmerImages = document.querySelectorAll('img[data-zimmerNr]');

    zimmerImages.forEach(function(imgElement) {
        let zimmerNr = imgElement.getAttribute('data-zimmerNr');

        imgElement.setAttribute("src", "/images/homePagePics/" + zimmerNr + ".jpg");
    });
});

