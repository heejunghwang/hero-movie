1. get hero

```
{
  hero {
    name
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

3. get human with parameter query
```$xslt
{
  human(id: "1000") {
    name
    height
  }
}
```

4. set alias
```$xslt
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