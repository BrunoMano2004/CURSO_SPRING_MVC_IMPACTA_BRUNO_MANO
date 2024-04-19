package integracao_api.integracao_api.response;

import lombok.Data;

@Data
public class PhotoResponse {

    private long albumId;
    private long id;
    private String title;
    private String url;
    private String thumbnailUrl;
}
