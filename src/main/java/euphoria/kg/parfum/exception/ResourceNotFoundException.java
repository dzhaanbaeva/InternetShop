package euphoria.kg.parfum.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
@Getter
@Setter
public class ResourceNotFoundException extends  RuntimeException{
    private  String resource;
    private  String name;

    public ResourceNotFoundException(String resource, String name) {
        super();
        this.resource = resource;
        this.name = name;
    }
}
