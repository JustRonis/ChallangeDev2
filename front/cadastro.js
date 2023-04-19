
const pixCampos = document.getElementById("pix-campos");
const contaCorrenteCampos = document.getElementById("conta-corrente-campos");
const pixRadio = document.getElementById("pix");
const contaCorrenteRadio = document.getElementById("contaCorrente");
const form = document.querySelector('form');
const formData = new FormData(form);


pixRadio.addEventListener("click", function() {
pixCampos.style.display = "block";
contaCorrenteCampos.style.display = "none";
});

contaCorrenteRadio.addEventListener("click", function() {
pixCampos.style.display = "none";
contaCorrenteCampos.style.display = "block";
});

$(document).ready(function() {
    // $('#nome').mask('AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA', {
    //   translation: {
    //     'A': { pattern: /[A-Za-zÀ-ú]/ }
    //   }
    // });
  
    $('#telefone').mask('(00) 00000-0000');
  
    $('#cpf').mask('000.000.000-00', { reverse: true });
  });


  fetch('/api/endpoint', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(formData)
  })
  .then(response => {
    console.log("sucesso! enviado para o back")
  })
  .catch(error => {
    console.log("Erro ao enviar para o back end")
  });