const btnInicio = document.getElementById("btn-inicio");
const btnSobre = document.getElementById("btn-sobre");
const btnSolucao = document.getElementById("btn-solucao");
const btnBeneficio = document.getElementById("btn-beneficio");
const btnContato = document.getElementById("btn-contato");
const secInicio = document.getElementById("inicio");
const secSobre = document.getElementById("sobre");
const secSolucao = document.getElementById("solucao");
const secBeneficio = document.getElementById("beneficio");
const secContato = document.getElementById("contato");
const formContato = document.getElementById("form-contato");
const btnEnviar = document.getElementById("btn-enviar");

btnInicio.addEventListener("click", () => {
    secInicio.scrollIntoView({ behavior: "smooth"});
});

btnSobre.addEventListener("click", () => {
    secSobre.scrollIntoView({ behavior: "smooth"});
});

btnSolucao.addEventListener("click", () => {
    secSolucao.scrollIntoView({ behavior: "smooth"});
});

btnBeneficio.addEventListener("click", () => {
    secBeneficio.scrollIntoView({ behavior: "smooth"});
});

btnContato.addEventListener("click", () => {
    secContato.scrollIntoView({ behavior: "smooth"});
});

formContato.addEventListener("submit", async (e) => {
    e.preventDefault(); // evita recarregar a página

    const dados = {
        nome: formContato.nome.value,
        email: formContato.email.value,
        mensagem: formContato.mensagem.value
    };

    btnEnviar.disabled = true;
    btnEnviar.textContent = "Enviando...";

    try {
        const resp = await fetch("https://solum-landpage.onrender.com/api/email", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(dados)
        });

        if (!resp.ok) throw new Error("Erro " + resp.status);

        alert("Mensagem enviada!");
        formContato.reset();
    } catch (erro) {
        console.error(erro);
        alert("Erro ao enviar. Tente novamente.");
    } finally {
        btnEnviar.disabled = false;
        btnEnviar.textContent = "Enviar Mensagem";
    }
});