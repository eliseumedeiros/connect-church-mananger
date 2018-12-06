package Objetos;
// Generated 03/06/2016 10:35:37 by Hibernate Tools 4.3.1


import Util.FormatoDataHora;
import Util.HibernateUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Evento generated by hbm2java
 */
public class Evento  implements java.io.Serializable {


     private EventoId id;
     private String publicoAlvo;
     private String tipo;
     private Set ministracoes = new HashSet(0);
     private Set visitantes = new HashSet(0);
     private Set noticias = new HashSet(0);

    public Evento() {
    }

	
    public Evento(EventoId id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }
    
    public Evento(String tema, Date diaHora, String publicoAlvo, String tipo) {
       this.id = new EventoId(tema,diaHora);
       this.publicoAlvo = publicoAlvo;
       this.tipo = tipo;
    }
    
    public Evento(EventoId id, String publicoAlvo, String tipo, Set ministracaos, Set visitantes, Set noticias) {
       this.id = id;
       this.publicoAlvo = publicoAlvo;
       this.tipo = tipo;
       this.ministracoes = ministracaos;
       this.visitantes = visitantes;
       this.noticias = noticias;
    }
   
    public EventoId getId() {
        return this.id;
    }
    
    public void setId(EventoId id) {
        this.id = id;
    }
    public String getPublicoAlvo() {
        return this.publicoAlvo;
    }
    
    public void setPublicoAlvo(String publicoAlvo) {
        this.publicoAlvo = publicoAlvo;
    }
    public String getTipo() {
        return this.tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public Set getMinistracoes() {
        return this.ministracoes;
    }
    
    public void setMinistracoes(Set ministracaos) {
        this.ministracoes = ministracaos;
    }
    public Set getVisitantes() {
        return this.visitantes;
    }
    
    public void setVisitantes(Set visitantes) {
        this.visitantes = visitantes;
    }
    public Set getNoticias() {
        return this.noticias;
    }
    
    public void setNoticias(Set noticias) {
        this.noticias = noticias;
    }
    
    ////////////////////////////////////////////////////////////
    
    public static Evento preencherDadosEvento(Object[] object, int index){
        Evento evento = new Evento();
        evento.setId(new EventoId((String)object[index],(Date)object[index+1]));
        if (object[index+2] != null)
            evento.setPublicoAlvo((String)object[index+2]);
        evento.setTipo((String)object[index+3]);
        return evento;
    }
    
    public static List<Evento> preencherDadosEvento(List<Object[]> objects, int index){
        List<Evento> eventos = new ArrayList();
        for(Object[] obj: objects){
            eventos.add(preencherDadosEvento(obj,index));
        }
        return eventos;
    }
    
    public static void cadastrarOuAtualizarEvento(Evento evento) throws Exception{
        HibernateUtil.persistirObjeto(evento);
    }
    
    public static void deletarEvento(Evento evento) throws Exception{
        HibernateUtil.deletarObjeto(evento);
    }
    
    public static Evento selectEventoPk(EventoId id){
        List<Object[]> objects = HibernateUtil.getTuplasDaTabela("evento", "tema like '%"+id.getTema() + "%' and dia_hora='"+FormatoDataHora.sqlDataHora(id.getDiaHora())+"'","",0);
        return preencherDadosEvento(objects.get(0),0);
    }
    
    public static Evento selectEventoPk(String tema, Date diaHora){
        //CONFERRIR STRING DE DIA_HORA!!!
        List<Object[]> objects = HibernateUtil.getTuplasDaTabela("evento", "tema like'%"+tema+"%'" + " and dia_hora='"+diaHora+"'","",0);
        return preencherDadosEvento(objects.get(0),0);
    }
       
    public static List<Evento> listarTodos(){
        List<Object[]> objects = HibernateUtil.getTuplasDaTabela("evento");
        return preencherDadosEvento(objects,0);
    }
    
    public static List<Evento> listarTodos(Ordem ordem){
        List<Object[]> objects = HibernateUtil.getTuplasDaTabela("evento","","dia_hora "+ ordem.getSqlOrder(),0);
        return preencherDadosEvento(objects, 0);
    }
    
    public static List<Evento> listarTodos(Ordem ordem, int numMaxResultados){
        List<Object[]> objects = HibernateUtil.getTuplasDaTabela("evento","","dia_hora "+ ordem.getSqlOrder(),numMaxResultados);
        return preencherDadosEvento(objects, 0);
    }
    
    public static List<Evento> selectEventoPorTema(String tema){
        List<Object[]> objects = HibernateUtil.getTuplasDaTabela("evento","tema like '%"+tema,"%'",0);
        return preencherDadosEvento(objects, 0);
    }
    
    public static List<Evento> selectEventoPorTema(String tema, Ordem ordem){
        List<Object[]> objects = HibernateUtil.getTuplasDaTabela("evento","tema like'%"+tema+"%'"," dia_hora DESC",0);
        return preencherDadosEvento(objects, 0);
    }
    
    public static List<Evento> selectEventoPorData(Date data, boolean buscarHora){
        List<Object[]> objects;
        if (buscarHora){
            objects = HibernateUtil.getTuplasDaTabela("evento", "dia_hora='"+FormatoDataHora.sqlDataHora(data)+"'", "dia_hora DESC", 0);
        }
        else{
            objects = HibernateUtil.getTuplasDaTabela("evento", "dia_hora like '"+FormatoDataHora.sqlData(data)+ "___:__:__'", "dia_hora DESC", 0);
        }
        return preencherDadosEvento(objects, 0);
    }
    
    public static List<Evento> selectEventoPorTemaeDia(String tema, Date diaHora){
        //CONFERRIR STRING DE DIA_HORA!!!
        List<Object[]> objects = HibernateUtil.getTuplasDaTabela("evento", "tema like '%"+tema+"%'" + " and dia_hora like='"+FormatoDataHora.sqlData(diaHora)+"'"+"___:__:__'","",0);
        return preencherDadosEvento(objects,0);
    }
    
    public void adicionarVisitante(Pessoa pessoa) throws Exception{
        Visitante visitante = new Visitante(pessoa);
        List<String> parametros = new ArrayList<>();
        parametros.add(""+visitante.getId());
        //Parâmetros do banco que se referem à Strings ou chars, precisam de aspas simples
        parametros.add("'"+this.id.getDiaHora()+"'");
        parametros.add("'"+this.id.getTema()+"'");
        HibernateUtil.insertInto("visita_evento", parametros);
    }

    //Criado por Rafael em 01/06
    //Verificar exception
    public void adicionarVisitante(Visitante visitante) throws Exception{
        List<String> parametros = new ArrayList<>();
        parametros.add(""+visitante.getId());
        //Parâmetros do banco que se referem à Strings ou chars, precisam de aspas simples
        parametros.add("'"+this.id.getDiaHora()+"'");
        parametros.add("'"+this.id.getTema()+"'");
        HibernateUtil.insertInto("visita_evento", parametros);
    }
    
    public void removerVisitante(Visitante visitante) throws Exception{
        HibernateUtil.deleteFrom("visita_evento","id_visitante="+visitante.getId()+" and tema_evt='"+this.getId().getTema()+
                "' and dia_hora_evt='"+FormatoDataHora.sqlDataHora(this.getId().getDiaHora())+"'");
    }
}


