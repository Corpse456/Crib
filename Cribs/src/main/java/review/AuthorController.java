//package review;
//
//import lombok.Data;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Repository;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@RestController
//public class AuthorController {
//
//    @Autowired
//    private AuthorSearchService service;
//
//    @GetMapping("/authors")
//    public List<AuthorDto> readAllAuthors(@RequestParam String query) {
//        final List<Author> authors = service.search(query);
//        return authors.stream()
//                .map(el -> {
//                    return new Mapper().map(el);
//                }).collect(Collectors.toList());
//    }
//
//}
//
//@Component
//class AuthorSearchService {
//
//    @Autowired
//    private AuthorsRepository authorsRepository;
//
//    @Autowired
//    private StatisticsRepository statisticsRepository;
//
//    private AlertRestClient arc = new AlertRestClient();
//
//    public List<Author> search(String query) {
//        List<Author> authors = authorsRepository.findByNameContainingIgnoreCase(query);
//        Statistics s = statisticsRepository.findById(query).orElse(null);
//        if (s == null) {
//            s = new Statistics(query);
//        }
//        s.setNumbers(s.getNumbers() + 1);
//        statisticsRepository.save(s);
//        if (s.getNumbers() > 1000 && authors.size() > 1000) {
//            System.out.println("Too popular");
//            arc.send(query, s.getNumbers(), authors.size());
//        }
//        return authors;
//    }
//}
//
//interface AuthorsRepository extends CrudRepository<Author, Long> {
//
//    List<Author> findByNameContainingIgnoreCase(String name);
//}
//
//@Repository
//interface StatisticsRepository extends CrudRepository<Statistics, String> {
//
//}
//
//@Data
//@Entity
//class Author {
//
//    @Id
//    @GeneratedValue
//    private Long id;
//
//    private String name;
//
//    @OneToMany(mappedBy = "author")
//    private List<Book> books;
//
//    public Author(final String name) {
//        this.name = name;
//    }
//}
//
//@Data
//@Entity
//class Statistics {
//
//    @Id
//    private String query;
//
//    private int numbers;
//
//    public Statistics(final String query) {
//        this.query = query;
//    }
//}
//
//@Data
//@Entity
//class Book {
//
//    private Long id;
//
//    private String name;
//}
//
//@Data
//class AuthorDto {
//
//    private Long id;
//
//    private String name;
//
//    private List<Book> books;
//}
//
//class AlertRestClient {
//
//    public void send(final String query, final int numbers, final int size) {
//        //some logic
//    }
//}
//
//class Mapper {
//
//    public AuthorDto map(final Author el) {
//        //some logic
//        return null;
//    }
//}
