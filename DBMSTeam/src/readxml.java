	import javax.xml.parsers.DocumentBuilderFactory;
	import javax.xml.parsers.DocumentBuilder;
	import org.w3c.dom.Document;
	import org.w3c.dom.NodeList;
	import org.w3c.dom.Node;
	import org.w3c.dom.Element;
	import java.io.File;
import java.util.ArrayList;
public class readxml {
	static Object p[][]=new Object[100][100];
	 private static final readxml instance = new readxml();
	    
	    //private constructor to avoid client applications to use constructor
	    private readxml(){}

	    public static readxml getInstance(){
	        return instance;
	    }


	  public static  void readfromxmlfile(String path,ArrayList <String>  a ) {

	    try {

		File fXmlFile = new File(path);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
				
	

		doc.getDocumentElement().normalize();

		System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
				
		NodeList nList = doc.getElementsByTagName("row");
				
		System.out.println("----------------------------");
		if(a.size()==0)
		{
		for (int temp = 0; temp < nList.getLength(); temp++) {

			Node nNode = nList.item(temp);
					
			System.out.println("\nCurrent Element :" + nNode.getNodeName());
					
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				NodeList list1=nNode.getChildNodes();
				for(int i=0;i<list1.getLength();i++)
				{
					Node n=list1.item(i);
					p[temp][i]="column"+(i+1)+" "+n.getTextContent();
					System.out.println("column"+(i+1)+" "+n.getTextContent());
				}
		}
		}
		}


		else {
	for (int temp = 0; temp < nList.getLength(); temp++) {

		Node nNode = nList.item(temp);
			
				
		System.out.println("\nCurrent Element :" + nNode.getNodeName());
				
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			NodeList list1=nNode.getChildNodes();
			for(int i=0;i<a.size();i++)
			{
				
				Node n=list1.item(Integer.parseInt( a.get(i))-1);
				p[temp][i]="column"+(i+1)+" "+n.getTextContent();
				System.out.println("column"+(a.get(i))+" "+n.getTextContent());
			}
			
	}
	
	}
		}
		
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	  }

	}


