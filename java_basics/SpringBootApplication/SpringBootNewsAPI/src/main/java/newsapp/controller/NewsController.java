package newsapp.controller;


import newsapp.dto.NewsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import newsapp.services.NewsService;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
@RequestMapping("/news")
public class NewsController {
    private final NewsService newsService;

    @GetMapping("/{id}")
    public NewsDto getNewsById(@PathVariable Integer id) {
        return newsService.getById(id);
    }

    @GetMapping
    public Collection<NewsDto> getAllNews() {
        return newsService.getAll();
    }

    @PostMapping
    public void createNews(@RequestBody NewsDto newsDto) {
        newsService.create(newsDto);
    }

    @PutMapping("/{id}")
    public void updateNews(@PathVariable Integer id, @RequestBody NewsDto newsDto) {
        newsService.update(id, newsDto);
    }

    @DeleteMapping("/{id}")
    public void deleteNews(@PathVariable Integer id) {
        newsService.deleteById(id);
    }
}
