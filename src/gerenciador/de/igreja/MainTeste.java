/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciador.de.igreja;

import Objetos.*;
import Util.FormatoDataHora;
import Util.HibernateUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Rafael
 */
public class MainTeste {
    
    public static void main(String[] args) throws Exception{
        List<String> valores = new ArrayList();
        valores.add(""+8);
        valores.add("'Anfitriões'");
        HibernateUtil.insertInto("participa_ministerio", valores);
        
    }
}
