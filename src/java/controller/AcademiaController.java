/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bin.Academia;
import model.AcademiaDAO;

/**
 *
 * @author Apolo
 */
@WebServlet(name = "AcademiaControle", urlPatterns = {"/AcademiaControle"})

public class AcademiaController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acao = request.getParameter("acao");
        PrintWriter resposta = response.getWriter();
        resposta.write("<script>");

        if (acao != null) {

            String id = request.getParameter("id");
            if (id != null && !id.isEmpty() && !id.equals("0")) {
                AcademiaDAO dao = new AcademiaDAO();
                int idAcademia = Integer.parseInt(id);

                switch (acao) {
                    case "excluir":
                        if (dao.excluir(idAcademia)) {
                            resposta.print("alert('Academia excluído com sucesso!');");
                            resposta.print("location.href='listaacademia.jsp';");

                        }
                        break;
                    case "alterar":
                        Academia academia = dao.buscarPorId(idAcademia);
                        if (academia == null) {
                            resposta.print("alert('academia não encontrado!');");
                            resposta.print("history.back();");
                        } else {
                            request.setAttribute("a", academia);
                            request.getRequestDispatcher("/academia.jsp").forward(request, response);

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
        PrintWriter resposta = response.getWriter();

        String id = request.getParameter("id");
        String cnpj = request.getParameter("cnpj");
        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        String telefone = request.getParameter("telefone");

        Academia academia = new Academia();
        academia.setCnpj(cnpj);
        academia.setNome(nome);
        academia.setEndereco(endereco);
        academia.setTelefone(telefone);

        AcademiaDAO dao = new AcademiaDAO();
        boolean sucesso = false;
        String mensagem = "";
        if (id != null && !id.isEmpty() && !id.equals("0")) {
            int idAcademia = Integer.parseInt(id);
            academia.setId(idAcademia);
            sucesso = dao.alterar(academia);
            mensagem = "Academia alterado com sucesso!";
        } else {
            sucesso = dao.inserir(academia);
            mensagem = " A academia foi cadastrado com sucesso!";

        }

        if (sucesso == true) {
            resposta.print("<h1>" + mensagem + "</h1>");
            resposta.print("<a href='listaacademia.jsp'>voltar</a>");

        } else {

            resposta.print("<h2 style='color:black'> Erro ao tentar salvar academia! </h2>");
            resposta.print("<a href='javascript:history.back()'>voltar</a>");
        }
        resposta.close();
    }
}
