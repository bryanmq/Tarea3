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

public class RegistroEstudiantes {
    
    private ArrayList<Estudiante> arrayEstudiante;
    private String rutaDocumento;
    private Element raiz;
    private Document document;
    
    public RegistroEstudiantes() {
        
    }
    
    private RegistroEstudiantes(String rutaDocumento, String nombreRaiz) throws IOException {
        this.rutaDocumento = rutaDocumento;
        this.raiz = new Element(nombreRaiz);
        this.document = new Document(raiz);
        guardarEstudiante();
    }
    
    public static RegistroEstudiantes crearDocumento() throws IOException {
        return new RegistroEstudiantes("./src/modelo/documents/BaseDatosEstudiantes", "estudiantes");
    }
    
    private RegistroEstudiantes(String rutaDocumento) throws JDOMException, IOException {
        SAXBuilder saBuilder = new SAXBuilder();
        saBuilder.setIgnoringElementContentWhitespace(true);
        this.document = saBuilder.build(rutaDocumento);
        this.raiz = document.getRootElement();
        this.rutaDocumento = rutaDocumento;
    }
    
    public static RegistroEstudiantes abrirDocumento() throws JDOMException, IOException {
        return new RegistroEstudiantes("./src/modelo/documents/BaseDatosEstudiantes");
    }
    
    public static boolean analizarDirectorio() {
        File listado[];
        File rutaDirectorio = new File("./src/modelo/documents");
        boolean state = false;
        listado = rutaDirectorio.listFiles();
        for (File listadoArchivos : listado) {
            if (listadoArchivos.getName().equals("BaseDatosEstudiantes")) {
                state = true;
            }
        }
        return state;
    }
    
    public void setEstudiante(Estudiante estudiante) throws IOException {
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
        guardarEstudiante();
    }
    
    private void guardarEstudiante() throws IOException {
        XMLOutputter xMLOutputter = new XMLOutputter();
        xMLOutputter.output(document, new PrintWriter(this.rutaDocumento));
    }
    
    public void eliminarEstudiante(Element libro) throws IOException {
        raiz.removeContent(libro);
        guardarEstudiante();
    }
    
    public void modificarEstudiante(Estudiante estudiante) throws IOException {
        Element estudianteEncontrado = (Element) this.buscarEstudiante(estudiante.getIdentificador(), 0);
        estudianteEncontrado.getChild("nombre").setText(estudiante.getNombre());
        estudianteEncontrado.getChild("cedula").setText(estudiante.getCedula());
        estudianteEncontrado.getChild("añoIngreso").setText(Integer.toString(estudiante.getAñoIngreso()));
        guardarEstudiante();
    }
    
    public Object buscarEstudiante(String identificador, int index) {
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
    
    public ArrayList<Estudiante> getEstudiantes() {
        if (raiz != null) {
            List<Element> elementosEstudiantes = (List<Element>) raiz.getChildren();
            arrayEstudiante = new ArrayList<Estudiante>();
            for (Element e : elementosEstudiantes) {
                Estudiante estudiante = new Estudiante();
                estudiante.setIdentificador(e.getAttributeValue("identificador"));
                estudiante.setNombre(e.getChildText("nombre"));
                estudiante.setCedula(e.getChildText("cedula"));
                estudiante.setAñoIngreso(Integer.parseInt(e.getChildText("añoIngreso")));
                arrayEstudiante.add(estudiante);
            }
            return arrayEstudiante;
        }
        return null;
    }
    
    public String getListadoEstudiantes() {
        String informacion = "";
        for (Estudiante students : getEstudiantes()) {
            informacion += students.getInformacion() + "\n";
        }
        return informacion;
    }
    
    public String[][] getMatrizEstudiantes() {
        getEstudiantes();
        String matriz[][] = new String[arrayEstudiante.size()][Estudiante.getConteoAtributos()];
        for (int fila = 0; fila < matriz.length; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                matriz[fila][columna] = arrayEstudiante.get(fila).getAtributo(columna);
            }
        }
        return matriz;
    }
    
    public String[] getVectorEstudiantes() {
        getEstudiantes();
        String[] vectorEstudiantes = new String[arrayEstudiante.size()];
        for (int index = 0; index < arrayEstudiante.size(); index++) {
            vectorEstudiantes[index] = arrayEstudiante.get(index).getNombre();
        }
        return vectorEstudiantes;
    }
    
    public ArrayList<Estudiante> filtrar(String identificador, String filtro) {
        getEstudiantes();
        ArrayList<Estudiante> listadoFiltro = new ArrayList<Estudiante>();
        
        for (Estudiante listadoEstudiantes : arrayEstudiante) {
            if (identificador.equalsIgnoreCase("Identificador")) {
                if (listadoEstudiantes.getIdentificador().equalsIgnoreCase(filtro)) {
                    listadoFiltro.add(listadoEstudiantes);
                }
            }
            if (identificador.equalsIgnoreCase("Nombre")) {
                if (listadoEstudiantes.getNombre().equalsIgnoreCase(filtro)) {
                    listadoFiltro.add(listadoEstudiantes);
                }
            }
            if (identificador.equalsIgnoreCase("Cédula")) {
                if (listadoEstudiantes.getCedula().equalsIgnoreCase(filtro)) {
                    listadoFiltro.add(listadoEstudiantes);
                }
            }
            if (identificador.equalsIgnoreCase("Año Ingreso")) {
                if (Integer.toString(listadoEstudiantes.getAñoIngreso()).equalsIgnoreCase(filtro)) {
                    listadoFiltro.add(listadoEstudiantes);
                }
            }
        }
        
        if (arrayEstudiante != null) {
            return listadoFiltro;
        } else {
            return null;
        }
        
    }
    
    public String[][] getMatrizEstudiantesFiltrada(String identificador, String filtro) {
        String matriz[][] = new String[filtrar(identificador, filtro).size()][Estudiante.getConteoAtributos()];
        for (int fila = 0; fila < matriz.length; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                matriz[fila][columna] = filtrar(identificador, filtro).get(fila).getAtributo(columna);
            }
        }
        return matriz;
    }
    
}
