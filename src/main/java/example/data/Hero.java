package example.data;

import lombok.Data;

import java.util.List;

@Data
public class Hero {
    private String name;
    private List<Hero> friends;
}
