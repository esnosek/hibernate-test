package library.service;

import library.dao.AuthorDao;
import library.dto.AuthorDto;
import library.entity.Author;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    private AuthorDao authorDao;

    @Autowired
    private ModelMapper modelMapper;

    public Author save(AuthorDto authorDto) {
        Author author = modelMapper.map(authorDto, Author.class);
        authorDao.save(author);
        return author;
    }

}
