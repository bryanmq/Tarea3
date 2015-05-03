/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

/**
 *
 * @author Bryan
 */
public class RegistroMatricula {

    private ArrayList<Matricula> arrayMatricula;
    private String rutaDocumento;
    private Element raiz;
    private Document document;

    public RegistroMatricula() {
        arrayMatricula = new ArrayList<Matricula>();
    }

    public void setMatricula(Matricula matricula) {
        arrayMatricula.add(matricula);
    }

    public String getInformacionMatricula() {
        String informacion = "";
        for (Matricula matricula : arrayMatricula) {
            informacion += matricula.getInfo() + "\n";
        }
        return informacion;
    }

    private RegistroMatricula(String rutaDocumento, String nombreRaiz) throws IOException {
        this.rutaDocumento = rutaDocumento;
        this.raiz = new Element(nombreRaiz);
        this.document = new Document(raiz);
        guardarMatricula();
    }

    public static RegistroMatricula crearDocumento() throws IOException {
        return new RegistroMatricula("./src/modelo/documents/BaseDatosMatricula", "matriculas");
    }

    private RegistroMatricula(String rutaDocumento) throws JDOMException, IOException {
        SAXBuilder saBuilder = new SAXBuilder();
        saBuilder.setIgnoringElementContentWhitespace(true);
        this.document = saBuilder.build(rutaDocumento);
        this.raiz = document.getRootElement();
        this.rutaDocumento = rutaDocumento;
    }

    public static RegistroMatricula abrirDocumento() throws JDOMException, IOException {
        return new RegistroMatricula("./src/modelo/documents/BaseDatosMatricula");
    }

    public static boolean analizarDirectorio() {
        File listado[];
        File rutaDirectorio = new File("./src/modelo/documents");
        boolean state = false;
        listado = rutaDirectorio.listFiles();
        for (File listadoArchivos : listado) {
            if (listadoArchivos.getName().equals("BaseDatosMatricula")) {
                state = true;
            }
        }
        return state;
    }

    public void setMatricula(Estudiante estudiante) throws IOException {
        Element eEstudiante = new Element("estudiante");
        Attribute aIdentificador = new Attribute("identificador", estudiante.getIdentificador());
        Element eNombre = new Element("nombre");
        Element eAñoIngreso = new Element("añoIngreso");
        Element eCedula = new Element("cedula");

        eNombre.addContent(String.valueOf(estudiante.getNombre()));
        eAñoIngreso.addContent(String.valueOf(estudiante.getAñoIngreso()));
        eCedula.addContent(String.valueOf(estudiante.getCedula()));
        eEstudiante.setAttribute(aIdentificador);
        eEstudiante.addContent(eNombre);
        eEstudiante.addContent(eAñoIngreso);
        eEstudiante.addContent(eCedula);

        raiz.addContent(eEstudiante);
        guardarMatricula();
    }

    private void guardarMatricula() throws IOException {
        XMLOutputter xMLOutputter = new XMLOutputter();
        xMLOutputter.output(document, new PrintWriter(this.rutaDocumento));
    }


    public Object buscarMatricula(String identificador, int index) {
        if (raiz != null) {
            List<Element> elementosEstudiantes = (List<Element>) raiz.getChildren();
            for (Element elemento : elementosEstudiantes) {
                if (elemento.getAttributeValue("identificador").equalsIgnoreCase(identificador)) {
                    if (index == 1) {
                        return new Estudiante(elemento.getChildText("nombre"),
                                Integer.parseInt(elemento.getChildText("añoIngreso")),
                                elemento.getAttributeValue("identificador"),
                                elemento.getChildText("cedula"));
                    } else {
                        return elemento;
                    }
                }
            }
        }
        return null;
    }

}
