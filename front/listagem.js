const updateReembolsado = (idPedido, reembolsado) => {
    fetch(`http://127.0.0.1:8080/api/cliente/${idPedido}?reembolsado=true`, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({
        reembolsado: reembolsado
      })
    })
    .then(response => {
      if (!response.ok) {
        throw new Error('Erro ao atualizar reembolsado.');
      }
      console.log('Reembolsado atualizado com sucesso.');
    })
    .catch(error => {
      console.error(error);
    });
  }
  
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
                <p>Nome: ${cliente.nome}</p>
                <p>Telefone: ${cliente.telefone}</p>
                <p>CPF: ${cliente.cpf}</p>
                <p>ID do Pedido: ${cliente.idPedido}
                <p>Chave pix: ${cliente.chavePix || '✖️'}</p>
                <p>Numero conta:  ${cliente.numeroConta || '✖️'}</p>
                <p>Agencia: ${cliente.agencia || '✖️'}</p>
                <p>Banco: ${cliente.banco || '✖️'}</p>
                <p class="d-inline" >Reembolsado:</p>
                <div class="form-check form-check-inline">
                  <input class="form-check-input" type="radio" name="inlineRadioOptions${index}" id="inlineRadio1${index}" value="option1" onchange="updateReembolsado(${cliente.idPedido}, true)" ${cliente.reembolsado ? 'checked' : ''}>
                  <label class="form-check-label" for="inlineRadio1${index}">Sim</label>
                </div>
                <div class="form-check form-check-inline">
                  <input class="form-check-input" type="radio" name="inlineRadioOptions${index}" id="inlineRadio2${index}" value="option2" onchange="updateReembolsado(${cliente.idPedido}, false)" ${!cliente.reembolsado ? 'checked' : ''}>
                  <label class="form-check-label" for="inlineRadio2${index}">Não</label>
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