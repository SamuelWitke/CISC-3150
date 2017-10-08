public class Dog extends Pet
{
  public String call()
  {// C
    return "woof!";
  }
  public String toString()
  { // D
    return "I'm a dog, pet me!";
  }
  public String call(int k)
  { // E
    String s = "Woof";
    for(int i = 1; i < k; ++i)
      s += ", woof";
    return s + "!";
  }
}
