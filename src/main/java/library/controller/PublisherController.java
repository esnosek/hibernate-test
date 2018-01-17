package library.controller;

import library.dto.AddressDto;
import library.dto.PublisherDto;
import library.entity.Address;
import library.entity.Publisher;
import library.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/publishers")
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String create(@RequestBody PublisherDto publisherDto) {
        Publisher publisher;
        try {
            publisher =  publisherService.save(publisherDto);
        }
        catch (Exception e) {
            return "Error creating the publisher: " + e.toString();
        }
        return "Publisher succesfully created! (id = " + publisher.getId() + ")";
    }

}
