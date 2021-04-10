
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
 * 2021-04-09T15:42:55.356-04:00
 * Generated source version: 3.3.0
 *
 */
public final class HotelWS_HotelWSImplPort_Client {

    private static final QName SERVICE_NAME = new QName("http://ws.revature.com/", "HotelWSImplService");

    private HotelWS_HotelWSImplPort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = HotelWSImplService.WSDL_LOCATION;
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

        HotelWSImplService ss = new HotelWSImplService(wsdlURL, SERVICE_NAME);
        HotelWS port = ss.getHotelWSImplPort();

        {
        System.out.println("Invoking getAllHotelsByState...");
        java.lang.String _getAllHotelsByState_arg0 = "";
        java.util.List<com.revature.ws.Hotel> _getAllHotelsByState__return = port.getAllHotelsByState(_getAllHotelsByState_arg0);
        System.out.println("getAllHotelsByState.result=" + _getAllHotelsByState__return);


        }
        {
        System.out.println("Invoking getAllHotels...");
        java.util.List<com.revature.ws.Hotel> _getAllHotels__return = port.getAllHotels();
        System.out.println("getAllHotels.result=" + _getAllHotels__return);


        }

        System.exit(0);
    }

}
