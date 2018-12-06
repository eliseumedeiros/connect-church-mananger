/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Rafael
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public static void persistirObjeto(Object o) throws Exception{
        Session s = sessionFactory.getCurrentSession();
        s.beginTransaction();
        try{
            s.saveOrUpdate(o);
            s.getTransaction().commit();
        }catch(Exception e){
            s.getTransaction().rollback();
            throw new Exception("Houve um problema no cadastro/atualização");
        }
    }
    
    public static void deletarObjeto(Object o) throws Exception{
        Session s = sessionFactory.getCurrentSession();
        s.beginTransaction();
        try{
            
            s.delete(o);
            s.getTransaction().commit();
        }catch(Exception e){
            s.getTransaction().rollback();
            throw new Exception("Houve um problema ao deletar");
        }
    }
    
    /**
     * Cria a Query SQL de insert into
     * @param tabela tabela para inserção da tupla
     * @param valores Parâmetros para o insert
     */
    public static void insertInto(String tabela, List<String> valores) throws Exception{
        Session s = sessionFactory.getCurrentSession();
        String parametros = "";
        
        //Concatenando todos os valores da tupla
        for (String str: valores){
            parametros += str + ","; 
        }
        //Tirar a última vírgula
        parametros = parametros.substring(0, parametros.length()-1);
        
        s.beginTransaction();
        try{
            Query query = s.createSQLQuery("insert into "+ tabela +" values("+parametros+")");
            query.executeUpdate();
            s.getTransaction().commit();
        } catch(Exception e){
            s.getTransaction().rollback();
            throw new Exception("Houve um problema ao inserir as informações");
        }
    }
    
    public static void insertInto(String tabela, List<String> colunas, List<String> valores) throws Exception{
        Session s = sessionFactory.getCurrentSession();
        String parametros = "";
        String columns = "";
        //Concatenando todos os valores da tupla
        for (String str: valores){
            parametros += str + ",";
        }
        for (String str: colunas){
            columns += str += ",";
        }
        //Tirar a última vírgula
        parametros = parametros.substring(0, parametros.length()-1);
        columns = columns.substring(0, columns.length()-1);
        s.beginTransaction();
        try{
            s.createSQLQuery("insert into "+ tabela+"(" +columns+ ") " +"values("+parametros+")");
            s.getTransaction().commit();
        } catch(Exception e){
            s.getTransaction().rollback();
            throw new Exception("Houve um problema ao inserir as informações: "+e.toString());
        }
    }
    
    public static void update(String tabela, List<AtributoValor> valores, String where) throws Exception{
        String set = "";
        
        for (AtributoValor atr: valores){
            set += atr.toString() + ", ";
        }
        set = set.substring(0, set.length() - 2);
        Session s = sessionFactory.getCurrentSession();
        s.beginTransaction();
        try{
            Query query = s.createSQLQuery("update "+tabela + " set "+ set + " where "+ where);
            query.executeUpdate();
            s.getTransaction().commit();
        }catch(Exception e){
            s.getTransaction().rollback();
            throw new Exception(e.toString());
        }
    }
    
    public static void deleteFrom(String tabela, String where) throws Exception{
        Session s = sessionFactory.getCurrentSession();
        s.beginTransaction();
        try{
           Query query = s.createSQLQuery("delete from "+ tabela + " where "+ where);
           query.executeUpdate();
           s.getTransaction().commit();
        }catch(Exception e){
            s.getTransaction().rollback();
            throw new Exception("Houve um problema ao deletar informações: "+e.toString());
        }
    }
    
    public static List getTuplasDaTabela(String tabela){
        Session s = sessionFactory.getCurrentSession();
        s.beginTransaction();
        List tuplas;
        //tuplas = s.createQuery("from "+tabela).list();
        //Query query = s.createSQLQuery("select * from "+ tabela);
        Query query = s.createQuery("from "+tabela);
        tuplas = query.list();
        s.getTransaction().commit();
        return tuplas;
    }
    
    public static List getTuplasDaTabela(String tabela, String where, String ordenadoPor, int numMaxResultados){
        Session s = sessionFactory.getCurrentSession();
        s.beginTransaction();
        List tuplas;
        String onde;
        String ordem;
        if (where.isEmpty()){
            onde = "";
        }
        else{
            onde = " where "+where;
        }
        if (ordenadoPor.isEmpty()){
            ordem = "";
        }
        else{
            ordem = " order by "+ordenadoPor;
        }
        if (numMaxResultados > 0){
            tuplas = s.createSQLQuery("select * from "+tabela+ onde + ordem).setMaxResults(numMaxResultados).list();
        }
        else{
            tuplas = s.createSQLQuery("select * from "+tabela+ onde + ordem).list();
        }
        s.getTransaction().commit();
        return tuplas;
    }
 
    public static List getTuplasDaTabela(String tabela, String where, String ordenadoPor, int numMaxResultados, List<ParametroQuery> parametros){
        Session s = sessionFactory.getCurrentSession();
        s.beginTransaction();
        List tuplas;
        String onde;
        String ordem;
        if (where.isEmpty()){
            onde = "";
        }
        else{
            onde = " where "+where;
        }
        if (ordenadoPor.isEmpty()){
            ordem = "";
        }
        else{
            ordem = " order by "+ordenadoPor;
        }
        System.out.println("from "+tabela + onde + ordem);
        Query query = s.createQuery("from "+tabela+ onde + ordem);
        query = inserirParametros(query, parametros);
        if (numMaxResultados > 0){
            tuplas = query.setMaxResults(numMaxResultados).list();
        }
        else{
            tuplas = query.list();
        }
        s.getTransaction().commit();
        return tuplas;
    }
    
    public static Query inserirParametros(Query query, List<ParametroQuery> parametros){
        for (ParametroQuery parametro: parametros){
            query.setParameter(parametro.getNomeParametro(), parametro.getValorParametro());
        }
        return query;
    }
    
    public static Criteria inserirParametros(Criteria criteria, List<Criterion> restricoes){
        for (Criterion restricao: restricoes){
            criteria.add(restricao);
        }
        return criteria;
    }
    
    public static List getTuplasPorExemplo(Object exemplo, Class classe){
        Session s = sessionFactory.getCurrentSession();
        s.beginTransaction();
        Example exemp = Example.create(exemplo);
        Criteria criteria = s.createCriteria(classe).add(exemp);
        List objetos = criteria.list();
        s.getTransaction().commit();
        return objetos;
    }
    
    public static List getTuplasPorExemplo(Object exemplo, Class classe, List<Criterion> parametros){
        Session s = sessionFactory.getCurrentSession();
        s.beginTransaction();
        Example exemp = Example.create(exemplo);
        Criteria criteria = s.createCriteria(classe).add(exemp);
        criteria = inserirParametros(criteria, parametros);
        List objetos = criteria.list();
        s.getTransaction().commit();
        return objetos;
    }
    
    public static List rodarSQL(String sql){
        Session s = sessionFactory.getCurrentSession();
        s.beginTransaction();
        List objects = s.createSQLQuery(sql).list();
        s.getTransaction().commit();
        return objects;
    }
}
