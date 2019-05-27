package example.data;

import lombok.Data;

import java.util.List;

@Data
public class Human{
    private String id;
    private String name;
    private Float height;
    private List<String> friends;
}
