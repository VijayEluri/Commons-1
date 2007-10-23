/*
 * Created on Aug 3, 2005
 *
 */
package com.hannonhill.commons.util.jdom;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.jdom.CDATA;
import org.jdom.Comment;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.EntityRef;
import org.jdom.JDOMException;
import org.jdom.ProcessingInstruction;
import org.jdom.Text;
import org.jdom.input.SAXBuilder;

import com.hannonhill.commons.util.StringUtil;

/**
 * Utility methods for building and parsing JDOM documents.
 * 
 * @author  Collin VanDyck
 * @version $Id: JDOMUtil.java 5410 2007-01-22 23:26:52Z bradley.wagner $
 * @since   1.0
 */
public class JDOMUtil
{

    private static final Logger LOG = Logger.getLogger(JDOMUtil.class);

    /**
     * Adds an attribute name/value pair to the specified element. If the value is empty, it will
     * not be added.
     * 
     * @param element
     * @param name
     * @param value
     */
    public static void addAttribute(Element element, String name, String value)
    {
        if (StringUtil.isEmpty(value))
        {
            return;
        }
        element.setAttribute(name, value);
    }

    /**
     * Adds a sub-element to the specified element with the specified text. Returns the newly
     * created element. If the text is empty, nothing will be added.
     * 
     * @param element
     * @param name
     * @param text
     */
    public static Element addElement(Element element, String name, String text)
    {
        if (StringUtil.isEmpty(name))
        {
            LOG.error("Element with no name cannot be added");
            return null;
        }
        if (StringUtil.isEmpty(text))
        {
            return null;
        }

        Element child = new Element(name);
        child.setText(text);
        element.addContent(child);
        return child;
    }

    /**
     * Builds a new JDOM Document from an input file
     * 
     * @param file the input file
     * @return a new JDOM Document
     * @throws JDOMException 
     * @throws IOException
     */
    public static Document buildDocument(File file) throws JDOMException, IOException
    {
        //build the document from an input stream instead to correct the problem with
        //improper escape of spaces in the file path
        InputStream is = new FileInputStream(file);
        return buildDocument(is);
    }

    /**
     * Builds a new JDOM document from an input stream
     * @param is
     * @return
     * @throws JDOMException
     * @throws IOException
     */
    public static final Document buildDocument(InputStream is) throws JDOMException, IOException
    {
        SAXBuilder builder = new SAXBuilder();
        Document document = builder.build(is);
        return document;
    }

    /**
     * Returns the non-null attribute value, or throws an exception otherwise.
     * 
     * @param element
     * @param attributeName
     * @return
     * @throws Exception
     */
    public static String getRequiredAttribute(Element element, String attributeName) throws Exception
    {
        String value = element.getAttributeValue(attributeName);
        if (value == null)
        {
            throw new Exception("Element " + element.getName() + " must supply the attribute " + attributeName);
        }
        return value;
    }

    /**
     * Returns the attribute value that must have non-empty string content, or throws an exception otherwise.
     * 
     * @param element
     * @param attributeName
     * @return
     * @throws Exception
     */
    public static String getNonEmptyAttribute(Element element, String attributeName) throws Exception
    {
        String value = element.getAttributeValue(attributeName);
        if (StringUtil.isEmpty(value))
        {
            throw new Exception("Element " + element.getName() + " must supply a non empty value for the attribute " + attributeName);
        }
        return value;
    }

    /**
     * Returns the text of a required child element of a given element with a given child element name.
     * 
     * @param sourceElement
     * @param elementName
     * @return
     */
    public static String getNonEmptyChildElementText(Element sourceElement, String elementName) throws Exception
    {
        Element child = getRequiredChildElement(sourceElement, elementName);
        String text = child.getText();
        if (StringUtil.isEmpty(text))
        {
            throw new Exception("Element with name " + elementName + " must supply non empty textual content");
        }
        return text;
    }

    /**
     * Returns a required child element of a given element with a given name.
     * 
     * @param sourceElement the parent
     * @param elementName the name of the child
     * @return the Element
     */
    public static Element getRequiredChildElement(Element sourceElement, String elementName) throws Exception
    {
        Element child = sourceElement.getChild(elementName);
        if (child == null)
        {
            throw new Exception("Element with name " + elementName + " is required under element " + sourceElement.getName());
        }
        return child;
    }

    /**
     * Helper function to copy all of the children from a src Element into a
     * dest Element.
     * 
     * @param destElement
     * @param srcElement
     */
    public static final void copyChildrenInto(Element destElement, Element srcElement)
    {
        final List srcElementContent = srcElement.getContent();
        final Iterator contentIter = srcElementContent.iterator();
        while (contentIter.hasNext())
        {
            final Object item = contentIter.next();
            if (item instanceof Element)
            {
                Element element = (Element) ((Element) item).clone();
                srcElement.removeContent(element);
                destElement.addContent(element);
            }
            else if (item instanceof Text)
            {
                Text text = (Text) ((Text) item).clone();
                srcElement.removeContent(text);
                destElement.addContent(text);
            }
            else if (item instanceof ProcessingInstruction)
            {
                ProcessingInstruction processingInstruction = (ProcessingInstruction) ((ProcessingInstruction) item).clone();
                srcElement.removeContent(processingInstruction);
                destElement.addContent(processingInstruction);
            }
            else if (item instanceof CDATA)
            {
                CDATA cdata = (CDATA) ((CDATA) item).clone();
                srcElement.removeContent(cdata);
                destElement.addContent(cdata);
            }
            else if (item instanceof Comment)
            {
                Comment comment = (Comment) ((Comment) item).clone();
                srcElement.removeContent(comment);
                destElement.addContent(comment);
            }
            else if (item instanceof EntityRef)
            {
                EntityRef entityRef = (EntityRef) ((EntityRef) item).clone();
                srcElement.removeContent(entityRef);
                destElement.addContent(entityRef);
            }
        }
    }

    /**
     * Checks the old element for a child by the given name. If the element
     * has the a non-null child with that name, does a deep clone of the 
     * element and adds it to the content of the new element.
     * 
     * @param newElement
     * @param oldElement
     * @param childName
     */
    public static void copyChildInto(Element newElement, Element oldElement, String childName)
    {
        Element child = oldElement.getChild(childName);
        if (child != null)
        {
            newElement.addContent((Element) child.clone());
        }
    }

    /**
     * Inserts the contents of a document into the content of an element.  This method ensures
     * that namespaces declared on the destination element are preserved in the content being
     * inserted.
     * 
     * @param toInsert the source document from which content will be taken
     * @param destination the element into which the content will be inserted
     */
    public static void insertDocumentContent(Document toInsert, Element destination)
    {
        Element root = toInsert.detachRootElement();
        destination.addContent(root);
    }
}
