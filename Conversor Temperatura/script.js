document.getElementById('calcForm').addEventListener('submit', async function(e){
    e.preventDefault();

    const num1 = parseFloat(document.getElementById('num1').value);
    const inicio = document.getElementById('inicio').value;
    const fim = document.getElementById('fim').value;


    // limpa mensagens anteriores
    document.getElementById('erro').textContent = '';
    document.getElementById('resultado').textContent = '';

    try{

        const response = await fetch ('http://localhost:8080/converter', {
            method: 'POST',
            headers:{
                'Content-Type': 'application/x-www-form-urlencoded'
            },
            body: new URLSearchParams({
                num1:num1,
                inicio: inicio,
                fim: fim,
            })
        });
        if(!response.ok){
            throw new Error('Erro na requisição');
        }

        const data = await response.json();

        if(data.erro){
            document.getElementById('erro').textContent = data.erro;
        }else{
            document.getElementById('resultado').textContent = 'Resultado' + data.resultado;
        }
    }catch(err){
        document.getElementById('erro').textContent = 'Erro' + err.message;
    }


});