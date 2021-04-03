
package com.revature.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for roomType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="roomType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="pricePerNight" type="{http://www.w3.org/2001/XMLSchema}float"/&gt;
 *         &lt;element name="roomType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="roomTypeId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "roomType", propOrder = {
    "pricePerNight",
    "roomType",
    "roomTypeId"
})
public class RoomType {

    protected float pricePerNight;
    protected String roomType;
    protected int roomTypeId;

    /**
     * Gets the value of the pricePerNight property.
     * 
     */
    public float getPricePerNight() {
        return pricePerNight;
    }

    /**
     * Sets the value of the pricePerNight property.
     * 
     */
    public void setPricePerNight(float value) {
        this.pricePerNight = value;
    }

    /**
     * Gets the value of the roomType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoomType() {
        return roomType;
    }

    /**
     * Sets the value of the roomType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoomType(String value) {
        this.roomType = value;
    }

    /**
     * Gets the value of the roomTypeId property.
     * 
     */
    public int getRoomTypeId() {
        return roomTypeId;
    }

    /**
     * Sets the value of the roomTypeId property.
     * 
     */
    public void setRoomTypeId(int value) {
        this.roomTypeId = value;
    }

}
