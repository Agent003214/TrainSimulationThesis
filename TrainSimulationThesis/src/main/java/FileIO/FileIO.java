package FileIO;

import Attachables.Attachable;
import Factories.CompoundTrain;
import GUI.MethodClass;
import TrainEngines.Locomotive;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;



public class FileIO
{
    private final MethodClass GUIMethods=new MethodClass();
    private final FileNameExtensionFilter xmlFilter=new FileNameExtensionFilter("xml","XML");

    /**
     * This method creates an XML file on disk.
     * @param compoundTrain The train that will be saved
     * @param panel The page the file chooser will open
     */
    public void save(CompoundTrain compoundTrain,JPanel panel)
    {
        try
        {
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();

            Element root=document.createElement("Save");
            document.appendChild(root);

            Element trainName= document.createElement("TrainName");
            trainName.appendChild(document.createTextNode(compoundTrain.getTrainName()));
            root.appendChild(trainName);

            Element trainElement=document.createElement("TrainElement");
            root.appendChild(trainElement);
            for (int i = 0; i < compoundTrain.getTrainLenght(); i++)
            {
                Element elements=document.createElement("Elements");
                if (compoundTrain.getCar(i) instanceof Locomotive)
                {
                    elements.appendChild(document.createTextNode(((Locomotive) compoundTrain.getCar(i)).getModelName()));
                }
                else if (compoundTrain.getCar(i) instanceof Attachable)
                {
                    elements.appendChild(document.createTextNode(((Attachable) compoundTrain.getCar(i)).getName()));
                }
                trainElement.appendChild(elements);
            }

            TransformerFactory transformerFactory=TransformerFactory.newInstance();
            Transformer transformer=transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT,"yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount","4");
            DOMSource domSource=new DOMSource(document);

            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setApproveButtonText("Save");
            fileChooser.setSelectedFile(new File(System.getProperty("user.dir")+"/"+compoundTrain.getTrainName()+".xml"));
            fileChooser.setFileFilter(xmlFilter);
            fileChooser.addChoosableFileFilter(xmlFilter);
            int helperint=fileChooser.showOpenDialog(panel);
            if (helperint==JFileChooser.APPROVE_OPTION)
            {
                StreamResult streamResult;
                String helperString= String.valueOf(fileChooser.getSelectedFile());
                String helperXml=helperString.substring(helperString.length()-4);
                System.out.println(helperString);
                if (!helperXml.equals(".xml"))
                {
                    streamResult=new StreamResult(new File(helperString+".xml"));
                }
                else
                {
                    streamResult=new StreamResult(new File(helperString));
                }
                transformer.transform(domSource,streamResult);
            }

        }
        catch (ParserConfigurationException ignored)
        {

        }
        catch (TransformerConfigurationException ignored)
        {
        }
        catch (TransformerException ignored)
        {
        }
    }

    /**
     * Loads the selected file from the disk
     * @param panel The page the file chooser will open
     */
    public void load(JPanel panel)
    {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        fileChooser.addChoosableFileFilter(xmlFilter);
        fileChooser.setFileFilter(xmlFilter);
        int returnVal = fileChooser.showOpenDialog(panel);
        if (returnVal == JFileChooser.APPROVE_OPTION)
        {
            try
            {
                ArrayList<CompoundTrain> tempTrain = new ArrayList<>();
                tempTrain.add(new CompoundTrain());

                File file = fileChooser.getSelectedFile();
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                dbFactory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
                DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();
                Document doc = dbBuilder.parse(file);
                doc.getDocumentElement().normalize();


                NodeList rootNode=doc.getChildNodes();

                Element root=(Element) rootNode.item(0);
                tempTrain.get(0).setTrainName(root.getElementsByTagName("TrainName").item(0).getTextContent());

                NodeList trainElement=doc.getElementsByTagName("TrainElement");
                for (int i = 0; i < trainElement.getLength(); i++)
                {
                    if (trainElement.item(i).getNodeType()==Node.ELEMENT_NODE)
                    {
                        String str=trainElement.item(i).getTextContent();
                        if (str.length()>0)
                        {
                            str=str.trim();
                            str=str.replace("\n",",");
                            String[] splitStr =str.split(",");
                            for (int j = 0; j < splitStr.length; j++)
                            {
                                for (int k = 0; k < GUIMethods.getLocomotivesArrayList().size(); k++)
                                {
                                    if (splitStr[j].trim().equals(GUIMethods.getLocomotivesArrayList().get(k).getModelName()))
                                    {
                                        tempTrain.get(0).addComponent(GUIMethods.getLocomotivesArrayList().get(k));
                                    }
                                }
                                for (int k = 0; k < GUIMethods.getAttachableArrayList().size(); k++)
                                {
                                    if (splitStr[j].trim().equals(GUIMethods.getAttachableArrayList().get(k).getName()))
                                    {
                                        tempTrain.get(0).addComponent(GUIMethods.getAttachableArrayList().get(k));
                                    }
                                }
                            }
                        }
                    }
                }
                GUIMethods.createTrain(tempTrain.get(0));
            }
            catch (ParserConfigurationException ignored)
            {

            }
            catch (IOException ignored)
            {

            }
            catch (SAXException ignored)
            {

            }
            catch (NullPointerException ignored)
            {

            }
        }
    }
}
