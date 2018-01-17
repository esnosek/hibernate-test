package library.service;

import library.dao.PublisherDao;
import library.dto.AddressDto;
import library.dto.PublisherDto;
import library.entity.Address;
import library.entity.Publisher;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublisherService {

    @Autowired
    private PublisherDao publisherDao;

    @Autowired
    private ModelMapper modelMapper;

    public Publisher save(PublisherDto publisherDto) {
        Publisher publisher = modelMapper.map(publisherDto, Publisher.class);
        publisherDao.save(publisher);
        return publisher;
    }
}
