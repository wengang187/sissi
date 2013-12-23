package com.sissi.protocol.iq.si;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.sissi.protocol.iq.data.XData;
import com.sissi.read.Collector;
import com.sissi.read.MappingMetadata;

/**
 * @author kim 2013年12月13日
 */
@MappingMetadata(uri = Feature.XMLNS, localName = Feature.NAME)
@XmlType(namespace = Feature.XMLNS)
@XmlRootElement
public class Feature implements Collector {

	public final static String XMLNS = "http://jabber.org/protocol/feature-neg";

	public final static String NAME = "feature";

	private XData x;

	@XmlElement
	public XData getX() {
		return x;
	}

	@XmlAttribute
	public String getXmlns() {
		return XMLNS;
	}

	@Override
	public void set(String localName, Object ob) {
		this.x = XData.class.cast(ob);
	}
}
