
package com.revature.ws;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.3.0
 * 2021-04-06T17:39:18.263-04:00
 * Generated source version: 3.3.0
 *
 */
public final class RoomWS_RoomWSImplPort_Client {

    private static final QName SERVICE_NAME = new QName("http://ws.revature.com/", "RoomWSImplService");

    private RoomWS_RoomWSImplPort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = RoomWSImplService.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) {
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

        RoomWSImplService ss = new RoomWSImplService(wsdlURL, SERVICE_NAME);
        RoomWS port = ss.getRoomWSImplPort();

        {
        System.out.println("Invoking getAllRoomsByHotelAndType...");
        int _getAllRoomsByHotelAndType_arg0 = 0;
        int _getAllRoomsByHotelAndType_arg1 = 0;
        java.util.List<java.lang.Integer> _getAllRoomsByHotelAndType__return = port.getAllRoomsByHotelAndType(_getAllRoomsByHotelAndType_arg0, _getAllRoomsByHotelAndType_arg1);
        System.out.println("getAllRoomsByHotelAndType.result=" + _getAllRoomsByHotelAndType__return);


        }
        {
        System.out.println("Invoking getAllRoomTypes...");
        java.util.List<com.revature.ws.RoomType> _getAllRoomTypes__return = port.getAllRoomTypes();
        System.out.println("getAllRoomTypes.result=" + _getAllRoomTypes__return);


        }

        System.exit(0);
    }

}
