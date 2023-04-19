fetch('http://127.0.0.1:8080/api/cliente')
.then(response => response.json())
.then(clientes => {
  clientes.forEach(cliente => {
    const html = `
      <div class="card mb-3">
        <div class="card-body">
          <h5 class="card-title">${cliente.nome}</h5>
          <p class="card-text">Telefone: ${cliente.telefone}</p>
          <p class="card-text">CPF: ${cliente.cpf}</p>
          <p class="card-text">ID do Pedido: ${cliente.idPedido}</p>
          <p class="card-text">Chave PIX: ${cliente.chavePix || 'Não informada'}</p>
          <p class="card-text">Conta: ${cliente.numeroConta || 'Não informado'}</p>
          <p class="card-text">Agência: ${cliente.agencia || 'Não informada'}</p>
          <p class="card-text">Banco: ${cliente.banco || 'Não informado'}</p>
        </div>
      </div>
    `;
    document.getElementById('clientes-container').insertAdjacentHTML('beforeend', html);
  });
})
.catch(error => {
  console.error(error);
});