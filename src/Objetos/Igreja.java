/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Rafael
 */
public class Igreja {
    
    private List<Membro> membros;
    private List<Visitante> visitantes;
    private List<Grupo> grupos;
    private List<Ministerio> ministerios;
    private List<Seminario> seminarios;
    private List<Noticia> noticias;
    private List<Evento> eventos;
    private List<Mensagem> mensagens;
    private Membro usuarioAtual;
    
    public Igreja(){
        this.membros = new ArrayList<>();
        this.visitantes = new ArrayList<>();
        this.grupos = new ArrayList<>();
        this.ministerios = new ArrayList<>();
        this.seminarios = new ArrayList<>();
        this.noticias = new ArrayList<>();
        this.eventos = new ArrayList<>();
        this.mensagens = new ArrayList<>();
    }

    public List<Membro> getMembros() {
        return membros;
    }

    public void setMembros(List<Membro> membros) {
        this.membros = membros;
    }

    public List<Visitante> getVisitantes() {
        return visitantes;
    }

    public void setVisitantes(List<Visitante> visitantes) {
        this.visitantes = visitantes;
    }

    public List<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(List<Grupo> grupos) {
        this.grupos = grupos;
    }

    public List<Ministerio> getMinisterios() {
        return ministerios;
    }

    public void setMinisterios(List<Ministerio> ministerios) {
        this.ministerios = ministerios;
    }

    public List<Seminario> getSeminarios() {
        return seminarios;
    }

    public void setSeminarios(List<Seminario> seminarios) {
        this.seminarios = seminarios;
    }

    public List<Noticia> getNoticias() {
        return noticias;
    }

    public void setNoticias(List<Noticia> noticias) {
        this.noticias = noticias;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

    public List<Mensagem> getMensagens() {
        return mensagens;
    }

    public void setMensagens(List<Mensagem> mensagens) {
        this.mensagens = mensagens;
    }

    public Membro getUsuarioAtual() {
        return usuarioAtual;
    }

    public void setUsuarioAtual(Membro usuarioAtual) {
        this.usuarioAtual = usuarioAtual;
    }
    
    //////////////////////////////////////////////////////////////
    
    public void carregarMembros(){
        membros = Membro.listarTodos();
    }
    
    public void carregarVisitantes(){
        visitantes = Visitante.listarTodos();
    }
    
    public void carregarGrupos(){
        grupos = Grupo.listarTodos();
    }
    
    public void carregarMinisterios(){
       ministerios = Ministerio.listarTodos();
    }
    
    public void carregarSeminarios(){
        seminarios = Seminario.listarTodos();
    }
    
    public void carregarNoticias(){
        noticias = Noticia.listarTodos();
    }
    
    public void carregarNoticias(Ordem ordem){
        noticias = Noticia.listarTodos(ordem);
    }
    
    public void carregarEventos(){
        eventos = Evento.listarTodos();
    }
    
    public void carregarEventos(Ordem ordem){
        eventos = Evento.listarTodos(ordem);
    }
    
    public void carregarEventos(Ordem ordem, int maxResults){
        eventos = Evento.listarTodos(ordem,maxResults);
    }
    
    public void carregarMensagens(){
        mensagens = Mensagem.listarTodos();
    }
    
}
