package Objetos;
// Generated 03/06/2016 10:35:37 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * TurmaId generated by hbm2java
 */
public class TurmaId  implements java.io.Serializable {


     private String codigo;
     private Date dataInicio;

    public TurmaId() {
    }

    public TurmaId(String codigo, Date dataInicio) {
       this.codigo = codigo;
       this.dataInicio = dataInicio;
    }
   
    public String getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public Date getDataInicio() {
        return this.dataInicio;
    }
    
    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof TurmaId) ) return false;
		 TurmaId castOther = ( TurmaId ) other; 
         
		 return ( (this.getCodigo()==castOther.getCodigo()) || ( this.getCodigo()!=null && castOther.getCodigo()!=null && this.getCodigo().equals(castOther.getCodigo()) ) )
 && ( (this.getDataInicio()==castOther.getDataInicio()) || ( this.getDataInicio()!=null && castOther.getDataInicio()!=null && this.getDataInicio().equals(castOther.getDataInicio()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getCodigo() == null ? 0 : this.getCodigo().hashCode() );
         result = 37 * result + ( getDataInicio() == null ? 0 : this.getDataInicio().hashCode() );
         return result;
   }   


}


