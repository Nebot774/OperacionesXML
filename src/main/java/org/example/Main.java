package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class Main {
    public static void main(String[] args) throws IOException {

        List<AtletaFemenina> atletas=new ArrayList<>();

        List<String> pruebas1=new ArrayList<>();
            pruebas1.add("Baile");

        AtletaFemenina atleta1=new AtletaFemenina("carla",pruebas1,18,"España");

        List<String> pruebas2=new ArrayList<>();
        pruebas2.add("natacion");
        pruebas2.add("senderismo");

        AtletaFemenina atleta2=new AtletaFemenina("rocio",pruebas2,15,"India");

        List<String> pruebas3=new ArrayList<>();
        pruebas3.add("natacion");
        pruebas3.add("crossfit");

        AtletaFemenina atleta3=new AtletaFemenina("alejandra",pruebas3,23,"Portugal");

        List<String> pruebas4=new ArrayList<>();
        pruebas4.add("natacion");
        pruebas4.add("baile");
        pruebas4.add("crossfit");

        AtletaFemenina atleta4=new AtletaFemenina("elena",pruebas3,23,"Portugal");

        atletas.add(atleta1);
        atletas.add(atleta2);
        atletas.add(atleta3);
        atletas.add(atleta4);


        System.out.println("\n**** Escritura de objeto XML por consola ****");
        String xml=escribirXMLdeAtletas(atletas);
        System.out.println(xml);

        //guardamos el XML en un archivo
        try(FileWriter writer=new FileWriter("C:\\Users\\Adria\\IdeaProjects\\atletas.xml")){
            writer.write(xml);
        }catch (IOException e){
            e.printStackTrace();
        }

        String ruta="atletas.xml";

        //creamos un path
        Path path= Paths.get(ruta);


        //llamamos al metodo convertirXmlaObjeto para que convierta el XML a un objeto atletas femeninas
        //lo almazenamos en una lista de tipo atleta femenina
        List<AtletaFemenina> atletasConversion= convertirXmlaObjeto(path);
        System.out.println("\n**** Resultado de convertir un XML a un array de objetos****");
        String xml2=escribirXMLdeAtletas(atletasConversion);
        System.out.println(xml2);



    }

    //Mapear la lista de objetos AtletaFemenina a un archivo XML llamado atletas_femeninas.xml
    public static String escribirXMLdeAtletas(List<AtletaFemenina> atletas){
        try{
            //creamos un Xmapper para mapear objetos java a XML
            XmlMapper xmlMapper=new  XmlMapper();

            // Habilitar la opción de indentación para una salida XML más legible
            xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);

            //convierte el array de objetos a un archivo XML
            return xmlMapper.writeValueAsString(atletas);

            //capturamso excepciones
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    //Crea un método que extraiga una lista de objetos AtletaFemenina a partir de un archivo XML.
    public static  List<AtletaFemenina> convertirXmlaObjeto(Path ruta){
        try {
            XmlMapper xmlMapper=new XmlMapper();
            return xmlMapper.readValue(ruta.toFile(), new TypeReference<>() { });

        }catch (IOException e) {
            throw new RuntimeException(e);
        }


    }





}