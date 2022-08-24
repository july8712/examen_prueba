const especie = document.querySelector("#especie");
const perro = document.querySelectorAll(".perro");
const gato = document.querySelectorAll(".gato");
const sexo = document.querySelector("#sexo");
const edad = document.querySelector("#edad");
const color = document.querySelector("#color");
const manchasRayas = document.querySelector("#manchas");
const buscar = document.querySelector("#buscar");
const macho = document.querySelectorAll(".macho")
const hembra = document.querySelectorAll(".hembra")
let especieElegida;
let sexoElegido;
let edadElegida;
let colorElegido;
let manchasElegidas;




// ******************************* Función elegir mascotas *************************************


// especie.addEventListener('change', (event) => {
//     especieElegida = event.target.value;
// })

// sexo.addEventListener('change', (event) => {
//     sexoElegido = event.target.value;
// })

// edad.addEventListener('change', (event) => {
//     edadElegida = event.target.value;
// })

// color.addEventListener('change', (event) => {
//     colorElegido = event.target.value;
// })

// manchasRayas.addEventListener('change', (event) => {
//     manchasElegidas = event.target.value;
// })

// buscar.addEventListener('click', (event) => {
//     event.preventDefault();
//     const filtros = [especieElegida, sexoElegido, edadElegida, colorElegido, manchasElegidas];

//     const ocultos = document.querySelectorAll(".oculto");
//     for (let elemento of ocultos) {
//         elemento.classList.remove('oculto');
//     }

//     let selector = "";
//     for (let filtro of filtros) {
//         if(!filtro) continue;
//         selector += "." + filtro;
//     }

//     if (!selector) return;

//     const elementosAOcultar = document.querySelectorAll(".card:not("+selector+")");
//     for (let elemento of elementosAOcultar) {
//         elemento.classList.add('oculto');
//     }











    // elementosAOcultar.forEach((el) => {
    //     el.style.display = "none";
    // });
    // console.log(selector)


    // if(especieElegida == "perro"){
    //     for(let i = 0; i< perro.length; i++){
    //         perro[i].style.display ="block";
    //     }
    //     for(let i = 0; i< gato.length; i++){
    //         gato[i].style.display ="none";
    //     }
    //     especie.style.border ="1px solid black";
    //     especie.style.color = "black";
    // }else if(especieElegida == "gato"){
    //     for(let i = 0; i< perro.length; i++){
    //         perro[i].style.display ="none";
    //     }
    //     for(let i = 0; i< gato.length; i++){
    //         gato[i].style.display ="block";
    //     }
    //     especie.style.border ="1px solid black";
    //     especie.style.color = "black";
    // }else if(especieElegida == "todos"){
    //     for(let i = 0; i< perro.length; i++){
    //         perro[i].style.display ="block";
    //     }
    //     for(let i = 0; i< gato.length; i++){
    //         gato[i].style.display ="block";
    //     }
    //     especie.style.border ="1px solid black";
    //     especie.style.color = "black";
    // }else{
    //     especie.style.border ="solid 2px red";
    //     especie.style.color = "red";
    // }

    // if(sexo == "macho"){
    //     for(let i = 0; i< macho.length; i++){
    //         macho[i].style.display ="block";
    //     }
    //     for(let i = 0; i< hembra.length; i++){
    //         hembra[i].style.display ="none";
    //     }

    // }else if(sexo == "hembra"){
    //     for(let i = 0; i< macho.length; i++){
    //         macho[i].style.display ="none";
    //     }
    //     for(let i = 0; i< hembra.length; i++){
    //         hembra[i].style.display ="block";
    //     }

    // }else{
    //     for(let i = 0; i< macho.length; i++){
    //         macho[i].style.display ="block";
    //     }
    //     for(let i = 0; i< hembra.length; i++){
    //         hembra[i].style.display ="block";
    //     }
    // }
//   })
