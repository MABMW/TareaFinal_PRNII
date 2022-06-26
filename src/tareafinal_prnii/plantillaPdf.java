package tareafinal_prnii;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class plantillaPdf {

    private Document documento;
    private FileOutputStream archivo;
    private Paragraph titulo;
    private String rutaPdf = "";
    private DefaultTableModel modelo;

    public plantillaPdf() {

    }
    
    public plantillaPdf(String rutaPdf, DefaultTableModel modelo) {
        this.rutaPdf = rutaPdf;
        this.modelo = modelo;
        documento = new Document();
        Font f = new Font(Font.FontFamily.TIMES_ROMAN, 32, Font.BOLD, BaseColor.GRAY);
        titulo = new Paragraph("Listado de Alumnos", f);
    }
    
    private void setImage(Document documento,String rutaImagen, int xEscala, int yEscala,int xPosicion, int yPosicion){
        Image image = null;
            try {
                image = Image.getInstance(getClass().getClassLoader().getResource(rutaImagen));//carga imagen
                image.scaleAbsolute(xEscala, yEscala);//cambia tamaño
                image.setAbsolutePosition(xPosicion, yPosicion);//coloca imagen en la posicion
                documento.add(image);
            } catch (BadElementException | IOException e) {
            } catch (DocumentException ex) {
        }
    }

    public void platillaAlumno() {
        try {
            archivo = new FileOutputStream(this.rutaPdf);
            PdfWriter.getInstance(documento, archivo);
            documento.setPageSize(PageSize.B3);
            documento.open();

            //Agrega una imagen al documento
            setImage(documento,"IMG/escuela.png",150,150,800,1250);
            setImage(documento, "IMG/escudo.png",150,150,100,1250);

            //configura el titulo en el centro del pdf
            titulo.setAlignment(1);
            documento.add(titulo);
            documento.add(Chunk.NEWLINE);

            //Imprime los datos generales de la institucion
            PdfPTable datos = new PdfPTable(2);
            datos.setWidthPercentage(100);
            PdfPCell cod = new PdfPCell(new Phrase("CODIGO: 0321"));
            cod.setHorizontalAlignment(0);
            cod.setBorderColor(BaseColor.WHITE);
            PdfPCell nombreCentro = new PdfPCell(new Phrase("Institucion: Centro Escolar Prueba DataBase"));
            nombreCentro.setHorizontalAlignment(2);
            nombreCentro.setBorderColor(BaseColor.WHITE);
            PdfPCell nombreDocente = new PdfPCell(new Phrase("Docente: Julio Cesar Ceren Maradona"));
            nombreDocente.setHorizontalAlignment(0);
            nombreDocente.setBorderColor(BaseColor.WHITE);
            DateTimeFormatter formatoAnio = DateTimeFormatter.ofPattern("yyyy");
            PdfPCell empyCell = new PdfPCell(new Phrase("Año: "+formatoAnio.format(LocalDateTime.now())));
            empyCell.setHorizontalAlignment(2);
            
            empyCell.setBorderColor(BaseColor.WHITE);
            PdfPCell empyCell1 = new PdfPCell(new Phrase(" "));
            empyCell1.setHorizontalAlignment(0);
            empyCell1.setBorderColor(BaseColor.WHITE);
            PdfPCell empyCell2 = new PdfPCell(new Phrase(" "));
            empyCell2.setHorizontalAlignment(0);
            empyCell2.setBorderColor(BaseColor.WHITE);

            datos.addCell(cod);
            datos.addCell(nombreCentro);
            datos.addCell(nombreDocente);
            datos.addCell(empyCell);
            datos.addCell(empyCell1);
            datos.addCell(empyCell2);

            documento.add(datos);

            //      documento.add(Chunk.NEWLINE);
            PdfPTable tabla = new PdfPTable(5);
            //tabla.setWidthPercentage(100);
            tabla.setWidths(new int[]{20, 90, 90, 30, 50});
            //Define las columnas
            PdfPCell id = new PdfPCell(new Phrase("CODIGO"));//new Paragraph("CODIGO"));
            id.setBackgroundColor(BaseColor.LIGHT_GRAY);
            id.setHorizontalAlignment(1);
            PdfPCell apellidos = new PdfPCell(new Phrase("APELLIDOS"));
            apellidos.setHorizontalAlignment(1);
            apellidos.setBackgroundColor(BaseColor.LIGHT_GRAY);
            PdfPCell nombre = new PdfPCell(new Phrase("NOMBRES"));
            nombre.setBackgroundColor(BaseColor.LIGHT_GRAY);
            nombre.setHorizontalAlignment(1);
            PdfPCell sexo = new PdfPCell(new Phrase("SEXO"));
            sexo.setHorizontalAlignment(1);
            sexo.setBackgroundColor(BaseColor.LIGHT_GRAY);
            PdfPCell fechaNa = new PdfPCell(new Phrase("FECHA NACIMIENTO"));
            fechaNa.setBackgroundColor(BaseColor.LIGHT_GRAY);
            fechaNa.setHorizontalAlignment(1);

            //Agrega las columnas a la tabla
            tabla.addCell(id);
            tabla.addCell(apellidos);
            tabla.addCell(nombre);
            tabla.addCell(sexo);
            tabla.addCell(fechaNa);

            //Agrega la lista completa de la tabla
            for (int i = 0; i < modelo.getRowCount(); i++) {
                tabla.addCell(modelo.getValueAt(i, 0).toString());
                tabla.addCell(modelo.getValueAt(i, 1).toString() + " " + modelo.getValueAt(i, 2).toString());
                tabla.addCell(modelo.getValueAt(i, 3).toString());
                tabla.addCell(modelo.getValueAt(i, 4).toString());
                tabla.addCell(modelo.getValueAt(i, 5).toString());
            }

            documento.add(tabla);
            documento.add(Chunk.NEWLINE);
            //Agrega fecha actual
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            documento.add(new Paragraph("Fecha: " + dtf.format(LocalDateTime.now())));

            documento.close();
            JOptionPane.showMessageDialog(null, "Exito");

        } catch (DocumentException | HeadlessException | FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public void plantillaNotas(){
        try {
            archivo = new FileOutputStream(this.rutaPdf);
            PdfWriter.getInstance(documento, archivo);
            Rectangle rt =new Rectangle(PageSize.getRectangle("A3").getHeight(), PageSize.getRectangle("A3").getWidth());  //PageSize.getRectangle("A3");
            documento.setPageSize(rt);
            documento.open();
            Paragraph tituloLocal = new Paragraph("Libreta de notas", new Font(Font.FontFamily.TIMES_ROMAN,26,Font.BOLD,BaseColor.DARK_GRAY));
            tituloLocal.setAlignment(1);
            documento.add(tituloLocal);
            
            documento.add(Chunk.NEWLINE);
            PdfPTable tabla1 = new PdfPTable(2);
            tabla1.setWidths(new int[]{40, 300});
            
            PdfPCell celdaCodigo = new PdfPCell(new Paragraph("Codigo: "));
            PdfPCell celdaNombre = new PdfPCell(new Paragraph("Nombre: "));
            
            tabla1.addCell(celdaCodigo);
            tabla1.addCell(celdaNombre);
            
            documento.add(tabla1);
            
            documento.add(Chunk.NEWLINE);
            
            
            
            
            documento.close();
            JOptionPane.showMessageDialog(null, "Exito");
        } catch (FileNotFoundException | DocumentException ex) {
            Logger.getLogger(plantillaPdf.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
