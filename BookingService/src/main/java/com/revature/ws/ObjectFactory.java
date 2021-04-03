
package com.revature.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.revature.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetAllRoomTypes_QNAME = new QName("http://ws.revature.com/", "getAllRoomTypes");
    private final static QName _GetAllRoomTypesResponse_QNAME = new QName("http://ws.revature.com/", "getAllRoomTypesResponse");
    private final static QName _GetAllRoomsByHotelAndType_QNAME = new QName("http://ws.revature.com/", "getAllRoomsByHotelAndType");
    private final static QName _GetAllRoomsByHotelAndTypeResponse_QNAME = new QName("http://ws.revature.com/", "getAllRoomsByHotelAndTypeResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.revature.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetAllRoomTypes }
     * 
     */
    public GetAllRoomTypes createGetAllRoomTypes() {
        return new GetAllRoomTypes();
    }

    /**
     * Create an instance of {@link GetAllRoomTypesResponse }
     * 
     */
    public GetAllRoomTypesResponse createGetAllRoomTypesResponse() {
        return new GetAllRoomTypesResponse();
    }

    /**
     * Create an instance of {@link GetAllRoomsByHotelAndType }
     * 
     */
    public GetAllRoomsByHotelAndType createGetAllRoomsByHotelAndType() {
        return new GetAllRoomsByHotelAndType();
    }

    /**
     * Create an instance of {@link GetAllRoomsByHotelAndTypeResponse }
     * 
     */
    public GetAllRoomsByHotelAndTypeResponse createGetAllRoomsByHotelAndTypeResponse() {
        return new GetAllRoomsByHotelAndTypeResponse();
    }

    /**
     * Create an instance of {@link RoomType }
     * 
     */
    public RoomType createRoomType() {
        return new RoomType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllRoomTypes }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAllRoomTypes }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.revature.com/", name = "getAllRoomTypes")
    public JAXBElement<GetAllRoomTypes> createGetAllRoomTypes(GetAllRoomTypes value) {
        return new JAXBElement<GetAllRoomTypes>(_GetAllRoomTypes_QNAME, GetAllRoomTypes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllRoomTypesResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAllRoomTypesResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.revature.com/", name = "getAllRoomTypesResponse")
    public JAXBElement<GetAllRoomTypesResponse> createGetAllRoomTypesResponse(GetAllRoomTypesResponse value) {
        return new JAXBElement<GetAllRoomTypesResponse>(_GetAllRoomTypesResponse_QNAME, GetAllRoomTypesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllRoomsByHotelAndType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAllRoomsByHotelAndType }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.revature.com/", name = "getAllRoomsByHotelAndType")
    public JAXBElement<GetAllRoomsByHotelAndType> createGetAllRoomsByHotelAndType(GetAllRoomsByHotelAndType value) {
        return new JAXBElement<GetAllRoomsByHotelAndType>(_GetAllRoomsByHotelAndType_QNAME, GetAllRoomsByHotelAndType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllRoomsByHotelAndTypeResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAllRoomsByHotelAndTypeResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.revature.com/", name = "getAllRoomsByHotelAndTypeResponse")
    public JAXBElement<GetAllRoomsByHotelAndTypeResponse> createGetAllRoomsByHotelAndTypeResponse(GetAllRoomsByHotelAndTypeResponse value) {
        return new JAXBElement<GetAllRoomsByHotelAndTypeResponse>(_GetAllRoomsByHotelAndTypeResponse_QNAME, GetAllRoomsByHotelAndTypeResponse.class, null, value);
    }

}
