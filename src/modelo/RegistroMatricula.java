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

    public void setMatricula(Matricula matricula) throws IOException {
        Element eMatricula = new Element("matricula");

        Element eCurso = new Element("curso");
        Element eFecha = new Element("fecha");
        Element eEstudiantes = new Element("estudiantes");

        eCurso.addContent(String.valueOf(matricula.getCurso()));
        eFecha.addContent(String.valueOf(matricula.getFecha()));
        eEstudiantes.addContent(String.valueOf("\n" + matricula.getEstudiantes()));

        eMatricula.addContent(eCurso);
        eMatricula.addContent(eEstudiantes);
        eMatricula.addContent(eFecha);

        raiz.addContent(eMatricula);
        guardarMatricula();
    }

    private void guardarMatricula() throws IOException {
        XMLOutputter xMLOutputter = new XMLOutputter();
        xMLOutputter.output(document, new PrintWriter(this.rutaDocumento));
    }

    public Element buscarMatricula(String curso, int index) {
        if (raiz != null) {
            List<Element> elementosMatriculas = (List<Element>) raiz.getChildren();
            for (Element elemento : elementosMatriculas) {
                if (elemento.getChildText("curso").equalsIgnoreCase(curso)) {
                    return elemento;
                }
            }
        }
        return null;
    }

    public String getInformacionMatricula() {
        String informacion = "";

        for (Matricula matricula : arrayMatricula) {
            informacion += matricula.getInfo() + "\n";
        }
        return informacion;
    }

}
