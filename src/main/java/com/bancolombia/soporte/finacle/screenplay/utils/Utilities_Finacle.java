package com.bancolombia.soporte.finacle.screenplay.utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.Map;
import java.util.Set;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import net.serenitybdd.core.pages.PageObject;

public class Utilities_Finacle extends PageObject {

	private String winHandleBefore;
	private String xmlFilePath;
	private String path= "src\\test\\resources\\com\\bancolombia\\soporte\\finacle\\FilesXml\\";

	public void selecFrame(WebDriver hisBrowser, String frame) {

		if (frame == "loginFrame") {

			hisBrowser.switchTo().frame(hisBrowser.findElement(By.name("loginFrame")));

		} else if (frame == "CoreServer") { 
			hisBrowser.switchTo().frame(hisBrowser.findElement(By.name("CoreServer")));
			hisBrowser.switchTo().frame(hisBrowser.findElement(By.name("FINW")));
		}

	}

	public void enterKey() throws AWTException, InterruptedException {

		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
	}



	public void swithWindows(WebDriver hisBrowser) {

		winHandleBefore = hisBrowser.getWindowHandle();

		for (String winHandle : hisBrowser.getWindowHandles()) {

			hisBrowser.switchTo().window(winHandle);
		}

	}

	public String getWinHandleBefore() {
		
		return winHandleBefore;
	}

	public String readXML(String xml, String parentNode, String sonNode)
			throws SAXException, IOException, ParserConfigurationException {

		String dataXmlResult;
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
				.parse(new InputSource(new StringReader(xml)));

		NodeList transactionNodes = doc.getElementsByTagName(parentNode);

		if (transactionNodes.getLength() > 0) {

			Element node = (Element) transactionNodes.item(0);
			dataXmlResult = node.getElementsByTagName(sonNode).item(0).getTextContent();

		} else {

			dataXmlResult = "No Response";
		}

		return dataXmlResult;

	}
	 

	public String fileXmlAction(String action) {

		if (action.equals("query")) {

			xmlFilePath = path + "InquireFromTitleNo.xml";
		
			
		}else if (action.equals("opening Physical")) {

			xmlFilePath = path +"CDT_Fisicos.xml";
			
		}else if (action.equals("interest Payment")) {

			xmlFilePath = path +"RequestGMF.xml";
		}
		
		return xmlFilePath;

	}
	
	public void copyPaste(String xmlFilePath) throws AWTException, IOException {

		String contents = FileUtils.readFileToString(new File(xmlFilePath), "UTF-8");

		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		StringSelection stringSelection = new StringSelection(contents);
		clipboard.setContents(stringSelection, stringSelection);
		Robot robot = new Robot();
		robot.keyPress(java.awt.event.KeyEvent.VK_CONTROL);
		robot.keyPress(java.awt.event.KeyEvent.VK_V);
		robot.keyRelease(java.awt.event.KeyEvent.VK_V);
		robot.keyRelease(java.awt.event.KeyEvent.VK_CONTROL);
	}

	public void updateXml(Map<String, String> dataAccount, String fileXml)
			throws ParserConfigurationException, SAXException, IOException, TransformerException {

		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		Document document = documentBuilder.parse(fileXml);

		NodeList nodePartne = document.getElementsByTagName("FIXML");
		Element nodeSon = (Element) nodePartne.item(0);

		Set<String> keys = dataAccount.keySet();
		String keysStr = String.join(",", keys);
		String[] strKey = keysStr.split(",");

		for (int i = 0; i < strKey.length; i++) {
			
			String valueElemnet = dataAccount.get(strKey[i]);
			if (strKey[i].equals("RequestUUID")) {
				
				valueElemnet = generateRequestId(valueElemnet);
			}

			NodeList tag_1 = nodeSon.getElementsByTagName(strKey[i]);
			Element value = (Element) tag_1.item(0);

			value.setTextContent(valueElemnet);
		}

		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource domSource = new DOMSource(document);
		StreamResult streamResult = new StreamResult(new File(fileXml));
		transformer.transform(domSource, streamResult);

	}
	
	public String generateRequestId(String value) {
			
		String[] parts = value.split("-");
		String[] parts2 = value.split("_");
		String id = null;
		
		if (parts[0].equals("db06050f")) {
			
			String generatedString = RandomStringUtils.randomAlphanumeric(12);
			id = parts[0] +"-" + parts[1]+"-" + parts[2]+"-" + parts[3]+"-" +generatedString;
			
		} else if (parts2[0].equals("Req")){
			
			String generatedString = RandomStringUtils.randomNumeric(13);
			id = parts2[0] +"_" +generatedString;
		}
		
	 	
		return id;
		
	}
	
	public void robotUrl() {
	
		
		
	}


}
