/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Rafael
 */
public class FormatoDataHora {
    
    public static Date getDataHoraAtual(){
        return new Date(System.currentTimeMillis());
    }
    
    //Ex: 2016-01-30 20:00:00
    public static String sqlDataHora(Date date){
        return ""+(date.getYear()+1900)+"-"+getCampoCompleto(date.getMonth()+1)+"-"+getCampoCompleto(date.getDate())+" "+getCampoCompleto(date.getHours())+":"+getCampoCompleto(date.getMinutes())+":"+getCampoCompleto(date.getSeconds());
    }
    
    //Ex: 2016-01-30
    public static String sqlData(Date date){
        return ""+(date.getYear()+1900)+"-"+getCampoCompleto(date.getMonth()+1)+"-"+getCampoCompleto(date.getDate());
    }
    
    //Ex: 20:00:00
    public static String sqlHora(Date date){
        return ""+getCampoCompleto(date.getHours())+":"+getCampoCompleto(date.getMinutes())+":"+getCampoCompleto(date.getSeconds());
    }
    
    ///////
    
    //Ex: 2016-01-30 20:00:00
    public static String userDataHora(Date date){
        return ""+date.getDate()+"/"+(date.getMonth()+1)+"/"+(date.getYear()+1900)+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
    }
    
    //Ex: 2016-01-30
    public static String userData(Date date){
        return ""+getCampoCompleto(date.getDate())+"/"+getCampoCompleto(date.getMonth()+1)+"/"+(date.getYear()+1900);
    }
    
    public static String userDataDiaMes(Date date){
        return ""+getCampoCompleto(date.getDate())+"/"+getCampoCompleto(date.getMonth()+1);
    }
    
    //Ex: 20:00:00
    public static String userHora(Date date){
        return ""+getCampoCompleto(date.getHours())+":"+getCampoCompleto(date.getMinutes());
    }
    
    public static int getMes(Date date){
        return date.getMonth()+1;
    }
    
    public static int getAno(Date date){
        return date.getYear()+1900;
    }
    
    public static String getCampoCompleto(int campo){
        String str = ""+campo;
        if (campo<10){
            str = "0"+str;
        }
        return str;
    }
    
    //////////////////////////CALENDAR/////////////////////////////////////////////////
    
    public static String sqlDataHora(Calendar date){
        return ""+date.get(Calendar.YEAR)+"-"+date.get(Calendar.MONTH)+"-"+date.get(Calendar.DAY_OF_MONTH)+" "+date.get(Calendar.HOUR)+":"+date.get(Calendar.MINUTE)+":"+date.get(Calendar.SECOND);
    }
    
    public static String sqlData(Calendar date){
        return ""+date.get(Calendar.YEAR)+"-"+date.get(Calendar.MONTH)+"-"+date.get(Calendar.DAY_OF_MONTH);
    }
    
    public static String sqlHora(Calendar date){
        return ""+date.get(Calendar.HOUR)+":"+date.get(Calendar.MINUTE)+":"+date.get(Calendar.SECOND);
    }
    
    ////////////////ENTRADAS DE DATAS///////////////////////////////////////
    
    
    public static Date getData(String data){
        String[] valores = data.split("/");
        int dia = Integer.parseInt(valores[0]);
        int mes = Integer.parseInt(valores[1]);
        int ano = Integer.parseInt(valores[2]);
        return new Date(ano-1900,mes-1,dia);
    }
    public static Date getHora(String hora){
        String[] valores = hora.split(":");
        int h = Integer.parseInt(valores[0]);
        int m = Integer.parseInt(valores[1]);
        Date hour = new Date();
        hour.setHours(h);
        hour.setMinutes(m);
        return hour;
    }
    
}

