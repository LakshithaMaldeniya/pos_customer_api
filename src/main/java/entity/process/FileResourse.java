package entity.process;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.sql.Blob;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FileResourse {
    @Column(columnDefinition = "LONGBLOG")
    private Blob fileName;

    @Column(columnDefinition = "LONGBLOG")
    private Blob resourceUrl;

    @Column(columnDefinition = "LONGBLOG")
    private Blob directory;

    @Column(columnDefinition = "LONGBLOG")
    private Blob hash;
}
