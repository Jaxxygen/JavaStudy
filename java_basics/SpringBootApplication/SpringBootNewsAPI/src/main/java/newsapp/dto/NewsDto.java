package newsapp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class NewsDto {

    @NonNull
    private String title;

    @NonNull
    private String text;

    @NonNull
    private CategoryDto categoryDto;
}
