fetch('http://127.0.0.1:8080/api/cliente')
.then(response => response.json())
.then(clientes => {
  clientes.forEach((cliente, index) => {
    const html = `
        <div class="accordion" id="accordionExample">
            <div class="accordion-item m-2">
                <h2 class="accordion-header" id="heading${index}">
                    <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapse${index}" aria-expanded="true" aria-controls="collapse${index}">
                        ID Pedido: ${cliente.idPedido}
                    </button>
                </h2>
                <div id="collapse${index}" class="accordion-collapse collapse" aria-labelledby="heading${index}" data-bs-parent="#accordionExample">
                    <div class="accordion-body">
                        <p>Telefone: ${cliente.telefone}</p>
                        <p>CPF: ${cliente.cpf}</p>
                        <p>ID do Pedido: ${cliente.idPedido}
                        <p>Chave pix: ${cliente.chavePix || '✖️'}</p>
                        <p>Numero conta:  ${cliente.numeroConta || '✖️'}</p>
                        <p>Agencia: ${cliente.agencia || '✖️'}</p>
                        <p>Banco: ${cliente.banco || '✖️'}</p>
                        <p class="d-inline" >Reembolsado:</p>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1" value="option1">
                            <label class="form-check-label" for="inlineRadio1">Sim</label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2">
                            <label class="form-check-label" for="inlineRadio2">Não</label>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    `;
    document.getElementById('clientes-container').insertAdjacentHTML('beforeend', html);
  });
})
.catch(error => {
  console.error(error);
});

