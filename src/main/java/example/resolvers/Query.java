package example.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import example.data.Hero;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hwang on 21/05/2019.
 */
@Component
public class Query implements GraphQLQueryResolver {

    public Hero getHero() {
        Hero hero = new Hero();
        hero.setName("R2-D2");

        List<Hero> friends = new ArrayList<>();
        Hero friend1 = new Hero();
        friend1.setName("Luke Skywalker");
        friends.add(friend1);

        Hero friend2 = new Hero();
        friend2.setName("Han Solo");
        friends.add(friend2);

        hero.setFriends(friends);
        return hero;
    }
}