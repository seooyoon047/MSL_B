import com.example.msl_b.Domain.Entity.PostEntity;

import lombok.*;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class PostDto {
    private BigInteger id;
    private String title;
    private String nickname;
    private String thumbnail;

    private String content;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public PostEntity toEntity(){
        PostEntity postEntity = PostEntity.builder()

                .title(title)
                .nickname(nickname)
                .thumbnail(thumbnail)
                .content(content)

                .build();
        return postEntity;
    }

    @Builder

    public PostDto(BigInteger id, String title, String nickname, String thumbnail, String content, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.id = id;

        this.title = title;
        this.nickname = nickname;
        this.thumbnail = thumbnail;
        this.content = content;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}