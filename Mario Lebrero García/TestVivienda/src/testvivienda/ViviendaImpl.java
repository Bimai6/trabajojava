package testvivienda;

public class ViviendaImpl implements Vivienda {
    
    private double superficie;
    private double precio;
    private Operacion operacion;
    private String direccion;
    private final double DESCUENTO= 0.1;
    
    //2. Constructores
        //2.1
     public ViviendaImpl(double superficie, double precio, Operacion operacion, String direccion){
        this.superficie=superficie;
        this.precio=precio;
        this.operacion=operacion;
        this.direccion=direccion;
    }
        //2.2
     public ViviendaImpl(String direccion){
         this.superficie=90.0;
         this.precio=150000;
         this.operacion=Operacion.VENTA;
         this.direccion=direccion;
     }
        //2.3
     public ViviendaImpl(){
        this.superficie=0;
        this.precio=0;
        this.operacion= Operacion.VENTA;
        this.direccion= "";
        
    }
     //1 Métodos observadores y modificadores
     public double getSuperficie(){
         return this.superficie;
     }
     
     public void setSuperficie(double superficie){
         this.superficie=superficie;
     }
     
     public double getPrecio(){
         return this.precio;
     }
     
     public void setPrecio(double precio){
         this.precio=precio;
     }
     
     public Operacion getOperacion(){
         return this.operacion;
     }
     
     public void setOperacion(Operacion operacion){
         this.operacion=operacion;
     }
     
     public String getDireccion(){
         return this.direccion;
     }
     
     public void setDireccion(String direccion){
         this.direccion=direccion;
     }
     
     //Métodos custom
    //3
     public double getRebaja(){
        return this.precio - (this.precio*this.DESCUENTO);
        }
     
    //4
     public String toString(){
         return "Direccion: " + this.direccion + " - precio=" + this.precio + " - superficie=" + this.superficie + " -operación=" +  this.operacion;
     }
     
     //5
     public boolean esOperacion (Operacion operacion){
         return this.operacion == operacion;
     }
     
     //6
     public double comisionInmobiliaria(){
         double comision= 0;
         
         switch(this.operacion){
             case ALQUILER:
                 comision = this.precio*0.08;
                 break;
             case VENTA:
                 comision = this.precio*0.14;
                 break;
             case ALQUILER_CON_OPCION_A_VENTA:
                 comision = this.precio*0.11;
                 break;
         }
         return comision;
     }
     
     //7
     public String getDireccionDeLaMasCostosaSiSonMismaOperacion(Vivienda vivienda){
         if(this.operacion == vivienda.getOperacion()){
             if(this.precio > vivienda.getPrecio()){
                 return this.direccion;
             }
             return vivienda.getDireccion();
         }
         return "Las viviendas no tienen la misma dirección";
     }
     
     //8
     public String viviendaSegunTamanyo(){
         if(this.superficie <70){
             return "Vivienda pequeña";
         }else if(this.superficie >= 70 && this.superficie <=95){
             return "Vivienda mediana";
         }
         return "Vivienda grande";
     }
     
     //9
     public String getLocalidad(){
         String array[] = this.direccion.split(",");
         return array[1];
     }
     
     //10
     public void modifySuperficie(double[] array){
         double suma= 0;
         for (int i =0; i<array.length; i++){
             suma+= array[i];
            this.superficie = suma;
         }
     }
     
     //Util para las actividades 11.8 y 11.13
     public double getPrecioPorM2(){
       return this.precio/this.superficie;
     }
}

