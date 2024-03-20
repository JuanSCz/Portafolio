const header = document.querySelector("header");
window.addEventListener("scroll", function () {
    header.classList.toggle("sticky", this.window.scrollY > 100);
});

let menu = document.querySelector('#menu-icon');
let navlist = document.querySelector('.navlist');

menu.onclick = () => {
    menu.classList.toggle('bx-x');
    navlist.classList.toggle('open');
};

window.onscroll = () => {
    menu.classList.remove('bx-x');
    navlist.classList.remove('open');
};

document.addEventListener('DOMContentLoaded', function () {
    var typed = new Typed("#typed-output", {
        strings: ["Programador Java Jr"],
        typeSpeed: 70,
        backSpeed: 55,
        backDelay: 1000,
        startDelay: 500,
        loop: true
    });
});

document.addEventListener("DOMContentLoaded", function () {
    var links = document.querySelectorAll('header a');

    links.forEach(function (link) {
        link.addEventListener('click', function (e) {
            e.preventDefault();

            var targetId = this.hash.substring(1);
            var targetElement = document.getElementById(targetId);

            if (targetElement) {
                var offset = document.querySelector('header').offsetHeight;
                var targetOffset = targetElement.offsetTop - offset;

                window.scrollTo({
                    top: targetOffset,
                    behavior: 'smooth'
                });
            }
        });
    });
});


document.addEventListener('DOMContentLoaded', function () {
    var certificados = [
        ["images/fullStackEgg.png", "images/certificadoSpring.png"],
        ["images/certificateCodoACodo.jpg", "images/certificateCodoACodo.jpg"]
    ];

    var contenedorFlotante = crearContenedorFlotante("contenedorFlotante", certificados);

    var certificadoButtonUno = document.getElementById("buttonCertificadoUno");
    var certificadoButtonDos = document.getElementById("buttonCertificadoDos");

    certificadoButtonUno.addEventListener("click", function (e) {
        e.preventDefault();
        mostrarContenedorFlotante(contenedorFlotante, certificados[1]);
    });

    certificadoButtonDos.addEventListener("click", function (e) {
        e.preventDefault();
        mostrarContenedorFlotante(contenedorFlotante, certificados[0]);
    });
});

function crearContenedorFlotante(id, imagenes) {
    var contenedorFlotante = document.createElement("div");
    contenedorFlotante.id = id;
    contenedorFlotante.className = "contenedorFlotante";
    contenedorFlotante.style.display = "none";
    contenedorFlotante.style.position = "fixed";
    contenedorFlotante.style.top = "0";
    contenedorFlotante.style.left = "0";
    contenedorFlotante.style.width = "100%";
    contenedorFlotante.style.height = "100%";
    contenedorFlotante.style.backgroundColor = "rgba(255, 255, 255, 0.9)";

    var row = document.createElement("div");
    row.className = "row";
    row.id = "certificados";

    var imagenesContainer = document.createElement("div");
    imagenesContainer.className = "imagenesContainer";

    for (var i = 0; i < imagenes.length; i++) {
        var img = document.createElement("img");
        img.className = "col-lg-6 imageCertificados";
        img.src = imagenes[i];
        img.alt = "Certificado " + (i + 1);
        imagenesContainer.appendChild(img);
    }

    row.appendChild(imagenesContainer);
    contenedorFlotante.appendChild(row);

    var salirButton = document.createElement("button");
    salirButton.innerText = "Salir";
    salirButton.className = "salirButton";
    salirButton.addEventListener("click", function () {
        contenedorFlotante.style.display = "none";
    });

    contenedorFlotante.appendChild(salirButton);

    document.body.appendChild(contenedorFlotante);

    return contenedorFlotante;
}

function mostrarContenedorFlotante(contenedor, imagenes) {
    var imagenesContainer = contenedor.querySelector(".imagenesContainer");
    imagenesContainer.innerHTML = "";

    for (var i = 0; i < imagenes.length; i++) {
        var img = document.createElement("img");
        img.className = "col-lg-6 imageCertificados";
        img.src = imagenes[i];
        img.alt = "Certificado " + (i + 1);
        imagenesContainer.appendChild(img);
    }

    contenedor.style.display = "flex";
}