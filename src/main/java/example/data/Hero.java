package example.data;

import lombok.Data;

import java.util.List;

@Data
public class Hero{
    private String id;
    private String name;
    private List<Hero> friends;
    private List<Episode> appearsIn;
}
