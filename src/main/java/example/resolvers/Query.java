package example.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import example.data.Episode;
import example.data.Hero;
import example.data.Human;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hwang on 21/05/2019.
 */
@Component
public class Query implements GraphQLQueryResolver {

    public Hero getHero() {
        return this.getEmpireHero();
    }

    private Hero getEmpireHero() {
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

    private Hero getJediHero() {
        Hero hero = new Hero();
        hero.setName("Jedi");

        List<Hero> friends = new ArrayList<>();
        Hero friend1 = new Hero();
        friend1.setName("Hulk");
        friends.add(friend1);

        hero.setFriends(friends);
        return hero;
    }

    public Human getHuman(String id) {
        Human human = new Human();
        human.setName("Luke Skywalker");
        human.setHeight(1.72f);
        return human;
    }

    public Hero getHeroByEpisode(Episode episode) {
        if (episode == Episode.EMPIRE) {
            return this.getEmpireHero();
        } else if(episode == Episode.JEDI){
            return this.getJediHero();
        }else {
            Hero hero = new Hero();
            hero.setName("ELSE Hero");
            return hero;
        }
    }
}