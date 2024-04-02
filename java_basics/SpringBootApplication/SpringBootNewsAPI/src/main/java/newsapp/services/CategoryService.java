package newsapp.services;

import newsapp.dto.CategoryDto;
import newsapp.entity.Category;
import newsapp.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@RequiredArgsConstructor
@Service
public class CategoryService implements CRUDService<CategoryDto> {

    private final CategoryRepository repository;

    @Override
    public CategoryDto getById(Integer id) {
        return mapToDto(repository.findById(id)
                .orElseThrow());
    }

    @Override
    public Collection<CategoryDto> getAll() {
        return repository.findAll().stream().map(CategoryService::mapToDto).toList();
    }

    @Override
    public void create(CategoryDto item) {
        repository.save(mapToEntity(item));
    }

    @Override
    public void update(Integer id, CategoryDto item) {
        repository.findById(id)
                .ifPresent(category -> {
                    category.setTitle(item.getTitle());
                    repository.save(category);
                });
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public static Category mapToEntity (CategoryDto categoryDto) {
        Category category = new Category();
        category.setTitle(categoryDto.getTitle());
        return category;
    }

    public static CategoryDto mapToDto (Category category) {
        return new CategoryDto(category.getTitle());
    }
}
