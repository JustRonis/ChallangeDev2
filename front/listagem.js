fetch('http://127.0.0.1:8080/api/cliente')
.then(response => response.json())
.then(clientes => {
  clientes.forEach(cliente => {
    const html = `
        <div class="accordion" id="accordionExample">
            <div class="accordion-item m-2">
                <h2 class="accordion-header">
                    <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                        ${cliente.nome}
                    </button>
                </h2>
                <div id="collapseOne" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
                    <div class="accordion-body">
                        <p>Telefone: ${cliente.telefone}</p>
                        <p>CPF: ${cliente.cpf}</p>
                        <p>ID do Pedido: ${cliente.idPedido}
                        <p>Chave pix: ${cliente.chavePix || '✖️'}</p>
                        <p>Numero conta:  ${cliente.numeroConta || '✖️'}</p>
                        <p>Agencia: ${cliente.agencia || '✖️'}</p>
                        <p>Banco: ${cliente.banco || '✖️'}</p>
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
