package newsapp.services;

import jakarta.persistence.EntityNotFoundException;
import newsapp.dto.CategoryDto;
import newsapp.dto.NewsDto;
import newsapp.entity.Category;
import newsapp.entity.News;
import newsapp.repositories.CategoryRepository;
import newsapp.repositories.NewsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@Service
public class NewsService implements CRUDService<NewsDto>{

    private final NewsRepository repository;
    private final CategoryRepository categoryRepository;

    @Override
    public NewsDto getById(Integer id) {
        log.info("Get by ID:" + id);
        if (repository.findById(id).isPresent()) {
            return mapToDto(repository.findById(id).get());
        }
            throw new EntityNotFoundException("Сущность" + id + " не найдена");
    }

    @Override
    public Collection<NewsDto> getAll() {
        log.info("Get values: ");
        Collection<News> news = repository.findAll();
        return news.stream().map(this::mapToDto).toList();
    }

    @Override
    public void create(NewsDto item) {
        log.info("Create new item");
        repository.save(mapToEntity(item));
    }

    @Override
    public void update(Integer id, NewsDto item) {
        log.info("Updated");
        repository.findById(id).ifPresentOrElse(news -> {
            news.setTitle(item.getTitle());
            news.setText(item.getText());
            news.setCategory(getOrCreateCategory(item.getCategoryDto()));
            repository.save(news);
        }, () -> {
            throw new EntityNotFoundException("News with id " + id + " not found");
        });
    }

    @Override
    public void deleteById(Integer id) {
        log.info("Delete id: " + id);
        repository.findById(id).ifPresentOrElse(news -> repository.deleteById(id),
                () -> {
                    throw new EntityNotFoundException("Новость с id:" + id + "не найдена");
                });
    }

    private Category getOrCreateCategory(CategoryDto categoryDto) {
        Optional<Category> categoryByTitle = categoryRepository.findCategoryByTitle(categoryDto.getTitle());
        if (categoryByTitle.isPresent()) {
            return categoryByTitle.get();
        } else {
            Category category = new Category();
            category.setTitle(categoryDto.getTitle());
            categoryRepository.save(category);
            return category;
        }
    }

    public NewsDto mapToDto (News news) {
        return new NewsDto(news.getTitle(),
                news.getText(),
                new CategoryDto(news.getCategory().getTitle()));
    }

    public News mapToEntity (NewsDto newsDto) {
        News news = new News();
        news.setTitle(newsDto.getTitle());
        news.setText(newsDto.getText());
        Category category = getOrCreateCategory(newsDto.getCategoryDto());
        news.setCategory(category);
        return news;
    }
}
