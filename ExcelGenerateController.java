package com.epds.epdsorder.controller;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;

import com.epds.epdsorder.component.ExcelGenerator;
import com.epds.epdsorder.entity.ManagementProfile;
import com.epds.epdsorder.service.ManagementProfileService;
import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.model.CityResponse;
@Controller
public class ExcelGenerateController {
    @Autowired
    private ManagementProfileService managementprofile;
   // @PreAuthorize("hasRole('USER')")
    @GetMapping("/export-to-excel")
    public void exportIntoExcelFile(HttpServletResponse response) throws IOException {
    	String geoLocation = ExcelGenerateController.getGeoLocation("192.168.2.161");
        response.setContentType("application/octet-stream");
        //DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
       // String currentDateTime = dateFormatter.format(new Date());
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=student"+".xlsx";
        response.setHeader(headerKey, headerValue);
        List <ManagementProfile> listOfStudents = managementprofile.getProfile();
        ExcelGenerator generator = new ExcelGenerator(listOfStudents);
        System.out.println("Response Object Is :"+response);
        generator.generateExcelFile(response);
    }
    
    public static String getGeoLocation(String ipAddress) {
        String geoLocation = "";
        try {
            File database = ResourceUtils.getFile("classpath:GeoLite2-City/GeoLite2-City.mmdb");;
            DatabaseReader dbReader = new DatabaseReader.Builder(database).build();
            CityResponse response = dbReader.city(InetAddress.getByName(ipAddress));
            
            String countryName = response.getCountry().getName();
            String cityName = response.getCity().getName();
            String postal = response.getPostal().getCode();
            String state = response.getLeastSpecificSubdivision().getName();
            
            geoLocation = "Country: " + countryName + "cityName: " + cityName + "postal: " + postal + "state: " + state;
            
            System.out.println(geoLocation);
        } catch(Exception ex) {
          System.out.println("Exception occured while trying to get GeoLocation of user: " + ex);
        }
        return geoLocation;
    }
}
