package conexiones;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class TablaEditor {

    Conectar conectar;
    String nombreTabla = "";
    String[] columnasTabla;

    public TablaEditor(Conectar conectar, String nombreTabla) {
        this.nombreTabla = nombreTabla;
        this.conectar = conectar;
    }

    /**
     * Reescribe los datos proporcionados aun modo que mysql los pueda leer
     *
     * @param valores los datos nuevos que se ingresaran a la base de datos
     * @param paraMetodo especifica que metodo lo utilizara, si: 'insertar' o
     * 'modificar'.
     *
     */
    private String ordenarValores(String[] valores, metodos paraMetodo) {
        String values = "";
        switch (paraMetodo) {
            case insertar://Ordena los valores en una cadena    
                for (int i = 0; i < valores.length; i++) {
                    values += "'" + valores[i] + "',";
                }
                values = values.substring(0, values.length() - 1);
                return values;
            case modificar:
                String[] clnT = columnasTabla;
                for (int i = 0; i < clnT.length; i++) {
                    values += clnT[i] + "='" + valores[i] + "',";
                }
                values = values.substring(0, values.length() - 1);
                return values;
            case mostrarTabla:
                for (int i = 0; i < valores.length; i++) {
                    values += valores[i] + ",";
                }
                values = values.substring(0, values.length() - 1);
                return values;
            default:
                return values;
        }
    }

    /**
     * Agrega un nuevo registro a la base de datos Nota: este metodo NO
     * sobreescribe un registro ya
     *
     * @param valores: valores que se agregaran
     * @param columnasTabla las columnas de la tabla donde se agregara el valor
     * @return true: si se logro agregar un nuevo registro, false: si no se
     * agrego el registro.
     *
     */
    public boolean insertar(String[] valores, String columnasTabla) {
        String values = String.format("insert into %s(%s) values(%s)", nombreTabla, columnasTabla, ordenarValores(valores, metodos.insertar));
        return conectar.AMB(values);
    }

    /**
     * Modifica los datos de un registro en la base de datos
     *
     * @param newValores los nuevos valores
     * @param columnasEditar las columnas que seran editadas
     * @param clavePrimaria nombre de la columna de referencia
     * @param valorClave valor de la columna
     * @return true: si se logro modificar, false: si hubo un problema al
     * momento de modificar el dato
     */
    public boolean modificar(String[] newValores, String[] columnasEditar, String clavePrimaria, String valorClave) {
        this.columnasTabla = columnasEditar;
        String values = String.format("update %s set %s where %s='%s'", nombreTabla, ordenarValores(newValores, metodos.modificar), clavePrimaria, valorClave);
        //sms(values);
        return conectar.AMB(values);
    }

    /**
     * Elimina un registro de la base de datos. Esta accion no puede deshacerse
     *
     * @param clavePrimaria nombre de la clave primaria
     * @param valorClave valor de la columna
     * @return true: si se logro eliminar el registro, false: si hubo un
     * problema al momento de eliminar el registro
     */
    public boolean eliminar(String clavePrimaria, String valorClave) {
        String values = String.format("delete from %s where %s='%s'", nombreTabla, clavePrimaria, valorClave);
        return conectar.AMB(values);
    }
    
    /**
     * Busca un Registro en especifico proporcionando una clave de registro mas su valor
     * @param clavePrimaria nombre de la clave primaria del registro
     * @param valorClave valor de la clave en el registro
     * @return retorna un ResultSet
     **/
    public ResultSet buscardato(String clavePrimaria, String valorClave) {
        String values = String.format("select * from %s where %s='%s'", nombreTabla, clavePrimaria, valorClave);
        return conectar.getValores(values);
    }
    
    /**
     * Cuenta cuantos registros se encuentra en la tabla
     * @param clavePrimaria nombre de la clave primaria del registro
     * @return retorna un ResultSet
     **/
    public ResultSet contarRegistros(String clavePrimaria) {
        String values = String.format("select count(%s) from %s", clavePrimaria, nombreTabla);
        return conectar.getValores(values);
    }
    
    /**
     * Retorna el ultimo registro del dato tabla
     * @param clavePrimaria nombre de la clave primaria del registro
     * @return retorna un ResultSet
     **/
    public ResultSet ultimoRegistro(String clavePrimaria) {
        String values = String.format("select max(%s) from %s", clavePrimaria, nombreTabla);
        return conectar.getValores(values);
    }
    
    /**
     * Retorna una tabla completa
     * @param columnasTabla las columanas de la tabla que se quieren modificar
     * @return retorna un ResultSet
     **/
    public ResultSet mostrarTabla(String[] columnasTabla) {
        String values = String.format("select %s from %s", ordenarValores(columnasTabla,metodos.mostrarTabla), nombreTabla);
        return conectar.getValores(values);
    }
    
    /**
     * Obtiene el numero de registro de la tabla
     * @return el numero de registros
     **/
    public int getCount(){
        int contador=0;
        ResultSet gf;
        gf = contarRegistros("codigo");
        try {
            while(gf.next()){
                return gf.getInt(1);
            }
        } catch (SQLException ex) {
            return 0;
        }
        return contador;
    }
    
    /**
     * Devuelve el valor maximo del registro
     * @return retorna un int
     **/
    public int getUltimoResgistro(){
        ResultSet rs = this.ultimoRegistro("Idalumno");
        try{
            while(rs.next()){
                return rs.getInt(1);
            }
        }catch(SQLException ex){
            return 0;
        }
        return 0;
    }
   
}

enum metodos {
    insertar,
    modificar,
    mostrarTabla
}
