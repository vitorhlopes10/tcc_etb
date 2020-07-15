package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bin.Avaliacao;
import model.AvaliacaoDAO;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;
import bin.Aluno;
import model.AlunoDAO;

@WebServlet(name = "AvaliacaoController", urlPatterns = {"/AvaliacaoController"})
public class AvaliacaoController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String funcionalidade = request.getParameter("funcionalidade");
        PrintWriter resposta = response.getWriter();
        resposta.write("<script>");

        if (funcionalidade != null) {

            String id = request.getParameter("id");
            if (id != null && !id.isEmpty() && !id.equals("0")) {
                AvaliacaoDAO dao = new AvaliacaoDAO();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                int idAvaliacao = Integer.parseInt(id);

                switch (funcionalidade) {
                    case "excluir":
                        if (dao.excluir(idAvaliacao)) {
                            resposta.print("alert('Avaliação Física excluída com sucesso!');");
                            resposta.print("location.href='listar_avaliacoes.jsp';");
                        }
                        break;

                    case "alterar":
                        Avaliacao a = dao.carregarPorId(idAvaliacao);
                        if (a == null) {
                            resposta.print("alert('Avaliação Física não encontrada!');");
                            resposta.print("history.back();");
                        } else {
                            request.setAttribute("a", a);
                            request.getRequestDispatcher("/avaliacao.jsp").forward(request, response);
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
            String biotipo = request.getParameter("biotipo");
            String data_ava = request.getParameter("data_ava");
            String idade = request.getParameter("idade");
            String peso = request.getParameter("peso");
            String ombro = request.getParameter("ombro");
            String braco_relaxado = request.getParameter("braco_relaxado");
            String braco_contraido = request.getParameter("braco_contraido");
            String antebraco = request.getParameter("antebraco");
            String torax = request.getParameter("torax");
            String panturrilha = request.getParameter("panturrilha");
            String cintura = request.getParameter("cintura");
            String abdomen = request.getParameter("abdomen");
            String quadril = request.getParameter("quadril");
            String coxa = request.getParameter("coxa");
            String validade_ava = request.getParameter("validade_ava");

            Avaliacao a = new Avaliacao();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            a.setBiotipo(biotipo);
            a.setData_ava(sdf.parse(request.getParameter("data_ava")));
            a.setIdade(Integer.parseInt(idade));
            a.setPeso(Double.parseDouble(torax));
            a.setOmbro(Double.parseDouble(ombro));
            a.setBraco_relaxado(Double.parseDouble(braco_relaxado));
            a.setBraco_contraido(Double.parseDouble(braco_relaxado));
            a.setAntebraco(Double.parseDouble(antebraco));
            a.setTorax(Double.parseDouble(torax));
            a.setPanturrilha(Double.parseDouble(panturrilha));
            a.setCintura(Double.parseDouble(cintura));
            a.setAbdomen(Double.parseDouble(abdomen));
            a.setQuadril(Double.parseDouble(quadril));
            a.setCoxa(Double.parseDouble(coxa));
            a.setValidade_ava(sdf.parse(request.getParameter("validade_ava")));
            
             String alunoId = request.getParameter("aluno");
        
        if ( alunoId != null && !alunoId.isEmpty() ) {
            Aluno aluno = new Aluno();
            aluno.setId( Integer.parseInt(request.getParameter("aluno")) );
        
            a.setAluno(aluno);
        } else {
            resposta.write("<script>alert('Selecione o aluno!');history.back();</script>");
            return;
        }

            AvaliacaoDAO dao = new AvaliacaoDAO();
            boolean sucesso = false;
            String mensagem = "";
            if (id != null && !id.isEmpty() && !id.equals("0")) {
                int idAvaliacao = Integer.parseInt(id);
                a.setId(idAvaliacao);
                sucesso = dao.alterar(a);
                mensagem = "Avaliação Física alterada com sucesso!";
            } else {
                sucesso = dao.inserir(a);
                mensagem = "Avaliação Física cadastrada com sucesso!";
            }

            if (sucesso == true) {
                resposta.print("<h1>" + mensagem + "</h1>");
                resposta.print("<a href='listar_avaliacoes.jsp'> voltar </a>");
            } else {
                resposta.print("<h1> Erro ao Gravar Avaliação Física </h1>");
                resposta.print("<a href='javascript:history.back()'> voltar </a>");
            }

            resposta.close();
        } catch (ParseException ex) {
            Logger.getLogger(AvaliacaoController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
