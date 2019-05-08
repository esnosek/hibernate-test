package library.service;

import library.dao.AuthorDao;
import library.dao.MagazineDao;
import library.dto.write.MagazineDto;
import library.entity.Author;
import library.entity.Magazine;
import library.entity.Publisher;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MagazineService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PublisherService publisherService;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private AuthorDao authorDao;
    @Autowired
    private MagazineDao magazineDao;

    public Magazine save(MagazineDto magazineDto) {
        Magazine magazine = modelMapper.map(magazineDto, Magazine.class);
        Publisher publisher = publisherService.findOne(Integer.valueOf(magazineDto.getPublisherId()));
        publisher.addMagazine(magazine);
        List<Author> authors = authorService.findByIds(magazineDto.getAuthorsIds());
        authors.forEach(magazine::addAuthor);
        magazineDao.save(magazine);
        return magazine;
    }

    public List<Magazine> findAll() {
        return magazineDao.findAll();
    }

    public Magazine update(Integer id, MagazineDto magazineDto) {
        Magazine magazine = magazineDao.findOne(id);

        Optional.ofNullable(magazineDto.getTitle()).ifPresent(magazine::setTitle);

        Optional.ofNullable(magazineDto.getPublisherId()).ifPresent(
                publisherId -> magazine.setPublisher(
                        publisherService.findOne(Integer.valueOf(publisherId))
                )
        );

        Optional.ofNullable(magazineDto.getAuthorsIds()).ifPresent(authorIds -> {
            magazine.removeAllAuthors();
            List<Author> authors = authorService.findByIds(authorIds);
            authors.forEach(magazine::addAuthor);
        });

        magazineDao.update(magazine);
        return magazine;
    }
}
