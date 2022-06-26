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
import java.text.DecimalFormat;
import java.text.NumberFormat;
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

    private void setImage(Document documento, String rutaImagen, int xEscala, int yEscala, int xPosicion, int yPosicion) {
        Image image = null;
        try {
            image = Image.getInstance(getClass().getClassLoader().getResource(rutaImagen));//carga imagen
            image.scaleAbsolute(xEscala, yEscala);//cambia tamaño
            image.setAbsolutePosition(xPosicion, yPosicion);//coloca imagen en la posicion
            documento.add(image);
        } catch (BadElementException | IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (DocumentException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public void platillaAlumno() {
        try {
            archivo = new FileOutputStream(this.rutaPdf);
            PdfWriter.getInstance(documento, archivo);
            documento.setPageSize(PageSize.B3);
            documento.open();

            //Agrega una imagen al documento
            setImage(documento, "IMG/escuela.png", 150, 150, 800, 1250);
            setImage(documento, "IMG/escudo.png", 150, 150, 100, 1250);

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
            PdfPCell empyCell = new PdfPCell(new Phrase("Año: " + formatoAnio.format(LocalDateTime.now())));
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

    public void plantillaNotas(infoAlumno infoAlumno) {
        try {
            archivo = new FileOutputStream(this.rutaPdf);
            PdfWriter.getInstance(documento, archivo);
            Rectangle rt = new Rectangle(PageSize.getRectangle("A3").getHeight(), PageSize.getRectangle("A3").getWidth());  //PageSize.getRectangle("A3");
            documento.setPageSize(rt);
            documento.open();
            //Configura las imagenes
            setImage(documento, "IMG/escuela.png", 150, 150, 1025, 690);
            setImage(documento, "IMG/escudo.png", 140, 140, 10, 690);
            Paragraph tituloLocal = new Paragraph("Libreta de notas", new Font(Font.FontFamily.TIMES_ROMAN, 26, Font.BOLD, BaseColor.DARK_GRAY));
            tituloLocal.setAlignment(1);
            documento.add(tituloLocal);
            documento.add(Chunk.NEWLINE);

            PdfPTable tabla1 = new PdfPTable(2);
            tabla1.setWidths(new int[]{100, 300});
            PdfPCell celdaCodInstitucion = new PdfPCell(new Phrase("CODIGO INSTITUCION: 0321"));
            celdaCodInstitucion.setHorizontalAlignment(1);
            celdaCodInstitucion.setBorderColor(BaseColor.WHITE);
            PdfPCell celdaInstitucion = new PdfPCell(new Paragraph("Institucion: Centro Escolar Prueba DataBase"));
            celdaInstitucion.setBorderColor(BaseColor.WHITE);
            celdaInstitucion.setHorizontalAlignment(2);
            tabla1.addCell(celdaCodInstitucion);
            tabla1.addCell(celdaInstitucion);
            tabla1.addCell(empyPCell());

            PdfPTable tabla2 = new PdfPTable(2);
            PdfPCell celdaDocente = new PdfPCell(new Paragraph("Docente: Julio Cesar Ceren Maradona"));
            celdaDocente.setBorderColor(BaseColor.WHITE);
            tabla2.addCell(celdaDocente);
            tabla2.addCell(empyPCell());
            tabla2.addCell(empyPCell());
            tabla2.addCell(empyPCell());

            PdfPTable tabla3 = new PdfPTable(4);
            tabla3.setWidths(new int[]{70, 250, 80, 100});
            PdfPCell celdaCodigo = new PdfPCell(new Paragraph("Codigo: " + infoAlumno.getCodigo()));
            celdaCodigo.setBorderColor(BaseColor.WHITE);
            PdfPCell celdaNombre = new PdfPCell(new Paragraph("Nombre: " + infoAlumno.getNombre()));
            celdaNombre.setBorderColor(BaseColor.WHITE);
            PdfPCell celdaSexo = new PdfPCell(new Paragraph("Sexo: " + infoAlumno.getSexo()));
            celdaSexo.setBorderColor(BaseColor.WHITE);
            PdfPCell celdaFechaNacimiento = new PdfPCell(new Paragraph("FechaNacimiento: " + infoAlumno.getFechaNacimiento()));
            celdaFechaNacimiento.setBorderColor(BaseColor.WHITE);
            tabla3.addCell(celdaCodigo);
            tabla3.addCell(celdaNombre);
            tabla3.addCell(celdaSexo);
            tabla3.addCell(celdaFechaNacimiento);

            documento.add(tabla1);
            documento.add(tabla2);
            documento.add(tabla3);
            documento.add(Chunk.NEWLINE);

            //Tabla de las notas
            Font fuenteEncabezado = new Font(Font.FontFamily.TIMES_ROMAN, 20, Font.BOLD);
            PdfPTable tablaNotas = new PdfPTable(2);
            tablaNotas.setWidths(new int[]{100, 500});
            tablaNotas.setWidthPercentage(100);
            PdfPCell celdaMaterias = new PdfPCell(new Paragraph("MATERIAS", fuenteEncabezado));
            celdaMaterias.setHorizontalAlignment(1);
            PdfPCell celdaNotas = new PdfPCell(new Paragraph("CALIFICACIONES", fuenteEncabezado));
            celdaNotas.setHorizontalAlignment(1);
            tablaNotas.addCell(celdaMaterias);
            tablaNotas.addCell(celdaNotas);

            //Agrega el nombre de las materias al pdf
            Font fuenteMateria = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
            PdfPTable tablaMaterias = new PdfPTable(1);
            tablaMaterias.setWidthPercentage(100);
            PdfPCell celdaMatematica = new PdfPCell(new Paragraph("Matematica", fuenteMateria));
            PdfPCell celdaLiteratura = new PdfPCell(new Paragraph("Lenguaje", fuenteMateria));
            PdfPCell celdaCiencia = new PdfPCell(new Paragraph("Ciencias", fuenteMateria));
            PdfPCell celdaSociales = new PdfPCell(new Paragraph("Sociales", fuenteMateria));
            //
            tablaMaterias.addCell(celdaMatematica);
            tablaMaterias.addCell(celdaLiteratura);
            tablaMaterias.addCell(celdaCiencia);
            tablaMaterias.addCell(celdaSociales);
            //
            tablaNotas.addCell(empyPCell());
            tablaNotas.addCell(empyPCell());
            tablaNotas.addCell(empyPCell());

            //Agrega la seccion de notas
            PdfPTable tablaCalificacion = new PdfPTable(4);
            tablaCalificacion.setWidthPercentage(100);
            PdfPCell celdaNota1 = new PdfPCell(new Paragraph("Nota1"));
            celdaNota1.setHorizontalAlignment(1);
            PdfPCell celdaNota2 = new PdfPCell(new Paragraph("Nota2"));
            celdaNota2.setHorizontalAlignment(1);
            PdfPCell celdaNota3 = new PdfPCell(new Paragraph("Nota3"));
            celdaNota3.setHorizontalAlignment(1);
            PdfPCell celdaNota4 = new PdfPCell(new Paragraph("Nota4"));
            celdaNota4.setHorizontalAlignment(1);
            //Agrego las celdas
            tablaCalificacion.addCell(celdaNota1);
            tablaCalificacion.addCell(celdaNota2);
            tablaCalificacion.addCell(celdaNota3);
            tablaCalificacion.addCell(celdaNota4);

            //Agrego las tablas calificaion y materias a la tabla principal
            tablaNotas.addCell(tablaCalificacion);
            tablaNotas.addCell(tablaMaterias);

            //ingreoNotas
            Font fuenteNotas = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.NORMAL);
            PdfPTable ingresoNotas = new PdfPTable(4);
            ingresoNotas.setWidthPercentage(100);
            //Ingresa todas las notas en la tabla ingresoNotas

            float promedioMate = 0.0f;
            float promedioLite = 0.0f;
            float promedioCiencia = 0.0f;
            float promedioSociales = 0.0f;

            
            for (int i = 0; i < 16; i++) {
                PdfPCell celdaNotaUno = new PdfPCell(new Paragraph(infoAlumno.getNotas()[i][2], fuenteNotas));
                celdaNotaUno.setHorizontalAlignment(1);
                ingresoNotas.addCell(celdaNotaUno);
                
                if(i<4){
                    promedioMate = promedioMate+ Float.valueOf(infoAlumno.getNotas()[i][2])/4;
                }else if(i<8 && i>3){
                    promedioLite = promedioLite + Float.valueOf(infoAlumno.getNotas()[i][2])/4;
                }else if(i<12 && i>8){
                    promedioCiencia = promedioCiencia + Float.valueOf(infoAlumno.getNotas()[i][2])/2;
                }else if(i<16 && i>12){
                    promedioSociales = promedioSociales + Float.valueOf(infoAlumno.getNotas()[i][2])/2;
                }
            }
            tablaNotas.addCell(ingresoNotas);

            documento.add(tablaNotas);
            documento.add(Chunk.NEWLINE);
            //Para imprimir los promedios
            PdfPTable promedio = new PdfPTable(2);
            promedio.setWidthPercentage(20);
            promedio.setWidths(new int[]{20,30});
            
            NumberFormat formatter = new DecimalFormat("0.00");
            PdfPCell tituloPromedio = new PdfPCell(new Paragraph("PROMEDIOS"));
            tituloPromedio.setHorizontalAlignment(1);
            tituloPromedio.setBorderColor(BaseColor.WHITE);
            PdfPCell mateCell = new PdfPCell(new Paragraph("Matematica"));
            PdfPCell literCell = new PdfPCell(new Paragraph("Lenguaje"));
            PdfPCell cienciaCell = new PdfPCell(new Paragraph("Ciencia"));
            PdfPCell socialesCell = new PdfPCell(new Paragraph("Sociales"));
            
            PdfPCell matePromedio = new PdfPCell(new Paragraph(formatter.format(promedioMate)));
            PdfPCell literaPromedio = new PdfPCell(new Paragraph(formatter.format(promedioLite)));
            PdfPCell cienciaPromedio = new PdfPCell(new Paragraph(formatter.format(promedioCiencia)));
            PdfPCell socialesPromedio = new PdfPCell(new Paragraph(formatter.format(promedioSociales)));
            
            promedio.addCell(tituloPromedio);
            promedio.addCell(empyPCell());
            promedio.addCell(mateCell);
            promedio.addCell(matePromedio);
            promedio.addCell(literCell);
            promedio.addCell(literaPromedio);
            promedio.addCell(cienciaCell);
            promedio.addCell(cienciaPromedio);
            promedio.addCell(socialesCell);
            promedio.addCell(socialesPromedio);
            
            documento.add(promedio);
            
            //Agrega fecha actual
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            documento.add(new Paragraph("Fecha: " + dtf.format(LocalDateTime.now())));

            documento.close();
            JOptionPane.showMessageDialog(null, "Exito");
        } catch (FileNotFoundException | DocumentException ex) {
            Logger.getLogger(plantillaPdf.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public PdfPCell empyPCell() {
        PdfPCell celdaEmpy = new PdfPCell(new Paragraph("  "));
        celdaEmpy.setBorderColor(BaseColor.WHITE);
        return celdaEmpy;
    }

}
