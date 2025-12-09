function onFormSubmit(e) {
  try {
   
    if (e && e.values) {
      
      var destinatario = "recursos-cinmot@motorola.com,nczs@cin.ufpe.br ";

      
      var mapeamentoPerguntas = {
        "DATA": 1,
        "EMAIL DO SOLICITANTE": 2,
        "TIPO DE SOLICITAÇÃO": 3,
        "STATUS DA LINHA": 10,
        "ID ARAS": 5,
        "OPERADORA": 6,
        "NUMERO DA LINHA": 7,
        "IMEI DE ATIVACÃO": 8,
        "EID DE ATIVACÃO": 9
      };

     
      var corpoEmail = "<b>Nova Solicitação de SimCard:</b><br><br>";
      for (var pergunta in mapeamentoPerguntas) {
        var numeroPergunta = mapeamentoPerguntas[pergunta];
        var resposta = e.values[numeroPergunta - 1]; 
        corpoEmail += "<b>" + pergunta + ":</b> " + resposta + "<br>";
      }

      
      GmailApp.sendEmail(destinatario, "Nova Solicitação de SimCard", "", {
        htmlBody: corpoEmail
      });
    } else {
      Logger.log("Evento não é um envio de formulário.");
    }
  } catch (erro) {
    Logger.log("Erro: " + erro.toString());
  }
}
