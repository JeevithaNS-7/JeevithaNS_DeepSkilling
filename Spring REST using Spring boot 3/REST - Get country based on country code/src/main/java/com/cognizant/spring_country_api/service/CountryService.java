package com.cognizant.spring_country_api.service;
import com.cognizant.spring_country_api.model.Country;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.List;
@Service
public class CountryService {

    public Country getCountry(String code) {

        List<Country> countries = getCountries();

        for (Country country : countries) {

            if (country.getCode().equalsIgnoreCase(code)) {
                return country;
            }

        }

        return null;
    }

    private List<Country> getCountries() {

        List<Country> countries = new ArrayList<>();

        try {

            ClassPathResource resource = new ClassPathResource("country.xml");

            Document document = DocumentBuilderFactory.newInstance()
                    .newDocumentBuilder()
                    .parse(resource.getInputStream());

            NodeList nodeList = document.getElementsByTagName("country");

            for (int i = 0; i < nodeList.getLength(); i++) {

                Element element = (Element) nodeList.item(i);

                String code = element.getElementsByTagName("code")
                        .item(0)
                        .getTextContent();

                String name = element.getElementsByTagName("name")
                        .item(0)
                        .getTextContent();

                countries.add(new Country(code, name));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return countries;
    }

}
