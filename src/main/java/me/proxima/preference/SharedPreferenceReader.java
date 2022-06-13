package me.proxima.preference;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;

public class SharedPreferenceReader {
    private final SharedPreferenceDecryptor sharedPreferenceDecryptor = new SharedPreferenceDecryptor();

    private Document document = null;
    private Node root = null;

    public SharedPreferenceReader(String filePath) throws IOException {
        File file = new File(filePath);
        if(!(file.isFile()))
            throw new IOException("doesn't exist "+filePath);

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            this.document = builder.parse(file);
            this.root = document.getDocumentElement();
        } catch (Exception e) {
        }
    }

    public long getUserId(){
        NodeList list = document.getElementsByTagName("string");
        for(int i=0; i<list.getLength(); i++){
            Node node = list.item(i);
            String name = node.getAttributes().getNamedItem("name").getNodeValue();
            if(name.equals("pch"))
                return Long.valueOf(sharedPreferenceDecryptor.decrypt(node.getTextContent()));
        }
        return 0L;
    }
}
