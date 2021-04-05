package com.revature.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.3.0
 * 2021-04-04T22:23:38.259-04:00
 * Generated source version: 3.3.0
 *
 */
@WebService(targetNamespace = "http://ws.revature.com/", name = "RoomWS")
@XmlSeeAlso({ObjectFactory.class})
public interface RoomWS {

    @WebMethod
    @RequestWrapper(localName = "getAllRoomsByHotelAndType", targetNamespace = "http://ws.revature.com/", className = "com.revature.ws.GetAllRoomsByHotelAndType")
    @ResponseWrapper(localName = "getAllRoomsByHotelAndTypeResponse", targetNamespace = "http://ws.revature.com/", className = "com.revature.ws.GetAllRoomsByHotelAndTypeResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<java.lang.Integer> getAllRoomsByHotelAndType(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1
    );

    @WebMethod
    @RequestWrapper(localName = "getAllRoomTypes", targetNamespace = "http://ws.revature.com/", className = "com.revature.ws.GetAllRoomTypes")
    @ResponseWrapper(localName = "getAllRoomTypesResponse", targetNamespace = "http://ws.revature.com/", className = "com.revature.ws.GetAllRoomTypesResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<com.revature.ws.RoomType> getAllRoomTypes();
}
