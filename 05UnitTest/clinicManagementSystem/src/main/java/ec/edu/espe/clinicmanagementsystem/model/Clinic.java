package ec.edu.espe.clinicmanagementsystem.model;
/**
 *
 * @author César Vargas, Paradigm, @ESPE
 */

import com.google.gson.reflect.TypeToken;
import ec.edu.espe.clinicmanagementsystem.utils.JsonRepository;
import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Clinic {

    private String name;
    private String address;
    private String phone;
    
    public Clinic(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}