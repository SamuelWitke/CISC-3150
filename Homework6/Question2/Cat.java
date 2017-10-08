public class Cat extends Pet
{
  public String call()
  {//F
    return "meow!";
  }
  public String toString()
  {//G
    return "I'm a cat, go away!";
  }
  public String toString(String b)
  {//H
    return b + "? ... " +
    "Don't waste my time.";
  }
}
