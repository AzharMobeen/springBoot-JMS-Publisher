package com.az.consumer.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;


@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "user")
public class User {

    @XmlElement
    protected String userName;
    @XmlElement
    protected String userId;    
    
}
