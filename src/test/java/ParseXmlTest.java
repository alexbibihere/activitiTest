import org.activiti.bpmn.converter.BpmnXMLConverter;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.bpmn.model.Process;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import java.io.*;

/**
 * @author: yan
 * @Date: 2019/7/26/0026 23:51
 * @Description:
 */
public class ParseXmlTest {

    public static void main(String[] args) throws IOException {
        try {
            String fileName = "F:/Config/businessServe.xml";
            String str="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                    "<definitions xmlns=\"http://www.omg.org/spec/BPMN/20100524/MODEL\" xmlns:activiti=\"http://activiti.org/bpmn\" xmlns:bpmndi=\"http://www.omg.org/spec/BPMN/20100524/DI\" xmlns:dc=\"http://www.omg.org/spec/DD/20100524/DC\" xmlns:di=\"http://www.omg.org/spec/DD/20100524/DI\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" expressionLanguage=\"http://www.w3.org/1999/XPath\" id=\"m1564156334337\" name=\"\" targetNamespace=\"http://www.activiti.org/testm1564156334337\" typeLanguage=\"http://www.w3.org/2001/XMLSchema\">\n" +
                    "  <process id=\"myProcess_1\" isClosed=\"false\" isExecutable=\"true\" processType=\"None\">\n" +
                    "    <startEvent id=\"_2\" name=\"StartEvent\"/>\n" +
                    "    <userTask activiti:exclusive=\"true\" id=\"_3\" name=\"UserTask\"/>\n" +
                    "    <endEvent id=\"_4\" name=\"EndEvent\"/>\n" +
                    "    <sequenceFlow id=\"_5\" sourceRef=\"_2\" targetRef=\"_3\"/>\n" +
                    "    <sequenceFlow id=\"_6\" sourceRef=\"_3\" targetRef=\"_4\"/>\n" +
                    "  </process>\n" +
                    "  <bpmndi:BPMNDiagram documentation=\"background=#FFFFFF;count=1;horizontalcount=1;orientation=0;width=842.4;height=1195.2;imageableWidth=832.4;imageableHeight=1185.2;imageableX=5.0;imageableY=5.0\" id=\"Diagram-_1\" name=\"New Diagram\">\n" +
                    "    <bpmndi:BPMNPlane bpmnElement=\"myProcess_1\">\n" +
                    "      <bpmndi:BPMNShape bpmnElement=\"_2\" id=\"Shape-_2\">\n" +
                    "        <dc:Bounds height=\"32.0\" width=\"32.0\" x=\"115.0\" y=\"255.0\"/>\n" +
                    "        <bpmndi:BPMNLabel>\n" +
                    "          <dc:Bounds height=\"32.0\" width=\"32.0\" x=\"0.0\" y=\"0.0\"/>\n" +
                    "        </bpmndi:BPMNLabel>\n" +
                    "      </bpmndi:BPMNShape>\n" +
                    "      <bpmndi:BPMNShape bpmnElement=\"_3\" id=\"Shape-_3\">\n" +
                    "        <dc:Bounds height=\"55.0\" width=\"85.0\" x=\"235.0\" y=\"235.0\"/>\n" +
                    "        <bpmndi:BPMNLabel>\n" +
                    "          <dc:Bounds height=\"55.0\" width=\"85.0\" x=\"0.0\" y=\"0.0\"/>\n" +
                    "        </bpmndi:BPMNLabel>\n" +
                    "      </bpmndi:BPMNShape>\n" +
                    "      <bpmndi:BPMNShape bpmnElement=\"_4\" id=\"Shape-_4\">\n" +
                    "        <dc:Bounds height=\"32.0\" width=\"32.0\" x=\"435.0\" y=\"230.0\"/>\n" +
                    "        <bpmndi:BPMNLabel>\n" +
                    "          <dc:Bounds height=\"32.0\" width=\"32.0\" x=\"0.0\" y=\"0.0\"/>\n" +
                    "        </bpmndi:BPMNLabel>\n" +
                    "      </bpmndi:BPMNShape>\n" +
                    "      <bpmndi:BPMNEdge bpmnElement=\"_5\" id=\"BPMNEdge__5\" sourceElement=\"_2\" targetElement=\"_3\">\n" +
                    "        <di:waypoint x=\"147.0\" y=\"271.0\"/>\n" +
                    "        <di:waypoint x=\"235.0\" y=\"262.5\"/>\n" +
                    "        <bpmndi:BPMNLabel>\n" +
                    "          <dc:Bounds height=\"0.0\" width=\"0.0\" x=\"0.0\" y=\"0.0\"/>\n" +
                    "        </bpmndi:BPMNLabel>\n" +
                    "      </bpmndi:BPMNEdge>\n" +
                    "      <bpmndi:BPMNEdge bpmnElement=\"_6\" id=\"BPMNEdge__6\" sourceElement=\"_3\" targetElement=\"_4\">\n" +
                    "        <di:waypoint x=\"320.0\" y=\"262.5\"/>\n" +
                    "        <di:waypoint x=\"435.0\" y=\"246.0\"/>\n" +
                    "        <bpmndi:BPMNLabel>\n" +
                    "          <dc:Bounds height=\"0.0\" width=\"0.0\" x=\"0.0\" y=\"0.0\"/>\n" +
                    "        </bpmndi:BPMNLabel>\n" +
                    "      </bpmndi:BPMNEdge>\n" +
                    "    </bpmndi:BPMNPlane>\n" +
                    "  </bpmndi:BPMNDiagram>\n" +
                    "</definitions>\n";
            File file = new File(fileName);
            BpmnXMLConverter converter = new BpmnXMLConverter();
            XMLInputFactory factory = XMLInputFactory.newInstance();
//            InputStream inputStream = new FileInputStream(file);
            InputStream inputStream = new ByteArrayInputStream(str.getBytes());
            XMLStreamReader reader = factory.createXMLStreamReader(inputStream);
            BpmnModel bpmnModel =converter.convertToBpmnModel(reader);
            System.out.println(bpmnModel);
            Process process = bpmnModel.getMainProcess();
            System.out.println(process);

        }catch (Exception e ){

            e.printStackTrace();
        }
//        SAXReader reader = new SAXReader();
//        File file = new File("F:/Config/businessServe.xml");
//        org.dom4j.Document document = reader.read(file);
//        org.dom4j.Element root = document.getRootElement();
//        List<Element> childElements = root.elements();
//        for (Element child : childElements) {
//
//
//            //已知属性名情况下
//            System.out.println("id: " + child.attributeValue("id"));
//
//            //未知子元素名情况下
//            /*List<Element> elementList = child.elements();
//            for (Element ele : elementList) {
//                System.out.println(ele.getName() + ": " + ele.getText());
//            }
//            System.out.println();*/
//
//            //已知子元素名的情况下
//            System.out.println("title" + child.elementText("UserTask"));
//            System.out.println("author" + child.elementText("SequenceFlow"));
//            //这行是为了格式化美观而存在
//            System.out.println();
//        }
    }
////        List<Book> books= new ReadXMLByJDom().getBooks(fileName);
//        System.out.println(fileName);
////        for(Book book : books){
////            System.out.println(book);
////        }
////    private List<Book> books = null;
////    private Book book = null;
//
////    public List<Book> getBooks(String fileName){
//
//    SAXBuilder saxBuilder = new SAXBuilder();
//        Document document = null;
//            document = saxBuilder.build(new FileInputStream(fileName));
//        //获取根节点bookstore
//        Element rootElement = document.getRootElement();
//        //获取根节点的子节点，返回子节点的数组
//        List<Element> bookList = rootElement.getChildren();
////            books = new ArrayList<Book>();
//        for (Element bookElement : bookList) {
////                book = new Book();
//            //获取bookElement的属性
//            List<Attribute> bookAttributes = bookElement.getAttributes();
//            for (Attribute attribute : bookAttributes) {
//                if (attribute.getName().equals("UserTask")) {
//                    String id = attribute.getValue(); //System.out.println(id);
//                    System.out.println(attribute);
//                }
//            }
////                //获取bookElement的子节点
////                List<Element> children = bookElement.getChildren();
////                for(Element child : children){
////                    if(child.getName().equals(“name”)){
////                        String name = child.getValue();//System.out.println(name);
////                        book.setName(name);
////                    }else if(child.getName().equals(“author”)){
////                        String author = child.getValue();
////                        book.setAuthor(author);//System.out.println(author);
////                    }else if(child.getName().equals(“year”)){
////                        String year = child.getValue();
////                        book.setYear(Integer.parseInt(year));
////                    }else if(child.getName().equals(“price”)){
////                        String price = child.getValue();
////                        book.setPrice(Double.parseDouble(price));
////                    }
////
////                }
////
////                books.add(book);
////                book = null;
//
//        }
//
//
//    }
}
