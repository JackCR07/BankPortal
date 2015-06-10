package com.gbm.mq;

import java.io.IOException;
import com.ibm.mq.MQC;
import com.ibm.mq.MQEnvironment;
import com.ibm.mq.MQException;
import com.ibm.mq.MQGetMessageOptions;
import com.ibm.mq.MQMessage;
import com.ibm.mq.MQPutMessageOptions;
import com.ibm.mq.MQQueue;
import com.ibm.mq.MQQueueManager;
import com.ibm.mq.constants.*;

//Parser
import org.xml.sax.InputSource;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.StringReader;
//*****

import com.bowstreet.util.IXml;
import com.bowstreet.util.XmlUtil;

/**
 * Java class to connect to MQ. Post and Retreive messages.
 * 
 */
public class MqConnection {

	String qMngrStr = "IB9QMGR";
	String user = "";
	String password = "";
	String queueInputName = "getCuentasInput";
	String queueOutputName = "getCuentasOutput";
	String hostName = "172.16.11.225";
	int port = 1414;
	String channel = "IB9.CH.SVRCONN";
	// message to put on MQ.
	/**
	 * String msg = "<datos>"+ "<id_cliente>lprado</id_cliente>" +
	 * "<id_tipo_cuenta>-1</id_tipo_cuenta>" +
	 * "<fecha_mayor_a>null</fecha_mayor_a>" +
	 * "<fecha_menor_a>null</fecha_menor_a>" +
	 * "<saldo_mayor_a>-1</saldo_mayor_a>" + "<saldo_menor_a>-1</saldo_menor_a>"
	 * + "</datos>";
	 **/
	// Create a default local queue.
	MQQueue inputQueue;
	MQQueue outputQueue;
	MQQueueManager qManager;

	/**
	 * Initialize the MQ
	 * 
	 */

	private void init() {

		// Set MQ connection credentials to MQ Envorinment.
		MQEnvironment.hostname = hostName;
		MQEnvironment.channel = channel;
		MQEnvironment.port = port;
		MQEnvironment.userID = user;
		MQEnvironment.password = password;
		// set transport properties.
		MQEnvironment.properties.put(CMQC.TRANSPORT_PROPERTY,
				CMQC.TRANSPORT_MQSERIES_CLIENT);

		try {
			// initialize MQ manager.
			qManager = new MQQueueManager(qMngrStr);
		} catch (MQException e) {
			e.printStackTrace();
		}
	}

	private String buildMessage(String idCliente, int idTipoCuenta, String moneda,
			String fechaMayorA, String fechaMenorA, double saldoMayorA,
			double saldoMenorA) {
		System.out.print("test");
		String msg = "<datos>" + "<id_cliente>" + idCliente + "</id_cliente>"
				+ "<id_tipo_cuenta>" + idTipoCuenta + "</id_tipo_cuenta>"
				+ "<moneda>" + moneda + "</moneda>"
				+ "<fecha_mayor_a>" + fechaMayorA + "</fecha_mayor_a>"
				+ "<fecha_menor_a>" + fechaMenorA + "</fecha_menor_a>"
				+ "<saldo_mayor_a>" + saldoMayorA + "</saldo_mayor_a>"
				+ "<saldo_menor_a>" + saldoMenorA + "</saldo_menor_a>"
				+ "</datos>";
		return msg;
	}

	public String putAndGetMessage(String idCliente, int idTipoCuenta, String moneda,
			String fechaMayorA, String fechaMenorA, double saldoMayorA,
			double saldoMenorA) {
		System.out.println("Moneda Esta ="+moneda);
		init();// Inicializar conecciones
		String msg = buildMessage(idCliente, idTipoCuenta, moneda, fechaMayorA,
				fechaMenorA, saldoMayorA, saldoMenorA);
		int openOptionsInputQueue = CMQC.MQOO_OUTPUT;// Permite realizar el put
														// de los mensajes
		int openOptionsOutputQueue = CMQC.MQGMO_WAIT |CMQC.MQOO_INPUT_AS_Q_DEF;// Espera hasta que el
														// mensaje llegue a la
														// cola de salida
		String valor="";
		try {
			inputQueue = qManager.accessQueue(queueInputName,
					openOptionsInputQueue);

			MQMessage putMessage = new MQMessage();
			putMessage.writeString(msg);

			// specify the message options...
			MQPutMessageOptions pmo = new MQPutMessageOptions();
			// accept
			// put the message on the queue
			inputQueue.put(putMessage, pmo);

			System.out.println("Message is put on MQ.");
			System.out.println(msg);

			outputQueue = qManager.accessQueue(queueOutputName,
					openOptionsOutputQueue);
			// get message from MQ.
			MQMessage getMessages = new MQMessage();
			// assign message id to get message.
			getMessages.messageId = putMessage.messageId;
			
			
			// get message options.
			MQGetMessageOptions gmo = new MQGetMessageOptions();
			//gmo.options= CMQC.MQGMO_NO_SYNCPOINT; //Set no sync point
			//gmo.options= CMQC.MQGMO_CONVERT; //Handles ASCII/EBCDIC
			
			//Importante; El witInterval se debe colocalar en el MQMessaegOptions, si se coloca
			//solamente en la cola la ejecución va a fallar con un error MQJE001: Completion Code '2', Reason '2033'.
			gmo.options= CMQC.MQGMO_WAIT;//Wait until message arrives
			gmo.waitInterval= CMQC.MQWI_UNLIMITED;
			System.out.println("Obtendre el mensaje.");
			valor="obtendere el mensaje";
			outputQueue.get(getMessages, gmo);
			System.out.println("Obtuve el mensaje.");
			String retreivedMsg = getMessages.readLine();
			System.out.println("Message got from MQ: " + retreivedMsg);

			return retreivedMsg;
		} catch (MQException e) {
			return e+"" + valor;
		} catch (IOException e) {
			return e+"";
		}
	}

	// Parser metodo***************************************************
	public IXml xmlParser(String responseQueue) {
		try {
			DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		    InputSource is = new InputSource();
		    is.setCharacterStream(new StringReader(responseQueue));
		    Document doc = db.parse(is);
		    doc.getDocumentElement().normalize();
			System.out.println("Root element :"+ doc.getDocumentElement().getNodeName());
			
			IXml cuentasXml = XmlUtil.create("operation1Response");
			System.out.println("----------------------------");
			NodeList nList = doc.getElementsByTagName("cuenta");
			System.out.println("----------------------------");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				System.out.println("\nCurrent Element :" + nNode.getNodeName());
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					String idCuenta = eElement.getElementsByTagName("id_cuenta").item(0).getTextContent();
					String tipoCuenta = eElement.getElementsByTagName("tipo_cuenta").item(0)
							.getTextContent();
					String moneda = eElement.getElementsByTagName("moneda").item(0)
							.getTextContent();
					double saldo = Double.parseDouble(eElement.getElementsByTagName("saldo").item(0)
							.getTextContent());
					String numeroCuenta = eElement.getElementsByTagName("numero_cuenta").item(0)
									.getTextContent();
					String fechaCreacion = eElement.getElementsByTagName("fecha_creacion").item(0)
									.getTextContent();
					System.out.print(idCuenta+numeroCuenta+saldo+fechaCreacion+tipoCuenta);
					
					IXml cuentaXML = getCuentaAsXml(idCuenta,tipoCuenta,moneda, saldo,numeroCuenta,fechaCreacion);
					cuentasXml.addChildElement(cuentaXML);
				}
			}
			return cuentasXml;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	// ********************************************************************************

	public IXml getMessageQueue(String idCliente, int idTipoCuenta, String moneda,
			String fechaMayorA, String fechaMenorA, String saldoMayorA,
			String saldoMenorA){
		System.out.println("Primero moneda "+moneda);
		//************************validar campos***************************
		fechaMayorA = (fechaMayorA.equals("") ? null : fechaMayorA);
		fechaMenorA = (fechaMenorA.equals("") ? null : fechaMenorA);
		moneda = (moneda.equals("") ? "todas" : moneda);
		saldoMayorA = (saldoMayorA.equals("") ? "-1" : saldoMayorA);
		saldoMenorA = (saldoMenorA.equals("") ? "-1" : saldoMenorA);
		double saldoMayorADouble= Double.parseDouble(saldoMayorA);
		double saldoMenorADouble= Double.parseDouble(saldoMenorA);
		//*************************************************************
		String messageQueue = putAndGetMessage(idCliente,idTipoCuenta, moneda,fechaMayorA,fechaMenorA,saldoMayorADouble,saldoMenorADouble);
		IXml queueMessageXML = xmlParser(messageQueue);
		return queueMessageXML;
	}

	// Creación de XML
	private IXml getCuentaAsXml(String idCuenta, String tipoCuenta, String moneda, double saldo, String numeroCuenta, String fechaCreacion) {
		IXml cuentaXml = XmlUtil.create("cuenta");
		/*
		 * <xsd:complexType name="Cuenta"> <xsd:sequence> <xsd:element
		 * name="id_cuenta" type="xsd:int"/> <xsd:element name="tipo_cuenta"
		 * type="xsd:string"/> <xsd:element name="saldo" type="xsd:double"/>
		 * <xsd:element name="numero_cuenta" type="xsd:string"></xsd:element>
		 * <xsd:element name="fecha_creacion" type="xsd:string"/>
		 * </xsd:sequence> </xsd:complexType>
		 */
		cuentaXml.setText("id_cuenta", idCuenta);
		cuentaXml.setText("tipo_cuenta", tipoCuenta);
		cuentaXml.setText("moneda", moneda);
		cuentaXml.setText("saldo", "" + saldo);
		cuentaXml.setText("numero_cuenta", numeroCuenta);
		cuentaXml.setText("fecha_creacion", fechaCreacion);
		return cuentaXml;
	}

	

	public static void main(String[] args) {

		System.out.println("Processing Main...");

		MqConnection clientTest = new MqConnection();
		String responseQueue = clientTest.putAndGetMessage("lprado", -1,"null", null, null, -1, -1);
		clientTest.xmlParser(responseQueue);
		// initialize MQ.
		/*
		 * String msg = "<datos>"+ "<id_cliente>lprado</id_cliente>" +
		 * "<id_tipo_cuenta>-1</id_tipo_cuenta>" +
		 * "<fecha_mayor_a>null</fecha_mayor_a>" +
		 * "<fecha_menor_a>null</fecha_menor_a>" +
		 * "<saldo_mayor_a>-1</saldo_mayor_a>" +
		 * "<saldo_menor_a>-1</saldo_menor_a>" + "</datos>";
		 */
		// put and retreive message from MQ.
		//clientTest.putAndGetMessage("lprado", -1,null, null, null, -1, -1);
		//System.out.print(clientTest.getMessageQueue("lprado", -1, null, null, -1, -1));
		System.out.println("Done!");
	}

}