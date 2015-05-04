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
 * TAREA #3 UCR-Programación II-2015
 *
 * @author Bryan Marín Quesada(B23907)
 */
public class RegistroCursos {

    private ArrayList<Curso> arrayCursos;
    private String rutaDocumento;
    private Element raiz;
    private Document document;

    public RegistroCursos() {
        arrayCursos = new ArrayList<Curso>();
    }

    private RegistroCursos(String rutaDocumento, String nombreRaiz) throws IOException {
        this.rutaDocumento = rutaDocumento;
        this.raiz = new Element(nombreRaiz);
        this.document = new Document(raiz);
        guardarCurso();
    }

    public static RegistroCursos crearDocumento() throws IOException {
        return new RegistroCursos("./src/modelo/documents/BaseDatosCursos", "cursos");
    }

    private RegistroCursos(String rutaDocumento) throws JDOMException, IOException {
        SAXBuilder saBuilder = new SAXBuilder();
        saBuilder.setIgnoringElementContentWhitespace(true);
        this.document = saBuilder.build(rutaDocumento);
        this.raiz = document.getRootElement();
        this.rutaDocumento = rutaDocumento;
    }

    public static RegistroCursos abrirDocumento() throws JDOMException, IOException {
        return new RegistroCursos("./src/modelo/documents/BaseDatosCursos");
    }

    public static boolean analizarDirectorio() {
        File listado[];
        File rutaDirectorio = new File("./src/modelo/documents");
        boolean state = false;
        listado = rutaDirectorio.listFiles();
        for (File listadoArchivos : listado) {
            if (listadoArchivos.getName().equals("BaseDatosCursos")) {
                state = true;
            }
        }
        return state;
    }

    public void setCurso(Curso curso) throws IOException {
        Element eCurso = new Element("curso");
        Attribute aSiglas = new Attribute("siglas", curso.getSiglas());
        Element eNombre = new Element("nombre");
        Element eCreditos = new Element("creditos");

        eNombre.addContent(String.valueOf(curso.getNombre()));
        eCreditos.addContent(String.valueOf(curso.getCreditos()));

        eCurso.setAttribute(aSiglas);
        eCurso.addContent(eNombre);
        eCurso.addContent(eCreditos);

        raiz.addContent(eCurso);
        guardarCurso();
    }

    private void guardarCurso() throws IOException {
        XMLOutputter xMLOutputter = new XMLOutputter();
        xMLOutputter.output(document, new PrintWriter(this.rutaDocumento));
    }

    public void eliminarCurso(Element libro) throws IOException {
        raiz.removeContent(libro);
        guardarCurso();
    }

    public void modificarCurso(Curso curso) throws IOException {
        Element cursoEncontrado = (Element) this.buscarCurso(curso.getSiglas(), 0);
        cursoEncontrado.getChild("nombre").setText(curso.getNombre());
        cursoEncontrado.getChild("creditos").setText(curso.getCreditos());
        guardarCurso();
    }

    public Object buscarCurso(String siglas, int index) {
        if (raiz != null) {
            List<Element> elementosCursos = (List<Element>) raiz.getChildren();
            for (Element elemento : elementosCursos) {
                if (elemento.getAttributeValue("siglas").equalsIgnoreCase(siglas)) {
                    if (index == 1) {
                        return new Curso(elemento.getChildText("nombre"), elemento.getAttributeValue("siglas"), elemento.getChildText("creditos"));
                    } else {
                        return elemento;
                    }
                }
            }
        }
        return null;
    }

    public ArrayList<Curso> getCursos() {
        if (raiz != null) {
            List<Element> elementosCursos = (List<Element>) raiz.getChildren();
            arrayCursos = new ArrayList<Curso>();
            for (Element e : elementosCursos) {
                Curso curso = new Curso(rutaDocumento, rutaDocumento, rutaDocumento);
                curso.setSiglas(e.getAttributeValue("siglas"));
                curso.setNombre(e.getChildText("nombre"));
                curso.setCreditos(e.getChildText("creditos"));
                arrayCursos.add(curso);
            }
            return arrayCursos;
        }
        return null;
    }

    public String getListadoCursos() {
        String informacion = "";
        for (Curso cursos : getCursos()) {
            informacion += cursos.getInfo() + "\n";
        }
        return informacion;
    }

    public String[][] getMatrizCursos() {
        getCursos();
        String matriz[][] = new String[arrayCursos.size()][Curso.size()];
        for (int fila = 0; fila < matriz.length; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                matriz[fila][columna] = arrayCursos.get(fila).getAtributos(columna);
            }
        }
        return matriz;
    }

    public String[] getVectorCursos() {
        String[] vectorCursos = new String[arrayCursos.size()];
        for (int index = 0; index < arrayCursos.size(); index++) {
            vectorCursos[index] = arrayCursos.get(index).getNombre();
        }
        return vectorCursos;
    }

    public ArrayList<Curso> filtrar(String siglas, String filtro) {
        getCursos();
        ArrayList<Curso> listadoFiltro = new ArrayList<Curso>();

        for (Curso listadoCursos : arrayCursos) {
            if (siglas.equalsIgnoreCase("Nombre")) {
                if (listadoCursos.getNombre().equalsIgnoreCase(filtro)) {
                    listadoFiltro.add(listadoCursos);
                }
            }
            if (siglas.equalsIgnoreCase("Siglas")) {
                if (listadoCursos.getSiglas().equalsIgnoreCase(filtro)) {
                    listadoFiltro.add(listadoCursos);
                }
            }
            if (siglas.equalsIgnoreCase("Créditos")) {
                if (listadoCursos.getCreditos().equalsIgnoreCase(filtro)) {
                    listadoFiltro.add(listadoCursos);
                }
            }
        }

        if (arrayCursos != null) {
            return listadoFiltro;
        } else {
            return null;
        }
    }

    public String[][] getMatrizCursosFiltrada(String siglas, String filtro) {
        String matriz[][] = new String[filtrar(siglas, filtro).size()][Curso.size()];
        for (int fila = 0; fila < matriz.length; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                if (filtrar(siglas, filtro).get(fila).getAtributos(columna) != null) {
                    matriz[fila][columna] = filtrar(siglas, filtro).get(fila).getAtributos(columna);
                }
            }
        }
        return matriz;
    }

}
