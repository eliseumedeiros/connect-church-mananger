package Objetos;
// Generated 03/06/2016 10:35:37 by Hibernate Tools 4.3.1


import Util.AtributoValor;
import Util.HibernateUtil;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Pessoa generated by hbm2java
 */
public class Pessoa  implements java.io.Serializable {

     private /*@ spec_public @*/ Integer id;
     private /*@ spec_public @*/ String nome;
     private /*@ spec_public @*/ String sobrenome;
     private /*@ spec_public @*/ String telefone;
     private /*@ spec_public @*/ String endRua;
     private /*@ spec_public @*/ Integer endNumero;
     private /*@ spec_public @*/ String endComp;
     private /*@ spec_public @*/ String endBairro;
     private /*@ spec_public @*/ String endCidade;
     private /*@ spec_public @*/ String endEstado;
     private /*@ spec_public @*/ String email;
     private /*@ spec_public @*/ Character estadoCivil;
     private /*@ spec_public @*/ Membro membro;
     private /*@ spec_public @*/ Set ministracaos = new HashSet(0);
     private /*@ spec_public @*/ Visitante visitante;

    //@ public invariant nome != null && sobrenome != null;
    //@ public invariant nome != "" && sobrenome != "" && 
     
    public Pessoa(String nome, String sobrenome) {
        this.nome = nome;
        this.sobrenome = sobrenome;
    }
    public Pessoa(String nome, String sobrenome, String telefone, String endRua, Integer endNumero, String endComp, String endBairro, String endCidade, String endEstado, String email, Character estadoCivil, Membro membro, Set ministracaos, Visitante visitante) {
       this.nome = nome;
       this.sobrenome = sobrenome;
       this.telefone = telefone;
       this.endRua = endRua;
       this.endNumero = endNumero;
       this.endComp = endComp;
       this.endBairro = endBairro;
       this.endCidade = endCidade;
       this.endEstado = endEstado;
       this.email = email;
       this.estadoCivil = estadoCivil;
       this.membro = membro;
       this.ministracaos = ministracaos;
       this.visitante = visitante;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getSobrenome() {
        return this.sobrenome;
    }
    
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    public String getTelefone() {
        return this.telefone;
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getEndRua() {
        return this.endRua;
    }
    
    public void setEndRua(String endRua) {
        this.endRua = endRua;
    }
    public Integer getEndNumero() {
        return this.endNumero;
    }
    
    public void setEndNumero(Integer endNumero) {
        this.endNumero = endNumero;
    }
    public String getEndComp() {
        return this.endComp;
    }
    
    public void setEndComp(String endComp) {
        this.endComp = endComp;
    }
    public String getEndBairro() {
        return this.endBairro;
    }
    
    public void setEndBairro(String endBairro) {
        this.endBairro = endBairro;
    }
    public String getEndCidade() {
        return this.endCidade;
    }
    
    public void setEndCidade(String endCidade) {
        this.endCidade = endCidade;
    }
    public String getEndEstado() {
        return this.endEstado;
    }
    
    public void setEndEstado(String endEstado) {
        this.endEstado = endEstado;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public Character getEstadoCivil() {
        return this.estadoCivil;
    }
    
    public void setEstadoCivil(Character estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
    public Membro getMembro() {
        return this.membro;
    }
    
    public final void setMembro(Membro membro) {
        this.membro = membro;
    }
    public Set getMinistracaos() {
        return this.ministracaos;
    }
    
    public void setMinistracaos(Set ministracaos) {
        this.ministracaos = ministracaos;
    }
    public Visitante getVisitante() {
        return this.visitante;
    }
    
    public void setVisitante(Visitante visitante) {
        this.visitante = visitante;
    }
    
    ////////////////////////////////////////////////
    
    //COMO ISSO FUNCIONA PARA UM MÉTODO ESTÁTICO?
    //@requires object != null;
    //@requires index >= 0;
    //@requires object.length > 2;
    //@requires object[index] != null;
    //@ensures nome = (String) object[index+1];
    //@ensures sobrenome = (String) object[index+2];
    //@ensures id = (Integer) object[index];
     public static Pessoa preencherDadosPessoa(Object[] object, int index){
        Pessoa p = new Pessoa((String)object[index+1],(String)object[index+2]);
        p.setId((Integer)object[index]);
        //if (object[index+3] != null)
        p.setTelefone((String)object[index+3]);
        //if (object[index+4] != null)
        p.setEndRua((String)object[index+4]);
        //if (object[index+5] != null)
        p.setEndNumero((Integer)object[index+5]);
        //if (object[index+6] != null)    
        p.setEndComp((String)object[index+6]);
        //if (object[index+7] != null)
        p.setEndBairro((String)object[index+7]);
        //if (object[index+8] != null)
        p.setEndCidade((String)object[index+8]);
        //if (object[index+9] != null)
        p.setEndEstado((String)object[index+9]);
        //if (object[index+10] != null)
        p.setEmail((String)object[index+10]);
        //if (object[index+11] != null)
        p.setEstadoCivil((Character)object[index+11]);
        return p;
    }
     
    public static List<Pessoa> preencherDadosPessoa(List<Object[]> objects, int index){
        List<Pessoa> pessoas = new ArrayList();
        for(Object[] obj: objects){
            pessoas.add(preencherDadosPessoa(obj, index));
        }
        return pessoas;
    }
    
    public static Pessoa cadastrarOuAtualizarPessoa(Pessoa pessoa) throws Exception{
        HibernateUtil.persistirObjeto(pessoa);
        List<Object[]> objects =HibernateUtil.getTuplasDaTabela("pessoa","", "id desc", 1);
        Pessoa p = (Pessoa) preencherDadosPessoa(objects.get(0), 0);
        return p;
    }
    
    public static void deletarPessoa(Pessoa pessoa) throws Exception{
        HibernateUtil.deletarObjeto(pessoa);
    }
    
    public static Pessoa selectPessoaPk(int id){
        return (Pessoa)HibernateUtil.getTuplasDaTabela("Pessoa", "id="+id,"",0).get(0);
    }
    
    public static List<Pessoa> listarTodos(){
        return HibernateUtil.getTuplasDaTabela("Pessoa");
    }
    
    public static List<Pessoa> selectPessoaPorNome(String nome){
        return HibernateUtil.getTuplasDaTabela("Pessoa","nome='"+nome+"'","",0);
    }
    
    public static List<Pessoa> selectPessoaPorNome(String nome, String sobrenome){
        return HibernateUtil.getTuplasDaTabela("Pessoa","nome='"+nome+"' and sobrenome='"+sobrenome+"'","",0);
    }
    
    //@requires evento != null;
    //@requires mensagem != null;
    
    public void cadastrarMinistracao(Evento evento, Mensagem mensagem) throws Exception{
        Ministracao ministracao = new Ministracao(evento,mensagem,this);
        HibernateUtil.persistirObjeto(ministracao);
    }

    public void cadastrarMinistracao(Ministracao ministracao) throws Exception{
        HibernateUtil.persistirObjeto(ministracao);
    }

}

