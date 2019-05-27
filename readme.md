1. get hero

```
{
  hero {
    name
  }
}
```

Result : 
```
{
  "data": {
    "hero": {
      "name": "R2-D2"
    }
  }
}
```


2. get hero and friends
```
{
  hero {
    name
    friends {
      name
    }
  }
}
```

Result : 
```
{
  "data": {
    "hero": {
      "name": "R2-D2",
      "friends": [
        {
          "name": "Luke Skywalker"
        },
        {
          "name": "Han Solo"
        }
      ]
    }
  }
}
```

3. get human with parameter query
```
{
  human(id: "1000") {
    name
    height
  }
}
```

Result : 
```
{
  "data": {
    "human": {
      "name": "Luke Skywalker",
      "height": 1.72
    }
  }
}
```

4. set alias
```
{
  empireHero : hero {
    name
    friends {
      name
    }
  }
 
  jediHero : human(id: "1000") {
    name
    height
  }
}
```

Result : 
```
{
  "data": {
    "empireHero": {
      "name": "R2-D2",
      "friends": [
        {
          "name": "Luke Skywalker"
        },
        {
          "name": "Han Solo"
        }
      ]
    },
    "jediHero": {
      "name": "Luke Skywalker",
      "height": 1.72
    }
  }
}
```

5. How to check meta data type
```
{
  human {
    __typename
    ... on Human {
      name
    }
  }
}

```

Result : 
```
{
  "data": {
    "human": {
      "__typename": "Human",
      "name": "Luke Skywalker"
    }
  }
}
```

6. You can reuse the parameter using fragment
```
query HeroComparison{
  leftComparison: human {
    ...comparisonFields
  }
  rightComparison: human {
    ...comparisonFields
  }
}

fragment comparisonFields on Human {
  name
  height
}
```

Result : 

```
{
  "data": {
    "leftComparison": {
      "name": "Luke Skywalker",
      "height": 1.72
    },
    "rightComparison": {
      "name": "Luke Skywalker",
      "height": 1.72
    }
  }
}
```

7. query with parameter

```
query HeroNameAndFriends($episode: Episode) {
  getHeroByEpisode(episode: $episode) {
    name
    
  }
}
```

```
{
  "episode": "JEDI"
}
```

Result : 

```
{
  "data": {
    "getHeroByEpisode": {
      "name": "Jedi"
    }
  }
}
```

8. You can show the result by the given parameters.
```
query Hero($episode: Episode, $withFriends: Boolean!) {
  getHeroByEpisode(episode: $episode) {
    name
    friends @include(if: $withFriends) {
      name
    }
  }
}
```

```
{
  "episode": "JEDI",
  "withFriends": true
}
```

When `withFriends`, it will show the result of the friends

Result : 
```
{
  "data": {
    "getHeroByEpisode": {
      "name": "Jedi",
      "friends": [
        {
          "name": "Hulk"
        }
      ]
    }
  }
}
```