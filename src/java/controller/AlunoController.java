package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bin.Academia;
import model.AcademiaDAO;
import bin.Aluno;
import model.AlunoDAO;

public class AlunoController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String funcionalidade = request.getParameter("funcionalidade");
        PrintWriter resposta = response.getWriter();
        resposta.write("<script>");

        if (funcionalidade != null) {

            String id = request.getParameter("id");
            if (id != null && !id.isEmpty() && !id.equals("0")) {
                AlunoDAO dao = new AlunoDAO();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                int idAluno = Integer.parseInt(id);

                switch (funcionalidade) {
                    case "excluir":
                        if (dao.excluir(idAluno)) {
                            resposta.print("alert('Aluno excluído com sucesso!');");
                            resposta.print("location.href='listar_aluno.jsp';");
                        }
                        break;

                    case "alterar":
                        Aluno alu = dao.carregarPorId(idAluno);
                        if (alu == null) {
                            resposta.print("alert('Aluno não encontrado!');");
                            resposta.print("history.back();");
                        } else {
                            request.setAttribute("alu", alu);
                            request.getRequestDispatcher("/cadastrar_aluno.jsp").forward(request, response);
                        }
                        break;
                }

            } else {
                resposta.write("alert('ID Inválido!');");
                resposta.write("history.back();");
            }

        } else {

            resposta.write("alert('Ação Inválida!');");
            resposta.write("history.back();");

        }

        resposta.write("</script>");
        resposta.close();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            PrintWriter resposta = response.getWriter();

            String id = request.getParameter("id");
            String cpf = request.getParameter("cpf");
            String nome = request.getParameter("nome");
            String email = request.getParameter("email");
            String data_nasc = request.getParameter("data_nasc");
            String sexo = request.getParameter("sexo");
            String endereco = request.getParameter("endereco");
            String telefone = request.getParameter("telefone");
            String status = request.getParameter("status");
            String valor_mensalidade = request.getParameter("valor_mensalidade");
            String plano = request.getParameter("plano");
            String senha = request.getParameter("senha");

            Aluno alu = new Aluno();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            alu.setCpf(cpf);
            alu.setNome(nome);
            alu.setEmail(email);
            alu.setData_nasc(sdf.parse(request.getParameter("data_nasc")));
            alu.setSexo(sexo);
            alu.setEndereco(endereco);
            alu.setTelefone(telefone);
            alu.setStatus(status);
            alu.setValor_mensalidade(Double.parseDouble(valor_mensalidade));
            alu.setPlano(plano);
            alu.setSenha(senha);

            String academiaId = request.getParameter("academia");

            if (academiaId != null && !academiaId.isEmpty()) {
                Academia academia = new Academia();
                academia.setId(Integer.parseInt(request.getParameter("academia")));

                alu.setAcademia(academia);

            } else {
                resposta.write("<script>alert('Selecione o aluno!');history.back();</script>");
                return;
            }

            AlunoDAO dao = new AlunoDAO();
            boolean sucesso = false;
            String mensagem = "";
            if (id != null && !id.isEmpty() && !id.equals("0")) {
                int idAluno = Integer.parseInt(id);
                alu.setId(idAluno);
                sucesso = dao.alterar(alu);
                mensagem = "Aluno alterado com sucesso!";
            } else {
                sucesso = dao.inserir(alu);
                mensagem = "Aluno cadastrado com sucesso!";
            }

            if (sucesso == true) {
                resposta.print("<h1>" + mensagem + "</h1>");
                resposta.print("<a href='listar_aluno.jsp'> voltar </a>");
            } else {
                resposta.print("<h1> Erro ao Gravar Aluno </h1>");
                resposta.print("<a href='javascript:history.back()'> voltar </a>");
            }

            resposta.close();
        } catch (ParseException ex) {
            Logger.getLogger(AvaliacaoController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
